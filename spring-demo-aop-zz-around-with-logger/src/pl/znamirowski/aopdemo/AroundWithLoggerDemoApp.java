package pl.znamirowski.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.znamirowski.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {

	private static Logger myLogger =
			Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		myLogger.info("\nMain Program : AroundDemoApp");
		myLogger.info("Calling getFortune");
		String data = theFortuneService.getFortune();
		myLogger.info("\nMy fortune is: " + data);
		myLogger.info("Finished");
		
		context.close();
	}

}
