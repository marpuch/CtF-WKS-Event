package victim.admin.bean;

public class AdminBean {

	private boolean listStacktrace;

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
}
