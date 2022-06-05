package com.study.basketball.ur.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @title	: [공통] 메인 Controller 클래스	  
 * @author	: 김모세
 * @create	: 2022.06.04
 */
@Controller
@RequestMapping("/ur/")
public class UrLoginController {

	/**
	 * @title   : 로그인 화면
	 * @method  : login()
	 * @comment : 로그인 화면으로 이동
	 * @param   : N/A
	 */
	@RequestMapping("login")
	public ModelAndView login(ModelAndView mav) throws Exception {
		mav.setViewName("basketball/ur/VWUR0001");
		return mav;
	}
	
	/**
	 * @title   : 회원가입 화면
	 * @method  : signUp()
	 * @comment : 회원가입 화면으로 이동
	 * @param   : N/A
	 */
	@RequestMapping("signUp")
	public ModelAndView signUp(ModelAndView mav) throws Exception {
		mav.setViewName("basketball/ur/VWUR0002");
		return mav;
	}
}
