package controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Component
@Controller
public class PostArticleController {
	String postArticleMessage;
	
	@RequestMapping(value = "/postArticle", method = RequestMethod.GET)
	public String postArticle(ModelMap modelMap){
		modelMap.addAttribute("postArticleMessage",postArticleMessage);
		return "postArticle";
	}
	
	public String getPostArticleMessage() {
		return postArticleMessage;
	}
	
	public void setPostArticleMessage(String postArticleMessage) {
		this.postArticleMessage = postArticleMessage;
	}
}
