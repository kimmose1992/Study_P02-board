package com.gdgs.slyouth.nt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gdgs.slyouth.nt.service.NtCounselService;
import com.gdgs.slyouth.nt.vo.NtCounselDVO;
import com.gdgs.slyouth.nt.vo.NtCounselSVO;

/**
 * @title	: [커뮤니티] 상담 Controller 클래스 
 * @author	: srar2
 * @create	: 2021. 6. 26.
 */
@RestController
@RequestMapping("/nt/")
public class NtCounselController {
	
	private static final Logger logger = LoggerFactory.getLogger(NtCounselController.class);
	
	@Autowired
	private NtCounselService ntCounselService;
	
	/**
	 * @title	: 상담 리스트 조회 페이지
	 * @method	: counselList() 
	 * @comment	: 상담 화면에서 입력된 정보로 상담 목록을 조회한다.		 
	 * @param	: NtCounselDVO
	 */
	@RequestMapping("counselList")
	public ModelAndView counselList(NtCounselDVO ntCounselDVO) throws Exception{
		
		// 상담 리스트 조회
		NtCounselSVO returnSVO = ntCounselService.counselList(ntCounselDVO);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("returnSVO", returnSVO);
		mav.setViewName("slyouth/nt/VWNT0004");
		
		return mav;
	}
	
	/**
	 * @title	: 상담 상세조회 페이지
	 * @method	: counselDetail() 
	 * @comment	: 상담 조회 목록에서 선택한 코드의 상세정보를 조회합니다.		 
	 * @param	: NtCounselDVO
	 */
	@PostMapping("counselDetail")
	public ModelAndView counselDetail(NtCounselDVO ntCounselDVO) throws Exception{
		
		// 상담 상세조회
		NtCounselSVO returnSVO = ntCounselService.counselDetail(ntCounselDVO);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("returnSVO", returnSVO);
		mav.setViewName("slyouth/nt/VWNT0005");
		return mav;
	}
	
	/**
	 * @title	: 상담 등록&수정 이동 페이지
	 * @method	: counselEdit() 
	 * @comment	: 상담 등록&수정하는 화면으로 이동한다.
	 * @param	: NtCounselDVO
	 */
	@RequestMapping("counselEdit")
	public ModelAndView counselEdit(NtCounselDVO ntCounselDVO) throws Exception{
		
		// 상담 상세조회
		NtCounselSVO returnSVO = ntCounselService.counselDetail(ntCounselDVO);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("returnSVO", returnSVO);
		mav.setViewName("slyouth/nt/VWNT0006");
		return mav;
	}
	
	/**
	 * @title	: 상담 등록&수정
	 * @method	: counselSave()
	 * @comment	: 상담 글, 답글을 등록&수정한다.
	 * @param	: NtCounselDVO
	 */
	@PostMapping("counselSave")
	public int[] counselSave(NtCounselDVO ntCounselDVO) throws Exception {
		
		int[] resultValue = ntCounselService.counselSave(ntCounselDVO);
		
		return resultValue;
	}
	
	/**
	 * @title	: 상담 삭제 
	 * @method	: counselDelete()
	 * @comment	: 상담 상세조회 페이지에서 선택한 코드의 상세정보를 삭제한다.	 
	 * @param	: NtCounselDVO
	 */
	@PostMapping("counselDelete")
	public int counselDelete(NtCounselDVO ntCounselDVO) throws Exception{
		
		// 상담 삭제
		int resultValue = ntCounselService.counselDelete(ntCounselDVO);
		
		return resultValue;
	}
}
