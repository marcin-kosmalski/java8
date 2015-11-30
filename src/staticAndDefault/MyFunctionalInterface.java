package staticAndDefault;

@FunctionalInterface
public interface MyFunctionalInterface {

	void myMethod();

	// nur eine Methode erlaubt
	// void myMethod2();

	static void staticMethod() {

		System.out.println("Static Method!");

	}
	
	//is from Object
	String toString();

	static void staticMethod2() {

		System.out.println("Static Method2!");

	}
}
