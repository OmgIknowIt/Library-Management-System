package com.lms.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lms.utils.WebUtils;

@Controller
public class MainController {

	@RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public ModelAndView welcomePage(ModelAndView model) {
		return new ModelAndView("redirect:/login");
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loginPage(ModelAndView model) {
		model.setViewName("loginPage");
		return model;
	}

	@RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
	public ModelAndView logoutSuccessfulPage(ModelAndView model) {
		return new ModelAndView("redirect:/find_book");
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accessDenied(ModelAndView model, Principal principal) {
		if (principal != null) {
			User loginedUser = (User) ((Authentication) principal).getPrincipal();
			String userInfo = WebUtils.toString(loginedUser);
			model.addObject("userInfo", userInfo);
			String message = "Hi, " + principal.getName() //
					+ "<br> You do not have permission to access this page!";
			model.addObject("message", message);
		}
		model.setViewName("403Page");
		return model;
	}
	
//	@RequestMapping(value = "/registation", method = RequestMethod.POST)
//	public ModelAndView reg() {
//		return null;
//		
//	}
}
