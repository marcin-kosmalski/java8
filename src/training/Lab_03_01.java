package training;

/*
  Based on course material for "Lambdas & Streams", a seminar prepared
  and owned by Angelika Langer & Klaus Kreft.
  contact: http://www.AngelikaLanger.com/ or mailto: info@AngelikaLanger.com

  © Copyright 2013-2014 by Angelika Langer & Klaus Kreft. All rights reserved.

  Permission to use, copy, and modify this software for any non-profit
  purpose is hereby granted to attendants of the above mentioned seminar
  without fee, provided that the above copyright notice appears in all
  copies.  Angelika Langer and Klaus Kreft make no representations about
  the suitability of this software for any purpose.  It is provided
  "as is" without express or implied warranty.
 */

import java.awt.Point;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Lab_03_01 {
	private static final java.util.List<Point> points = generatePoints();

	private static java.util.List<Point> generatePoints() {
		java.util.List<Point> result = new ArrayList<>();
		result.add(new Point(1, 1));
		result.add(new Point(2, 2));
		result.add(new Point(3, 3));
		result.add(new Point(1, -1));
		result.add(new Point(2, -2));
		result.add(new Point(3, -3));
		result.add(new Point(-1, -1));
		result.add(new Point(-2, -2));
		result.add(new Point(-3, -3));
		result.add(new Point(-1, 1));
		result.add(new Point(-2, 2));
		result.add(new Point(-3, 3));
		return result;
	}

	/*
	 * Step 1: In a list of Point objects find all points with positive
	 * x-coordinate and print these points.
	 */
	private static void printAllPositivePoints() {

		points.stream().filter(p -> p.getX() > 0).forEach(System.out::print);

	}

	/*
	 * Step 2: In a list of Point objects find all points with positive
	 * x-coordinate, and print these coordinates.
	 */
	private static void printAllPositiveCoordinates() {

		points.stream().filter(p -> p.getX() > 0).forEach(p -> {
			System.out.println(String.format("%f,%f", p.getX(), p.getY()));
		});

	}

	/*
	 * Step 3: In a list of Point objects find all points with distinct positive
	 * x-coordinate, and print these coordinates.
	 */
	private static void printDistinctPositiveCoordinates() {

		points.stream().filter(p -> p.getX() > 0).map(p -> p.getX()).distinct()
				.forEach(System.out::println);

		points.stream()
				.filter(p -> p.x > 0)
				.collect(
						Collectors.toCollection(() -> new TreeSet<Point>((p1,
								p2) -> p1.x - p2.x)))
				.forEach(p -> System.out.println(p));

	}

	/*
	 * Step 4 (optional): In a list of Point objects find all points with
	 * distinct positive x-coordinate, and print these points.
	 */
	private static void printDistinctPositivePoints() {

		points.stream()
				.filter(p -> p.getX() > 0)
				.map(p -> p.getX())
				.distinct()
				.forEach(
						it -> points.stream().filter(it2 -> it2.getX() == it)
								.forEach(System.out::println));

	}

	public static void main(String... args) {
		printAllPositivePoints();
		printAllPositiveCoordinates();
		printDistinctPositiveCoordinates();
		printDistinctPositivePoints();
	}
}
