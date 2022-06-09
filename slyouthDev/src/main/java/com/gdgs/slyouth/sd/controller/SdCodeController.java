package com.gdgs.slyouth.sd.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gdgs.slyouth.sd.service.SdCodeService;
import com.gdgs.slyouth.sd.vo.SdCodeDVO;
import com.gdgs.slyouth.sd.vo.SdCodeSVO;

/**
 * @title	: [기준정보] 코드관리 Controller 클래스	  
 * @author	: gypig
 * @create	: 2021.06.16
 */
@RestController
@RequestMapping("/sd/")
public class SdCodeController {

	private static final Logger logger = LoggerFactory.getLogger(SdCodeController.class);

	@Autowired
	private SdCodeService sdCodeService;
	
	/**
	 * @title	: 코드 리스트 조회 페이지  
	 * @method	: codeList()
	 * @comment	: 코드관리 화면에서 입력된 정보로 코드 목록을 조회한다.			 
	 * @param	: SdCodeDVO
	 */
	@RequestMapping("codeList")
	public ModelAndView codeList(SdCodeDVO sdCodeDVO) throws Exception {
		
		// 코드 조회
		SdCodeSVO returnSVO = sdCodeService.selectCodeList(sdCodeDVO);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("returnSVO", returnSVO);
		mav.setViewName("slyouth/sd/VWSD0001");
		
		return mav;
	}
	
	/**
	 * @title	: 코드 리스트 조회
	 * @method	: selectCodeList()
	 * @comment	: 코드관리 화면에서 입력된 정보로 코드 목록을 조회한다.			 
	 * @param	: SdCodeDVO
	 */
	@RequestMapping("selectCodeList")
	public SdCodeSVO selectCodeList(SdCodeDVO sdCodeDVO) throws Exception {
		return sdCodeService.selectCodeList(sdCodeDVO);
	}
	
	/**
	 * @title	: 코드 등록/수정 페이지  
	 * @method	: codeList()
	 * @comment	: 코드관리 등록/수정 페이지로 이동한다.			 
	 * @param	: SdCodeDVO
	 */
	@RequestMapping("codeEdit")
	public ModelAndView codeEdit(SdCodeDVO sdCodeDVO) throws Exception {
		
		// 코드 상세정보 조회
		SdCodeSVO returnSVO = sdCodeService.selectCodeDetail(sdCodeDVO);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("sdCodeSVO", returnSVO);
		mav.setViewName("slyouth/sd/VWSD0002");
		
		return mav;
	}
	
}
