package pl.analyzeapi.analyzeapi.service.word.abstracts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.analyzeapi.analyzeapi.model.Word;

import java.util.Set;

public interface IWordQueryService {
    Set <Word> getAllByNames(Set <String> names);

    Page <Word> getAllByNameWithWords(String name , Pageable pageable);
}
