package patterns.builder;

import java.util.function.Consumer;

public class ModelDao {

	public static void persist(Consumer<ModelBuilder> builder) {

		ModelBuilder myBuilder = new ModelBuilder();
		builder.accept(myBuilder);

		System.out.println(myBuilder.toString());

	}
}
