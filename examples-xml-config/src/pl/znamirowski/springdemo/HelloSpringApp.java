package pl.znamirowski.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		Coach theCoach = context.getBean("mySwimmingCoach", Coach.class);
		Coach swimmCoach = context.getBean("mySwimmingCoach", Coach.class);
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		if (theCoach == swimmCoach) {
			System.out.println("Coaches are the same instance :D");
		} else {
			System.out.println("Unfortunately, coaches are different.");
		}
		
		context.close();
		
	}

}
