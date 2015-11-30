package patterns.decorator;

import utils.Base;

public class DecoratorTest extends Base {

	public static void main(String[] args) {
		new DecoratorTest();
	}

	public DecoratorTest() {
		
		Decorator decorator=new Decorator();
		decorator.setFilters(t->t.split("-")[0],t->t.trim(),t->"["+t+"]");
		p(decorator.transform("kkkk - mmm"));

	}

}
