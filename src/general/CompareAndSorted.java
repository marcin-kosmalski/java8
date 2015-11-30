package general;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import utils.Base;

public class CompareAndSorted extends Base {

	public static void main(String[] args) {
		new CompareAndSorted();
	}

	public CompareAndSorted() {
		// useIntegerCompare();
		// useCompareWithOwnImplementation();
		useComparatorComparingToCompare();
		useComparatorComparingToSort();

		simpleStringSort();
	}

	public void useComparatorComparingToCompare() {

		
		p(Arrays.asList(Unit.create(5, 1), Unit.create(9, 1),
				Unit.create(4, 2), Unit.create(6, 2)).stream()
				.min(Comparator.comparing(u -> u.getNumber())).get()
				.getNumber());
	}

	public void simpleStringSort() {

		// needs to implement Comparable
		Arrays.asList(Unit.create(5, 1), Unit.create(9, 1), Unit.create(4, 2),
				Unit.create(6, 2)).stream().sorted()
				.forEach(System.out::println);
	}

	public void useComparatorComparingToSort() {

		p(Arrays.asList(Unit.create(5, 1), Unit.create(9, 1),
				Unit.create(4, 2), Unit.create(6, 2))
				.stream()
				.sorted(Comparator.comparing((Unit u) -> u.getId())
						.thenComparing((Unit u) -> u.getNumber()))
				.collect(Collectors.toList()));
	}

	public void useIntegerCompare() {
		Arrays.asList(22, 333, 1).stream().sorted(Integer::compare)
				.forEach(System.out::println);
	}

	public void useCompareWithOwnImplementation() {
		List<String> list1 = Arrays.asList("test22", "test333", "test1");
		list1.sort(CompareAndSorted::compare);
		list1.forEach(System.out::println);

	}

	public static int compare(String str1, String str2) {
		return Integer.compare(str1.length(), str2.length());
	}

	public void sortWithoutReferenceMethods() {

		List<String> list = Arrays.asList("test22", "test333", "test1");

		list.sort((str1, str2) -> (Integer.compare(str1.length(), str2.length())));

		list.forEach(it -> System.out.println(it));

	}
}
