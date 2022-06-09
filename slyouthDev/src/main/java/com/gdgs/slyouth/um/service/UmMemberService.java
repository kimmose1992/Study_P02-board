package com.gdgs.slyouth.um.service;

import java.util.List;

import com.gdgs.slyouth.um.vo.UmMemberDVO;
import com.gdgs.slyouth.um.vo.UmMemberSVO;

/**
 * @title   : 공동체관리 Service 클래스
 * @author  : 송근영
 * @create  : 2021.05.24
 * @update  : 2021.08.26
 */
public interface UmMemberService {
	
	/**
	 * @title	: 교인 검색 조회   
	 * @method	: memberList()	 
	 * @comment	: 교인을 조회한다
	 * @param	: UmMemberVO
	 */
	public UmMemberSVO memberList(UmMemberDVO umMemberDVO) throws Exception;
	
	/**
	 * @title	: 교인 검색 단건 조회   
	 * @method	: memberDetail()	 
	 * @comment	: 교인을 조회한다
	 * @param	: UmMemberVO
	 */
	public UmMemberSVO memberDetail(UmMemberDVO umMemberDVO) throws Exception;
	
	/**
	 * @title	: 교인 검색 단건 등록수정   
	 * @method	: memberEdit()	 
	 * @comment	: 교인을 조회한다
	 * @param	: UmMemberVO
	 */
	public UmMemberSVO memberEdit(UmMemberDVO umMemberDVO) throws Exception;
	
	/**
	 * @title	: 교인 추가/수정   
	 * @method	: memberSave()	 
	 * @comment	: 교적 Edit 페이지을 통해 교인을 등록/수정한다
	 * @param	: UmMemberSVO
	 */
	public UmMemberDVO memberSave(UmMemberSVO paramSVO) throws Exception;
	
	/**
	 * @title	: 교인 삭제
	 * @method	: deleteMember()	 
	 * @comment	: 교적등록을 통해 교인을 등록한다
	 * @param	: UmMemberVO
	 */
	public int deleteMember(UmMemberDVO umMbemberDVO) throws Exception;
	
	/**
	 * @title	: 모달 검색 조회   
	 * @method	: selectChrMemberModal()	 
	 * @comment	: 모달창에 띄울 교인을 조회한다
	 * @param	: UmMemberDVO
	 */
	public List<UmMemberDVO> selectChrMemberModal(UmMemberDVO umMemberDVO) throws Exception;
}
