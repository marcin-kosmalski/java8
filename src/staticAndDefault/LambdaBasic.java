package staticAndDefault;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

public class LambdaBasic {

	public static void main(String[] args) {

		listeDurchlaufen();
		listeDurchlaufen2();
		listeSortieren();
		listeManipulieren();

	}

	private static void listeManipulieren() {
		List<String> toPrintList = Arrays.asList("a", "b", "c");
		toPrintList.replaceAll(x -> x + "_m");

		toPrintList.forEach(e -> System.out.println(e));

	}

	private static void listeDurchlaufen() {
		List<String> toPrintList = Arrays.asList("a", "b", "c");
		toPrintList.forEach(e -> System.out.println(e));
	}

	private static void listeDurchlaufen2() {

		List<String> toPrintList = Arrays.asList("a", "b", "c");
		toPrintList.forEach(e -> {

			if (e == null) {
				throw new NullPointerException();
			}

			System.out.println(e);

		});
	}

	private static void listeSortieren() {
		List<Integer> toSortList = Arrays.asList(3, 2, 9, 4, 1, 6);
		toSortList.sort((x, y) -> x - y);

		toSortList.forEach(e -> System.out.println(e));
	}
}
