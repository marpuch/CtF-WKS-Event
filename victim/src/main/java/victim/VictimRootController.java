package victim;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VictimRootController {

	@RequestMapping("/")
	public String redirectRoot() {
		return "redirect:index";
	}
}
