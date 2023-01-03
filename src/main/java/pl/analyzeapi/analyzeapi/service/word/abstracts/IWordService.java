package pl.analyzeapi.analyzeapi.service.word.abstracts;

import pl.analyzeapi.analyzeapi.dto.word.WordFullInformationDTO;

import java.util.List;
import java.util.Optional;

public interface IWordService {
    List <WordFullInformationDTO> getAllDTOByNameWithFragments(String name , Optional <Integer> pageOpt , Optional <Integer> pageSizeOpt);
}
