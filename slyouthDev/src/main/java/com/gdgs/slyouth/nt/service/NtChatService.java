package com.gdgs.slyouth.nt.service;

import java.util.List;

import com.gdgs.slyouth.nt.vo.NtChatDVO;
import com.gdgs.slyouth.nt.vo.NtChatSVO;
import com.gdgs.slyouth.nt.vo.NtCommentDVO;

/**
 * @title	: [커뮤니티] 자유게시판 Service 인터페이스 
 * @author	: 김모세
 * @create	: 2021.08.16
 */
public interface NtChatService {
	
	/**
	 * @title	: 자유게시판 목록 조회
	 * @method	: chatList
	 * @comment	: 자유게시판 목록 정보를 조회한다.
	 * @param	: NtChatDVO
	 */
	public NtChatSVO chatList(NtChatDVO ntChatDVO) throws Exception;
	
	/**
	 * @title	: 자유게시판 상세 조회
	 * @method	: chatDetail 
	 * @comment	: 자유게시판 게시물의 상세 정보를 조회한다.		 
	 * @param	: NtChatDVO
	 */
	public NtChatSVO chatDetail(NtChatDVO ntChatDVO) throws Exception;

	/**
	 * @title	: 자유게시판 등록/수정
	 * @method	: chatEdit 	  
	 * @comment	: 자유게시판 등록/수정에 필요한 정보를 조회한다.		 
	 * @param	: NtChatDVO
	 */
	public NtChatSVO chatEdit(NtChatDVO ntChatDVO) throws Exception;
	
	/**
	 * @title	: [자유게시판] 게시물 등록&수정
	 * @method	: chatSave() 
	 * @comment	: 자유게시판의 게시물을 등록&수정한다.		 
	 * @param	: NtChatDVO
	 */
	public NtChatDVO chatSave(NtChatDVO ntChatDVO) throws Exception;
	
	/**
	 * @title	: 자유게시판 삭제
	 * @method	: chatDelete 
	 * @comment	: 자유게시판 게시글 삭제
	 * @param	: NtChatDVO
	 */
	public NtChatDVO chatDelete(NtChatDVO ntChatDVO) throws Exception;
	
	/**
	 * @title	: [댓글] 리스트 데이터 조회
	 * @method	: commentList() 
	 * @comment	: 댓글을 리스트 형태로 조회할 수 있도록 데이터를 가져온다.		 
	 * @param	: NtChatDVO
	 */
	public List<NtCommentDVO> commentList(NtChatDVO ntChatDVO) throws Exception;
	
	/**
	 * @title	: [댓글] 등록&수정
	 * @method	: commentSave() 
	 * @comment	: 댓글을 등록&수정한다.		 
	 * @param	: NtCommentDVO
	 */
	public NtCommentDVO commentSave(NtCommentDVO ntCommentDVO) throws Exception;
	
	/**
	 * @title	: [댓글] 삭제
	 * @method	: commentDelete() 
	 * @comment	: 댓글을 삭제한다.		 
	 * @param	: NtCommentDVO
	 */
	public NtCommentDVO chatDelete(NtCommentDVO ntCommentDVO) throws Exception;

}
