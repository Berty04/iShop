package by.htp.ishop.bean;

public class User {
	private static User instance;
	
	private long id;
	private String login;
	private String password;
	private String name;
	private String surname;

	private User() {
		super();
	}
	
	private User(long id) {
		super();
		this.id = id;
	}

	private User(String login, String password, String name, String surname) {
		super();
		this.login = login;
		this.password = password;
		this.name = name;
		this.surname = surname;
	}

	public static synchronized User getInstance() {
		if (instance == null) {
			instance = new User();
		}
		return instance;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", login=");
		builder.append(login);
		builder.append(", password=");
		builder.append(password);
		builder.append(", name=");
		builder.append(name);
		builder.append(", surname=");
		builder.append(surname);
		builder.append("]");
		return builder.toString();
	}
}
