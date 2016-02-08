package algorithms;

public class FactorialWithAndWithoutRecursion {

	public static void main(String[] args) {
		System.out.println("5!  = " + factorial2(5));
		System.out.println("5!  = " + factorial(5));
	}

	public static long factorial2(int num) {

		long sum = 1;
		while (num > 0) {
			sum *=  num--;
		}
		return sum;

	}

	public static long factorial(int num) {

		return num * (num == 1 ? 1 : factorial(num - 1));

	}

}