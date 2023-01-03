package pl.analyzeapi.analyzeapi.service.analyze.abstracts;

import pl.analyzeapi.analyzeapi.dto.word.WordDTO;

import java.util.List;

public interface IAnalyzeService {
    List <WordDTO> process(String text);
}
