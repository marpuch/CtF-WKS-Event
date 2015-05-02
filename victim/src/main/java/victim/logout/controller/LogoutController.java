package victim.logout.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

	@RequestMapping(value = "/logout")
	public String loginPost(HttpSession session) {
		session.removeAttribute("user");
		return "index";
	}

}
