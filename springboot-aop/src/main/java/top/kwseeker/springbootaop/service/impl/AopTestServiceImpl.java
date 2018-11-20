package top.kwseeker.springbootaop.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import top.kwseeker.springbootaop.service.IAopTestService;

@Service
public class AopTestServiceImpl implements IAopTestService {

    private static final Logger logger = LoggerFactory.getLogger(AopTestServiceImpl.class);

    @Override
    public void aopTest() {
        logger.info("进入aopTest()...");
    }
}
