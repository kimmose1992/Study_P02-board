package com.gdgs.slyouth.nf.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gdgs.slyouth.nf.service.NfVisionService;
import com.gdgs.slyouth.nf.vo.NfVisionDVO;
import com.gdgs.slyouth.nf.vo.NfVisionSVO;

/**
 * @title  : [양육과훈련] 승리청년비전 Controller 클래스
 * @author : 김모세
 * @create : 2021.08.02
 */
@RestController
@RequestMapping("/nf/")
public class NfVisionController {
	
	@Autowired
	private NfVisionService nfVisionService;

	/**
	 * @title   : 승리청년비전 정보 조회
	 * @method  : visionInfo
	 * @comment : 승리청년비전 조회 페이지로 이동한다.
	 * @param   : NfVisionDVO
	 */
	@RequestMapping("vision")
	public ModelAndView visionInfo(NfVisionDVO nfVisionDVO, HttpServletRequest request, ModelAndView mav) throws Exception {

		// 승리청년비전 정보 조회
		NfVisionSVO returnSVO = nfVisionService.visionInfo(nfVisionDVO);
		
		mav.addObject("returnSVO", returnSVO);
		mav.setViewName("slyouth/nf/VWNF0001");
		return mav;
	}

}
