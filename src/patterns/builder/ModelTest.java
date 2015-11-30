package patterns.builder;

import utils.Base;

public class ModelTest extends Base {

	public static void main(String[] args) {
		new ModelTest();
	}

	public ModelTest() {

		ModelDao.persist(m->m.id(3).text("mytest"));
		
	}

}
