package pl.analyzeapi.analyzeapi.service.word;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.analyzeapi.analyzeapi.model.Word;
import pl.analyzeapi.analyzeapi.repository.IWordRepository;
import pl.analyzeapi.analyzeapi.service.word.abstracts.IWordQueryService;

import java.util.Set;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@AllArgsConstructor
@Service
class WordQueryService implements IWordQueryService {

    private final IWordRepository repository;

    @Override
    public Set <Word> getAllByNames(Set <String> names) {
        Set <String> namesToLowerCase = names.stream().map(String::toLowerCase).collect(Collectors.toSet());
        return repository.findAllByNames(namesToLowerCase);
    }

    @Override
    public Page <Word> getAllByNameWithWords(String name , Pageable pageable) {
        return repository.findAllByName(name , pageable);
    }

}
