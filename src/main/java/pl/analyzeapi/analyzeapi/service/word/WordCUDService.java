package pl.analyzeapi.analyzeapi.service.word;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.analyzeapi.analyzeapi.model.Word;
import pl.analyzeapi.analyzeapi.repository.IWordRepository;
import pl.analyzeapi.analyzeapi.service.word.abstracts.IWordCUDService;

@AllArgsConstructor
@Transactional
@Slf4j
@Service
class WordCUDService implements IWordCUDService {

    private final IWordRepository repository;

    @Override
    public Word create(Word entity) {
        var created = repository.save(entity);
        log.debug("Word with id: {}, created successfully" , created.getId());
        return created;
    }

    @Override
    public Word update(Word entity) {
        var updated = repository.save(entity);
        log.debug("Word with id: {}, updated successfully" , updated.getId());
        return updated;
    }

}
