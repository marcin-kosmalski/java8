package concurrency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTests {

	public static void main(String[] args) {
		new CompletableFutureTests();
	}

	public CompletableFutureTests() {
		create();
		createAndTransform();
		createAndTransformAndOutput();
		createTransformException();
		createTwoWaitAndInform();
		createTwoWaitAndCombine();
		createTwoAndOutputFirstFinished();
		createManyWaitForAllAndCombine();

		loadWebPage();
	}

	public void loadWebPage() {
		getWebPage("http://www.google.pl").thenAccept(
				content -> System.out.println(content));// .join();
		System.out.println("Thread requesting page: "
				+ Thread.currentThread().getName());
	}

	private CompletableFuture<String> getWebPage(String urlString) {

		CompletableFuture<String> cf = new CompletableFuture<String>();

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					URL oracle = new URL(urlString);
					BufferedReader in = new BufferedReader(
							new InputStreamReader(oracle.openStream()));
					String inputLine;
					StringBuffer buffer = new StringBuffer();
					while ((inputLine = in.readLine()) != null) {
						buffer.append(inputLine);
					}
					in.close();
					System.out.println("Thread loading page: "
							+ Thread.currentThread().getName());
					cf.complete(buffer.toString());
				} catch (IOException e) {
					cf.completeExceptionally(e);
				}
			}
		},"MySpecialThead").start();;
		

		return cf;
	}

	public void create() {
		try {
			System.out.println(CompletableFuture.supplyAsync(() -> "4")
					.exceptionally(ex -> ex.toString()).get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

	public void createAndTransform() {

		try {
			System.out.println(CompletableFuture.supplyAsync(() -> "4")
					.thenApply(n -> Integer.valueOf(n)).thenApply(n -> n * n)
					.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

	public void createAndTransformAndOutput() {

		CompletableFuture.supplyAsync(() -> "4")
				.thenApply(n -> Integer.valueOf(n)).thenApply(n -> n * n)
				.thenAccept(it -> System.out.println("Output: " + it));
	}

	public void createTransformException() {
		CompletableFuture.supplyAsync(() -> 4 / 0).exceptionally(ex -> {
			System.out.println("Exception: " + ex.toString());
			return -1;
		}).thenAccept(it -> System.out.println("Exception Output: " + it));
	}

	public void createTwoWaitAndInform() {
		CompletableFuture<Integer> cf1 = CompletableFuture
				.supplyAsync(() -> "4").thenApply(n -> Integer.valueOf(n))
				.thenApply(n -> n * n);
		CompletableFuture<Integer> cf2 = CompletableFuture
				.supplyAsync(() -> "5").thenApply(n -> Integer.valueOf(n))
				.thenApply(n -> n * n);

		cf1.thenAcceptBoth(cf2, (n1, n2) -> System.out.println(String.format(
				"Processing finish! Results %d,%d", n1, n2)));
	}

	public void createTwoWaitAndCombine() {
		CompletableFuture<Integer> cf1 = CompletableFuture
				.supplyAsync(() -> "4").thenApply(n -> Integer.valueOf(n))
				.thenApply(n -> n * n);
		CompletableFuture<Integer> cf2 = CompletableFuture
				.supplyAsync(() -> "5").thenApply(n -> Integer.valueOf(n))
				.thenApply(n -> n * n);

		cf1.thenCombine(cf2, (n1, n2) -> n1 + n2).thenAccept(
				n -> System.out.println("Combination results: " + n));
	}

	public void createTwoAndOutputFirstFinished() {
		CompletableFuture<Integer> cf1 = CompletableFuture
				.supplyAsync(() -> "4").thenApply(n -> Integer.valueOf(n))
				.thenApply(n -> n * n);
		CompletableFuture<Integer> cf2 = CompletableFuture
				.supplyAsync(() -> "5").thenApply(n -> Integer.valueOf(n))
				.thenApply(n -> n * n);

		cf1.acceptEither(cf1,
				zahl -> System.out.println("First completed: " + zahl));
	}

	public void createManyWaitForAllAndCombine() {
		CompletableFuture<Integer> cf1 = CompletableFuture
				.supplyAsync(() -> "4").thenApply(n -> Integer.valueOf(n))
				.thenApply(n -> n * n);
		CompletableFuture<Integer> cf2 = CompletableFuture
				.supplyAsync(() -> "5").thenApply(n -> Integer.valueOf(n))
				.thenApply(n -> n * n);

		CompletableFuture.allOf(cf1, cf2).thenAccept(
				n -> System.out.println("Combination of all results: " + n));
	}
}
