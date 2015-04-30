package victim.login.bean;

public class UserData {

	private String login;
	private String passEncryptionMethod;
	private String password;
	private String fullName;
	private String passReminder;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassEncryptionMethod() {
		return passEncryptionMethod;
	}

	public void setPassEncryptionMethod(String passEncryptionMethod) {
		this.passEncryptionMethod = passEncryptionMethod;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassReminder() {
		return passReminder;
	}

	public void setPassReminder(String passReminder) {
		this.passReminder = passReminder;
	}

}
