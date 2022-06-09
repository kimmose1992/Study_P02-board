package com.gdgs.slyouth.ps.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gdgs.slyouth.cm.utils.CmConvKeyUtils;
import com.gdgs.slyouth.cm.vo.CmFileDVO;
import com.gdgs.slyouth.ps.service.PsIntroService;
import com.gdgs.slyouth.ps.vo.PsIntroDVO;
import com.gdgs.slyouth.ps.vo.PsIntroSVO;

/**
 * @title  : [찬양과셀라] 셀라소개 Controller 클래스
 * @author : 김예림
 * @create : 2021.06.28
 * @update : 2021.07.17
 */
@RestController
@RequestMapping("/ps/")
public class PsIntroController {
	
	@Autowired
	private PsIntroService psIntroService;

	/**
	 * @title   : 셀라소개 기본정보 조회
	 * @method  : selahInfo()
	 * @comment : 셀라소개 기본정보를 조회해온다.
	 * @param   : psIntroDVO
	 */
	@RequestMapping("selah")
	public ModelAndView selahInfo(PsIntroDVO psIntroDVO, HttpServletRequest request) throws Exception {

		// 셀라소개 기본정보 조회
		psIntroDVO.setSlyouthTbKey(new CmConvKeyUtils().getTbKey(request.getRequestURI()));
		PsIntroSVO returnSVO = psIntroService.selahInfo(psIntroDVO);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("returnSVO", returnSVO);
		mav.setViewName("slyouth/ps/VWPS0001");
		
		return mav;
	}

	/**
	 * @title	: 셀라소개 기본정보 조회
	 * @method	: selahEdit
	 * @comment	: 셀라소개 기본정보를 조회해서 수정페이지로 이동한다.
	 * @param	: PsIntroDVO
	 */
	@RequestMapping("selahEdit")
	public ModelAndView selahEdit(PsIntroDVO psIntroDVO, HttpServletRequest request) throws Exception {
		
		// 셀라소개 기본정보 조회
		psIntroDVO.setSlyouthTbKey(new CmConvKeyUtils().getTbKey(request.getRequestURI()));
		PsIntroSVO returnSVO = psIntroService.selahInfo(psIntroDVO);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("returnSVO", returnSVO);
		mav.setViewName("slyouth/ps/VWPS0002");

		return mav;
	}
	
	/**
	 * @title	: 셀라소개 정보 수정
	 * @method	: saveSelahInfo
	 * @comment	: 셀라소개 기본정보 수정과 변경 이미지를 업로드한다.
	 * @param	: PsIntroDVO
	 */
	@RequestMapping("saveSelahInfo")
	public PsIntroDVO saveMemberInfo(CmFileDVO cmFileDVO, PsIntroDVO psIntroDVO) throws Exception {
		PsIntroSVO paramSVO = new PsIntroSVO();
		paramSVO.setCmFileDVO(cmFileDVO);
		paramSVO.setPsIntroDVO(psIntroDVO);
		
		return psIntroService.saveSelahInfo(paramSVO);
	}
}
