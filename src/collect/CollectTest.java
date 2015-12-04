package collect;

import general.Unit;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

import utils.Base;

public class CollectTest extends Base {

	public static void main(String[] args) {
		new CollectTest();
	}

	public CollectTest() {

		// groupBy();
		// groupByIntToList();
		// partitionByEvenOddNumber();
		// groupBySum();
		// groupByMaxNum();
		// joinWithPrefix();
		// collectToMap();

		getIdWithMaxNumUnits();
	}

	public void collectToMap() {

		p(Arrays.asList(Unit.create(5, 1), Unit.create(9, 1),
				Unit.create(4, 2), Unit.create(6, 2)).stream()
				.collect(Collectors.toMap(u -> u.getNumber(), u -> u.getId())));

		p(Arrays.asList(Unit.create(5, 1), Unit.create(9, 1),
				Unit.create(4, 2), Unit.create(6, 2))
				.stream()
				.collect(
						Collectors.toMap(u -> u.getId(), u -> u.getNumber(), (
								u1, u2) -> (u1 < u2) ? u2 : u1)));

	}

	public void getIdWithMaxNumUnits() {

		p(Arrays.asList(Unit.create(5, 1), Unit.create(9, 1),
				Unit.create(4, 2), Unit.create(6, 2), Unit.create(60, 2))
				.stream()
				.collect(
						Collectors.groupingBy(u -> u.getId(),
								Collectors.counting())).entrySet().stream()
				.max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).get());

	}

	public void groupBy() {
		p(Arrays.asList(Unit.create(5, 1), Unit.create(9, 1),
				Unit.create(4, 2), Unit.create(6, 2)).stream()
				.collect(Collectors.groupingBy(u -> u.getId())));
	}

	public void groupByIntToList() {
		p(Arrays.asList(Unit.create(5, 1), Unit.create(9, 1),
				Unit.create(4, 2), Unit.create(6, 2))
				.stream()
				.collect(
						Collectors.groupingBy(u -> u.getId(), Collectors
								.mapping(u -> u.getNumber(),
										Collectors.toList()))));

	}

	public void groupBySum() {
		p(Arrays.asList(Unit.create(5, 1), Unit.create(9, 1),
				Unit.create(4, 2), Unit.create(6, 2))
				.stream()
				.collect(
						Collectors.groupingBy(u -> u.getId(), Collectors
								.summingInt((Unit u) -> u.getNumber()))));

	}

	public void joinWithPrefix() {

		p(Arrays.asList(Unit.create(5, 1), Unit.create(9, 1),
				Unit.create(4, 2), Unit.create(6, 2)).stream()
				.map(u -> u.toString())
				.collect(Collectors.joining(" -- ", "<<<<<", ">>>>>")));

	}

	public void groupByMaxNum() {
		p(Arrays.asList(Unit.create(5, 1), Unit.create(9, 1),
				Unit.create(4, 2), Unit.create(6, 2))
				.stream()
				.collect(
						Collectors.groupingBy(u -> u.getId(), Collectors
								.maxBy(Comparator.comparing((Unit u) -> u
										.getNumber())))));
	}

	public void partitionByEvenOddNumber() {

		p(Arrays.asList(Unit.create(5, 1), Unit.create(9, 1),
				Unit.create(4, 2), Unit.create(6, 2))
				.stream()
				.collect(Collectors.partitioningBy(u -> u.getNumber() % 2 == 0)));

	}

}
