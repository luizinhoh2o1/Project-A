package com.alone.projecta.resources.pages;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ClientPanelResource {

	@RequestMapping(value = "/client-panel")
	public ModelAndView clientPanel() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("pages-client/client-panel.html");
		return modelAndView;
	}

}