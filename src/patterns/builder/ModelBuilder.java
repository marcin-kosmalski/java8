package patterns.builder;

public class ModelBuilder {

	class Model {
		private long id;
		private String text;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}
	}
	
	

	private long id;
	private String text;

	public ModelBuilder id(long id) {
		this.id = id;
		return this;
	}

	public ModelBuilder text(String text) {
		this.text = text;
		return this;
	}

	@Override
	public String toString() {
		return "ModelBuilder [id=" + id + ", text=" + text + "]";
	}

}
