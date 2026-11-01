package CH4;

import java.util.*;

public class ArrayHandler {
	final static int NOTFOUND = -1; 
	public static int searchAt(int[] numbers,int target){
		int numbersLength = numbers.length;
		for(var i=0;i<numbersLength;i++){
			if(numbers[i] == target){
				return i;
			}
		}
		return ArrayHandler.NOTFOUND;
	}	

	public static void main(String[] args) {
		// 4.
		int[] numbers = new int[]{1,10,31,33,37,48,60,70,80};
		var scanner = new Scanner(System.in);
		System.out.println("Enter an integer for searching:");
		int inputNumber = scanner.nextInt();
		int foundIndex = ArrayHandler.searchAt(numbers, inputNumber);
		System.out.printf("%d is searched at index %d.%n",inputNumber,foundIndex);
	}
}
