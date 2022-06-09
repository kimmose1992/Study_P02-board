package com.gdgs.slyouth.wk.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdgs.slyouth.cm.vo.CmPagingOutDVO;
import com.gdgs.slyouth.wk.service.WkVoluntaryService;
import com.gdgs.slyouth.wk.service.dao.WkVoluntaryDAO;
import com.gdgs.slyouth.wk.vo.WkSVO;
import com.gdgs.slyouth.wk.vo.WkVoluntaryDVO;

/**
 * @title   : [업무] 봉사부서 관리 Service 구현 클래스     
 * @author  : gypig
 * @create  : 2021.06.24
 */
@Component
@Service("wkVoluntaryService")
public class WkVoluntaryServiceImpl implements WkVoluntaryService{

	private static final Logger logger = LoggerFactory.getLogger(WkVoluntaryServiceImpl.class);
	
	@Autowired
	private WkVoluntaryDAO wkVoluntaryDAO;
	
	/**
	 * @title	: 봉사부서리스트조회  
	 * @method	: selectVolDeptList()
	 * @comment	: 모든 봉사부서를 조회합니다.	 
	 * @param	: WkVoluntaryDVO
	 */
	@Override
	public WkSVO selectVolDeptList(WkVoluntaryDVO wkVoluntaryDVO) throws Exception {
		
		WkSVO returnSVO = new WkSVO();
		
		if(wkVoluntaryDVO.getUseYn() == null || wkVoluntaryDVO.getUseYn() == "") {
			wkVoluntaryDVO.setUseYn("Y");
		}
		
		// 봉사부서 리스트 조회
		List<WkVoluntaryDVO> volDeptList = wkVoluntaryDAO.selectVolDeptList(wkVoluntaryDVO);
		
		// 봉사부서 리스트 데이터 갯수
		int volDeptTotalCnt = wkVoluntaryDAO.volDeptTotalCnt(wkVoluntaryDVO);
		
		if(volDeptList.size() > 0 ) {
			returnSVO.setWkVoluntaryDVOList(volDeptList);
			// 페이징 설정
			CmPagingOutDVO cmPagingOutDVO = new CmPagingOutDVO(wkVoluntaryDVO);
			cmPagingOutDVO.setTotalDataCnt(volDeptTotalCnt);
			returnSVO.setCmPagingOutDVO(cmPagingOutDVO);
		}
		else {
			returnSVO.setWkVoluntaryDVOList(null);
			CmPagingOutDVO cmPagingOutDVO = new CmPagingOutDVO(wkVoluntaryDVO);
			cmPagingOutDVO.setTotalDataCnt(0);
			returnSVO.setCmPagingOutDVO(cmPagingOutDVO);
		}
		
		return returnSVO;
	}

	/**
	 * @title	: 봉사부서 등록/수정
	 * @method	: volDeptSave()
	 * @comment	: 봉사부서를 등록합니다.	 
	 * @param	: WkVoluntaryDVO
	 */
	@Override
	@Transactional
	public WkVoluntaryDVO volDeptSave(WkVoluntaryDVO wkVoluntaryDVO) throws Exception {
		
		WkVoluntaryDVO returnDVO = null;
		int resultValue = 0;
		
		// 봉사번호가 없는 경우는 등록, 그 외에는 수정
		if(wkVoluntaryDVO.getDeptNo() == "" || wkVoluntaryDVO.getDeptNo() == null) {
			try {	
				
				// 시작일자
				wkVoluntaryDVO.setStrYmd(LocalDate.now().toString());
				
				// 종료일자
				wkVoluntaryDVO.setEndYmd(LocalDate.parse("2999-12-31").toString());
				
				// 최초등록자 세팅 --> 변경필요
				wkVoluntaryDVO.setFrsRegNo(2);
				
				// 최초수정자 세팅 --> 변경필요
				wkVoluntaryDVO.setLstMdfNo(2);
				
				resultValue = wkVoluntaryDAO.insertVolDept(wkVoluntaryDVO);
				
			} catch (Exception e) {
				e.printStackTrace();
				logger.debug("봉사부서 등록에 실패했습니다");
			}
		} else {
			
			try {
				
				// 최종수정자 세팅 --> 변경필요
				wkVoluntaryDVO.setLstMdfNo(2);
					
				resultValue = wkVoluntaryDAO.updateVolDept(wkVoluntaryDVO);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		// 성공적으로 수정완료 후 ajax 콜백을 위한 단건 조회로 업데이트 성공하면 업데이트 한 정보를, 업데이서 실패하면 빈객체 들고가기
		if(resultValue != 0) {
			returnDVO = wkVoluntaryDAO.selectVolDept(wkVoluntaryDVO);
		}
		else {
			returnDVO = new WkVoluntaryDVO();
		}

		return returnDVO;
	}
}
