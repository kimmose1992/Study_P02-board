package com.gdgs.slyouth.nt.service;

import com.gdgs.slyouth.nt.vo.NtNoticeDVO;
import com.gdgs.slyouth.nt.vo.NtNoticeSVO;

/**
 * @title : [커뮤니티] 공지사항 Service 인터페이스
 * @author : 신지현
 * @create : 2021.05.26
 */
public interface NtNoticeService {

	/**
	 * @title : 공지사항 조회 페이지
	 * @method : noticeList()
	 * @comment : 공지사항 등록에서 입력된 정보를 공지사항 리스트로 조회합니다.
	 * @param : N/A
	 */
	public NtNoticeSVO noticeList(NtNoticeDVO ntNoticeDVO) throws Exception;

	/**
	 * @title : 공지사항 상세조회 페이지
	 * @method : noticeDetail
	 * @comment : 공지사항 목록에서 선택한 게시글의 화면을 조회합니다.
	 * @param : NtNoticeDVO
	 */
	public NtNoticeSVO noticeDetail(NtNoticeDVO ntNoticeDVO) throws Exception;

	/**
	 * @title : 공지사항 등록&수정
	 * @method : noticeSave
	 * @comment : 공지사항 글을 등록 및 수정합니다.
	 * @param : NtNoticeDVO
	 */
	 public int noticeSave(NtNoticeDVO ntNoticeDVO) throws Exception; 
	 
	/**
	 * @title : 공지사항 삭제
	 * @method : removeNotice
	 * @comment : 공지사항 글을 삭제합니다.
	 * @param : NtNoticeDVO
	 */
	public int removeNotice(NtNoticeDVO ntNoticeDVO) throws Exception;

}
