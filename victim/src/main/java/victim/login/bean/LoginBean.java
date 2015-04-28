package victim.login.bean;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.util.StringUtils;

public class LoginBean {

	@NotBlank
	private String name;

	@NotBlank
	private String password;

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
		this.name = StringUtils.trimWhitespace(name);
	}
}
