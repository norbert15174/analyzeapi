package pl.analyzeapi.analyzeapi.validator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

@ExtendWith(MockitoExtension.class)
class AnalyzeValidatorTests {

    @InjectMocks
    private AnalyzeValidator validator;

    @Test
    void emptyText_throwNullOrEmptyError() {
        String text = "   ";
        Errors errors = new BeanPropertyBindingResult(text , "text");
        validator.analyze(text , errors);
        assertTrue(errors.hasErrors());
        Assertions.assertThat(errors.getAllErrors().stream().flatMap(e -> Arrays.stream(Objects.requireNonNull(e.getCodes()))).collect(Collectors.toSet())).contains("Field cannot be null or empty");
    }

    @Test
    void textWithoutWords_throwTextDoesNotContainWords() {
        String text = ".,:!";
        Errors errors = new BeanPropertyBindingResult(text , "text");
        validator.analyze(text , errors);
        assertTrue(errors.hasErrors());
        Assertions.assertThat(errors.getAllErrors().stream().flatMap(e -> Arrays.stream(Objects.requireNonNull(e.getCodes()))).collect(Collectors.toSet())).contains("Text does not contain words");
    }

}
