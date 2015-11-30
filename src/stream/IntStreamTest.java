package stream;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import utils.Base;

public class IntStreamTest extends Base {

	public static void main(String[] args) {
		new IntStreamTest();
	}

	public IntStreamTest() {

		create();

	}

	public void create() {

		p(IntStream.range(5, 10).boxed().collect(Collectors.toList()));
		p(IntStream.rangeClosed(5, 10).boxed().collect(Collectors.toList()));

		p(IntStream.iterate(1, it -> it + 1).limit(100).count());
	}

}
