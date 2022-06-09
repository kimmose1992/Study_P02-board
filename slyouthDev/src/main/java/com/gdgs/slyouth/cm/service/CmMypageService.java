package com.gdgs.slyouth.cm.service;

import com.gdgs.slyouth.cm.vo.CmMypageDVO;
import com.gdgs.slyouth.cm.vo.CmMypageSVO;

/**
 * @title	: [공통] 마이페이지 Service 인터페이스 
 * @author	: srar2
 * @create	: 2021. 8. 11.
 */
public interface CmMypageService {
	
	/**
	 * @title	: [마이페이지] 상세조회
	 * @method	: mypageInfo()
	 * @comment	: 로그인한 사용자의 개인정보를 상세 조회한다.		 
	 * @param	: cmMypageDVO
	 */
	public CmMypageSVO mypageInfo(CmMypageDVO cmMypageDVO) throws Exception;
	
	/**
	 * @title	: [마이페이지] 비밀번호 변경
	 * @method	: mypagePwModify()
	 * @comment	: 사용자의 비밀번호를 변경한다.		 
	 * @param	: CmMypageDVO
	 */
	public CmMypageDVO mypagePwModify(CmMypageDVO cmMypageDVO) throws Exception;
}
