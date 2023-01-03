package pl.analyzeapi.analyzeapi.service.fragment;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.analyzeapi.analyzeapi.model.Fragment;
import pl.analyzeapi.analyzeapi.repository.IFragmentRepository;
import pl.analyzeapi.analyzeapi.service.fragment.abstracts.IFragmentCudService;

@Transactional
@AllArgsConstructor
@Slf4j
@Service
class FragmentCudService implements IFragmentCudService {

    private final IFragmentRepository repository;

    @Override
    public Fragment create(Fragment entity) {
        var created = repository.save(entity);
        log.debug("Fragment with id: {}, created successfully" , created.getId());
        return created;
    }

    @Override
    public Fragment update(Fragment entity) {
        var updated = repository.save(entity);
        log.debug("Fragment with id: {}, updated successfully" , updated.getId());
        return updated;
    }

}
