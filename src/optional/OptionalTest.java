package optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalTest {

	public static void main(String[] args) {

		System.out.println(Optional.ofNullable(null).isPresent());
		System.out.println(Optional.ofNullable("K").get());

		System.out.println(Optional.ofNullable(genStringList()));

		System.out.println(wrap(genStringList()));

		System.out.println(wrap(null).orElse("default"));

		try {
			System.out.println(genStringListOrMyException());
		} catch (MyException e) {
			e.printStackTrace();
		}

		try {
			System.out.println(nullToException(getNullStringList()));
		} catch (MyException e) {
			e.printStackTrace();
		}
	}

	public static <T> Optional<T> wrap(T t) {
		return Optional.ofNullable(t);
	}

	public static List<String> genStringList() {
		return Arrays.asList("1", "2", "kk");
	}

	public static List<String> getNullStringList() {
		return null;
	}

	public static <T, M> T nullToException(T input) throws MyException {
		return (T) Optional.ofNullable(input).orElseThrow(MyException::new);
	}

	public static List<String> genStringListOrMyException() throws MyException {
		return Optional.ofNullable(getNullStringList()).orElseThrow(
				MyException::new);
	}

}
