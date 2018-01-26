package com.agent.controller.view;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
	
	@RequestMapping(value= {"/index","/","/home"})
	public String index(HttpServletRequest request) {
		return "index";
	}

}
