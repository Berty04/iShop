package by.htp.ishop.bean;

public class Order {
	private static Order instance;
	
	private long id;
	
	private Order() {
		super();
	}
	
	private Order(long id) {
		super();
		this.id = id;
	}

	public static synchronized Order getInstance() {
		if (instance == null) {
			instance = new Order();
		}
		return instance;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
