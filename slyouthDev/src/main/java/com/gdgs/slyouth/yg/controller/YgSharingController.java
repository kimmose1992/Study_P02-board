package com.gdgs.slyouth.yg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gdgs.slyouth.yg.service.YgSharingService;
import com.gdgs.slyouth.yg.vo.YgSharingDVO;
import com.gdgs.slyouth.yg.vo.YgSharingSVO;

/**
 * 
 * @title    : [사랑방] 나눔자료공유게시판 Controller 클래스      
 * @author   : 김예림
 * @create   : 2021. 08. 26.
 */
@RestController
@RequestMapping("/yg/")
public class YgSharingController {
	
	@Autowired
	private YgSharingService ygSharingService;
	
	/**
	 * @title	: 나눔자료게시판 목록 조회
	 * @method 	: sharingList
	 * @comment	: 나눔자료게시판 목록 조회 화면으로 이동
	 * @param	: YgSharingDVO
	 */
	@RequestMapping("sharingList")
	public ModelAndView sharingList(YgSharingDVO ygSharingDVO, ModelAndView mav) throws Exception {
		YgSharingSVO returnSVO = ygSharingService.sharingList(ygSharingDVO);
		mav.addObject("returnSVO", returnSVO);
		mav.setViewName("slyouth/yg/VWYG0001");
		return mav;
	}	
	
	/**
	 * @title	: 나눔자료게시판 상세 조회
	 * @method 	: sharingDetail
	 * @comment	: 나눔자료게시판 게시글 상세 조회 화면으로 이동
	 * @param	: YgSharingDVO
	 */
	@RequestMapping("sharingDetail")
	public ModelAndView sharingDetail(YgSharingDVO ygSharingDVO, ModelAndView mav) throws Exception {
		YgSharingSVO returnSVO = ygSharingService.sharingDetail(ygSharingDVO);
		mav.addObject("returnSVO", returnSVO);
		mav.setViewName("slyouth/yg/VWYG0002");
		return mav;
	}
	
	/**
	 * @title	: 나눔자료게시판 등록/수정 화면
	 * @method 	: sharingEdit
	 * @comment	: 나눔자료게시판 등록/수정 화면으로 이동
	 * @param	: YgSharingDVO
	 */
	@RequestMapping("sharingEdit")
	public ModelAndView sharingEdit(YgSharingDVO ygSharingDVO, ModelAndView mav) throws Exception {
		YgSharingSVO returnSVO = ygSharingService.sharingEdit(ygSharingDVO);
		mav.addObject("returnSVO", returnSVO);
		mav.setViewName("slyouth/yg/VWYG0003");
		return mav;
	}	
	
	/**
	 * @title	: 나눔자료게시판 등록/수정 후 저장
	 * @method 	: sharingSave
	 * @comment	: 나눔자료게시판 등록/수정된 게시글을 저장
	 * @param	: YgSharingDVO
	 */
	@PostMapping("sharingSave")
	public YgSharingDVO sharingSave(YgSharingDVO ygSharingDVO) throws Exception {
		return ygSharingService.sharingSave(ygSharingDVO);
	}
	
	/**
	 * @title	: 나눔자료게시판 게시글 삭제
	 * @method 	: sharingDelete
	 * @comment	: 나눔자료게시판 게시글 삭제
	 * @param	: YgSharingDVO
	 */
	@PostMapping("sharingDelete")
	public YgSharingDVO sharingDelete(YgSharingDVO ygSharingDVO) throws Exception {
		return ygSharingService.sharingSave(ygSharingDVO);
	}
}
