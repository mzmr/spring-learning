package pl.znamirowski.springdemo;

import org.springframework.stereotype.Component;

@Component
public class SingingCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Practice singing very high pitches";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}
