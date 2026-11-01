package CH11.practice1;

import CH11.practice1.*;

public class Tortoise extends Competitor{

	public Tortoise(int totalStep){
		super(totalStep, "tortoise", false,1);
	}

	// entry point for test
	public static void main(String[] args) {
		Tortoise tortoise = new Tortoise(10);
		tortoise.startCompetition();
	}
}