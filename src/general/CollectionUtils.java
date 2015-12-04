package general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class CollectionUtils {

	public static void main(String[] args) {
		new CollectionUtils();
	}

	public CollectionUtils() {

		List<Integer> list = new ArrayList<>(Arrays.asList(1, 3, 2, 8));
		System.out.println(list);
		list.removeIf(n -> n < 3);
		System.out.println(list);

		list.replaceAll(i -> i * 10);

		System.out.println(list);

	}
}
