package concurrency;

import java.util.stream.IntStream;

public class BlockingParallelOperationInStreams {

	public static void main(String[] args) {
		new BlockingParallelOperationInStreams();
	}

	public BlockingParallelOperationInStreams() {
		test();
	}

	private void test() {

		Runnable task = () -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			IntStream
					.rangeClosed(100, 105)
					.parallel()
					.forEach(
							i -> System.out.println(Thread.currentThread()
									.getName() + " - Not blocking: " + i));
		};

		new Thread(task, "single-thread").start();

		IntStream.rangeClosed(1, 50).parallel().map(i -> blockingOperation(i))
				.forEach(i -> System.out.println(i));
	}

	private int blockingOperation(int value) {
		System.out.println("Start blocking: "
				+ Thread.currentThread().getName());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("End blocking: " + Thread.currentThread().getName());
		return value;

	}
}
