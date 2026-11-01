package CH4;

import java.lang.*;
import java.util.*;

public class NumberHandler{
	public static class FibonacciHandler{
		public static ArrayList<Integer> fibonacciArray = new ArrayList<Integer>();
		public static void build(int n){
			NumberHandler.FibonacciHandler.fibonacciArray.add(0);
			NumberHandler.FibonacciHandler.fibonacciArray.add(1);
			for(var i=2;i<=2000;i++){
				var t = NumberHandler.FibonacciHandler.fibonacciArray.get(n-1)+NumberHandler.FibonacciHandler.fibonacciArray.get(n-2);
				NumberHandler.FibonacciHandler.fibonacciArray.add(t);
			}
		}

		public static void reset(){
			NumberHandler.FibonacciHandler.fibonacciArray.clear();
		}
	}
	
	public static void main(String[] args){
		// # 1.
		var n = 10;
		for(var i =0 ; i<n;i++){
			var t = NumberHandler.FibonacciHandler.fibonacciArray.get(i);
			System.out.printf("%d ",t);
		}
	}
}
