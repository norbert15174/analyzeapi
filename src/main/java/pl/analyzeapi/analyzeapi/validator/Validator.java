package pl.analyzeapi.analyzeapi.validator;

import com.google.common.base.Strings;
import org.springframework.validation.Errors;

public class Validator {

    private final Integer MAX_TEXT_LENGTH = 32767;

    protected boolean validateStringEmpty(String value , Errors errors) {
        if ( Strings.isNullOrEmpty(value) || value.isBlank() ) {
            errors.reject("Field cannot be null or empty");
            return false;
        }
        return true;
    }

    protected boolean validateMaxLength(String text , Errors errors) {
        if ( text.length() > MAX_TEXT_LENGTH ) {
            errors.reject(String.format("Text cannot be longer than %d characters" , MAX_TEXT_LENGTH));
            return false;
        }
        return true;
    }

}
