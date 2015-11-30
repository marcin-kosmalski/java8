package map;

import java.util.Arrays;

public class MapTest {

	public static void main(String[] args) {
		new MapTest();
	}
	
	public MapTest(){
		Arrays.asList(1,5,3,7,2).stream().map(v->v*3).forEach(System.out::println);
		
		
		Arrays.asList("1","5","3","7").stream().mapToDouble(v->Double.valueOf(v)).forEach(System.out::println);
		
		Arrays.asList("1","5","3","7").stream().mapToInt(v->Integer.valueOf(v)).forEach(System.out::println);
		System.out.println(Arrays.asList("1","5","3","7").stream().mapToLong(v->Long.valueOf(v)).summaryStatistics().toString());
		

	}

}
