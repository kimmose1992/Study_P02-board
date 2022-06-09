package com.gdgs.slyouth.nt.service;

import com.gdgs.slyouth.nt.vo.NtCounselDVO;
import com.gdgs.slyouth.nt.vo.NtCounselSVO;

/**
 * @title	: [커뮤니티] 상담 Service 인터페이스 
 * @author	: srar2
 * @create	: 2021. 6. 26.
 */
public interface NtCounselService {
	
	/**
	 * @title	: 상담 목록 조회
	 * @method	: counselList() 
	 * @comment	: 상담 화면에서 입력된 정보로 상담 목록을 조회한다.		 
	 * @param	: ntCounselDVO
	 */
	public NtCounselSVO counselList(NtCounselDVO ntCounselDVO) throws Exception;
	
	/**
	 * @title	: 상담 상세 조회
	 * @method	: counselDetail() 
	 * @comment	: 상담 목록에서 선택한 코드의 상세정보를 조회합니다. 		 
	 * @param	: NtCounselDVO
	 */
	public NtCounselSVO counselDetail(NtCounselDVO ntCounselDVO) throws Exception;
	
	/**
	 * @title	: 상담 등록&수정
	 * @method	: counselSave()
	 * @comment	: 상담 글, 답글을 등록&수정한다.
	 * @param	: NtCounselDVO
	 */
	public int[] counselSave(NtCounselDVO ntCounselDVO) throws Exception;
	
	/**
	 * @title	: 상담 삭제
	 * @method	: counselDelete()
	 * @comment	: 상담 상세조회 페이지에서 선택한 코드의 상세정보를 삭제한다.
	 * @param	: NtCounselDVO
	 */
	public int counselDelete(NtCounselDVO ntCounselDVO) throws Exception;
}
