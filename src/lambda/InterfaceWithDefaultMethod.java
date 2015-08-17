package lambda;


public interface InterfaceWithDefaultMethod {

	
	void normalMethod();
	

	default void defaultMethod(){
		System.out.println("Default Method!");
		
		normalMethod();
	}
}
