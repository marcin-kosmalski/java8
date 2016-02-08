package algorithms;

import java.util.Scanner;

public class CalcPower {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter base number: ");
		int baseNumber = sc.nextInt();

		System.out.println("Enter power number: ");
		int power = sc.nextInt();

		System.out.println(power(baseNumber, baseNumber, power));
	}

	private static long power(int base, int power, int result) {
		if (power <= 1) {
			return result;
		}
		return power(base, power - 1, result * base);
	}

}
