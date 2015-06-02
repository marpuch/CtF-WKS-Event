package victim.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import victim.blog.bean.BlogData;
import victim.blog.data.BlogDao;

@Controller
public class BlogController {

	@Autowired
	private BlogDao blogDao;
	
	@RequestMapping(value = "/blog", method = RequestMethod.GET)
	public String initBlog(@RequestParam(value="showComments", required=false, defaultValue="10")String number, Model model) {
		List<BlogData> list = blogDao.find(number);
		model.addAttribute("comments", list);
		return "blog";
	}
}
