package pl.analyzeapi.analyzeapi.mapper;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.analyzeapi.analyzeapi.dto.fragment.FragmentDTO;
import pl.analyzeapi.analyzeapi.dto.word.WordDTO;
import pl.analyzeapi.analyzeapi.dto.word.WordFullInformationDTO;
import pl.analyzeapi.analyzeapi.model.Word;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WordMapper {

    public static List <WordDTO> map(Set <Word> words) {
        return words.stream().map(
                        word -> WordDTO.builder()
                                .name(word.getName())
                                .count(word.getCount())
                                .positions(word.getPositionsAsIntegerArray())
                                .build()
                ).sorted(Comparator.comparing(WordDTO::getName , String::compareToIgnoreCase))
                .collect(Collectors.toList());
    }

    public static List <WordFullInformationDTO> mapFullInformation(List <Word> words) {
        List <WordFullInformationDTO> dtos = new ArrayList <>();
        for (var word : words) {
            var fragments = word.getFragments().stream()
                    .map(fragment -> FragmentDTO.builder()
                            .id(fragment.getId())
                            .text(fragment.getText()).build())
                    .collect(Collectors.toSet());
            var dto = WordFullInformationDTO.builder()
                    .name(word.getName())
                    .fragments(fragments)
                    .positions(word.getPositionsAsIntegerArray())
                    .count(word.getCount())
                    .build();
            dtos.add(dto);
        }
        return dtos;
    }

}
