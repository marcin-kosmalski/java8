package general;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysSortWithComparator {

	public static void main(String[] args) {


		Unit[] unitArray={Unit.create(5, 1), Unit.create(9, 1),
				Unit.create(4, 2), Unit.create(6, 2)};

		
		Arrays.sort(unitArray,Comparator.comparing(Unit::getId).thenComparing(Unit::getNumber).reversed());
		
		System.out.println(Arrays.asList(unitArray));

	}

}
