package com.gdgs.slyouth.nm.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gdgs.slyouth.cm.utils.CmConvKeyUtils;
import com.gdgs.slyouth.cm.vo.CmFileDVO;
import com.gdgs.slyouth.nm.service.NmIntroService;
import com.gdgs.slyouth.nm.vo.NmIntroDVO;
import com.gdgs.slyouth.nm.vo.NmIntroSVO;

/**
 * @title  : [새가족] 새가족조회 Controller 클래스
 * @author : 이하은
 * @create : 2021.06.30
 */

@RestController
@RequestMapping("/nm/")
public class NmIntroController {

	@Autowired 
	private NmIntroService nmIntroService;
	
	/**
	 * @title	: 새가족소개 기본정보 조회
	 * @method	: memberInfo
	 * @comment	: 새가족소개 기본정보를 조회해온다.
	 * @param	: NmIntroDVO
	 */
	@RequestMapping("member")
	public ModelAndView memberInfo(NmIntroDVO nmIntroDVO, HttpServletRequest request) throws Exception {
		
		// 새가족소개 기본정보 조회
		nmIntroDVO.setSlyouthTbKey(new CmConvKeyUtils().getTbKey(request.getRequestURI()));
		NmIntroSVO returnSVO = nmIntroService.memberInfo(nmIntroDVO);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("returnSVO", returnSVO);
		mav.setViewName("slyouth/nm/VWNM0001");
		
		return mav;
	}
	
	/**
	 * @title	: 새가족소개 기본정보 조회
	 * @method	: memberEdit
	 * @comment	: 새가족소개 기본정보를 조회해서 수정페이지로 이동한다.
	 * @param	: NmIntroDVO
	 */
	@RequestMapping("memberEdit")
	public ModelAndView memberEdit(NmIntroDVO nmIntroDVO, HttpServletRequest request) throws Exception {
		
		// 새가족소개 기본정보 조회
		nmIntroDVO.setSlyouthTbKey(new CmConvKeyUtils().getTbKey(request.getRequestURI()));
		NmIntroSVO returnSVO = nmIntroService.memberInfo(nmIntroDVO);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("returnSVO", returnSVO);
		mav.setViewName("slyouth/nm/VWNM0002");
		
		return mav;
	}
	
	/**
	 * @title	: 새가족소개 정보 수정
	 * @method	: saveMemberInfo
	 * @comment	: 새가족소개 기본정보 수정과 변경 이미지를 업로드한다.
	 * @param	: NmIntroSVO
	 */
	@RequestMapping("saveMemberInfo")
	public NmIntroDVO saveMemberInfo(CmFileDVO cmFileDVO, NmIntroDVO nmIntroDVO) throws Exception {
		NmIntroSVO paramSVO = new NmIntroSVO();
		paramSVO.setCmFileDVO(cmFileDVO);
		paramSVO.setNmIntroDVO(nmIntroDVO);
		
		return nmIntroService.saveMemberInfo(paramSVO);
	}
}
