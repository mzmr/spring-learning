package pl.znamirowski.springdemo;

public class SwimmingCoach implements Coach {
	
	private FortuneService fortuneService;

	public SwimmingCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Swim 5km without break 3 times";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
