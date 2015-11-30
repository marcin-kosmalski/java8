package staticAndDefault;


public class Test1 {

	public static void main(String[] args) {
		// subtest1();
		
		//staticMethod();
		//referenceMethod();
	}
	

	public static void defaultMethod(){
		
		new DefaultMethodKlass().defaultMethod();
		
	}
	
	public static void staticMethod(){
		
		MyFunctionalInterface.staticMethod();
	}

}
