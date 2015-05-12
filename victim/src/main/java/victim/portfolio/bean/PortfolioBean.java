package victim.portfolio.bean;

import java.util.ArrayList;
import java.util.List;

public class PortfolioBean {

	private List<String> result = new ArrayList<String>();

	public PortfolioBean(List<String> result) {
		super();
		this.result = result;
	}

	public List<String> getResult() {
		return result;
	}

	public void setResult(List<String> result) {
		this.result = result;
	}
}
