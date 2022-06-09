package com.gdgs.slyouth.cm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gdgs.slyouth.cm.service.CmMypageService;
import com.gdgs.slyouth.cm.vo.CmMypageDVO;
import com.gdgs.slyouth.cm.vo.CmMypageSVO;

/**
 * @title	: [공통] 마이페이지 Controller 클래스  
 * @author	: srar2
 * @create	: 2021. 8. 11.
 */
@RestController
@RequestMapping("/cm/")
public class CmMypageController {
	
	@Autowired
	private CmMypageService cmMypageService;
	
	/**
	 * @title	: [마이페이지] 상세조회
	 * @method	: mypageInfo() 
	 * @comment	: 로그인한 사용자의 개인정보가 표시된다.	 
	 * @param	: ModelAndView
	 */
	@RequestMapping("mypage")
	public ModelAndView mypageInfo(CmMypageDVO cmMypageDVO, ModelAndView mav) throws Exception {
		
		// 마이페이지 정보조회
		CmMypageSVO returnSVO = cmMypageService.mypageInfo(cmMypageDVO);
		
		mav.addObject("returnSVO", returnSVO);
		mav.setViewName("slyouth/cm/VWCM0004");
		return mav;
	}
	
	/**
	 * @title	: [마이페이지] 비밀번호 변경
	 * @method	: mypagePw() 
	 * @comment	: 비밀번호 변경화면으로 이동한다.	 
	 * @param	: ModelAndView
	 */
	@RequestMapping("mypagePw")
	public ModelAndView mypagePw(ModelAndView mav) throws Exception {
		mav.setViewName("slyouth/cm/VWCM0005");
		
		return mav;
	}
	
	/**
	 * @title	: [마이페이지] 비밀번호 변경
	 * @method	: mypagePwModify 
	 * @comment	: 사용자의 비밀번호를 수정한다.	 
	 * @param	: CmMypageDVO
	 */
	@PostMapping("mypagePwModify")
	public CmMypageDVO mypagePwModify(CmMypageDVO cmMypageDVO) throws Exception {
		
		// 마이페이지 비밀번호 변경
		CmMypageDVO returnDVO = cmMypageService.mypagePwModify(cmMypageDVO);
		
		return returnDVO;
	}
}
