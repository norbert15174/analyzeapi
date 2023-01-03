package pl.analyzeapi.analyzeapi.dto.word;

import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class WordDTO {

    private String name;
    private Integer count;
    private List <Integer> positions;

}
