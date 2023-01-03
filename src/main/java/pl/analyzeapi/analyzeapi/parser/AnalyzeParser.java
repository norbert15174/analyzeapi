package pl.analyzeapi.analyzeapi.parser;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.stream.Stream;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AnalyzeParser {

    private static final String REGEX = "\\W";

    public static String[] parse(String text) {
        return Stream.of(text.split(REGEX)).filter(word -> word.length() > 1).toArray(String[]::new);
    }

}
