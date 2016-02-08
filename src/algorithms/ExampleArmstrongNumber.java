package algorithms;

import java.util.Scanner;

//An Armstrong number of three digits is an integer such that the sum of^
//the cubes of its digits is equal to the number itself.
//There are just four 3-digit numbers which are the sums of the cubes of their digits:
// 
//153=1^3+5^3+3^3

public class ExampleArmstrongNumber {

	public static void main(String[] args) {

		int number, remainder, sum = 0;

		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter an Integer:");
		number = sc.nextInt();

		for (int i = number; i > 0; i = i / 10) {
			remainder = i % 10;
			sum = sum + remainder * remainder * remainder;
		}

		if (sum == number) {
			System.out.println("\n" + number + " is an Armstrong Number\n");
		} else {
			System.out.println("\n" + number + " is Not an Armstrong Number\n");
		}

	}

}
