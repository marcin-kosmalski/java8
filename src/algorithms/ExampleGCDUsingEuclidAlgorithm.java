package algorithms;

import java.math.BigInteger;
import java.util.Scanner;

//the Euclidean algorithm[a], or Euclid's algorithm, 
//is an efficient method for computing the greatest common divisor (GCD) of two numbers,

//Der größte gemeinsame Teiler

public class ExampleGCDUsingEuclidAlgorithm {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter first number: ");
		int num1 = sc.nextInt();

		System.out.println("Enter second number: ");
		int num2 = sc.nextInt();

		System.out.println("GCD1 = " + gcdRecursion(num1, num2));

		System.out.println("GCD2 = "
				+ BigInteger.valueOf(num1).gcd(BigInteger.valueOf(num2)));
	}

	public static int gcdRecursion(int n1, int n2) {
		if (n2 == 0)
			return n1;
		else
			return gcdRecursion(n2, n1 % n2);
	}

}
