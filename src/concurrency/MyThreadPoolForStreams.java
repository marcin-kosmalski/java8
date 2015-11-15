package concurrency;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyThreadPoolForStreams {

	private ExecutorService executorService = Executors.newFixedThreadPool(2);

	public void run() {

		String[] values = { "2", "3", "1", "4" };

		long time = GregorianCalendar.getInstance().getTimeInMillis();

		Task task = new Task();
		System.out.println(parallelStream(Arrays.stream(values).map(MyEntity::new),
				task::doBigJob).reduce(0, Math::max));

		System.out.println("Execution time: "
				+ (GregorianCalendar.getInstance().getTimeInMillis() - time));

	}

	public <T, M> Stream<M> parallelStream(Stream<T> stream,
			Function<T, M> transformation) {

		return (Stream<M>) stream
				.map((val) -> {
					try {
						return (Future<M>) executorService
								.submit(() -> transformation.apply(val));
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				}).collect(Collectors.toList()).stream().map((future) -> {
					try {
						return (M) future.get();
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				});

	}

	@SuppressWarnings("unchecked")
	public <T, M> Stream<M> parallelOLD(Stream<T> stream,
			Function<T, M> transformation) {

		return (Stream<M>) stream.map(val -> {
			try {
				return executorService.submit(() -> transformation).get()
						.apply(val);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return val;
		});
	}

	public MyThreadPoolForStreams() {
		run();
	}

	public static void main(String[] args) {
		new MyThreadPoolForStreams();
	}
}

class MyEntity {

	private String val;

	public MyEntity(String val) {
		this.val = val;
	}

	public String getVal() {
		return this.val;
	}

}

class Task {

	public Integer doBigJob(MyEntity value) {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return Integer.valueOf(value.getVal());
	}

	public Integer doBigJobOLD(String value) {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return Integer.valueOf(value);
	}

}
