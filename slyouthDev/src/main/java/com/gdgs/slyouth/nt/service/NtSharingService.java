package com.gdgs.slyouth.nt.service;

import com.gdgs.slyouth.nt.vo.NtSharingDVO;
import com.gdgs.slyouth.nt.vo.NtSharingSVO;

/**
 * @title    : [커뮤니티] 나눔 Service 인터페이스     
 * @author   : 신지현
 * @create   : 2021.06.24
 */
public interface NtSharingService {

	/**
	 * @title : 나눔 조회 화면
	 * @method : sharingList()
	 * @comment : 나눔 등록에서 입력된 정보를 나눔 리스트로 조회합니다.
	 * @param : NtSharingDVO
	 */
	public NtSharingSVO sharingList(NtSharingDVO ntSharingDVO) throws Exception;
	
	/**
	 * @title : 나눔 조회 화면
	 * @method : sharingList()
	 * @comment : 나눔 리스트를 누르면 상세화면으로 이동합니다.
	 * @param : NtSharingDVO
	 */
	public NtSharingSVO sharingDetail(NtSharingDVO ntSharingDVO) throws Exception;
	
	/**
	 * @title : 나눔 등록 & 수정
	 * @method : sharingEdit()
	 * @comment : 나눔 글을 등록 및 수정합니다.
	 * @param : NtSharingDVO
	 */
	public NtSharingSVO sharingEdit(NtSharingDVO ntSharingDVO) throws Exception;
	
	/**
	 * @title : 나눔 등록 & 수정
	 * @method : sharingSave()
	 * @comment : 나눔 글을 등록 및 수정합니다.
	 * @param : NtSharingDVO
	 */
	public NtSharingDVO sharingSave(NtSharingDVO ntSharingDVO) throws Exception;
	
	/**
	 * @title : 나눔 삭제
	 * @method : removeSharing()
	 * @comment : 나눔 글을 삭제 합니다.
	 * @param : NtSharingDVO
	 */
	public NtSharingDVO removeSharing(NtSharingDVO ntSharingDVO) throws Exception;


	/**
	 * @title : 나눔 좋아요 증가
	 * @method : updateLikePuls
	 * @comment : 좋아요 버튼을 누르면 1증가합니다.
	 * @param : NtSharingDVO
	 */
	public int updateLikePuls(NtSharingDVO ntSharingDVO) throws Exception;
	
	/**
	 * @title : 나눔 좋아요 감소
	 * @method : updateLikeMinus
	 * @comment : 이미 좋아요한 버튼을 누르면 1감소합니다.
	 * @param : NtSharingDVO
	 */
	public int updateLikeMinus(NtSharingDVO ntSharingDVO) throws Exception;
}
