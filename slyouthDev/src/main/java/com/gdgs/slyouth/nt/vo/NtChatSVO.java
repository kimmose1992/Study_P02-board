package com.gdgs.slyouth.nt.vo;

import java.util.List;

import com.gdgs.slyouth.cm.vo.CmPagingOutDVO;

/**
 * @title	: [커뮤니티] 자유게시판 SVO 클래스  
 * @author	: srar2
 * @create	: 2021. 8. 1.
 */
public class NtChatSVO {
	
	// 페이징 출력 VO
	private CmPagingOutDVO cmPagingOutDVO;
	
	// 자유게시판 VO
	private NtChatDVO ntChatDVO;
	
	// 자유게시판 리스트
	private List<NtChatDVO> ntChatDVOList;
	
	// 댓글 VO
	private NtCommentDVO ntCommentDVO;
	
	// 댓글 리스트
	private List<NtCommentDVO> ntCommentDVOList;

	public CmPagingOutDVO getCmPagingOutDVO() {
		return cmPagingOutDVO;
	}

	public void setCmPagingOutDVO(CmPagingOutDVO cmPagingOutDVO) {
		this.cmPagingOutDVO = cmPagingOutDVO;
	}

	public NtChatDVO getNtChatDVO() {
		return ntChatDVO;
	}

	public void setNtChatDVO(NtChatDVO ntChatDVO) {
		this.ntChatDVO = ntChatDVO;
	}

	public List<NtChatDVO> getNtChatDVOList() {
		return ntChatDVOList;
	}

	public void setNtChatDVOList(List<NtChatDVO> ntChatDVOList) {
		this.ntChatDVOList = ntChatDVOList;
	}

	public NtCommentDVO getNtCommentDVO() {
		return ntCommentDVO;
	}

	public void setNtCommentDVO(NtCommentDVO ntCommentDVO) {
		this.ntCommentDVO = ntCommentDVO;
	}

	public List<NtCommentDVO> getNtCommentDVOList() {
		return ntCommentDVOList;
	}

	public void setNtCommentDVOList(List<NtCommentDVO> ntCommentDVOList) {
		this.ntCommentDVOList = ntCommentDVOList;
	}
	
}
