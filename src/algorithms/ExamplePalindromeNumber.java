package algorithms;

import java.util.Scanner;
//The program first reverses a number and then checks if given number and reverse numbers are equal. 
//If they are equal, then its a palindrome.
public class ExamplePalindromeNumber {

	public static void main(String[] args) {

		int num, temp, remainder, reverse = 0;
		System.out.println("Enter an integer");

		try (Scanner sc = new Scanner(System.in);) {
			num = sc.nextInt();
		}
		temp = num;
		while (num > 0) {
			remainder = num % 10;
			reverse = reverse * 10 + remainder;
			num /= 10;
		}
		System.out.println("\nGiven number is " + temp + ". Its reverse is "
				+ reverse);
		if (temp == reverse)
			System.out.println("\nNumber is a palindrome");
		else
			System.out.println("\nNumber is not a palindrome");

	}

}
