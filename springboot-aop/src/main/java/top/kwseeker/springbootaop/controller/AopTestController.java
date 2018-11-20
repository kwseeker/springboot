package top.kwseeker.springbootaop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.kwseeker.springbootaop.service.IAopTestService;

@RestController
@RequestMapping("/aopMod")
public class AopTestController {

    private final static Logger logger = LoggerFactory.getLogger(AopTestController.class);

    @Autowired
    IAopTestService aopTestService;

    @GetMapping("/greet")
    public String greet() {
        return "Hello, This is a test for Spring AOP";
    }

    @GetMapping("/testAop")
    public String testAop() {
        logger.info("进入testAop()...");
        aopTestService.aopTest();
        logger.info("退出testAop()...");
        return "testAop";
    }

}
