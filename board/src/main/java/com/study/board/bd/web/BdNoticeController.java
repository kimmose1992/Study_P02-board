package com.study.board.bd.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.study.board.bd.service.BdNoticeService;
import com.study.board.bd.vo.BdNoticeVO;

/**
 * @title	: [게시판] 공지사항 Controller 클래스	  
 * @author	: 김모세
 * @create	: 2022.06.08
 */
@RestController
@RequestMapping("/bd/")
public class BdNoticeController {

	@Autowired
	private BdNoticeService bdNoticeService;
	
	/**
	 * @title   : 게시판 목록 화면
	 * @method  : boardList()
	 * @comment : 게시판 목록 조회
	 * @param   : N/A
	 */
	@RequestMapping("boardList")
	public ModelAndView login(ModelAndView mav, BdNoticeVO param) throws Exception {
		bdNoticeService.boardList(param);
		mav.setViewName("board/bd/VWBD0001");
		return mav;
	}
}
