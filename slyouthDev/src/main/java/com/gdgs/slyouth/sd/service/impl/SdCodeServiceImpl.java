package com.gdgs.slyouth.sd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gdgs.slyouth.cm.vo.CmPagingOutDVO;
import com.gdgs.slyouth.sd.service.SdCodeService;
import com.gdgs.slyouth.sd.service.dao.SdCodeDAO;
import com.gdgs.slyouth.sd.vo.SdCodeDVO;
import com.gdgs.slyouth.sd.vo.SdCodeSVO;

/**
 * @title	: [기준정보] 코드관리 Service 구현 클래스	  
 * @author	: gypig
 * @create	: 2021.06.16
 */
@Component
@Service("sdCodeService")
public class SdCodeServiceImpl implements SdCodeService {

	@Autowired
	private SdCodeDAO sdCodeDAO;
	
	/**
	 * @title	: 코드 목록 조회	  
	 * @method	: selectCodeList()	 
	 * @comment	: 코드관리 화면에서 입력된 정보로 코드 목록을 조회한다.	  
	 * @param	: sdCodeDVO
	 */
	@Override
	public SdCodeSVO selectCodeList(SdCodeDVO sdCodeDVO) throws Exception {
		SdCodeSVO returnSVO = new SdCodeSVO();
		
		// 리스트 초기화
		List<SdCodeDVO> sdCodeList = null;
		
		// 코드 목록 건수 조회
		int totalDataCnt = sdCodeDAO.selectCodeTotalDataCnt(sdCodeDVO);
		
		if (totalDataCnt > 0) {
			
			// 코드 목록 조회
			sdCodeList = sdCodeDAO.selectCodeList(sdCodeDVO);
			
			// 페이징 설정
			CmPagingOutDVO cmPagingOutDVO = new CmPagingOutDVO(sdCodeDVO);
			cmPagingOutDVO.setTotalDataCnt(totalDataCnt);
			returnSVO.setCmPagingOutDVO(cmPagingOutDVO);
		}
				
		returnSVO.setSdCodeDVO(sdCodeDVO);
		returnSVO.setSdCodeDVOList(sdCodeList);
		return returnSVO;
	}

	/**
	 * @title	: 코드 상세 조회	  
	 * @method	: selectCodeDetail()	 
	 * @comment	: 코드 조회 목록에서 선택한 코드의 상세정보를 조회한다.	  
	 * @param	: sdCodeDVO
	 */
	@Override
	public SdCodeSVO selectCodeDetail(SdCodeDVO sdCodeDVO) throws Exception {
		SdCodeSVO returnSVO = new SdCodeSVO();
		SdCodeDVO paramVO = sdCodeDVO;
		
		SdCodeDVO codeDetail = sdCodeDAO.selectCodeDetail(paramVO);
		
		if (codeDetail == null) {
			codeDetail = new SdCodeDVO();
		}
		
		returnSVO.setSdCodeDVO(codeDetail);	
		return returnSVO;
	}

}
