package victim.admin.controller;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.jdom2.Document;
import org.jdom2.input.SAXBuilder;
import org.jdom2.input.sax.XMLReaderJDOMFactory;
import org.jdom2.input.sax.XMLReaderXSDFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import victim.admin.bean.AdminBean;
import victim.blog.data.BlogDao;

@Controller
public class AdminController {

	@Autowired
	private BlogDao blogDao;
	
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
		gatherData(model, session);
		return "admin";
	}

	@RequestMapping(value = "/adminDeleteComments", method = RequestMethod.POST)
	public String adminDeleteComments(Model model, HttpSession session) {
		blogDao.deleteAll();
		gatherData(model, session);
		return "admin";
	}

	private AdminBean gatherData(Model model, HttpSession session) {
		AdminBean bean = new AdminBean();
		Object showStacktrace = session.getAttribute("showStacktrace");
        if (showStacktrace != null) {
        	session.removeAttribute("showStacktrace");
        	model.addAttribute("bean", bean);
        } else {
        	session.setAttribute("showStacktrace", new Object());
        	bean.setListStacktrace(true);
        	model.addAttribute("bean", bean);
        }
        return bean;
	}

	@RequestMapping(value = "/adminTest", method = RequestMethod.POST)
	public String adminTest() {
		throw new RuntimeException("This is a test.");
	}
	
	@RequestMapping(value="/adminUpload", method=RequestMethod.POST)
    public String handleFileUpload(@RequestParam("file") MultipartFile file, Model model, 
    		HttpSession httpSession){
        gatherData(model, httpSession);
		if (!file.isEmpty()) {
            try {
                File xsdfile = new File("src/main/resources/static/xml/settings-1.0.0.xsd");
                XMLReaderJDOMFactory schemafac = new XMLReaderXSDFactory(xsdfile);
                SAXBuilder builder = new SAXBuilder(schemafac);
                @SuppressWarnings("unused")
				Document document = builder.build(file.getInputStream());
                // TODO write here
            } catch (Exception e) {
                throw new RuntimeException(e);
            } 
        } else {
        	throw new RuntimeException("Empty file");
        }
        return "admin";
    }
	
}
