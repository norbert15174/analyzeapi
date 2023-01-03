package pl.analyzeapi.analyzeapi.validator;

import com.google.common.base.Strings;
import org.springframework.validation.Errors;

public class Validator {

    protected boolean validateStringEmpty(String value , Errors errors) {
        if ( Strings.isNullOrEmpty(value) || value.isBlank() ) {
            errors.reject("Field cannot be null or empty");
            return false;
        }
        return true;
    }

}
