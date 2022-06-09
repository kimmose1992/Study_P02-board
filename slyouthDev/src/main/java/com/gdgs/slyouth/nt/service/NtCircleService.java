package com.gdgs.slyouth.nt.service;

import java.util.List;

import com.gdgs.slyouth.nt.vo.NtCircleDVO;
import com.gdgs.slyouth.nt.vo.NtCircleSVO;
import com.gdgs.slyouth.um.vo.UmMemberDVO;

/**
 * @title   : [커뮤니티] 동아리 Service 인터페이스     
 * @author  : 송근영
 * @create  : 2021.07.25
 * @update  : 2021.08.16
 */
public interface NtCircleService {

	/**
	 * @title   : 동아리 목록조회
	 * @method  : circleList()
	 * @comment : 동아리 목록을 가져옵니다.
	 * @param   : NtCircleDVO
	 */
	public NtCircleSVO circleList(NtCircleDVO ntCircleDVO) throws Exception;

	/**
	 * @title   : 동아리 상세조회
	 * @method  : circleDetail()
	 * @comment : 동아리 상세 조회 데이터를 가져옵니다.
	 * @param   : NtCircleDVO
	 */
	public NtCircleSVO circleDetail(NtCircleDVO ntCircleDVO) throws Exception;
	
	/**
	 * @title   : 동아리 등록수정
	 * @method  : circleEdit()
	 * @comment : 동아리 수정페이지 정보를 가져옵니다.
	 * @param   : NtCircleDVO
	 */
	public NtCircleSVO circleEdit(NtCircleDVO ntCircleDVO) throws Exception;
	
	/**
	 * @title   : 동아리 삭제
	 * @method  : circleDel()
	 * @comment : 동아리와 관련된 모든 정보를 삭제합니다.
	 * @param   : NtCircleSVO
	 */
	public int circleDel(NtCircleSVO paramSVO) throws Exception;

	/**
	 * @title   : 동아리 저장
	 * @method  : circleSave()
	 * @comment : 동아리 정보를 저장합니다.
	 * @param   : NtCircleSVO
	 */
	public NtCircleDVO circleSave(NtCircleSVO paramSVO) throws Exception;
	
	/**
	 * @title   : 동아리 게시판 상세
	 * @method  : circleBoardDetail()
	 * @comment : 동아리 게시판 상세정보를 조회합니다.
	 * @param   : NtCircleDVO
	 */
	public NtCircleSVO circleBoardDetail(NtCircleDVO ntCircleDVO) throws Exception;
	
	/**
	 * @title   : 동아리 게시판 작성
	 * @method  : circleBoardEdit()
	 * @comment : 동아리 게시판 작성 페이지정보를 조회합니다.
	 * @param   : NtCircleDVO
	 */
	public NtCircleSVO circleBoardEdit(NtCircleDVO ntCircleDVO) throws Exception;
	
	/**
	 * @title   : 동아리 게시판 저장
	 * @method  : circleBoardSave()
	 * @comment : 동아리 게시판 작성 내용을 저장합니다.
	 * @param   : NtCircleSVO
	 */
	public NtCircleDVO circleBoardSave(NtCircleSVO paramSVO) throws Exception;
	
	/**
	 * @title   : 동아리 게시판 삭제
	 * @method  : circleBoardDel()
	 * @comment : 동아리 게시판 상세 내용을 삭제합니다.
	 * @param   : NtCircleDVO
	 */
	public int circleBoardDel(NtCircleDVO ntCircleDVO) throws Exception;

	/**
	 * @title   : 동아리 신청가능 인원 조회
	 * @method  : selectChrMemberModal()
	 * @comment : 동아리 신청 가능한 인원을 조회합니다.
	 * @param   : N/A
	 */
	public List<UmMemberDVO> selectChrMemberModal() throws Exception;

	/**
	 * @title   : 동아리 신청가능 인원 조회
	 * @method  : memberModalSave()
	 * @comment : 동아리 신청 가능한 인원을 조회합니다.
	 * @param   : List<NtCircleDVO>
	 */
	public int memberModalSave(List<NtCircleDVO> appMember);
}
