package victim.login.controler;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import victim.login.bean.LoginBean;
import victim.login.bean.UserBean;
import victim.login.logic.LoginLogic;

@Controller
public class LoginControler {

	@Autowired
	private LoginLogic loginLogic;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGet(Model model) {
		model.addAttribute("bean", new LoginBean());
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(@Valid @ModelAttribute("bean") LoginBean bean,
			BindingResult bindingResult, HttpSession session) {
		if (bindingResult.hasErrors()) {
			return "login";
		}
		UserBean user = loginLogic.login(bean, bindingResult);
		if (user == null) {
			return "login";
		}
		// A nice fat security bug (no session rotation after login).
		session.setAttribute("user", user);
		return "index";
	}

	// spring setter
	
	public void setLoginLogic(LoginLogic loginLogic) {
		this.loginLogic = loginLogic;
	}
}
