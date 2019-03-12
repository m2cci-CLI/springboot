package com.training.springcore.bigcorp.config;


import com.training.springcore.bigcorp.service.SiteService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MonitoredAspect {
    private final static Logger logger = LoggerFactory.getLogger(SiteService.class);
    @Before("@annotation(com.training.springcore.bigcorp.service.Monitored)")

    public void logServiceBeforeCall(JoinPoint jp) {
        logger.debug("Appel finder " + jp.getSignature());
    }
}
