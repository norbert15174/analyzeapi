package pl.analyzeapi.analyzeapi.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import pl.analyzeapi.analyzeapi.parser.AnalyzeParser;

@Component
public class AnalyzeValidator extends Validator {

    public void analyze(String text , Errors errors) {
        if ( !validateStringEmpty(text , errors) ) {
            return;
        }

        if ( !validateMaxLength(text , errors) ) {
            return;
        }

        var lines = AnalyzeParser.parse(text);
        if ( lines.length == 0 ) {
            errors.reject("Text does not contain words");
        }
    }

}
