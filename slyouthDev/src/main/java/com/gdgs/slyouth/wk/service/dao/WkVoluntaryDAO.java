package com.gdgs.slyouth.wk.service.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.gdgs.slyouth.cm.service.dao.AbstractDAO;
import com.gdgs.slyouth.wk.vo.WkVoluntaryDVO;

/**
 * @title   : [업무] 봉사부서 관리 DAO 클래스     
 * @author  : gypig
 * @create  : 2021.06.24
 */
@Component
@Repository("wkVoluntaryDAO")
public class WkVoluntaryDAO extends AbstractDAO{

	private static final String NAMESPACE = "wk.voluntary.dept.";
	
	/**
	 * @title	: 봉사부서 전체조회
	 * @method	: selectVolDeptList()	 
	 * @comment	: 데이터 베이스에서 전체 봉사부서를 조회합니다.
	 * @param	: N/A
	 */
	public List<WkVoluntaryDVO> selectVolDeptList(WkVoluntaryDVO wkVoluntaryDVO) {
		
		return (List<WkVoluntaryDVO>) selectList(NAMESPACE + "selectVolDeptList", wkVoluntaryDVO);
	}
	
	/**
	 * @title	: 봉사부서 단건조회(부서)
	 * @method	: selectVolDept()	 
	 * @comment	: 데이터 베이스에서 전체 봉사부서를 조회합니다.
	 * @param	: WkVoluntaryDVO
	 */
	public WkVoluntaryDVO selectVolDept(WkVoluntaryDVO wkVoluntaryDVO) {
		
		return (WkVoluntaryDVO) select(NAMESPACE + "selectVolDept", wkVoluntaryDVO);
	}
	
	/**
	 * @title	: 봉사부서 전체조회
	 * @method	: insertVolDept()	 
	 * @comment	: 데이터 베이스에서 전체 봉사부서를 조회합니다.
	 * @param	: WkVoluntaryDVO
	 */
	public int insertVolDept(WkVoluntaryDVO wkVoluntaryDVO) {
		
		return (int) insert(NAMESPACE + "insertVolDept", wkVoluntaryDVO);
	}
	
	/**
	 * @title	: 봉사부서 수정
	 * @method	: updateVolDept()	 
	 * @comment	: 봉사부서의 이름을 변경하여 저장합니다.
	 * @param	: WkVoluntaryDVO
	 */
	public int updateVolDept(WkVoluntaryDVO wkVoluntaryDVO) {
		
		return (int) update(NAMESPACE + "updateVolDept", wkVoluntaryDVO);
	}
	
	/**
	 * @title	: 봉사부서 전체 갯수
	 * @method	: volDeptTotalCnt()	 
	 * @comment	: 봉사부서의 조건에 따른 전체갯수를 가져옵니다.
	 * @param	: WkVoluntaryDVO
	 */
	public int volDeptTotalCnt(WkVoluntaryDVO wkVoluntaryDVO) {
		
		return (int) select(NAMESPACE + "volDeptTotalCnt", wkVoluntaryDVO);
	}
}
