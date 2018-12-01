package top.kwseeker.springbootvalidator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.kwseeker.springbootvalidator.config.validator.GroupIdentityCheck;
import top.kwseeker.springbootvalidator.config.validator.GroupStudentCheck;
import top.kwseeker.springbootvalidator.entity.UserBiz;
import top.kwseeker.springbootvalidator.util.ValidateRetUtil;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/validate")
public class ValidatorController {

    private final static Logger logger = LoggerFactory.getLogger(ValidatorController.class);

    @Autowired
    //Validator myValidator;
    Validator defaultValidator;

    /**
     * 使用@Validated注解校验
     */
    @PostMapping("/test1")
    public String test1(@RequestBody @Validated UserBiz userBiz, BindingResult bindingResult) {
        Map<String, String> fieldErrorMap = ValidateRetUtil.getFieldErrorsMap(bindingResult);
        if(fieldErrorMap != null) {
            logger.warn(fieldErrorMap.toString());
        }
        logger.info(userBiz.toString());
        return "使用 @Validated 注解校验";
    }

    /**
     * 使用@Validated注解校验指定校验组
     */
    @PostMapping("/test2")
    public String test2(@RequestBody @Validated({GroupIdentityCheck.class, Default.class}) UserBiz userBiz,
                        BindingResult bindingResult) {
        Map<String, String> fieldErrorMap = ValidateRetUtil.getFieldErrorsMap(bindingResult);
        if(fieldErrorMap != null) {
            logger.warn(fieldErrorMap.toString());
        }
        logger.info(userBiz.toString());
        return "使用@Validated注解指定校验组";
    }

    /**
     * 构建校验器校验
     */
    @PostMapping("/test3")
    public String test3(@RequestBody UserBiz userBiz) {
        //Set<ConstraintViolation<Object>> violationSet = myValidator.validate(userBiz, GroupStudentCheck.class);
        Set<ConstraintViolation<Object>> violationSet = defaultValidator.validate(userBiz, GroupStudentCheck.class);
        Map<String, String> violationsMap = ValidateRetUtil.getConstraintViolationsMap(violationSet);
        if(violationsMap != null) {
            logger.warn(violationsMap.toString());
        }
        return "构建校验器校验";
    }
}
