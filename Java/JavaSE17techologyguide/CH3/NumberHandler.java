//package CH3;

import java.lang.*;
import java.util.*;

import CH4.NumberHandler;

public class NumberHandler{
	public static class FactorHandler{
		public static int getMaxFactor(int m, int n){
			ArrayList<Integer> factorsOfM = NumberHandler.FactorHandler.getFactors(m);
			ArrayList<Integer> factorsOfN = NumberHandler.FactorHandler.getFactors(n);
			ArrayList<Integer> commonFactors = NumberHandler.ArrayListHandler.getCommonElements(factorsOfM, factorsOfN);
			int maxFactor = NumberHandler.ArrayListHandler.max(commonFactors);
			return maxFactor;
		}
		public static ArrayList<Integer> getFactors(int m){
			ArrayList<Integer> factors = new ArrayList<Integer>();
			
			factors.add(1);
			for(var i=2;i<Math.sqrt(m);i++){
				if(m % i == 0 ){
					factors.add(i);
				}
			}
			return factors;
		}
	}	

	public static class ArmstrongNumberHandler{
		public static boolean isArmStrongNumber(int m){
			ArrayList<Integer> digits = NumberHandler.DigitHandler.getDigits(m);
			var total = 0;
			var length = digits.size();
			for(var i=0;i<length;i++){
				var digit = digits.get(i);
				total += Math.pow(digit, length);
			}
			return total == m;
		}
	}

	public static class DigitHandler{
		public static ArrayList<Integer> getDigits(int m){
			ArrayList<Integer> digits = new ArrayList<Integer>();
			var num = m;
			while(num > 1){
				digits.add(num%10);
				num /= 10;
			}
			Collections.reverse(digits);
			return digits;
		}
	}

	public static class ArrayListHandler{
		public static <T> ArrayList<T> getCommonElements(ArrayList<T> arrayList1,ArrayList<T> arrayList2){
			ArrayList<T> commonArrayList = new ArrayList<T>();

			int minLength = Math.min(arrayList1.size(), arrayList2.size());
			for(var i=0;i<minLength;i++){
				var arrayList1Elem = arrayList1.get(i);
				var arrayList2Elem = arrayList2.get(i);
				if(arrayList1Elem.equals(arrayList2Elem)){
					commonArrayList.add(arrayList1Elem);
				}
			}
			return commonArrayList;
		}

		public static int max(ArrayList<Integer> arrayList){
			var length = arrayList.size();
			var maxValue = Integer.MIN_VALUE;
			for(var i =0;i<length;i++){
				maxValue = Math.max(arrayList.get(i),maxValue);
			}
			return maxValue;
		}
	}

	public static void main(String[] args){
		// # 1.
		var m = 1000;
		var n = 495;

		System.out.printf("max factor of %d and %d is %d.%n",m,n,NumberHandler.FactorHandler.getMaxFactor(m,n));

		// # 2.
		for(var i=100;i<1000;i++){
			System.out.printf("i:%d is an armstrong number? %b.%n",i,NumberHandler.ArmstrongNumberHandler.isArmStrongNumber(i));
		}
	}
}
