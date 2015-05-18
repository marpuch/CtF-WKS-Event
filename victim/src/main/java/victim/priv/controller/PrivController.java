package victim.priv.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import victim.login.bean.UserBean;
import victim.priv.bean.PrivBean;
import victim.priv.logic.PrivLogic;

@Controller
public class PrivController {

	@Autowired
	private PrivLogic privLogic;
	
	@RequestMapping("/private")
	public String show(Model model, HttpSession session) {
		UserBean bean = (UserBean) session.getAttribute("user");
		if (bean == null) {
			return "redirect:login";
		} else {
			PrivBean result = privLogic.getText(bean);
			model.addAttribute("result", result);
			return "private";
		}
	}
	
	// Spring setters

	public void setPrivLogic(PrivLogic privLogic) {
		this.privLogic = privLogic;
	}
	
}
