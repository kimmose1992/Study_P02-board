package com.gdgs.slyouth.nt.service.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.gdgs.slyouth.cm.service.dao.AbstractDAO;
import com.gdgs.slyouth.nt.vo.NtChatDVO;
import com.gdgs.slyouth.nt.vo.NtCommentDVO;

/**
 * @title	: [커뮤니티] 자유게시판 DAO 클래스 
 * @author	: 김모세
 * @create	: 2021.08.16
 */
@Component
@Repository("ntChatDAO")
@SuppressWarnings("unchecked")
public class NtChatDAO extends AbstractDAO {
	
	private static final String NAMESPACE = "nt.chat.";
	
	/**
	 * @title	: 자유게시판 목록 건수 조회
	 * @method	: selectChatTotalDataCnt
	 * @comment	: 자유게시판에서 입력된 정보로 조회된 데이터의 건수를 리턴한다.		 
	 * @param	: NtChatDVO
	 */
	public int selectChatTotalDataCnt(NtChatDVO ntChatDVO) {
		return (int) select(NAMESPACE + "selectChatTotalDataCnt", ntChatDVO);
	}
	
	/**
	 * @title	: 자유게시판 목록 조회
	 * @method	: selectChatList
	 * @comment	: 자유게시판에서 입력된 정보로 데이터를 리스트 형태로 조회한다.		 
	 * @param	: NtChatDVO
	 */
	public List<NtChatDVO> selectChatList(NtChatDVO ntChatDVO) {
		return (List<NtChatDVO>) selectList(NAMESPACE + "selectChatList", ntChatDVO);
	}
	
	/**
	 * @title	: 자유게시판 상세 조회
	 * @method	: selectChatInfo 
	 * @comment	: 자유게시판 게시물의 상세 정보를 조회한다.		 
	 * @param	: NtChatDVO
	 */
	public NtChatDVO selectChatInfo(NtChatDVO ntChatDVO) {
		return (NtChatDVO) select(NAMESPACE + "selectChatInfo", ntChatDVO);
	}
	
	/**
	 * @title	: 자유게시판 게시물 등록
	 * @method	: insertChatInfo 
	 * @comment	: 자유게시판에서 입력된 정보로 게시물을 등록한다.		 
	 * @param	: NtChatDVO
	 */
	public int insertChatInfo(NtChatDVO ntChatDVO) {
		return (int) insert(NAMESPACE + "insertChatInfo", ntChatDVO);
	}
	
	/**
	 * @title	: 자유게시판 게시물 수정
	 * @method	: updateChatInfo
	 * @comment	: 자유게시판에서 입력된 정보로 게시물을 수정한다.		 
	 * @param	: NtChatDVO
	 */
	public int updateChatInfo(NtChatDVO ntChatDVO) {
		return (int) update(NAMESPACE + "updateChatInfo", ntChatDVO);
	}
	
	/**
	 * @title	: 자유게시판 삭제
	 * @method	: deleteChatInfo 
	 * @comment	: 자유게시판 게시글 삭제
	 * @param	: NtChatDVO
	 */
	public int deleteChatInfo(NtChatDVO ntChatDVO) {
		return (int) delete(NAMESPACE + "deleteChatInfo", ntChatDVO);
	}
	
	/**
	 * @title	: [댓글] 리스트 데이터 조회
	 * @method	: commentList()
	 * @comment	: 댓글에서 데이터를 리스트 형태로 조회한다.	 
	 * @param	: NtChatDVO
	 */
	public List<NtCommentDVO> commentList(NtChatDVO ntChatDVO){
		return (List<NtCommentDVO>) selectList(NAMESPACE + "commentList", ntChatDVO);
	}
	
	/**
	 * @title	: [댓글] 등록
	 * @method	: commentRegist()
	 * @comment	: 입력된 정보로 댓글을 등록한다.		 
	 * @param	: NtCommentDVO
	 */
	public int commentRegist(NtCommentDVO ntCommentDVO) {
		return (int) insert(NAMESPACE + "commentRegist", ntCommentDVO);
	}
	
	/**
	 * @title	: [댓글] 삭제
	 * @method	: commentDelete() 
	 * @comment	: 댓글을 삭제한다.		 
	 * @param	: NtCommentDVO
	 */
	public int commentDelete(NtCommentDVO ntCommentDVO) {
		return (int) delete(NAMESPACE + "commentDelete", ntCommentDVO);
	}
}
