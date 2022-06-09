package com.gdgs.slyouth.nf.service;

import java.util.List;

import com.gdgs.slyouth.nf.vo.NfPgmDVO;
import com.gdgs.slyouth.nf.vo.NfPgmSVO;

/**
 * @title  : [양육과훈련] 프로그램 Service 인터페이스
 * @author : 송근영
 * @create : 2021.08.02
 */
public interface NfPgmService {

	/**
	 * @title   : 프로그램 목록 조회
	 * @method  : pgmList
	 * @comment : 프로그램 목록 정보를 조회한다.
	 * @param   : NfPgmDVO
	 */
	public NfPgmSVO pgmList(NfPgmDVO nfPgmDVO) throws Exception;
	
	/**
	 * @title   : 프로그램 상세
	 * @method  : pgmDetail
	 * @comment : 프로그램 상세정보를 조회한다.
	 * @param   : NfPgmDVO
	 */
	public NfPgmSVO pgmDetail(NfPgmDVO nfPgmDVO) throws Exception;

	/**
	 * @title   : 프로그램 작성     
	 * @method  : pgmEdit
	 * @comment : 프로그램 작성/수정 정보를 조회합니다.       
	 * @param   : NfPgmDVO
	 */
	public NfPgmSVO pgmEdit(NfPgmDVO nfPgmDVO) throws Exception;

	/**
	 * @title   : 프로그램 저장      
	 * @method  : pgmSave
	 * @comment : 프로그램 정보를 저장합니다       
	 * @param   : NfPgmSVO
	 */
	public NfPgmDVO pgmSave(NfPgmSVO paramSVO) throws Exception;

	/**
	 * @title   : 프로그램 게시판 상세      
	 * @method  : pgmBoardDetail    
	 * @comment : 게시판(활동게시판, 공지사항) 상세 정보를 조회합니다.       
	 * @param   : NfPgmDVO
	 * @throws Exception 
	 */
	public NfPgmSVO pgmBoardDetail(NfPgmDVO nfPgmDVO) throws Exception;

	/**
	 * @title   : 프로그램 게시판 작성     
	 * @method  : pgmBoardEdit    
	 * @comment : 프로그램 게시판 작성페이지 정보를 조회합니다.       
	 * @param   : NfPgmDVO
	 * @throws Exception 
	 */
	public NfPgmSVO pgmBoardEdit(NfPgmDVO nfPgmDVO) throws Exception;

	/**
	 * @title   : 프로그램 게시판 저장     
	 * @method  : pgmBoardSave    
	 * @comment : 프로그램 게시판 작성페이지 정보를 저장합니다.       
	 * @param   : NfPgmSVO
	 */
	public NfPgmDVO pgmBoardSave(NfPgmSVO paramSVO);

	/**
	 * @title   : 프로그램 게시판 삭제    
	 * @method  : pgmBoardDel    
	 * @comment : 프로그램 게시판 정보를 삭제합니다.       
	 * @param   : NfPgmSVO
	 */
	public NfPgmDVO pgmBoardDel(NfPgmSVO paramSVO);

	/**
	 * @title   : 프로그램 신청    
	 * @method  : pgmBoardDel    
	 * @comment : 프로그램 참가자 명단을 추가합니다.       
	 * @param   : NfPgmSVO
	 */
	public int pgmApply(NfPgmDVO nfPgmDVO);

	/**
	 * @title   : 프로그램 신청취소  
	 * @method  : pgmApplyCancel    
	 * @comment : 프로그램 참가자 명단에서 로그인한 유저를 삭제합니다.       
	 * @param   : NfPgmSVO
	 */
	public int pgmApplyCancel(NfPgmDVO nfPgmDVO);

	/**
	 * @title   : 프로그램 신청명단 조회  
	 * @method  : selectPgmAppMember    
	 * @comment : 프로그램 신청자 명단 정보를 조회합니다.       
	 * @param   : N/A
	 */
	public List<NfPgmDVO> selectPgmAppMember(NfPgmDVO nfPgmDVO);
}
