package victim.admin.bean;

public class AdminBean {

	private boolean listStacktrace;
	private String message;

	public AdminBean() {
		// nothing
	}

	public AdminBean(boolean listStacktrace) {
		setListStacktrace(listStacktrace);
	}

	public boolean isListStacktrace() {
		return listStacktrace;
	}

	public void setListStacktrace(boolean listStacktrace) {
		this.listStacktrace = listStacktrace;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
