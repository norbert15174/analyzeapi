package pl.analyzeapi.analyzeapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.analyzeapi.analyzeapi.dto.word.WordDTO;
import pl.analyzeapi.analyzeapi.exception.ValidationObjectException;
import pl.analyzeapi.analyzeapi.service.analyze.abstracts.IAnalyzeService;
import pl.analyzeapi.analyzeapi.validator.AnalyzeValidator;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/analyze")
public class AnalyzeController {

    private final AnalyzeValidator validator;
    private final IAnalyzeService analyzeService;

    @PostMapping
    public ResponseEntity <List <WordDTO>> analyze(@RequestBody String text , Errors errors) {
        validator.analyze(text , errors);
        if ( errors.hasErrors() ) {
            throw new ValidationObjectException(errors);
        }

        return new ResponseEntity <>(analyzeService.process(text) , HttpStatus.CREATED);
    }

}
