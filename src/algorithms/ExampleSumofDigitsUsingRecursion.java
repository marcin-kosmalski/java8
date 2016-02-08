package algorithms;

import java.util.Scanner;

public class ExampleSumofDigitsUsingRecursion {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number");
		int num = sc.nextInt();

		System.out.println("Sum of digits of " + num + " is " + sum(num));
	}

	public static long sum(int num) {
		return num == 0 ? 0 : num % 10 + sum(num / 10);
	}

}