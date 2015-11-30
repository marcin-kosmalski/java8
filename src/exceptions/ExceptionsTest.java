package exceptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import utils.Base;

public class ExceptionsTest extends Base {

	public static void main(String[] args) {
		new ExceptionsTest();
	}

	public ExceptionsTest() {

		toUncheckedException();
		exceptionInFunctionDef();

	}

	public void toUncheckedException() {
		Stream.of(".").map(str -> Paths.get(str)).map(path -> {
			try {
				return Files.readAllBytes(path);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}).findFirst().get();
	}

	public void exceptionInFunctionDef() {

		try {
			p(StringUtils.append("mmm", eh -> eh.append("xxx")).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			p(StringUtils.append("m", eh -> eh.append("xxx")).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
