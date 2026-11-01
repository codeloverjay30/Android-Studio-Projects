package CH5;

import java.util.*;

public class HanoiTower{
	private int numDisk;
	private String[] stickNames;
	private int currentSteps;
	private int steps;

	public HanoiTower(int numDisk,String[] stickNames){
		this.numDisk = numDisk;
		this.stickNames = stickNames;
		this.currentSteps = 0 ;
		this.steps = (int)Math.pow(2.0,(double)this.numDisk) - 1;
	}

	public void move(){
		this.move(this.stickNames[0],this.stickNames[1],this.stickNames[2],this.currentSteps,this.steps);
	}

	public void move(String src,String aux,String dest,int currentSteps,int steps){
		if(currentSteps == steps) 
			return;
		currentSteps++;
		this.move(src,dest,aux,currentSteps,steps);
		System.out.printf("move disk from %s to %s.%n",src,dest);
		currentSteps++;
		this.move(aux,src,dest,currentSteps,steps);
	}

	public static void main(String[] args) {
		var numDisk = 3;
		var stickNames = new String[]{"A","B","C"};		
		var hanoiTower = new HanoiTower(numDisk,stickNames);
		hanoiTower.move();
	}
}