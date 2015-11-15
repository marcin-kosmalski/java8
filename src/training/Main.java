package training;

import java.util.stream.Stream;



public class Main {

	public static void main(String[] args) {
		
		
		Stream.of(3,2,1,5).sorted().forEach(System.out::println);

	}

}
