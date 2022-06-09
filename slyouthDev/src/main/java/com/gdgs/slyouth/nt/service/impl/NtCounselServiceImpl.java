package com.gdgs.slyouth.nt.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdgs.slyouth.cm.vo.CmPagingOutDVO;
import com.gdgs.slyouth.nt.service.NtCounselService;
import com.gdgs.slyouth.nt.service.dao.NtCounselDAO;
import com.gdgs.slyouth.nt.vo.NtCounselDVO;
import com.gdgs.slyouth.nt.vo.NtCounselSVO;

/**
 * @title	: [커뮤니티] 상단 Service 구현 클래스  
 * @author	: srar2
 * @create	: 2021. 6. 26.
 */
@Component
@Service("ntCounselService")
public class NtCounselServiceImpl implements NtCounselService {
	
	private static final Logger logger = LoggerFactory.getLogger(NtCounselServiceImpl.class);
	
	@Autowired
	private NtCounselDAO ntCounselDAO;
	
	/**
	 * @title	: 상담 목록 조회
	 * @method	: counselList() 
	 * @comment	: 상담 화면에서 입력된 정보로 상담 목록을 조회한다.		 
	 * @param	: ntCounselDVO
	 */
	@Override
	public NtCounselSVO counselList(NtCounselDVO ntCounselDVO) throws Exception {
		NtCounselSVO returnSVO = new NtCounselSVO();
		
		// 리스트 초기화
		List<NtCounselDVO> ntCounselList = null;
		
		// 상담 목록 건수 조회
		int totalDataCnt = ntCounselDAO.selectCounselTotalDataCnt(ntCounselDVO);
		
		if(totalDataCnt > 0) {
			
			// 상담 목록 조회
			ntCounselList = ntCounselDAO.counselList(ntCounselDVO);
			
			// 페이징 설정
			CmPagingOutDVO cmPagingOutDVO = new CmPagingOutDVO(ntCounselDVO);
			cmPagingOutDVO.setTotalDataCnt(totalDataCnt);
			returnSVO.setCmPagingOutDVO(cmPagingOutDVO);
		}else {
			
			CmPagingOutDVO cmPagingOutDVO = new CmPagingOutDVO(ntCounselDVO);
			cmPagingOutDVO.setTotalDataCnt(0);
			returnSVO.setCmPagingOutDVO(cmPagingOutDVO);
		}
		
		returnSVO.setNtCounselDVO(ntCounselDVO);
		returnSVO.setNtCounselDVOList(ntCounselList);
		return returnSVO;
	}
	
	/**
	 * @title	: 상담 상세 조회
	 * @method	: counselDetail() 
	 * @comment	: 상담 목록에서 선택한 코드의 상세정보를 조회합니다. 		 
	 * @param	: NtCounselDVO
	 */
	@Override
	public NtCounselSVO counselDetail(NtCounselDVO ntCounselDVO) throws Exception {
		NtCounselSVO returnSVO = new NtCounselSVO();
		NtCounselDVO returnDVO = new NtCounselDVO();
		
		// 조회구분코드(U: update, D: detail, RS: replySave)
		String selDivCd = ntCounselDVO.getSelDivCd();
		
		if(selDivCd != null) {
			if(selDivCd.equals("U") || selDivCd.equals("D")) {
				int grpCount = ntCounselDAO.counselCount(ntCounselDVO);
				
				returnDVO = ntCounselDAO.counselDetail(ntCounselDVO);
				
				// 그룹 번호에 따른 글의 수
				returnDVO.setGrpCount(grpCount);
			}else {
				returnDVO = ntCounselDVO;
			}
		}
		
		returnDVO.setSelDivCd(selDivCd);
		returnSVO.setNtCounselDVO(returnDVO);
		return returnSVO;
	}
	
	/**
	 * @title	: 상담 등록&수정
	 * @method	: counselSave()
	 * @comment	: 상담 글, 답글을 등록&수정한다.
	 * @param	: NtCounselDVO
	 */
	@Override
	@Transactional
	public int[] counselSave(NtCounselDVO ntCounselDVO) throws Exception {
		int[] saveArr = new int[2]; 
		
		// 공개 여부
		if(ntCounselDVO.getOpenYn() != null) {
			ntCounselDVO.setOpenYn("Y");
		}else {
			ntCounselDVO.setOpenYn("N");
		}
		
		// 익명 여부
		if(ntCounselDVO.getAnnyYn() != null) {
			ntCounselDVO.setAnnyYn("Y");
		}else {
			ntCounselDVO.setAnnyYn("N");
		}
		
		// 조회구분코드(U: update, D: detail, RS: replySave)
		String selDivCd = ntCounselDVO.getSelDivCd();
		
		int resultValue = 0;
		if(selDivCd != null) {
			// 상담 수정
			if(selDivCd.equals("U")){
				resultValue = ntCounselDAO.counselUpdate(ntCounselDVO);
				
				int grpOrd = ntCounselDVO.getGrpOrd();
				if(grpOrd == 0) {
					int subResultValue = ntCounselDAO.counselSubUpdate(ntCounselDVO);
				}
				
				int cmntyNo = ntCounselDVO.getCmntyNo();
				saveArr[1] = cmntyNo;
			}else if(selDivCd.equals("RS")) {
				resultValue = ntCounselDAO.counselReply(ntCounselDVO);
			}
		}else {
			// 상담 등록
			resultValue = ntCounselDAO.counselRegist(ntCounselDVO);
		}
		
		saveArr[0] = resultValue;
		
		return saveArr;
	}
	
	/**
	 * @title	: 상담 삭제
	 * @method	: counselDelete()
	 * @comment	: 상담 상세조회 페이지에서 선택한 코드의 상세정보를 삭제한다.
	 * @param	: NtCounselDVO
	 */
	@Override
	@Transactional
	public int counselDelete(NtCounselDVO ntCounselDVO) throws Exception {
		
		// 그룹 별 글 개수
		int count = ntCounselDAO.counselCount(ntCounselDVO);
		// 그룹 순서
		int grpOrd = ntCounselDVO.getGrpOrd();
		
		int resultValue = 0;
		if(count >= 2 && grpOrd == 0) {
			// 상담 본 글 존재 && 답글 존재일 경우
			resultValue = -1;
		}else {
			resultValue = ntCounselDAO.counselDelete(ntCounselDVO);
		}
		
		return resultValue;
	}
}
