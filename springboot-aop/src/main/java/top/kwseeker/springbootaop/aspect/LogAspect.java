package top.kwseeker.springbootaop.aspect;

import com.google.gson.Gson;
import eu.bitwalker.useragentutils.UserAgent;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

/**
 * 使用切面实现非侵入式的日志
 * 日志用于捕捉请求的参数数据
 */
@Aspect
//@Component
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    private static final String REQUEST_START_TIME = "request-start-time";
    private static final String cutPointExecute = "execution(public * top.kwseeker.springbootaop.controller..*.*(..))";

    @Before(cutPointExecute)
    public void beforeLog(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();   //TODO: RequestContextHolder
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();
        String requestHeader = request.getHeader("User-Agent");
        UserAgent userAgent = UserAgent.parseUserAgentString(requestHeader);      //TODO: UserAgent

        logger.info("【请求 IP】：{}", request.getRemoteAddr());
        logger.info("【请求 URL】：{}", request.getRequestURL());
        logger.info("【请求类名】：{}，【请求方法名】：{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());   //TODO: JointPoint
        Map<String, String[]> parameterMap = request.getParameterMap();
        logger.info("【请求参数】：{}", new Gson().toJson(parameterMap, Map.class));
        logger.info("【浏览器类型】：{}，【操作系统】：{}，【原始User-Agent】：{}",
                userAgent.getBrowser().toString(), userAgent.getOperatingSystem().toString(), requestHeader);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info("【请求时间】: {}", sdf.format(new Date()));

        Long requestTimeInMillis = System.currentTimeMillis();
        request.setAttribute(REQUEST_START_TIME, requestTimeInMillis);
    }

    //@Around 兼具 @Before @After的功能
    @Around(cutPointExecute)
    public Object aroundLog(ProceedingJoinPoint proceedingJoinPoint) {
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
            logger.info("【请求返回值】：{}", new Gson().toJson(result, Object.class));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;
    }

    @After(cutPointExecute)
    public void afterLog() {
        Long responseTimeInMillis = System.currentTimeMillis();
        Date now = new Date();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();
        Long requestDealTime = responseTimeInMillis - (Long)request.getAttribute(REQUEST_START_TIME);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        logger.info("【响应时间】：{},【请求处理时间】：{}ms", sdf.format(now), requestDealTime);
    }

}
