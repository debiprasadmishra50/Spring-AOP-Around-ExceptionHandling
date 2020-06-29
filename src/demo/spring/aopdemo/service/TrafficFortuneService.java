package demo.spring.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {
	
	public String getFortune() {
		
		//Simulate a delay
		try {
//			Thread.sleep(5000);
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//return a fortune
		return "Expect heavy traffic this morning";
	}

	public String getFortune(boolean tripware) {
		
		if(tripware)
			throw new RuntimeException("\nException : Accident!, Highway is closed");

		return getFortune();
	}
}
