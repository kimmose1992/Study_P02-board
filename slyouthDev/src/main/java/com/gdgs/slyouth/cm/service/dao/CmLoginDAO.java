package com.gdgs.slyouth.cm.service.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.gdgs.slyouth.cm.vo.CmLoginDVO;

/**
 * @title    : [공통] 회원가입 및 로그인 DAO 클래스
 * @author   : gypig
 * @create   : 2021.06.19
 * @update   : 2021.07.25
 */
@Component
@Repository("cmLoginDAO")
public class CmLoginDAO extends AbstractDAO {

	private static final String NAMESPACE = "cm.login.";
	
	/**
	 * @title    : [본인인증] 교적 확인     
	 * @method   : selectCertMember()
	 * @comment  : 본인인증 입력정보에 해당되는 교인정보를 조회합니다
	 * @param    : CmLoginDVO
	 */
	public CmLoginDVO selectCertMember(CmLoginDVO cmLoginDVO) {
		
		return (CmLoginDVO) select(NAMESPACE + "selectCertMember", cmLoginDVO);
	}

	/**
	 * @title	: [본인인증] 인증정보 저장 	  
	 * @method	: saveAuthInfo	 
	 * @comment	: 입력된 사용자의 정보를 기준으로 생성된 본인 인증번호 저장	 
	 * @param	: CmLoginDVO
	 */
	public int saveAuthInfo(CmLoginDVO cmLoginDVO) {
		
		return (int) insert(NAMESPACE + "saveAuthInfo", cmLoginDVO);
	}

	/**
	 * @title	: [본인인증] 인증정보 조회 	   	  
	 * @method	: selectAuthInfo	 
	 * @comment	: 사용자의 정보를 기준으로 발급된 본인 인증번호 정보를 조회한다.		 
	 * @param	: CmLoginDVO
	 */
	public CmLoginDVO selectAuthInfo(CmLoginDVO cmLoginDVO) {
		return (CmLoginDVO) select(NAMESPACE + "selectAuthInfo", cmLoginDVO);
	}
	
	/**
	 * @title    : 회원가입     
	 * @method   : insertUser()
	 * @comment  : DB에 회원정보를 저장합니다.
	 * @param    : CmLoginDVO
	 */
	public int insertUser(CmLoginDVO cmLoginDVO) {
		
		return (int) insert(NAMESPACE + "insertUser", cmLoginDVO);
	}
	
	/**
	 * @title   : 사용자 정보 조회
	 * @method  : findByUsrId
	 * @comment : 입력받은 ID로 사용자 정보를 조회한다. 
	 * @param   : CmLoginDVO
	 * @return	: CmLoginDVO
	 */
	public CmLoginDVO findByUsrId(CmLoginDVO cmLoginDVO) {
		return (CmLoginDVO) select(NAMESPACE + "findByUsrId", cmLoginDVO);
	}
	
	/**
	 * @title    : 로그인 계정 잠금     
	 * @method   : updateLoginInfoLock()
	 * @comment  : 로그인 계정을 잠금합니다.
	 * @param    : CmLoginDVO
	 */
	public int updateLoginInfoLock(CmLoginDVO cmLoginDVO) {
		
		return (int) update(NAMESPACE + "updateLoginInfoLock", cmLoginDVO);
	}
	
	/**
	 * @title    : 로그인 계정 잠금 해제    
	 * @method   : updateLoginInfoUnlock()
	 * @comment  : 로그인 계정을 잠금합니다.
	 * @param    : CmLoginDVO
	 */
	public int updateLoginInfoUnlock(CmLoginDVO cmLoginDVO) {
		
		return (int) update(NAMESPACE + "updateLoginInfoUnlock", cmLoginDVO);
	}
	
	/**
	 * @title	: 비밀번호 수정 
	 * @method	: updatePassword()	 
	 * @comment	: 유저의 비밀번호를 수정합니다.		 
	 * @param	: updatePassword
	 */
	public int updatePassword(CmLoginDVO cmLoginDVO) {
		return (int) update(NAMESPACE + "updatePassword", cmLoginDVO);
	}

	/**
	 * @title	: 비밀번호 오류 횟수 수정
	 * @method	: updatePwErrCnt
	 * @comment	: 비밀번호 오류 횟수를 수정한다. (로그인 성공: 0, 로그인 실패: + 1)		 
	 * @param	: CmLoginDVO
	 */
	public void updatePwErrCnt(CmLoginDVO cmLoginDVO) {
		update(NAMESPACE + "updatePwErrCnt", cmLoginDVO);
	}

	/**
	 * @title	: 로그인 횟수 수정	  
	 * @method	: updateLoginCnt	 
	 * @comment	: 로그인 횟수를 수정한다. (로그인 성공: +1)		 
	 * @param	: CmLoginDVO
	 */
	public void updateLoginCnt(CmLoginDVO cmLoginDVO) {
		update(NAMESPACE + "updateLoginCnt", cmLoginDVO);
	}
	
	/**
	 * @title    : ID 확인     
	 * @method   : checkId()
	 * @comment  : ID로 DB에 등록되어있는 유저번호를 가져옵니다.
	 * @param    : CmLoginDVO
	 */
	public CmLoginDVO checkId(CmLoginDVO cmLoginDVO) {
		
		return (CmLoginDVO) select(NAMESPACE + "checkId", cmLoginDVO);
	}

}
