package demo.spring.aopdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(value = 1)
public class MyDemoLoggingAspect {
	
	// this is where we add all of our related advice for logging
	
	// Implement Around Advice, Execute this before and after that method
	@Around("execution(* demo.spring.aopdemo.service.*.get*(..))")
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		
		// print out the method that we are advising on
		String method = proceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n====>>> Executing @Around on method : "+method);
		
		// get the begin time-stamp
		long begin = System.currentTimeMillis();
		
		// execute the method
		Object result = null;
		
		try {
			result = proceedingJoinPoint.proceed();
		} 
		catch (Exception e) {
			// log the exception and give user a custom message
			System.out.println(e.getMessage());
			//result = "\nHighway is being cleared, Hold your Position";
			return e.toString();
			
			// Rethrowing the Exception
			// throw e;
		} 
		
		// get the end time-stamp
		long end = System.currentTimeMillis();
		
		// compute the duration and display it
		long duration = end - begin;
		System.out.println("\n====>>> Duration : "+duration / 1000.0 +" seconds");
		
		return result;
	}
	
}
