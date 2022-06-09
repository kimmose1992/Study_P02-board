package com.gdgs.slyouth.nt.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdgs.slyouth.cm.vo.CmPagingOutDVO;
import com.gdgs.slyouth.nt.service.NtChatService;
import com.gdgs.slyouth.nt.service.dao.NtChatDAO;
import com.gdgs.slyouth.nt.vo.NtChatDVO;
import com.gdgs.slyouth.nt.vo.NtChatSVO;
import com.gdgs.slyouth.nt.vo.NtCommentDVO;

/**
 * @title	: [커뮤니티] 자유게시판 Service 구현 클래스 
 * @author	: 김모세
 * @create	: 2021.08.16
 */
@Component
@Service("ntChatService")
public class NtChatServiceImpl implements NtChatService {
	
	private static final Logger logger = LoggerFactory.getLogger(NtChatServiceImpl.class);
	
	@Autowired
	private NtChatDAO ntChatDAO;
	
	/**
	 * @title	: 자유게시판 목록 조회
	 * @method	: chatList
	 * @comment	: 자유게시판 목록 정보를 조회한다.
	 * @param	: NtChatDVO
	 */
	@Override
	public NtChatSVO chatList(NtChatDVO ntChatDVO) throws Exception {
		NtChatSVO returnSVO = new NtChatSVO();
		
		List<NtChatDVO> ntChatList = null;
		CmPagingOutDVO cmPagingOutDVO = null;
		
		// 자유게시판 목록 전체 건수 조회
		int totalDataCnt = ntChatDAO.selectChatTotalDataCnt(ntChatDVO);
		
		if (totalDataCnt > 0) {
			
			// 자유게시판 목록 조회
			ntChatList = ntChatDAO.selectChatList(ntChatDVO);
			
			// 페이징 설정
			cmPagingOutDVO = new CmPagingOutDVO(ntChatDVO);
			cmPagingOutDVO.setTotalDataCnt(totalDataCnt);
		}
		
		returnSVO.setNtChatDVO(ntChatDVO);
		returnSVO.setNtChatDVOList(ntChatList);
		returnSVO.setCmPagingOutDVO(cmPagingOutDVO);
		return returnSVO;
	}
	
	/**
	 * @title	: 자유게시판 상세 조회
	 * @method	: chatDetail 
	 * @comment	: 자유게시판 게시물의 상세 정보를 조회한다.		 
	 * @param	: NtChatDVO
	 */
	@Override
	public NtChatSVO chatDetail(NtChatDVO ntChatDVO) throws Exception {
		NtChatSVO returnSVO = new NtChatSVO();
		
		// 자유게시판 상세 조회
		NtChatDVO chatInfo = ntChatDAO.selectChatInfo(ntChatDVO);
		
		// 페이지 번호 설정
		chatInfo.setPageNo(ntChatDVO.getPageNo());
		
//		// 댓글 리스트조회
//		List<NtCommentDVO> returnCommentDVOList = ntChatService.commentList(ntChatDVO);
//		
//		returnSVO.setNtCommentDVOList(returnCommentDVOList);
		
		returnSVO.setNtChatDVO(chatInfo);
		return returnSVO;
	}

	/**
	 * @title	: 자유게시판 등록/수정
	 * @method	: chatEdit 	  
	 * @comment	: 자유게시판 등록/수정에 필요한 정보를 조회한다.		 
	 * @param	: NtChatDVO
	 */
	@Override
	public NtChatSVO chatEdit(NtChatDVO ntChatDVO) throws Exception {
		NtChatSVO returnSVO = new NtChatSVO();
		NtChatDVO chatDetail = null;
		
		// 등록
		if ("I".equals(ntChatDVO.getEditDivCd())) {
			chatDetail = ntChatDVO;
		}
		// 수정
		else if ("U".equals(ntChatDVO.getEditDivCd())) {
			chatDetail = ntChatDAO.selectChatInfo(ntChatDVO);
		}
		
		chatDetail.setEditDivCd(ntChatDVO.getEditDivCd());
		returnSVO.setNtChatDVO(chatDetail);
		return returnSVO;
	}
	
