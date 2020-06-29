package demo.spring.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import demo.spring.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {
	
	public static void main(String[] args) throws Exception {
		
		// read the spring configuration java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		// get the bean from spring container
		TrafficFortuneService fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		System.out.println("Main Program : AroundDemoMainApp");
		
		System.out.println("\nCalling getFortune()");
		
		boolean tripware = true; // tripware to simulate the application, make it true or false
		// if true, throw exception, if false, execute successfully
		String fortune = fortuneService.getFortune(tripware);
		
		// For Re-throwing the exception
//		String fortune = null;
//		try {
//			fortune = fortuneService.getFortune(tripware);
//		} catch (Exception e) {
//			System.out.println(e);
//		}
		
		System.out.println("\nMy fortune is : \n"+fortune);
		
		System.out.println("\nFinished");
		
		// close the context
		context.close();
	}
}
