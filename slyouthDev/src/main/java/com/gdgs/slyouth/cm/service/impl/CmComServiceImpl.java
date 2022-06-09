package com.gdgs.slyouth.cm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gdgs.slyouth.cm.service.CmComService;
import com.gdgs.slyouth.cm.service.dao.CmComDAO;
import com.gdgs.slyouth.cm.vo.CmComDVO;

/**
 * @title	: [공통] 기능관리 Service 구현 클래스	  
 * @author	: gypig
 * @update	: 2021.06.29
 */
@Component
@Service("cmComService")
public class CmComServiceImpl implements CmComService {

	@Autowired
	private CmComDAO cmComDAO;
	
	/**
	 * @title	: 콤보박스 구성  
	 * @method	: makeCombo()
	 * @comment	: 콤보박스 요청 정보를 조회한다.		 
	 * @param	: CmComDVO
	 * @return	: CmComDVO
	 */
	@Override
	public CmComDVO makeCombo(CmComDVO cmComDVO) throws Exception {
		CmComDVO returnDVO = new CmComDVO();
		
		// 콤보 데이터 저장
		String comboDataKey;
		List<CmComDVO> comboDataList;
		HashMap<String, Object> comboData = new HashMap<String, Object>();
		
	
		// 콤보 데이터 조회
		if(cmComDVO.getCodeRefKey() == null) {
			// 메인 콤보
			for(int i=0; i<cmComDVO.getCodeKeyArr().length; i++) {
				cmComDVO.setCodeKey(cmComDVO.getCodeKeyArr()[i]);
				
				comboDataList = cmComDAO.selectComboDataList(cmComDVO);
				
				comboDataKey = cmComDVO.getComboIdArr()[i] + "|" + cmComDVO.getComboTypeArr()[i];
				comboData.put(comboDataKey, comboDataList);
			}
		}
		else {
			// 참조 콤보
			comboDataList = cmComDAO.selectComboDataList(cmComDVO);
			
			comboDataKey = cmComDVO.getComboId() + "|" + cmComDVO.getComboType();
			comboData.put(comboDataKey, comboDataList);
		}
		
		returnDVO.setComboMap(comboData);
		return returnDVO;
	}
	
	/**
	 * @title	: 콤보박스 커스텀 구성  
	 * @method	: makeCustomCombo()
	 * @comment	: 콤보박스 요청 정보를 조회한다. (커스텀)
	 * @param	: CmComDVO
	 * @return	: CmComDVO
	 */
	@Override
	public CmComDVO makeCustomCombo(CmComDVO cmComDVO) throws Exception {
		CmComDVO returnDVO = new CmComDVO();
		
		// 콤보 데이터 저장
		String comboDataKey;
		List<CmComDVO> comboDataList;
		HashMap<String, Object> comboData = new HashMap<String, Object>();
		
		// 콤보 데이터 조회
		for(int i=0; i<cmComDVO.getCodeKeyArr().length; i++) {
			
			comboDataList = new ArrayList<CmComDVO>();	
			
			// 교역자 조회 콤보
			if ("TRUCKER".equals(cmComDVO.getCodeKeyArr()[i])) {
				cmComDVO.setCodeKey(cmComDVO.getCodeKeyArr()[i]);

				comboDataList = new ArrayList<CmComDVO>();	
				comboDataList = cmComDAO.selectComboPastorList(cmComDVO);
			}
			// 봉사부서 조회 콤보
			else if("VOL_DEPT".equals(cmComDVO.getCodeKeyArr()[i])) {
				cmComDVO.setCodeKey(cmComDVO.getCodeKeyArr()[i]);

				comboDataList = new ArrayList<CmComDVO>();	
				comboDataList = cmComDAO.selectComboVolDeptList(cmComDVO);
			}
			comboDataKey = cmComDVO.getComboIdArr()[i] + "|" + cmComDVO.getComboTypeArr()[i];
			comboData.put(comboDataKey, comboDataList);
		}
		
		returnDVO.setComboMap(comboData);
		return returnDVO;
	}

}
