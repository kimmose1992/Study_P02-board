package com.gdgs.slyouth.cm.vo;

/**
 * @title    : [공통] 로그인 및 회원가입 SVO 클래스     
 * @author   : gypig
 * @create   : 2021.07.13
 */
public class CmLoginSVO extends CmBaseSVO {
	
	/**
	 * 로그인 정보(단건)
	 */
	private CmLoginDVO cmLoginDVO;
	
	public CmLoginDVO getCmLoginDVO() {
		return cmLoginDVO;
	}

	public void setCmLoginDVO(CmLoginDVO cmLoginDVO) {
		this.cmLoginDVO = cmLoginDVO;
	}
	
}
