package victim.admin.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import victim.admin.bean.AdminBean;
import victim.login.bean.LoginBean;
import victim.login.bean.UserBean;

@Controller
public class AdminController {

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminGet(Model model, HttpSession session) {
		AdminBean bean = new AdminBean();
		Object showStacktrace = session.getAttribute("showStacktrace");
        if (showStacktrace != null) {
        	bean.setListStacktrace(true);
        }
		model.addAttribute("bean", bean);
		return "admin";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.POST)
	public String adminPost(Model model, HttpSession session) {
		Object showStacktrace = session.getAttribute("showStacktrace");
        if (showStacktrace != null) {
        	session.removeAttribute("showStacktrace");
        	model.addAttribute("bean", new AdminBean());
        } else {
        	session.setAttribute("showStacktrace", new Object());
        	model.addAttribute("bean", new AdminBean(true));
        }
		return "admin";
	}

	@RequestMapping(value = "/adminTest", method = RequestMethod.POST)
	public String adminTest() {
		throw new RuntimeException("This is a test.");
	}
	
}
