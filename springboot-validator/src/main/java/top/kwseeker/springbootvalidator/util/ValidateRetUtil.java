package top.kwseeker.springbootvalidator.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.validation.ConstraintViolation;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ValidateRetUtil {

    public static Map<String, String> getFieldErrorsMap(BindingResult bindingResult) {
        Map<String, String> fieldErrorsMap = new HashMap<>();
        if(bindingResult.hasErrors()) {
            for(FieldError fieldError : bindingResult.getFieldErrors()) {
                fieldErrorsMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
        }
        return fieldErrorsMap;
    }

    public static Map<String, String> getConstraintViolationsMap(Set<ConstraintViolation<Object>> violationSet) {
        Map<String, String> violationsMap = new HashMap<>();
        for(ConstraintViolation<Object> violation : violationSet) {
            violationsMap.put(violation.getPropertyPath().toString(), violation.getMessage());
        }
        return violationsMap;
    }
}
