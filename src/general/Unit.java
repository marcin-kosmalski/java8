package general;

public class Unit {

	private int number = 0;

	private int id = 0;

	public static Unit create(int number, int id) {
		return new Unit(number, id);
	}

	private Unit(int number, int id) {
		this.number = number;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public int getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return "Unit [number=" + number + ", id=" + id + "]";
	}

}