	/**
	 * @title	: 자유게시판 저장 (등록/수정)
	 * @method	: chatSave
	 * @comment	: 자유게시판의 작성된 게시글을 저장한다. 	 
	 * @param	: NtChatDVO
	 */
	@Override
	@Transactional
	public NtChatDVO chatSave(NtChatDVO ntChatDVO) throws Exception {
		NtChatDVO returnDVO = new NtChatDVO();
		
		int resultCnt = 0;
		
		try {
			// 등록
			if ("I".equals(ntChatDVO.getEditDivCd())) {
				resultCnt = ntChatDAO.insertChatInfo(ntChatDVO);
			}
			// 수정
			else if ("U".equals(ntChatDVO.getEditDivCd())) {
				resultCnt = ntChatDAO.updateChatInfo(ntChatDVO);
			}
		} catch (Exception e) {
			logger.debug("#############################");
			logger.debug("## " + e.getMessage());
			logger.debug("#############################");
			
			throw new RuntimeException();
		}
		
		returnDVO.setResultCnt(resultCnt);
		return returnDVO;
	}
	
	/**
	 * @title	: 자유게시판 삭제
	 * @method	: chatDelete 
	 * @comment	: 자유게시판 게시글 삭제
	 * @param	: NtChatDVO
	 */
	@Override
	@Transactional
	public NtChatDVO chatDelete(NtChatDVO ntChatDVO) throws Exception {
		NtChatDVO returnDVO = new NtChatDVO();
		
		int resultCnt = 0;
		
		try {
			resultCnt = ntChatDAO.deleteChatInfo(ntChatDVO);
		} catch (Exception e) {
			logger.debug("#############################");
			logger.debug("## " + e.getMessage());
			logger.debug("#############################");
			
			throw new RuntimeException();
		}
		
		returnDVO.setResultCnt(resultCnt);
		return returnDVO;
	}
	
	/**
	 * @title	: [댓글] 리스트 데이터 조회
	 * @method	: commentList() 
	 * @comment	: 댓글을 리스트 형태로 조회할 수 있도록 데이터를 가져온다.		 
	 * @param	: NtChatDVO
	 */
	@Override
	public List<NtCommentDVO> commentList(NtChatDVO ntChatDVO) throws Exception {
		return ntChatDAO.commentList(ntChatDVO);
	}
	
	/**
	 * @title	: [댓글] 등록&수정
	 * @method	: commentSave() 
	 * @comment	: 댓글을 등록&수정한다.		 
	 * @param	: NtCommentDVO
	 */
	@Override
	@Transactional
	public NtCommentDVO commentSave(NtCommentDVO ntCommentDVO) throws Exception {
		NtCommentDVO returnDVO = new NtCommentDVO();
		
		int resultCnt = 0; 
		resultCnt = ntChatDAO.commentRegist(ntCommentDVO);
		
		returnDVO.setRefNo(ntCommentDVO.getRefNo());
		returnDVO.setResultCnt(resultCnt);
		return returnDVO;
	}
	
	/**
	 * @title	: [댓글] 삭제
	 * @method	: commentDelete() 
	 * @comment	: 댓글을 삭제한다.		 
	 * @param	: NtCommentDVO
	 */
	@Override
	@Transactional
	public NtCommentDVO chatDelete(NtCommentDVO ntCommentDVO) throws Exception {
		NtCommentDVO returnDVO = new NtCommentDVO();
		
		int resultCnt = 0;
		try {
			resultCnt = ntChatDAO.commentDelete(ntCommentDVO);
			
			returnDVO.setResultCnt(resultCnt);
			returnDVO.setRefNo(ntCommentDVO.getRefNo());
		}catch(Exception e) {
			logger.debug(e.getMessage());
		}
		
		return returnDVO;
	}
}
