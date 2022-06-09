package com.gdgs.slyouth.cm.service;

import com.gdgs.slyouth.cm.vo.CmComDVO;

/**
 * @title	: [공통] 기능관리 Service 인터페이스	  
 * @author	: mosekim
 * @create	: 2021.05.15
 */
public interface CmComService {

	/**
	 * @title	: 콤보박스 구성  
	 * @method	: makeCombo()
	 * @comment	: 콤보박스 요청 정보를 조회한다.		 
	 * @param	: CmComDVO
	 * @return	: CmComDVO
	 */
	public CmComDVO makeCombo(CmComDVO cmComDVO) throws Exception;
	
	/**
	 * @title	: 콤보박스 커스텀 구성  
	 * @method	: makeCustomCombo()
	 * @comment	: 콤보박스 요청 정보를 조회한다.
	 * @param	: CmComDVO
	 * @return	: CmComDVO
	 */
	public CmComDVO makeCustomCombo(CmComDVO cmComDVO) throws Exception;

}
