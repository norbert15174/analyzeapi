package pl.analyzeapi.analyzeapi.creator;

import com.google.common.collect.Sets;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.analyzeapi.analyzeapi.model.Word;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WordCreator {

    public static Set <Word> buildWords(Map <String, Set <Integer>> positionsByWord) {
        Set <Word> words = Sets.newHashSet();
        for (var entity : positionsByWord.entrySet()) {
            words.add(build(entity.getKey().toLowerCase() , entity.getValue()));
        }
        return words;
    }

    private static Word build(String name , Set <Integer> positions) {
        var word = new Word();
        word.setName(name);
        word.setCount(positions.size());
        word.setPositions(positions.stream().sorted().map(String::valueOf).collect(Collectors.joining(",")));
        return word;
    }

}
