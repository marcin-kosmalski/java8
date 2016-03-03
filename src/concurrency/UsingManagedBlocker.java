package concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinPool.ForkJoinWorkerThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class UsingManagedBlocker {

	public static void main(String[] args) {
		new UsingManagedBlocker();
	}

	public UsingManagedBlocker() {
		test();
	}

	private void test() {

		IntStream
				.range(1, 100).parallel()
				.map(i -> {
					MyManagedBlocker<Integer> blocker = new MyManagedBlocker<>(
							i);
					try {
						ForkJoinPool.managedBlock(blocker);
					} catch (InterruptedException e) {

					}
					return blocker.getValue();
				})
				.forEach(
						i -> System.out.println(Thread.currentThread()
								.getName() + ": blocking " + i));

	}

	private class MyManagedBlocker<T> implements ForkJoinPool.ManagedBlocker {

		private T t;

		private AtomicBoolean done;

		public MyManagedBlocker(T t) {
			done = new AtomicBoolean(false);
			this.t = t;
		}

		@Override
		public boolean block() throws InterruptedException {
			if (done.get() == false) {
				Thread.sleep(10000);
				done.set(true);
			}
			return true;
		}

		@Override
		public boolean isReleasable() {
			return done.get();
		}

		public T getValue() {
			return t;
		}

	}
}
