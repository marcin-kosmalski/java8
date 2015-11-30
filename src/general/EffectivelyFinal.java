package general;


public class EffectivelyFinal {

	public static void main(String[] args) {

		// new Test1().effectivelyFinal();

		new EffectivelyFinal().effectivelyFinal2();

	}

	public void effectivelyFinal() {

		int var = 8;

		Runnable runnable = () -> {
			System.out.println("effecively final: " + var);
			System.out.println(this);
		};

		// effecively final - modification not possible
		// var=9;

		new Thread(runnable).start();
	}

	public void effectivelyFinal2() {

		class Bin {
			public String value = "init";
		}
		Bin bin = new Bin();

		Runnable runnable = () -> {
			bin.value = "kkk";
			System.out.println(this);
		};

		Thread thread = new Thread(runnable);
		thread.start();

		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(bin.value);
	}

}
