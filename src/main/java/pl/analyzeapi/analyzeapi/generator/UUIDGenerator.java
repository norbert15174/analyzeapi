package pl.analyzeapi.analyzeapi.generator;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UUIDGenerator {

    private static final String FORMAT = "%s%d-%d-%s%d";

    public static String generateForText(String firstWord , String lastWord , int textSize) {
        return String.format(FORMAT , firstWord.charAt(0) , firstWord.hashCode() , textSize , lastWord.charAt(0) , lastWord.hashCode());
    }

}
