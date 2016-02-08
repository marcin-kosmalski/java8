package algorithms;

//f(n) = f(n-1) + f(n-2)
public class Fibonacci {

	public static void main(String[] args) {

		int n = 10;

		for (int i = 0; i <= n; i++) {
			System.out.println("Fibonacci(" + i + ") = " + fibonacci(i));// 55
		}
	}

	public static long fibonacci(int num) {
		if (num == 1) {
			return 1;
		}
		if (num == 0) {
			return 0;
		}
		return fibonacci(num - 1) + fibonacci(num - 2);
	}
}
