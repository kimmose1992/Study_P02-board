package com.gdgs.slyouth.cm.service;

import com.gdgs.slyouth.cm.vo.CmLoginDVO;
import com.gdgs.slyouth.cm.vo.CmLoginSVO;

/**
 * @title    : [공통] 회원가입 및 로그인 Service 인터페이스     
 * @author   : gypig
 * @create   : 2021.06.19
 * @update   : 2021.07.25
 */
public interface CmLoginService {

	/**
	 * @title	: 인증번호 생성   
	 * @method	: authNoGen()
	 * @comment	: 인증번호를 생성 및 조회 합니다.		 
	 * @param	: CmLoginDVO
	 */
	public CmLoginDVO authNoGen(CmLoginDVO cmLoginDVO) throws Exception;

	/**
	 * @title	: 본인인증 번호 확인
	 * @method	: authNoCheck()
	 * @comment	: 발급된 인증번호와 사용자가 입력한 본인인증 번호 일치여부를 확인한다.
	 * @param	: CmLoginDVO
	 */
	public CmLoginDVO authNoCheck(CmLoginDVO cmLoginDVO) throws Exception;

	/**
	 * @title	: 회원가입 정보 저장  
	 * @method	: joinSave
	 * @comment	: 회원가입 정보를 저장한다.
	 * @param	: CmLoginDVO
	 */
	public boolean joinSave(CmLoginDVO cmLoginDVO) throws Exception;
	
	/**
	 * @title	: 로그인 체크
	 * @method	: loginCheck()
	 * @comment	: 입력받은 ID와 PW를 체크합니다		 
	 * @param	: CmLoginDVO
	 */
	public CmLoginSVO loginCheck(CmLoginDVO cmLoginDVO) throws Exception;
	
	/**
	 * @title	: ID 확인  
	 * @method	: checkId()
	 * @comment	: ID로 DB에 등록되어있는 유저가 있는지 확인합니다.		 
	 * @param	: CmLoginDVO
	 */
	public CmLoginDVO checkId(CmLoginDVO cmLoginDVO) throws Exception;
	
	/**
	 * @title	: 비밀번호 변경   
	 * @method	: changePassword()
	 * @comment	: 비밀번호를 변경합니다.		 
	 * @param	: CmLoginDVO
	 */
	public int changePassword(CmLoginDVO cmLoginDVO) throws Exception;



}
