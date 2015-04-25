package victim.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginControler {

    @RequestMapping("/login")
    public String greeting(Model model) {
        return "login";
    }

}