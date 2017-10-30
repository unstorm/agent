package com.agent.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class AgentController {

	@RequestMapping("/hjsun")
	public String hjsun() {
		return "I must success!!";
	}
}
