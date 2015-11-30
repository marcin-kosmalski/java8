package optional;

import java.util.Arrays;
import java.util.Optional;

public class OptionalAggregation {

	public static void main(String[] args) {
		findAny();
		findFirst();
	}

	public static void findFirst() {
		Arrays.asList(1, 2, 8, 2, 5, 4, 7).stream().filter(v -> v > 3)
				.findFirst().ifPresent(v -> System.out.println("Value: " + v));

	}

	public static void findAny() {

		Arrays.asList(1, 2, 8, 2, 5, 4, 7).stream().filter(v -> v > 3)
				.findAny().ifPresent(v -> System.out.println("Value: " + v));

	}
	
	class Driver {
	    void foo(Optional<String> x) { }

	    public  void k() {
	        foo(Optional.empty());
	    }
	}
}
