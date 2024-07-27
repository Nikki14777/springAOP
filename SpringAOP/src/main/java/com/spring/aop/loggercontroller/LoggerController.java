package com.spring.aop.loggercontroller;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerController {
	
	
	@Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
	public void pointCutForRepoAndRestController() {}
	
    
    @Around("pointCutForRepoAndRestController()")
    public Object logInAround(ProceedingJoinPoint joinPoint) throws Throwable {
        
    	 System.out.println("Entering method: " + joinPoint.getSignature().getName());
         
         // Log the input arguments
         Object[] args = joinPoint.getArgs();
         for (Object arg : args) {
             System.out.println("Argument: " + arg);
         }
         
         // Proceed with method execution and capture the response
         Object result = joinPoint.proceed();
         
         // Log the response
         System.out.println("Response: " + result);
         
         System.out.println("Exiting method: " + joinPoint.getSignature().getName());
         return result;
    }
	
	
 	
 	
}
