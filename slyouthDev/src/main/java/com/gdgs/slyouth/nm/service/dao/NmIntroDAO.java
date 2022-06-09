package com.gdgs.slyouth.nm.service.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.gdgs.slyouth.cm.service.dao.AbstractDAO;
import com.gdgs.slyouth.nm.vo.NmIntroDVO;

/**
 * @title   : [새가족] 새가족조회 DAO 클래스  
 * @author   : 이하은
 * @create   : 2021.06.30
 */

@Component
@Repository("nmIntroDAO")
public class NmIntroDAO extends AbstractDAO {

	private static final String NAMESPACE = "nm.member.";

	/**
	 * @title	: 새가족소개 기본정보 조회  
	 * @method	: selectMemberInfo
	 * @comment	: 새가족소개 기본정보를 가져온다.
	 * @param	: nmIntroDVO
	 */
	public NmIntroDVO selectMemberInfo(NmIntroDVO nmIntroDVO) throws Exception {
		return (NmIntroDVO) select(NAMESPACE + "selectMemberInfo", nmIntroDVO);
	}

	/**
	 * @title	: 새가족소개 수정이력 업데이트	  
	 * @method	: updateIntroInfo	 
	 * @comment	: 새가족소개 수정이력 업데이트		 
	 * @param	: resultCnt
	 */
	public int updateIntroInfo(NmIntroDVO nmIntroDVO) throws Exception {
		return (int) update(NAMESPACE + "updateIntroInfo", nmIntroDVO);
	}
	
	
}
