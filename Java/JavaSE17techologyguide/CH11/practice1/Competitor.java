package CH11.practice1;

import java.util.*;

public class Competitor {
	private int totalStep;
	private int movement = 1;
	private String name;
	private int currentStep = 0;
	private boolean canSleepInCompetition = false;

	private boolean[] sleepFlag = {true,false};

	public Competitor(int totalStep,String name,boolean canSleepInCompetition,int movement){
		this.totalStep = totalStep;
		this.name = name;
		this.canSleepInCompetition = canSleepInCompetition;
		this.movement = movement;
		this.currentStep = 0;
	}

	public Competitor(int totalStep,String name,boolean canSleepInCompetition){
		this(totalStep,name,canSleepInCompetition,1);
	}

	public void startCompetition(){
		this.currentStep = 0;
		while(true){
			if(this.finishCompetition()){
				break;
			}
			this.runOrSleep();
		}
		this.printFinishCompleteMessage();
	}

	private void runOrSleep(){
		if(this.canSleepInCompetition){
			this.tryToSleep();
		}else{
			this.move();
		}
	}

	private void tryToSleep(){
		var willSleep = this.sleepFlag[((int)Math.random()*10)%2];
		if(willSleep){
			this.sleep();
		}else{
			this.move();
		}
	}

	private void sleep(){
		this.printSleepMessage();
	}

	private void printSleepMessage(){
		System.out.printf("The competitor %s sleeps zzzz.%n",this.name);
	}

	private void move(){
		this.updateMovement();
		this.printRunMessage();

	}

	private void updateMovement(){
		this.currentStep += this.movement;
	}

	private void printRunMessage(){
		System.out.printf("The competitor %s moves %d steps.%n",this.name,this.movement);
	}

	private boolean finishCompetition(){
		return this.currentStep >= this.totalStep;
	}

	private void printFinishCompleteMessage(){
		System.out.printf("The competitor %s finish the completition.%n",this.name);
	}
}
