package com.study.board.cm.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @title	: [공통] 메인 Controller 클래스	  
 * @author	: 김모세
 * @create	: 2022.06.08
 */
@Controller
@RequestMapping("/")
public class CmMainController {

	@GetMapping("/")
	public String main(Model model) {
		return "redirect:/bd/boardList";
	}
}
