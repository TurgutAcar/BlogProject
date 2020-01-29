package controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Component
public class PostMemberController {
String message;
	
	@RequestMapping(value = "/postMembe",method = RequestMethod.GET)
	public ModelAndView postMemberController(){
		ModelAndView modelAndView = new ModelAndView("postMember");
		System.out.println("turgut acar");
		modelAndView.addObject("message",message);
		return modelAndView;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
