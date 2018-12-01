package top.kwseeker.springbootvalidator.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@ControllerAdvice
public class ValidatorExceptionHandler {

    private final static Logger logger = LoggerFactory.getLogger(ValidatorExceptionHandler.class);

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public Map<String, Object> handleConstrainViolationException(ConstraintViolationException cve) {
        Set<ConstraintViolation<?>> violationSet = cve.getConstraintViolations();
        StringBuilder stringBuilder = new StringBuilder();
        for (ConstraintViolation<?> constraintViolation : violationSet) {
            logger.info(constraintViolation.getMessage());
            stringBuilder.append(constraintViolation.getMessage());
        }
        Map<String, Object> map = new HashMap<>();
        map.put("errorCode", 500);
        map.put("errorMsg", stringBuilder.toString());
        return map;
    }
}
