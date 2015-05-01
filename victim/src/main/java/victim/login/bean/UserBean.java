package victim.login.bean;

public class UserBean {
	private String login;
	private String name;
	// Yet another security bug. Passwords should not be held in memory in plain text.
	private String password;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
