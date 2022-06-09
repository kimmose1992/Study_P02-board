package com.gdgs.slyouth.ws.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdgs.slyouth.cm.vo.CmPagingOutDVO;
import com.gdgs.slyouth.ws.service.WsReviewService;
import com.gdgs.slyouth.ws.service.dao.WsReviewDAO;
import com.gdgs.slyouth.ws.vo.WsReviewDVO;
import com.gdgs.slyouth.ws.vo.WsReviewSVO;

/**
 * @title    : [예배와 말씀] 말씀후기 ServiceImpl 클래스      
 * @author   : gypig
 * @create   : 2021.07.01
 * @update   : 2021.07.10
 */

@Component
@Service("wsReviewService")
public class WsReviewServiceImpl implements WsReviewService{

	@Autowired
	private WsReviewDAO wsReivewDAO;
	
	/**
	 * @title     : 목록조회     
	 * @method    : reviewList()
	 * @comment   : 말씀후기 목록을 조회합니다.       
	 * @param     : WsReviewDVO
	 */
	@Override
	public WsReviewSVO reviewList(WsReviewDVO wsReviewDVO) {
		
		WsReviewSVO returnSVO = new WsReviewSVO();
		
		List<WsReviewDVO> reviewList = null;
		int totalDataCnt = wsReivewDAO.reviewListTotalCnt(wsReviewDVO);
		
		if(totalDataCnt > 0) {
			
			// 주보 목록 조회
			reviewList = wsReivewDAO.reviewList(wsReviewDVO);
			
			// 페이징 설정
			CmPagingOutDVO cmPagingOutDVO = new CmPagingOutDVO(wsReviewDVO);
			cmPagingOutDVO.setTotalDataCnt(totalDataCnt);
			returnSVO.setCmPagingOutDVO(cmPagingOutDVO);
		}else {
			
			CmPagingOutDVO cmPagingOutDVO = new CmPagingOutDVO(wsReviewDVO);
			cmPagingOutDVO.setTotalDataCnt(0);
			returnSVO.setCmPagingOutDVO(cmPagingOutDVO);
		}
		
		// 데이터가 아무것도 없는 경우 처리
		if(reviewList == null) {
			reviewList = new ArrayList<WsReviewDVO>();
		}
		
		returnSVO.setWsReviewDVO(wsReviewDVO);
		returnSVO.setWsReviewDVOList(reviewList);
		return returnSVO;
	}

	/**
	 * @title     : 말씀후기 상세조회   
	 * @method    : reviewDetail()    
	 * @comment   : 말씀후기 목록을 상세조회합니다.
	 * @param     : WsReviewDVO
	 */
	@Override
	public WsReviewSVO reviewDetail(WsReviewDVO wsReviewDVO) {
		
		WsReviewSVO returnSVO = new WsReviewSVO();
		WsReviewDVO returnDVO = null;
		
		// 등록 페이지의 경우
		if("I".equals(wsReviewDVO.getEditDivCd())) {
			returnDVO = new WsReviewDVO();
			returnDVO.setTitle(wsReviewDVO.getTitle());
		} else if("U".equals(wsReviewDVO.getEditDivCd())) { // 수정 페이지의 경우
			returnDVO = wsReivewDAO.reviewDetail(wsReviewDVO);
		} else { // 상세 페이지의 경우
			wsReivewDAO.reviewCnt(wsReviewDVO);
			returnDVO = wsReivewDAO.reviewDetail(wsReviewDVO);
		}
		
		returnSVO.setWsReviewDVO(returnDVO);
		return returnSVO;
	}

	/**
	 * @title     : 말씀후기 등록/수정     
	 * @method    : reviewSave()
	 * @comment   : 말씀후기 등록/수정을 진행합니다.       
	 * @param     : WsReviewDVO
	 */
	@Override
	@Transactional
	public int reviewSave(WsReviewDVO wsReviewDVO) {
		
		int returnValue = 0;
		
		try {
			if("I".equals(wsReviewDVO.getEditDivCd())) {
				returnValue =  wsReivewDAO.insertReview(wsReviewDVO);
			} else if("U".equals(wsReviewDVO.getEditDivCd())) {
				returnValue = wsReivewDAO.updateReview(wsReviewDVO);
			}
		} catch (Exception e) {
			// 저장 실패
			e.printStackTrace();
		}
		
		return returnValue;
	}

	/**
	 * @title     : 말씀후기 삭제 
	 * @method    : reviewDel()
	 * @comment   : 말씀후기를 삭제합니다.       
	 * @param     : WsReviewDVO
	 */
	@Override
	@Transactional
	public int reviewDel(WsReviewDVO wsReviewDVO) {
		
		int returnValue = 0;
		
		try {
			returnValue = wsReivewDAO.deleteReview(wsReviewDVO);
		} catch (Exception e) {
			// 삭제 실패 
			e.printStackTrace();
		}
		
		return returnValue;
	}
	
}
