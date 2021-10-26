package com.alone.projecta.resources.pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alone.projecta.services.AccountService;

@RestController
public class ListServersResource {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping(value = "/list-servers")
	public ModelAndView listServers(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("list-servers");
	    modelAndView.addObject("servers", accountService.findAllServersAccount(username));
	    return modelAndView;
	}
}
