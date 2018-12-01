package top.kwseeker.springbootvalidator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@Configuration
public class ValidatorConfig {

    /**
     * Spring Boot 本身初始化了一个名为 defaultValidator 的 Validator 实例
     * 这里只是演示一下创建一个 Validator 实例的方法，更多参考 ValidationAutoConfiguration.class
     */
    @Bean(name = "myValidator")
    public Validator constructValidator() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        return validatorFactory.getValidator();
    }
}