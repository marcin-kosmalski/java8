package patterns.decorator;

import java.util.function.Function;
import java.util.stream.Stream;

public class Decorator {

	public Decorator() {
		setFilters();
	}

	private Function<String, String> filters;

	public void setFilters(Function<String, String>... filters) {
		this.filters = Stream.of(filters)
				.reduce((filter, next) -> filter.andThen(next))
				.orElseGet(Function::identity);
	}

	public String transform(String text) {
		return this.filters.apply(text);
	}

}
