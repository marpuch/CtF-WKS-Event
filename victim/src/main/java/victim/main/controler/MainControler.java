package victim.main.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainControler {

	@RequestMapping("/index")
    public String greeting() {
        return "index";
    }
}
