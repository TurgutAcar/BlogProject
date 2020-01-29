package controller;

import javax.validation.Valid;

import org.eclipse.persistence.exceptions.DatabaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import entity.Article;
import entity.Authorities;
import entity.Member;
import entity.User;
import service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	@Autowired
	private PostMemberController postMemberController;
	

	@ModelAttribute("member")
	public Member getMemberObject(){
		return new Member();
	}
	
	@RequestMapping(value="/memberRegister",method=RequestMethod.GET)
	public String addMember(){
		return "memberRegister";
	}
	
	
	@RequestMapping(value = "/memberRegister",method = RequestMethod.POST)
	   public ModelAndView  addItem(@Valid @ModelAttribute("member") Member member,BindingResult result) {
	    	
		String insertMessage="";
		ModelAndView modelAndView;
		
		if(result.hasErrors()) {
			System.out.println("\n\nResult hataya sahip");
			modelAndView = new ModelAndView("memberRegister");
			return modelAndView;
		}
		modelAndView = new ModelAndView("postMember");
			try {
				member.setEnabled(true);
				member.setRole("ROLE_MANAGER");
				
				
				insertMessage=memberService.create(member);} 
			
			catch (DatabaseException e) {
				System.out.println("An error occured while inserting new user!");
				System.out.println("Error is:"+e);
				insertMessage = "An error occured while inserting new user!\nError is:"+e.getInternalException();

			}
			System.out.println("\n\ninsert message icin buraya bak:"+insertMessage+"\n\n");
			//postMemberController.setMessage(insertMessage);
			modelAndView.addObject("message",insertMessage);

			return modelAndView;
	        			//modelAndView.addObject("message",insertMessage);
	       
	   }
	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {
		ModelAndView model = new ModelAndView("error/generic_error");
		if(ex.toString().contains("MySQLIntegrityConstraintViolationException: Duplicate entry")){
			model.addObject("errCode","Ayný E-posta hesabý ikinci kez kayýt olamaz!");
			model.addObject("errMsg", "this is Exception.class");
		}
		else {
			model.addObject("errCode",ex.getMessage());
			model.addObject("errMsg", ex.getMessage());
		}
		
		return model;

	}
}
