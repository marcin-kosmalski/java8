package exceptions;

public class StringAppender {

	private String base;

	public StringAppender(String base) {
		this.base = base;
	}

	public String append(String str) {
		return base.concat(str);
	}
}
