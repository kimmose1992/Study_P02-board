package com.gdgs.slyouth.ws.vo;

import java.util.List;

import com.gdgs.slyouth.cm.vo.CmPagingOutDVO;

/**
 * @title    : [예배와 말씀] 말씀후기 SVO 클래스     
 * @author   : gypig
 * @create   : 2021.07.01
 */
public class WsReviewSVO {
	
	// 페이징 출력 VO
	private CmPagingOutDVO cmPagingOutDVO;
		
	// 말씀후기 VO
	private WsReviewDVO wsReviewDVO;
	
	// 말씀후기 목록
	private List<WsReviewDVO> wsReviewDVOList;

	public CmPagingOutDVO getCmPagingOutDVO() {
		return cmPagingOutDVO;
	}

	public void setCmPagingOutDVO(CmPagingOutDVO cmPagingOutDVO) {
		this.cmPagingOutDVO = cmPagingOutDVO;
	}

	public WsReviewDVO getWsReviewDVO() {
		return wsReviewDVO;
	}

	public void setWsReviewDVO(WsReviewDVO wsReviewDVO) {
		this.wsReviewDVO = wsReviewDVO;
	}

	public List<WsReviewDVO> getWsReviewDVOList() {
		return wsReviewDVOList;
	}

	public void setWsReviewDVOList(List<WsReviewDVO> wsReviewDVOList) {
		this.wsReviewDVOList = wsReviewDVOList;
	}
	
}
