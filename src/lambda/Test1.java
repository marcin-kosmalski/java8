package lambda;

import java.util.Arrays;
import java.util.List;

public class Test1 {

	public static void main(String[] args) {
		// subtest1();

		//new Test1().effectivelyFinal();
		
		//staticMethod();
		
		referenceMethod();
	}
	
	public static void referenceMethod(){
		
		List<String> list1 = Arrays.asList("test22", "test333", "test1");
		list1.sort(Test1::compare);
		list1.forEach(System.out::println);
		
		List<Integer> list2 = Arrays.asList(22,333, 1);
		list2.sort(Integer::compare);
		list2.forEach(System.out::println);
	}
	
	public static int compare(String str1,String str2){
		return Integer.compare(str1.length(),str2.length());
	}
	
	public static void defaultMethod(){
		
		new DefaultMethodKlass().defaultMethod();
		
	}
	
	public static void staticMethod(){
		
		MyFunctionalInterface.staticMethod();
	}

	public static void sortAndAusgibtMitLambda() {

		List<String> list = Arrays.asList("test22", "test333", "test1");

		list.sort((str1, str2) -> (Integer.compare(str1.length(), str2.length())));

		list.forEach(it -> System.out.println(it));

	}

	public void effectivelyFinal() {

		int var = 8;

		Runnable runnable = () -> {
			System.out.println("effecively final: "+var);
			System.out.println(this);
		};
		
		//effecively final
		//var=9;

		new Thread(runnable).start();
	}

}
