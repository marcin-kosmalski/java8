package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import utils.Base;

public class FileTest extends Base {

	public static void main(String[] args) {
		new FileTest();
	}

	public FileTest() {

		// listFiles();
		//
		// System.out.println("====dirs====");
		// listDirs();
		// System.out.println("====all====");
		// listFilesWithExtension(".xml");
		// System.out.println("====pom====");
		// printPomXML();
		// get5LargestFiles();

		IntStream.rangeClosed(1, 100).forEach(i -> printFilesAndLineCount());
		System.out.println("AVG: " + avg / 100);
	}

	int avg = 0;

	public void printFilesAndLineCount() {

		long time = GregorianCalendar.getInstance().getTimeInMillis();
		try (Stream<Path> pathStream = Files.walk(Paths.get("c:\\development"))) {

			pathStream
					.map(Path::toFile)
					.filter(File::isFile)
					.filter(f -> f.getName().endsWith(".java"))
					.collect(
							Collectors.toMap(
									f -> {
										try {
											return Files.lines(f.toPath()).count();
										} catch (Exception e) {
											// throw new RuntimeException(e);
										}
										return 0l;
									},
									f -> f.getName(),
									(s1, s2) -> s2,
									() -> new TreeMap<Long, String>(Comparator
											.reverseOrder()))).entrySet()
					.stream().map(e -> e.getValue() + "=" + e.getKey())
					.collect(Collectors.joining("\n"));

		} catch (IOException e) {
			e.printStackTrace();
		}

		long timeElapsed = GregorianCalendar.getInstance().getTimeInMillis()
				- time;
		avg += timeElapsed;
		// System.out.println(timeElapsed);
	}

	public void get5LargestFiles() {

		try (Stream<Path> pathStream = Files.walk(Paths.get("."))) {

			p(pathStream
					.map(Path::toFile)
					.filter(File::isFile)
					.collect(
							Collectors.toMap(
									f -> f.length(),
									(File f) -> f.getAbsolutePath(),
									(l1, l2) -> l2,
									() -> new TreeMap<Long, String>(Comparator
											.reverseOrder()))).entrySet()
					.stream().limit(5)
					.map(e -> e.getValue() + "=" + e.getKey())
					.collect(Collectors.joining("\n")));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void printPomXML() {

		try {
			new BufferedReader(new FileReader(Paths.get("pom.xml").toFile()))
					.lines().forEach(System.out::println);
			;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void listFilesWithExtension(String extension) {
		try {
			Files.newDirectoryStream(Paths.get("."),
					path -> path.toString().endsWith(extension)).forEach(
					System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void listDirs() {
		try {
			Files.list(Paths.get(".")).filter(Files::isDirectory)
					.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void listFiles() {
		try {
			Files.list(Paths.get(".")).forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
