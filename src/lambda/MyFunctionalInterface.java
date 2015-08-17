package lambda;

@FunctionalInterface
public interface MyFunctionalInterface {

	void myMethod();
	
	//nur eine Methode erlaubt
	//void myMethod2();
	
	static void staticMethod(){
	
		System.out.println("Static Method!");
		
	}
	
}
