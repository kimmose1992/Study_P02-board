package com.gdgs.slyouth.cm.service.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.gdgs.slyouth.cm.vo.CmComDVO;

/**
 * @title	: [공통] 기능관리 DAO 클래스	  
 * @author	: gypig
 * @update	: 2021.06.29
 */
@Component
@Repository("cmComDAO")
@SuppressWarnings("unchecked")
public class CmComDAO extends AbstractDAO {

	private static final String NAMESPACE = "cm.com.";
	
	/**
	 * @title	: 콤보박스 리스트 조회 
	 * @method	: selectComboDataList()
	 * @comment	: 콤보박스 데이터를 조회하여 리턴한다.
	 * @param	: codeNo
	 * @return	: List<CmComDVO>
	 */
	public List<CmComDVO> selectComboDataList(CmComDVO cmComDVO) {
		return (List<CmComDVO>) selectList(NAMESPACE + "selectComboDataList", cmComDVO);
	}
	
	/**
	 * @title	: 콤보박스 교역자 리스트 조회 
	 * @method	: selectComboPastorList()
	 * @comment	: 콤보박스 교역자 데이터를 조회하여 리턴한다.
	 * @param	: N/A
	 * @return	: List<CmComDVO>
	 */
	public List<CmComDVO> selectComboPastorList(CmComDVO cmComDVO) {
		return (List<CmComDVO>) selectList(NAMESPACE + "selectComboPastorList", cmComDVO);
	}
	
	/**
	 * @title	: 콤보박스 봉사부서 리스트 조회 
	 * @method	: selectComboVolDeptList()
	 * @comment	: 콤보박스 봉사부서 데이터를 조회하여 리턴한다.
	 * @param	: CmComDVO
	 * @return	: List<CmComDVO>
	 */
	public List<CmComDVO> selectComboVolDeptList(CmComDVO cmComDVO) {
		return (List<CmComDVO>) selectList(NAMESPACE + "selectComboVolDeptList", cmComDVO);
	}
}
