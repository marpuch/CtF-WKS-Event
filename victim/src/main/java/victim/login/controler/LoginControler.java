package victim.login.controler;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import victim.login.bean.LoginBean;

@Controller
public class LoginControler {

	@ModelAttribute("loginbean")
	public LoginBean getLoginBean() {
		return new LoginBean();
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGet(Model model) {
		model.addAttribute("bean", new LoginBean());
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(@Valid @ModelAttribute("bean") LoginBean bean, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "login";
		}
		return "redirect:/index.html";
	}

}