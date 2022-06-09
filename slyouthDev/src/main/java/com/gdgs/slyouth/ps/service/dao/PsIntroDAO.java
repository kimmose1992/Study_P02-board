package com.gdgs.slyouth.ps.service.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.gdgs.slyouth.cm.service.dao.AbstractDAO;
import com.gdgs.slyouth.ps.vo.PsIntroDVO;

/**
 * @title   : [찬양과셀라] 셀라소개 DAO 클래스     
 * @author  : 김예림
 * @create  : 2021.07.03
 * @update	: 2021.07.17
 */

@Component
@Repository("psIntroDAO")
public class PsIntroDAO extends AbstractDAO {
	
	private static final String NAMESPACE = "ps.intro.";
	
	/**
	 * @title   : 셀라소개 기본정보 조회
	 * @method  : selectSelahInfo()
	 * @comment : 셀라소개 기본정보를 조회해온다.
	 * @param   : psIntroDVO
	 */
	public PsIntroDVO selectSelahInfo(PsIntroDVO psIntroDVO) {
		return (PsIntroDVO) select(NAMESPACE + "selectSelahInfo", psIntroDVO);
	}

	/**
	 * @title	: 셀라소개 수정이력 업데이트	  
	 * @method	: updateIntroInfo	 
	 * @comment	: 셀라소개 수정이력 업데이트		 
	 * @param	: resultCnt
	 */
	public int updateIntroInfo(PsIntroDVO psIntroDVO) {
		return (int) update(NAMESPACE + "updateIntroInfo", psIntroDVO);
	}
}
