package com.gdgs.slyouth.ws.service.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.gdgs.slyouth.cm.service.dao.AbstractDAO;
import com.gdgs.slyouth.ws.vo.WsReviewDVO;

/**
 * @title    : [예배와 말씀] 말씀후기 DAO 클래스  
 * @author   : gypig
 * @create   : 2021.07.01
 * @update   : 2021.07.10
 */

@Component
@Repository("wsReviewDAO")
public class WsReviewDAO extends AbstractDAO{

	private static final String NAMESPACE = "ws.review."; 
	
	/**
	 * @title	: 말씀후기 리스트 목록조회
	 * @method	: reviewList()
	 * @comment	: 주보 데이터를 list 형태로 조회한다.
	 * @param	: WsReviewDVO
	 */
	public List<WsReviewDVO> reviewList(WsReviewDVO wsReviewDVO) {
		
		return (List<WsReviewDVO>) selectList(NAMESPACE + "reviewList", wsReviewDVO);
	
	}
	
	/**
	 * @title	: 말씀후기 리스트 목록 수 조회
	 * @method	: reviewListTotalCnt()
	 * @comment	: 말씀후기에 대한 전체 목록수를 조회합니다.
	 * @param	: WsReviewDVO
	 */
	public int reviewListTotalCnt(WsReviewDVO wsReviewDVO) {
		
		return (int) select(NAMESPACE + "reviewListTotalCnt", wsReviewDVO);
	}
	
	/**
	 * @title	: 말씀후기 조회수 증가
	 * @method	: reviewCnt()
	 * @comment	: 말씀후기에 대한 조회수를 증가합니다.
	 * @param	: WsReviewDVO
	 */
	public int reviewCnt(WsReviewDVO wsReviewDVO) {
		
		return (int) update(NAMESPACE + "reviewCnt", wsReviewDVO);
	}
	
	/**
	 * @title	: 말씀후기 목록 상세조회
	 * @method	: reviewDetail()
	 * @comment	: 주보 데이터를 list 형태로 조회한다.
	 * @param	: WsReviewDVO
	 */
	public WsReviewDVO reviewDetail(WsReviewDVO wsReviewDVO) {
		
		return (WsReviewDVO) select(NAMESPACE + "reviewDetail", wsReviewDVO);
	}
	
	/**
	 * @title	: 말씀후기 등록
	 * @method	: insertReview()
	 * @comment	: 주보 데이터를 등록합니다.
	 * @param	: WsReviewDVO
	 */
	public int insertReview(WsReviewDVO wsReviewDVO) {
		
		return (int) insert(NAMESPACE + "insertReview", wsReviewDVO);
	}
	
	/**
	 * @title	: 말씀후기 수정
	 * @method	: updateReview()
	 * @comment	: 말씀후기를 수정합니다.
	 * @param	: WsReviewDVO
	 */
	public int updateReview(WsReviewDVO wsReviewDVO) {
		
		return (int) update(NAMESPACE + "updateReview", wsReviewDVO);
	}
	
	/**
	 * @title	: 말씀후기 삭제
	 * @method	: deleteReview()
	 * @comment	: 말씀후기를 삭제합니다.
	 * @param	: WsReviewDVO
	 */
	public int deleteReview(WsReviewDVO wsReviewDVO) {
		
		return (int) delete(NAMESPACE + "deleteReview", wsReviewDVO);
	}
}
