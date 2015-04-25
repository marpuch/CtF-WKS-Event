package victim.controlers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SessionTestControler {

    @RequestMapping("/sessionTest")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model, HttpSession session) {
        model.addAttribute("name", session.getId());
        return "greeting";
    }

}