package stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import utils.Base;

public class StreamTest extends Base {

	public static void main(String[] args) {
		new StreamTest();
	}

	public StreamTest() {

		createStream();
	}

	public void createStream() {
		Stream.empty();
		Stream.of(1, 2, 3, 4, 5, 6, 10);
		p(Stream.builder().add(5).add(6).build().map(it->String.valueOf(it)).collect(Collectors.joining(", ")));
		
	}

}
