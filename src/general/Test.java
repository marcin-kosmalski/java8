package general;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import utils.Base;

public class Test extends Base {

	public static void main(String[] args) {

		new Test();
	}

	public Test() {
		p(extractPresent(Arrays.asList(Optional.<String> ofNullable(null),
				Optional.<String> ofNullable("kkk"))));
	}

	static <T> List<T> extractPresent(List<java.util.Optional<T>> opts) {
		return opts.stream().filter(p -> p.isPresent()).map(p -> p.get())
				.collect(Collectors.toList());
	}

	static <T> List<T> extractPresent2(List<java.util.Optional<T>> opts) {
		return opts.stream().filter(Optional::isPresent).map(Optional::get)
				.collect(Collectors.toList());
	}

}
