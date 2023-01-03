package pl.analyzeapi.analyzeapi.service.fragment.abstracts;

import pl.analyzeapi.analyzeapi.dto.fragment.FragmentDTO;
import pl.analyzeapi.analyzeapi.model.Fragment;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IFragmentQueryService {
    Set <Fragment> getAllByUUIDWithWords(String uuid);

}
