package com.agent.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Brian H Sun
 * @date 2017-10-30
 * @see ����Ȯ��   ���� ���� Ȯ��
 */
@RestController
public class AgentController {

	@RequestMapping("/hjsun")
	public String hjsun() {
		return "I must success!!";
	}
}
