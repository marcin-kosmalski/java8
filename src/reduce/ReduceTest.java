package reduce;

import java.util.Arrays;

import utils.Base;

public class ReduceTest extends Base {

	public static void main(String[] args) {
		new ReduceTest();
	}

	public ReduceTest() {

		explicitForm();

		generalizedForm();

	}

	public void generalizedForm() {

		// used for optimization if not necessery
		p(Arrays.asList(1, 2, 3, 4).stream()
				.reduce(1, (v1, v2) -> v1 * v2, Integer::min));
	}

	public void explicitForm() {

		// returns integer with identit and accumulator
		p(Arrays.asList(1, 2, 3, 4).stream().reduce(0, Math::max));
		
	

		// returns optional only with accumulator
		p(Arrays.asList(1, 2, 3, 4).stream().reduce((k1, k2) -> k1 + k2).get());

		p(Arrays.asList(1, 2, 3).stream().reduce((k1, k2) -> k1 * k2).get());

	}

}
