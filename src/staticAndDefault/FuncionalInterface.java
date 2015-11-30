package staticAndDefault;

import java.util.function.Function;
import java.util.function.Predicate;

public class FuncionalInterface {

	public static void main(String[] args) {
		Runnable runnable = () -> System.out.println("test");

		Thread thread = new Thread(runnable);
		thread.start();

		Function<Integer, String> integerConcat = x -> x + "m";

		System.out.println(integerConcat.apply(3));

		Predicate<Integer> isBiggerThan5 = x -> x > 5;

		System.out.println(isBiggerThan5.test(3));
	}
}
