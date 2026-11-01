package CH4;

import java.lang.*;
import java.util.*;

public class PokerGame {
	public static class Poker{
		public static String[] colors = new String[]{"桃","心","梅","磚"};
		public static String[] points = new String[]{"1","2","3","4","5","6","7","8","9","10","J","Q","K"};
	}

	public static void shuffle(){
		int colorsLength = PokerGame.Poker.colors.length;
		int pointsLength = PokerGame.Poker.points.length;
		for(var i = 0 ; i < colorsLength;i++){
			for(var j=0; j < pointsLength;j++){
				PokerGame.shufflePair();
			}
		}
	}

	public static void shufflePair(){
		int colorsLength = PokerGame.Poker.colors.length;
		int pointsLength = PokerGame.Poker.points.length;
		var random = new Random();
		int randomColorIndex = random.nextInt(colorsLength);
		int randomPointIndex = random.nextInt(pointsLength);
		String randomColor = PokerGame.Poker.colors[randomColorIndex];
		String randomPoint = PokerGame.Poker.points[randomPointIndex];
		System.out.printf("%s %s ",randomColor,randomPoint);
	}

	public static void main(String[] args) {
		// 2.
		PokerGame.shuffle();
	}
}
