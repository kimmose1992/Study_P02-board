package com.gdgs.slyouth.cm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @title	: [공통] 메인 Controller 클래스	  
 * @author	: mosekim
 * @create	: 2021.04.12
 */
@Controller
@RequestMapping("/")
public class CmMainController {

	@GetMapping("/")
	public String main(Model model) {
		return "redirect:/mi/main";
	}
	
	@GetMapping("user")
	public String user(Model model) {
		return "cm/user";
	}
	
	@GetMapping("manager")
	public String manager(Model model) {
		return "cm/manager";
	}
	
	@GetMapping("admin")
	public String admin(Model model) {
		return "cm/admin";
	}
}
