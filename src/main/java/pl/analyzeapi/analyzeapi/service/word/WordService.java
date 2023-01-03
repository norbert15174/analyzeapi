package pl.analyzeapi.analyzeapi.service.word;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.analyzeapi.analyzeapi.dto.word.WordFullInformationDTO;
import pl.analyzeapi.analyzeapi.mapper.WordMapper;
import pl.analyzeapi.analyzeapi.properties.GlobalProperties;
import pl.analyzeapi.analyzeapi.service.word.abstracts.IWordService;
import pl.analyzeapi.analyzeapi.service.word.abstracts.IWordQueryService;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service
class WordService implements IWordService {

    private final IWordQueryService wordQueryService;
    private final GlobalProperties properties;

    @Transactional(readOnly = true)
    @Override
    public List <WordFullInformationDTO> getAllDTOByNameWithFragments(String name , Optional <Integer> pageOpt , Optional <Integer> pageSizeOpt) {
        var page = pageOpt.orElse(0);
        var pageSize = pageSizeOpt.orElse(properties.getPageSize());
        var words = wordQueryService.getAllByNameWithWords(name , PageRequest.of(page , pageSize));
        return WordMapper.mapFullInformation(words.getContent());
    }

}
