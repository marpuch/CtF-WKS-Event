package victim.priv.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PrivController {

	@RequestMapping("/private")
	public String show(HttpSession session) {
		if (session.getAttribute("user") == null) {
			return "redirect:login";
		} else {
			return "private";
		}
	}
	
}
