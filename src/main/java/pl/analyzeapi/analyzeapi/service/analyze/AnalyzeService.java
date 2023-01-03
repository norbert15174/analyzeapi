package pl.analyzeapi.analyzeapi.service.analyze;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.analyzeapi.analyzeapi.creator.FragmentCreator;
import pl.analyzeapi.analyzeapi.creator.WordCreator;
import pl.analyzeapi.analyzeapi.dto.word.WordDTO;
import pl.analyzeapi.analyzeapi.generator.UUIDGenerator;
import pl.analyzeapi.analyzeapi.mapper.CommonMapper;
import pl.analyzeapi.analyzeapi.mapper.WordMapper;
import pl.analyzeapi.analyzeapi.model.Fragment;
import pl.analyzeapi.analyzeapi.model.Word;
import pl.analyzeapi.analyzeapi.parser.AnalyzeParser;
import pl.analyzeapi.analyzeapi.service.analyze.abstracts.IAnalyzeService;
import pl.analyzeapi.analyzeapi.service.fragment.abstracts.IFragmentCudService;
import pl.analyzeapi.analyzeapi.service.fragment.abstracts.IFragmentQueryService;
import pl.analyzeapi.analyzeapi.service.word.abstracts.IWordCUDService;
import pl.analyzeapi.analyzeapi.service.word.abstracts.IWordQueryService;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
class AnalyzeService implements IAnalyzeService {

    private final IFragmentQueryService fragmentQueryService;
    private final IWordQueryService wordQueryService;
    private final IWordCUDService wordCUDService;
    private final IFragmentCudService fragmentCudService;

    @Transactional
    @Override
    public List <WordDTO> process(String text) {
        var words = AnalyzeParser.parse(text);
        var positionsByWord = CommonMapper.positionsByWord(words);
        var uuid = UUIDGenerator.generateForText(words[0] , words[words.length - 1] , text.length());


        var domainFragment = getFragmentOrCreate(text , uuid);
        if ( domainFragment.hasWords() ) {
            return WordMapper.map(domainFragment.getWords());
        }

        var domainWords = getWordsOrCreate(positionsByWord);
        domainWords.forEach(domainFragment::addWord);
        var createdFragment = fragmentCudService.create(domainFragment);
        domainWords.forEach(wordCUDService::update);
        return WordMapper.map(createdFragment.getWords());
    }

    //thanks to uuid, we can find same fragment faster
    private Fragment getFragmentOrCreate(String text , String uuid) {
        return fragmentQueryService.getAllByUUIDWithWords(uuid).stream()
                .filter(fragment -> fragment.getText().equalsIgnoreCase(text))
                .findFirst()
                .orElse(FragmentCreator.build(text , uuid));
    }

    private Set <Word> getWordsOrCreate(Map <String, Set <Integer>> positionsByWord) {
        var wordsFromDB = wordQueryService.getAllByNames(positionsByWord.keySet());
        var domainWords = WordCreator.buildWords(positionsByWord);
        var wordsToPersist = domainWords.stream().filter(word -> !wordsFromDB.contains(word)).collect(Collectors.toSet());
        var wordsToMergeWithFragment = wordsFromDB.stream().filter(domainWords::contains).collect(Collectors.toSet());
        wordsToPersist.forEach(word -> wordsToMergeWithFragment.add(wordCUDService.create(word)));
        return wordsToMergeWithFragment;
    }

}
