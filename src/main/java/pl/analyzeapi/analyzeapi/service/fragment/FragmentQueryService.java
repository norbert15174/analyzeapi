package pl.analyzeapi.analyzeapi.service.fragment;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.analyzeapi.analyzeapi.model.Fragment;
import pl.analyzeapi.analyzeapi.repository.IFragmentRepository;
import pl.analyzeapi.analyzeapi.service.fragment.abstracts.IFragmentQueryService;

import java.util.Set;

@Transactional(readOnly = true)
@AllArgsConstructor
@Service
class FragmentQueryService implements IFragmentQueryService {

    private final IFragmentRepository repository;

    @Override
    public Set <Fragment> getAllByUUIDWithWords(String uuid) {
        return repository.findAllByUUIDWithWords(uuid);
    }

}
