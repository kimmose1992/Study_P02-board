package com.gdgs.slyouth.yg.service;

import com.gdgs.slyouth.yg.vo.YgSharingDVO;
import com.gdgs.slyouth.yg.vo.YgSharingSVO;

/**
 * @title    : [사랑방] 나눔자료게시판 Service 인터페이스      
 * @author   : 김예림
 * @create   : 2021. 08. 26.
 */
public interface YgSharingService {
	
	/**
	 * @title	: 자료게시판 목록 조회
	 * @method	: sharingList
	 * @comment	: 자료게시판 목록 정보 조회
	 * @param	: YgSharingDVO
	 */
	public YgSharingSVO	sharingList(YgSharingDVO ygSharingDVO) throws Exception;

	/**
	 * @title	: 자료게시판 상세 조회
	 * @method	: sharingDetail
	 * @comment	: 자료게시판 게시글 상세 정보 조회
	 * @param	: YgSharingDVO
	 */
	public YgSharingSVO	sharingDetail(YgSharingDVO ygSharingDVO) throws Exception;

	/**
	 * @title	: 자료게시판 게시글 삭제
	 * @method	: sharingDelete
	 * @comment	: 자료게시판 게시글 삭제
	 * @param	: YgSharingDVO
	 */
	public YgSharingDVO	sharingDelete(YgSharingDVO ygSharingDVO) throws Exception;

	/**
	 * @title	: 자료게시판 게시글 등록/수정
	 * @method	: sharingEdit
	 * @comment	: 자료게시판 게시글 등록/수정에 필요한 정보 조회
	 * @param	: YgSharingDVO
	 */
	public YgSharingSVO	sharingEdit(YgSharingDVO ygSharingDVO) throws Exception;

	/**
	 * @title	: 자료게시판 게시글 등록/수정
	 * @method	: sharingSave
	 * @comment	: 자료게시판 게시글 등록/수정
	 * @param	: YgSharingDVO
	 */
	public YgSharingDVO	sharingSave(YgSharingDVO ygSharingDVO) throws Exception;

}
