package pl.analyzeapi.analyzeapi.parser;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnalyzeParserTests {

    @Test
    void wordWithNumber_readAll() {
        String wordWithNumber = "test832 7836test";
        var result = AnalyzeParser.parse(wordWithNumber);
        Assertions.assertThat(result).contains("test832", "7836test");
    }

    @Test
    void wordWithSeparators_readOnlyWords() {
        String wordWithNumber = "test832.7836test %test, 543tes2, test::,!";
        var result = AnalyzeParser.parse(wordWithNumber);
        Assertions.assertThat(result).contains("test832", "7836test","test","543tes2");
    }

    @Test
    void wordWithNumber_readAll2() {
        String wordWithNumber = "test832 7836testąą dssa d212d";
        var result = AnalyzeParser.parse(wordWithNumber);
        Assertions.assertThat(result).contains("test832", "7836testąą");
    }

}
