package pl.znamirowski.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {

	private String fortunes[] = {
		"Some fortune text",
		"One of the threeee fortunes",
		"The fortune is fortune - nothing more, nothing less"
	};
	
	@Override
	public String getFortune() {
		int number = new Random().nextInt(3);
		return fortunes[number];
	}

}
