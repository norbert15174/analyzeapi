package pl.analyzeapi.analyzeapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.analyzeapi.analyzeapi.dto.word.WordFullInformationDTO;
import pl.analyzeapi.analyzeapi.service.word.abstracts.IWordService;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/words")
public class WordController {

    private final IWordService wordService;

    @GetMapping
    public ResponseEntity <List <WordFullInformationDTO>> getAllDTOByNameWithWords(@RequestParam String name , @RequestParam(required = false) Optional <Integer> page , @RequestParam(required = false) Optional <Integer> pageSize) {
        return new ResponseEntity <>(wordService.getAllDTOByNameWithFragments(name , page , pageSize) , HttpStatus.OK);
    }

}
