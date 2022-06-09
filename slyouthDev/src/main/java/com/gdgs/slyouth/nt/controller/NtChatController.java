package com.gdgs.slyouth.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gdgs.slyouth.nt.service.NtChatService;
import com.gdgs.slyouth.nt.vo.NtChatDVO;
import com.gdgs.slyouth.nt.vo.NtChatSVO;
import com.gdgs.slyouth.nt.vo.NtCommentDVO;

/**
 * @title	: [커뮤니티] 자유게시판 Controller 클래스 
 * @author	: 김모세
 * @create	: 2021.08.16
 */
@RestController
@RequestMapping("/nt/")
public class NtChatController {
	
	@Autowired
	private NtChatService ntChatService;
	
	/**
	 * @title	: 자유게시판 목록 조회 
	 * @method	: chatList
	 * @comment	: 자유게시판 목록 조회 화면으로 이동한다.
	 * @param	: NtChatDVO
	 */
	@RequestMapping("chatList")
	public ModelAndView chatList(NtChatDVO ntChatDVO, ModelAndView mav) throws Exception {
		
		// 자유게시판 목록 조회
		NtChatSVO returnSVO = ntChatService.chatList(ntChatDVO);
		
		mav.addObject("returnSVO", returnSVO);
		mav.setViewName("slyouth/nt/VWNT0004");
		return mav;
	}
	
	/**
	 * @title	: 자유게시판 상세 조회
	 * @method	: chatDetail
	 * @comment	: 자유게시판 상세 조회 화면으로 이동한다. 
	 * @param	: NtChatDVO
	 */
	@PostMapping("chatDetail")
	public ModelAndView chatDetail(NtChatDVO ntChatDVO, ModelAndView mav) throws Exception {
		
		NtChatSVO returnSVO = ntChatService.chatDetail(ntChatDVO);
		
		mav.addObject("returnSVO", returnSVO);
		mav.setViewName("slyouth/nt/VWNT0005");
		return mav;
	}
	
	/**
	 * @title	: 자유게시판 등록/수정 화면
	 * @method	: chatEdit
	 * @comment	: 자유게시판 등록/수정하는 화면으로 이동한다.		 
	 * @param	: NtChatDVO
	 */
	@RequestMapping("chatEdit")
	public ModelAndView chatEdit(NtChatDVO ntChatDVO, ModelAndView mav) throws Exception {
		
		NtChatSVO returnSVO = ntChatService.chatEdit(ntChatDVO);
		
		mav.addObject("returnSVO", returnSVO);
		mav.setViewName("slyouth/nt/VWNT0006");
		return mav;
	}
	
	/**
	 * @title	: 자유게시판 저장 (등록/수정)
	 * @method	: chatSave
	 * @comment	: 자유게시판의 작성된 게시글을 저장한다. 	 
	 * @param	: NtChatDVO
	 */
	@PostMapping("chatSave")
	public NtChatDVO chatSave(NtChatDVO ntChatDVO) throws Exception {
		return ntChatService.chatSave(ntChatDVO);
	}
	
	/**
	 * @title	: 자유게시판 삭제
	 * @method	: chatDelete 
	 * @comment	: 자유게시판 게시글 삭제
	 * @param	: NtChatDVO
	 */
	@PostMapping("chatDelete")
	public NtChatDVO chatDelete(NtChatDVO ntChatDVO) throws Exception {
		return ntChatService.chatDelete(ntChatDVO);
	}
	
	/**
	 * @title	: [댓글] 등록&수정
	 * @method	: commentSave()
	 * @comment	: 댓글을 등록&수정한다.
	 * @param	: NtCommentDVO
	 */
	@PostMapping("commentSave")
	public NtCommentDVO commentSave(NtCommentDVO ntCommentDVO) throws Exception {
		return ntChatService.commentSave(ntCommentDVO);
	}
	
	/**
	 * @title	: [댓글] 삭제
	 * @method	: commentDelete() 
	 * @comment	: 댓글을 삭제한다. 		 
	 * @param	: NtCommentDVO
	 */
	@PostMapping("commentDelete")
	public NtCommentDVO chatDelete(NtCommentDVO ntCommentDVO) throws Exception {
		return ntChatService.chatDelete(ntCommentDVO);
	}
}
