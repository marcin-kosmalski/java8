package algorithms;


public class ExampleDecimalToBinaryUsingRecursion {

	public static void main(String[] args) {

		decToBin(7);
		System.out.println();
		decToBin(8);
		System.out.println();
		decToBin(9);

	}

	public static void decToBin(int n) {
		if (n > 0) {
			decToBin(n / 2);
			System.out.printf("%d", n % 2);
		}
	}

}
