package pl.analyzeapi.analyzeapi.dto.word;

import lombok.*;
import pl.analyzeapi.analyzeapi.dto.fragment.FragmentDTO;

import java.util.List;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class WordFullInformationDTO {

    private String name;
    private Integer count;
    private List <Integer> positions;
    private Set <FragmentDTO> fragments;

}
