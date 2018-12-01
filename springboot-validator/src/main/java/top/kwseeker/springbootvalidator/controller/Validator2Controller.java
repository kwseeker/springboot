package top.kwseeker.springbootvalidator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@RestController
@RequestMapping("/validate2")
@Validated
public class Validator2Controller {

    private final static Logger logger = LoggerFactory.getLogger(Validator2Controller.class);

    /**
     * 方法校验
     */
    @PostMapping("/test4")
    public @NotBlank String test4(@RequestParam("userId") @Min(1000000) Integer userId) {
        logger.info("userId:" + userId);
        return "方法校验";
    }
}
