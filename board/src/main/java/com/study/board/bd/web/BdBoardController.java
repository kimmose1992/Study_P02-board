package com.study.board.bd.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @title	: 게시판 Controller 클래스	  
 * @author	: 김모세
 * @create	: 2022.06.08
 */
@Controller
@RequestMapping("/bd/")
public class BdBoardController {

	/**
	 * @title   : 게시판 목록 화면
	 * @method  : boardList()
	 * @comment : 게시판 목록 조회
	 * @param   : N/A
	 */
	@RequestMapping("boardList")
	public ModelAndView login(ModelAndView mav) throws Exception {
		mav.setViewName("board/bd/VWBD0001");
		return mav;
	}
}
