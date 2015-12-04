package stream;

import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import utils.Base;

public class StreamTest extends Base {

	public static void main(String[] args) {
		new StreamTest();
	}

	public StreamTest() {

		createStream();
		createStream2();
	}

	public void createStream() {
		Stream.empty();
		Stream.of(1, 2, 3, 4, 5, 6, 10);
		p(Stream.builder().add(5).add(6).build().map(it->String.valueOf(it)).collect(Collectors.joining(", ")));
		
	}
	
	public void createStream2() {
		Stream.empty();
		p(Stream.of(1, 2, 3, 4, 5, 6, 10).map(val->"["+val+"]").collect(Collectors.toCollection(TreeSet::new)));
		
	}

}
