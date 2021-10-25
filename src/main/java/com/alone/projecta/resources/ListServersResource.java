package com.alone.projecta.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alone.projecta.services.ServerService;

@RestController
public class ListServersResource {
	
	@Autowired
	private ServerService serverService;
	
	@GetMapping(value = "/list-servers")
	public ModelAndView listServers() {
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("list-servers");
	    modelAndView.addObject("servers", serverService.findAll());
	    return modelAndView;
	}
}
