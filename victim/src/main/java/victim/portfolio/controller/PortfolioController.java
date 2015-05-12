package victim.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import victim.portfolio.bean.PortfolioBean;
import victim.portfolio.data.PortfolioDao;

@Controller
public class PortfolioController {

	@Autowired
	private PortfolioDao portfolioDao;
	
	@RequestMapping("/portfolio")
	public @ResponseBody PortfolioBean getPortfolio(@RequestParam(value="mode", required=false, defaultValue="all")String mode) {
		return new PortfolioBean(portfolioDao.find(mode));
	}
	
	// Spring setter

	public void setPortfolioDao(PortfolioDao portfolioDao) {
		this.portfolioDao = portfolioDao;
	}
}
