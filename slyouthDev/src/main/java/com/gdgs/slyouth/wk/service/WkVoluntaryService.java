package com.gdgs.slyouth.wk.service;

import com.gdgs.slyouth.wk.vo.WkSVO;
import com.gdgs.slyouth.wk.vo.WkVoluntaryDVO;

/**
 * @title   : [업무] 봉사부서 관리 Service 인터페이스     
 * @author  : gypig
 * @create  : 2021.06.24
 */
public interface WkVoluntaryService {

	
	/**
	 * @title	: 봉사부서리스트조회  
	 * @method	: selectVolDeptList()
	 * @comment	: 모든 봉사부서를 조회합니다.	 
	 * @param	: WkVoluntaryDVO
	 */
	public WkSVO selectVolDeptList(WkVoluntaryDVO wkVoluntaryDVO) throws Exception;
	
	/**
	 * @title	: 봉사부서등록
	 * @method	: volDeptSave()
	 * @comment	: 봉사부서를 등록/수정합니다.	 
	 * @param	: WkVoluntaryDVO
	 */
	public WkVoluntaryDVO volDeptSave(WkVoluntaryDVO wkVoluntaryDVO) throws Exception;
}
