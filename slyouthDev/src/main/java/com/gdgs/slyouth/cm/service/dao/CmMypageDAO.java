package com.gdgs.slyouth.cm.service.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.gdgs.slyouth.cm.vo.CmMypageDVO;

/**
 * @title	: [공통] 마이페이지 DAO 클래스  
 * @author	: srar2
 * @create	: 2021. 8. 11.
 */
@Component
@Repository("cmMypageDAO")
public class CmMypageDAO extends AbstractDAO {
	
	private static final String NAMESPACE = "cm.mypage.";
	
	/**
	 * @title	: [마이페이지] 상세조회
	 * @method	: mypage()
	 * @comment	: 로그인한 사용자의 개인정보를 상세 조회한다.		 
	 * @param	: CmLoginDVO
	 */
	public CmMypageDVO mypageInfo(CmMypageDVO cmMypageDVO) {
		return (CmMypageDVO) select(NAMESPACE + "mypageInfo", cmMypageDVO);
	}
	
	/**
	 * @title	: [마이페이지] 비밀번호 변경
	 * @method	: mypagePwModify()
	 * @comment	: 사용자의 비밀번호를 변경한다.		 
	 * @param	: CmMypageDVO
	 */
	public int mypagePwModify(CmMypageDVO cmMypageDVO) {
		return (int) update(NAMESPACE + "mypagePwModify", cmMypageDVO); 
	}
}
