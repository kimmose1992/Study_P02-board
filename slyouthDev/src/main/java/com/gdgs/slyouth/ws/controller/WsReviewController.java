package com.gdgs.slyouth.ws.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gdgs.slyouth.ws.service.WsReviewService;
import com.gdgs.slyouth.ws.vo.WsReviewDVO;
import com.gdgs.slyouth.ws.vo.WsReviewSVO;

/**
 * @title    : [예배와 말씀] 말씀후기 Controller 클래스     
 * @author   : gypig
 * @create   : 2021.07.01
 * @update   : 2021.07.10
 */

@RestController
@RequestMapping("/ws/")
public class WsReviewController {

	private static final Logger logger = LoggerFactory.getLogger(WsReviewController.class);
	
	@Autowired
	private WsReviewService wsReviewService;
	
	/**
	 * @title 	: 말씀후기 목록조회
	 * @method 	: reviewList()
	 * @comment : 말씀후기 목록조회 페이지로 이동합니다.
	 * @param 	: WsReviewDVO
	 */
	@RequestMapping("reviewList")
	public ModelAndView reviewList(WsReviewDVO wsReviewDVO) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		WsReviewSVO returnSVO = wsReviewService.reviewList(wsReviewDVO);
		
		mav.addObject("returnSVO", returnSVO);
		mav.setViewName("slyouth/ws/VWWS0003");
		return mav;
	}
	
	/**
	 * @title 	: 말씀후기 상세조회
	 * @method 	: reviewDetail()
	 * @comment : 말씀후기 상세조회 페이지로 이동합니다.
	 * @param 	: WsReviewDVO
	 */
	@RequestMapping("reviewDetail")
	public ModelAndView reviewDetail(WsReviewDVO wsReviewDVO) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		WsReviewSVO returnSVO = wsReviewService.reviewDetail(wsReviewDVO);
		
		mav.addObject("returnSVO", returnSVO);
		mav.setViewName("slyouth/ws/VWWS0004");
		return mav;
	}
	
	/**
	 * @title 	: 말씀후기 등록/수정 페이지
	 * @method 	: reviewEdit()
	 * @comment : 말씀후기 상세조회 페이지로 이동합니다.
	 * @param 	: WsReviewDVO
	 */
	@RequestMapping("reviewEdit")
	public ModelAndView reviewEdit(WsReviewDVO wsReviewDVO) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		WsReviewSVO returnSVO = wsReviewService.reviewDetail(wsReviewDVO);
		
		mav.addObject("returnSVO", returnSVO);
		mav.setViewName("slyouth/ws/VWWS0005");
		return mav;
	}
	
	/**
	 * @title 	: 말씀후기 등록/수정
	 * @method 	: reviewSave()
	 * @comment : 말씀후기 등록/수정을 진행합니다.
	 * @param 	: WsReviewDVO
	 */
	@PostMapping("reviewSave")
	public int reviewSave(WsReviewDVO wsReviewDVO) throws Exception {

		return wsReviewService.reviewSave(wsReviewDVO);
	}
	
	/**
	 * @title 	: 말씀후기 삭제
	 * @method 	: reviewDel()
	 * @comment : 말씀후기 삭제를 진행합니다.
	 * @param 	: WsReviewDVO
	 */
	@PostMapping("reviewDel")
	public int reviewDel(WsReviewDVO wsReviewDVO) throws Exception {

		return wsReviewService.reviewDel(wsReviewDVO);
	}
}
