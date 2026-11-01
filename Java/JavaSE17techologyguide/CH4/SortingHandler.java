package CH4;

public class SortingHandler {

	/*
	Use bubble sort.
	See [bubble sort](https://www.geeksforgeeks.org/bubble-sort-algorithm/)
	*/

	public static int[] sorted(int[] numbers){
		int numbersLength = numbers.length;
		boolean hasSwapped = false;
		for(var i=0;i < numbersLength-1 ; i++){
			for(var j=0;j<numbersLength-1-i;j++){
				if(numbers[j] > numbers[j+1]){
					SortingHandler.swapWithIndex(numbers,j, j+1);
					hasSwapped = true;
				}
			}

			if(hasSwapped == false){
				break;
			}
		}
		return numbers;
	}
	private static int[] swapWithIndex(int[] numbers,int i,int j){
		int temp = numbers[i];
		numbers[i] = numbers[j] ;
		numbers[j] = temp;
		return numbers;
	}
	private static void printNumbers(int[] numbers){
		int numbersLength = numbers.length;
		for(var i=0;i<numbersLength;i++){
			System.out.printf("%d\t",numbers[i]);
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// 3.
		int[] numbers = new int[]{70,80,31,37,10,1,48,60,33,80};
		SortingHandler.printNumbers(numbers);
		numbers = SortingHandler.sorted(numbers);
		SortingHandler.printNumbers(numbers);
	}	
}
