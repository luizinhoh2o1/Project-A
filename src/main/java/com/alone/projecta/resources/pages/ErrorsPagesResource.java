package com.alone.projecta.resources.pages;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ErrorsPagesResource {

	@RequestMapping(value = "/disabled")
	public ModelAndView disabled() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("pages-errors/disabled.html");
		return modelAndView;
	}

}