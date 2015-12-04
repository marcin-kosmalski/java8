package general;

import java.util.Random;
import java.util.SplittableRandom;

import utils.Base;

public class RandomTest extends Base{
	
	
	public static void main(String[] args) {
		new RandomTest();
	}
	
	public RandomTest(){
	
		new Random().ints(3).forEach(System.out::println);
		new Random().doubles(3).forEach(System.out::println);
		new Random().ints(3,1, 100).forEach(System.out::println);
		
	//	new SplittableRandom().split().
	}

}
