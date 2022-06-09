package com.gdgs.slyouth.cm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gdgs.slyouth.cm.service.CmComService;
import com.gdgs.slyouth.cm.vo.CmComDVO;

/**
 * @title	: [공통] 기능관리 Controller 클래스	  
 * @author	: mosekim
 * @create	: 2021.05.15
 */
@RestController
@RequestMapping("/cm/")
public class CmComController {

	@Autowired
	private CmComService cmComService;
	
	/**
	 * @title	: 콤보박스 구성  
	 * @method	: makeCombo()
	 * @comment	: 콤보박스 요청 정보를 조회한다.		 
	 * @param	: CmComDVO
	 * @return	: CmComDVO
	 */
	@PostMapping("makeCombo")
	public CmComDVO makeCombo(CmComDVO cmComDVO) throws Exception {
		return cmComService.makeCombo(cmComDVO);
	}
	
	/**
	 * @title	: 콤보박스 커스텀 구성  
	 * @method	: makeCustomCombo()
	 * @comment	: 콤보박스 요청 정보를 조회한다. (커스텀)		 
	 * @param	: CmComDVO
	 * @return	: CmComDVO
	 */
	@PostMapping("makeCustomCombo")
	public CmComDVO makeCustomCombo(CmComDVO cmComDVO) throws Exception {
		return cmComService.makeCustomCombo(cmComDVO);
	}

}
