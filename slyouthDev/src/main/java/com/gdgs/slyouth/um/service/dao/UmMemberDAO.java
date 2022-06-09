package com.gdgs.slyouth.um.service.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.gdgs.slyouth.cm.service.dao.AbstractDAO;
import com.gdgs.slyouth.cm.vo.CmFileDVO;
import com.gdgs.slyouth.cm.vo.CmLoginDVO;
import com.gdgs.slyouth.um.vo.UmMemberDVO;

/**
 * @title   : 교적관리 DAO 클래스     
 * @author  : gypig
 * @create  : 2021.05.24
 * @update  : 2021.08.23
 */
@Component
@Repository("umMemberDAO")
public class UmMemberDAO extends AbstractDAO{
	
	private static final String NAMESPACE = "um.member.";
	
	/**
	 * @title	: 전체 인원 및 검색 인원
	 * @method	: memberList()	 
	 * @comment	: 데이터 베이스에서 기본 전체 인원 및 검색 인원을 DB에서 조회합니다
	 * @param	: UmMemberDVO
	 */
	public List<UmMemberDVO> memberList(UmMemberDVO umMemberDVO) {
		
		return (List<UmMemberDVO>) selectList(NAMESPACE + "memberList", umMemberDVO);
	}
	
	/**
	 * @title	: 교인 단건 정보 조회
	 * @method	: selectMember()	 
	 * @comment	: 데이터 베이스에서 단일 인물 정보를 조회합니다.
	 * @param	: UmMemberDVO
	 */
	public UmMemberDVO selectMember(UmMemberDVO umMemberDVO) {
		
		return (UmMemberDVO) select(NAMESPACE + "selectMember", umMemberDVO);
	}
	
	/**
	 * @title	: 교인 단건 사진 정보 조회
	 * @method	: selectMemberImage()	 
	 * @comment	: 데이터 베이스에서 단일 인물 사진 정보를 조회합니다
	 * @param	: UmMemberDVO
	 */
	public CmFileDVO selectMemberImage(UmMemberDVO umMemberDVO) {
		
		return (CmFileDVO) select(NAMESPACE + "selectMemberImage", umMemberDVO);
	}
	
	/**
	 * @title	: 교인등록
	 * @method	: insertMember()	 
	 * @comment	: 데이터 베이스에 교인정보를 등록합니다.
	 * @param	: UmMemberVO
	 */
	public int insertMember(UmMemberDVO umMemberDVO) {
		
		return (int) insert(NAMESPACE + "insertMember", umMemberDVO);
	}
	
	/**
	 * @title	: 교인수정
	 * @method	: updateMember()	 
	 * @comment	: 데이터 베이스에 교인정보를 수정합니다.
	 * @param	: UmMemberDVO
	 */
	public int updateMember(UmMemberDVO umMemberDVO) {
		
		return (int) update(NAMESPACE + "updateMember", umMemberDVO);
	}
	
	/**
	 * @title	: 교인삭제
	 * @method	: deleteMember()	 
	 * @comment	: 데이터 베이스에 교인정보를 삭제합니다.
	 * @param	: UmMemberDVO
	 */
	public int deleteMember(UmMemberDVO umMemberDVO) {
		
		return (int) delete(NAMESPACE + "deleteMember", umMemberDVO);
	}
	
	/**
	 * @title	: 교인갯수 구하기
	 * @method	: memberTotalCnt	 
	 * @comment	: 데이터 베이스에 교인정보를 삭제합니다.
	 * @param	: UmMemberDVO
	 */
	public int memberTotalCnt(UmMemberDVO umMemberDVO) {
		
		return (int) select(NAMESPACE + "memberTotalCnt", umMemberDVO);
	}
	
	/**
	 * @title    : 교적 ID 갱신     
	 * @method   : updateMemberId()
	 * @comment  : DB에 회원정보를 저장합니다.
	 * @param    : CmLoginDVO
	 */
	public int updateMemberId(CmLoginDVO cmLoginDVO) {
		
		return (int) update(NAMESPACE + "updateMemberId", cmLoginDVO);
	}
	
	/**
	 * @title	: 모달 검색 조회   
	 * @method	: selectChrMemberModal()	 
	 * @comment	: 모달창에 띄울 교인을 조회한다
	 * @param	: UmMemberDVO
	 */
	public List<UmMemberDVO> selectChrMemberModal(UmMemberDVO umMemberDVO) {
		
		return (List<UmMemberDVO>) selectList(NAMESPACE + "selectChrMemberModal", umMemberDVO);
	}
}
