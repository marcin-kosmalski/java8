package algorithms;

//Program to swap numbers without Using temp variable:
public class ExampleSwapNumbers {

	public static void main(String[] args) {

		int n1 = 3;
		int n2 = 5;

		System.out.println("Before: " + n1 + " - " + n2);
		n1 = n1 + n2;
		n2 = n1 - n2;
		n1 = n1 - n2;
		System.out.println("After: " + n1 + " - " + n2);
	}

}