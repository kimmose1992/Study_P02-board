package com.gdgs.slyouth.ws.service;

import com.gdgs.slyouth.ws.vo.WsReviewDVO;
import com.gdgs.slyouth.ws.vo.WsReviewSVO;

/**
 * @title    : [예배와 말씀] 말씀후기 Service 클래스     
 * @author   : gypig
 * @create   : 2021.07.01
 * @update   : 2021.07.09
 */
public interface WsReviewService {

	/**
	 * @title	: 목록 조회   
	 * @method	: reviewList()	 
	 * @comment	: 말씀후기 목록을 조회합니다.
	 * @param	: WsReviewDVO
	 */
	public WsReviewSVO reviewList(WsReviewDVO wsReviewDVO);
	
	/**
	 * @title	: 말씀후기 상세조회 
	 * @method	: reviewDetail()	 
	 * @comment	: 말씀후기 목록을 조회합니다.
	 * @param	: WsReviewDVO
	 */
	public WsReviewSVO reviewDetail(WsReviewDVO wsReviewDVO);
	
	/**
	 * @title	: 말씀후기 등록/수정
	 * @method	: reviewSave()	 
	 * @comment	: 말씀후기 등록/수정을 진행합니다.
	 * @param	: WsReviewDVO
	 */
	public int reviewSave(WsReviewDVO wsReviewDVO);
	
	/**
	 * @title	: 말씀후기 삭제
	 * @method	: reviewDel()	 
	 * @comment	: 말씀후기 삭제를 진행합니다.
	 * @param	: WsReviewDVO
	 */
	public int reviewDel(WsReviewDVO wsReviewDVO);
}
