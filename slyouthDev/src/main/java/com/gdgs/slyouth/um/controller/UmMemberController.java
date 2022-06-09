package com.gdgs.slyouth.um.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gdgs.slyouth.cm.vo.CmFileDVO;
import com.gdgs.slyouth.um.service.UmMemberService;
import com.gdgs.slyouth.um.vo.UmMemberDVO;
import com.gdgs.slyouth.um.vo.UmMemberSVO;

/**
 * @title   : [공동체관리] 메인 컨트롤러      
 * @author  : 송근영
 * @create  : 2021.05.24
 * @update  : 2021.08.26
 */
@RestController
@RequestMapping("/um/")
public class UmMemberController {
	
	@Autowired
	private UmMemberService umMemberService;
	
	/**
	 * @title	: 교적조회  
	 * @method	: memberList()
	 * @comment	: 교인에 대한 정보를 조회하는 화면으로 이동합니다.	.	 
	 * @param	: UmMemberDVO, ModelAndView
	 */
	@RequestMapping("memberList")
	public ModelAndView memberList(UmMemberDVO umMemberDVO, ModelAndView mav) throws Exception {
		
		// 교적 멤버 조회
		UmMemberSVO returnSVO = umMemberService.memberList(umMemberDVO);
		
		mav.addObject("returnSVO", returnSVO);
		mav.setViewName("slyouth/um/VWUM0001");
		return mav;
	}
	
	/**
	 * @title	: 교적상세조회  
	 * @method	: memberDetail()
	 * @comment	: 교인에 대한 정보를 조회하는 화면으로 이동합니다.	.	 
	 * @param	: UmMemberDVO, ModelAndView
	 */
	@RequestMapping("memberDetail")
	public ModelAndView memberDetail(UmMemberDVO umMemberDVO, ModelAndView mav) throws Exception {
		
		UmMemberSVO returnSVO = umMemberService.memberDetail(umMemberDVO);
		
		mav.addObject("returnSVO", returnSVO);
		mav.setViewName("slyouth/um/VWUM0003");
		return mav;
	}
	
	/**
	 * @title	: 교적 등록/수정 이동
	 * @method	: memberEdit()
	 * @comment	: 교인에 대한 정보를 등록/수정하는 페이지로 이동합니다.		 
	 * @param	: UmMemberDVO, ModelAndView
	 */
	@RequestMapping("memberEdit")
	public ModelAndView memberEdit(UmMemberDVO umMemberDVO, ModelAndView mav) throws Exception {
		
		UmMemberSVO returnSVO = umMemberService.memberEdit(umMemberDVO);
		
		mav.addObject("returnSVO", returnSVO);
		mav.setViewName("slyouth/um/VWUM0002");
		return mav;
	}
	
	/**
	 * @title	: 교적등록/수정
	 * @method	: memberSave()
	 * @comment	: 교인에 대한 정보를 등록/수정합니다.		 
	 * @param	: UmMemberVO
	 */
	@PostMapping("memberSave")
	public UmMemberDVO memberSave(UmMemberDVO umMemberDVO, CmFileDVO cmFileDVO) throws Exception {
		
		UmMemberSVO paramSVO = new UmMemberSVO();
		paramSVO.setUmMemberDVO(umMemberDVO);
		paramSVO.setCmFileDVO(cmFileDVO);
		
		return umMemberService.memberSave(paramSVO);
	}
	
	/**
	 * @title	: 교적삭제
	 * @method	: memberDel()
	 * @comment	: 교인에 대한 정보를 삭제합니다.	 
	 * @param	: UmMemberVO
	 */
	@PostMapping("memberDel")
	public int memberDel(UmMemberDVO umMemberDVO) throws Exception {
		
		return umMemberService.deleteMember(umMemberDVO);
	}
}