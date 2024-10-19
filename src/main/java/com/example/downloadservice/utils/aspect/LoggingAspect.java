package com.example.downloadservice.utils.aspect;

import com.example.downloadservice.utils.utils.NodeIdProvider;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("within(@com.example.downloadservice.utils.annotation.Logging *)")
    public Object logMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        MDC.put("nodeId", NodeIdProvider.getNodeId());
        try {
            // Log entering the method
            String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
            String methodName = joinPoint.getSignature().getName();
            logger.info("{}.{}() :: entered",className, methodName);

            // Proceed with the method execution
            Object result = joinPoint.proceed();

            // Log exiting the method
            logger.info("{}.{}() :: exited",className, methodName);
            return result;
        } finally {
            MDC.clear();
        }
    }
}