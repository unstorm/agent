package com.agent.controller;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <pre>
 * com.agent.controller 
 *    |_ DemoController.java
 *  1.개요 thymeleaf를 사용하기위한 Controller 
 * </pre>
 * @date : 2017. 11. 6. 오전 10:41:41
 * @version : 
 * @author : Brian H Sun
 */
@Controller
public class DemoController {
	
    @RequestMapping(value = "/demo", method= RequestMethod.GET)
    public String demo(Model model) {

        model.addAttribute("result", "demo");
        return "demo";
    }
}