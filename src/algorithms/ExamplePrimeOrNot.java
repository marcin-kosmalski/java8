package algorithms;

import java.util.Scanner;

public class ExamplePrimeOrNot {

	public static void main(String[] args) {

		System.out.println("Please enter a number: ");
		Scanner reader = new Scanner(System.in);
		long num = reader.nextLong();

		checkPrimeorNot(num);
	}

	private static void checkPrimeorNot(long n) {
		long j = 0;

		if (n == 1) {
			System.out.println("1 is not prime");
			return;
		}
		// We don;t need to go further than n/2 to check if n is prime
		for (long i = 2; i <= n / 2; i++) {
			if (n % i == 0) {
				System.out.println("Number: " + n + " is Not Prime.");
				System.out.println("One of the factors is " + i);
				return;
			}
		}

		System.out.println("Number: " + n + " is Prime. ");

	}

}