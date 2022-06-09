package com.gdgs.slyouth.nf.service.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.gdgs.slyouth.cm.service.dao.AbstractDAO;
import com.gdgs.slyouth.nf.vo.NfPgmDVO;

/**
 * @title  : [양육과훈련] 프로그램 DAO 클래스
 * @author : 김모세
 * @create : 2021.08.02
 */
@Component
@Repository("nfPgmDAO")
public class NfPgmDAO extends AbstractDAO {
	
	private static final String NAMESPACE = "nf.pgm.";
	
	/**
	 * @title   : 프로그램 목록 조회
	 * @method  : selectPgmList
	 * @comment : 프로그램 목록 정보를 조회한다.
	 * @param   : NfPgmDVO
	 */
	public List<NfPgmDVO> selectPgmList(NfPgmDVO nfPgmDVO) {
		
		return (List<NfPgmDVO>) selectList(NAMESPACE + "selectPgmList", nfPgmDVO);
	}
	
	/**
	 * @title   : 프로그램 목록 갯수조회
	 * @method  : selectPgmListTotalCnt
	 * @comment : 프로그램 목록 정보 전체갯수를 조회한다.
	 * @param   : NfPgmDVO
	 */
	public int selectPgmListTotalCnt(NfPgmDVO nfPgmDVO) {
		
		return (int) select(NAMESPACE + "selectPgmListTotalCnt", nfPgmDVO);
	}
	
	/**
	 * @title   : 프로그램 목록 상세조회
	 * @method  : selectPgmDetail
	 * @comment : 프로그램 목록 상세정보를 조회한다.
	 * @param   : NfPgmDVO
	 */
	public NfPgmDVO selectPgmDetail(NfPgmDVO nfPgmDVO) {
		
		return (NfPgmDVO) select(NAMESPACE + "selectPgmDetail", nfPgmDVO);
	}
	
	/**
	 * @title   : 프로그램 상세 파일갯수조회
	 * @method  : selectPgmFileTotalCnt
	 * @comment : 프로그램 상세 파일갯수를 조회한다
	 * @param   : NfPgmDVO
	 */
	public int selectPgmFileTotalCnt(NfPgmDVO nfPgmDVO) {
		
		return (int) select(NAMESPACE + "selectPgmFileTotalCnt", nfPgmDVO);
	}
	
	/**
	 * @title   : 프로그램 상세 파일조회
	 * @method  : selectPgmFile
	 * @comment : 프로그램 상세 파일을 조회한다
	 * @param   : NfPgmDVO
	 */
	public NfPgmDVO selectPgmFile(NfPgmDVO nfPgmDVO) {
		
		return (NfPgmDVO) select(NAMESPACE + "selectPgmFile", nfPgmDVO);
	}
	
	/**
	 * @title   : 프로그램 공지사항 갯수조회
	 * @method  : selectPgmCmntyListTotalCnt
	 * @comment : 프로그램 공지사항 게시물 갯수를 조회한다
	 * @param   : NfPgmDVO
	 */
	public int selectPgmCmntyListTotalCnt(NfPgmDVO nfPgmDVO) {
		
		return (int) select(NAMESPACE + "selectPgmCmntyListTotalCnt", nfPgmDVO);
	}
	
	/**
	 * @title   : 프로그램 공지사항 게시판 조회
	 * @method  : selectPgmCmntyList
	 * @comment : 프로그램 공지사항 게시물을 조회한다
	 * @param   : NfPgmDVO
	 */
	public List<NfPgmDVO> selectPgmCmntyList(NfPgmDVO nfPgmDVO) {
		
		return (List<NfPgmDVO>) selectList(NAMESPACE + "selectPgmCmntyList", nfPgmDVO);
	}
	
	/**
	 * @title   : 프로그램 활동게시판 갯수조회
	 * @method  : selectPgmActCmntyListTotalCnt
	 * @comment : 프로그램 공지사항 게시물 갯수를 조회한다
	 * @param   : NfPgmDVO
	 */
	public int selectPgmActCmntyListTotalCnt(NfPgmDVO nfPgmDVO) {
		
		return (int) select(NAMESPACE + "selectPgmActCmntyListTotalCnt", nfPgmDVO);
	}
	
	/**
	 * @title   : 프로그램 활동게시판 조회
	 * @method  : selectPgmActCmntyList
	 * @comment : 프로그램 공지사항 게시물을 조회한다
	 * @param   : NfPgmDVO
	 */
	public List<NfPgmDVO> selectPgmActCmntyList(NfPgmDVO nfPgmDVO) {
		
		return (List<NfPgmDVO>) selectList(NAMESPACE + "selectPgmActCmntyList", nfPgmDVO);
	}
	
	/**
	 * @title   : 프로그램 등록
	 * @method  : insertProgram
	 * @comment : 프로그램을 DB에 등록합니다
	 * @param   : NfPgmDVO
	 */
	public int insertProgram(NfPgmDVO nfPgmDVO) {
		
		return (int) insert(NAMESPACE + "insertProgram", nfPgmDVO);
	}

	/**
	 * @title   : 프로그램 공지사항 게시판 등록
	 * @method  : insertPgmCmntyMng
	 * @comment : 게시판 관리 테이블에 새로운 프로그램 공지사항 게시판을 추가합니다.
	 * @param   : NfPgmDVO
	 */
	public int insertPgmCmntyMng(NfPgmDVO nfPgmDVO) {
		
		return (int) insert(NAMESPACE + "insertPgmCmntyMng", nfPgmDVO);
	}

	/**
	 * @title   : 프로그램 대표사진 수정
	 * @method  : updateProgramThumbNo
	 * @comment : 프로그램 대표사진 번호 수정
	 * @param   : NfPgmDVO
	 */
	public int updateProgramThumbNo(NfPgmDVO nfPgmDVO) {
		
		return (int) update(NAMESPACE + "updateProgramThumbNo", nfPgmDVO);
	}

	/**
	 * @title   : 프로그램 수정
	 * @method  : updateProgram
	 * @comment : 프로그램 정보를 수정합니다.
	 * @param   : NfPgmDVO
	 */
	public int updateProgram(NfPgmDVO nfPgmDVO) {
		
		return (int) update(NAMESPACE + "updateProgram", nfPgmDVO);
	}
	
	/**
	 * @title   : 프로그램 게시판 상세 조회
	 * @method  : selectProgramBoard
	 * @comment : 프로그램 게시물 정보를 조회한다
	 * @param   : NfPgmDVO
	 */
	public NfPgmDVO selectProgramBoard(NfPgmDVO nfPgmDVO) {
		
		return (NfPgmDVO) select(NAMESPACE + "selectProgramBoard", nfPgmDVO);
	}
	
	/**
	 * @title   : 프로그램 게시판 첨부파일 갯수 조회     
	 * @method  : selectPgmBoardFileTotalCnt
	 * @comment : 프로그램 게시판에 첨부된 파일의 갯수를 조회합니다.
	 * @param   : NfPgmDVO
	 */
	public int selectPgmBoardFileTotalCnt(NfPgmDVO nfPgmDVO) {
		
		return (int) select(NAMESPACE + "selectPgmBoardFileTotalCnt", nfPgmDVO);
	}
	
	/**
	 * @title   : 프로그램 게시판 첨부파일 조회    
	 * @method  : selectPgmBoardFile    
	 * @comment : 게시판 상세에 첨부된 파일을 조회합니다.       
	 * @param   : NfPgmDVO
	 */
	public NfPgmDVO selectPgmBoardFile(NfPgmDVO nfPgmDVO) {
		
		return (NfPgmDVO) select(NAMESPACE + "selectPgmBoardFile", nfPgmDVO);
	}

	/**
	 * @title   : 프로그램 게시판 저장      
	 * @method  : insertProgramCmnty
	 * @comment : 프로그램 게시물 정보를 저장합니다.       
	 * @param   : NfPgmDVO
	 */
	public int insertProgramCmnty(NfPgmDVO nfPgmCmnty) {
		
		return (int) insert(NAMESPACE + "insertProgramCmnty", nfPgmCmnty);
	}
	
	/**
	 * @title   : 프로그램 게시판 수정      
	 * @method  : updateProgramCmnty
	 * @comment : 프로그램 게시물 수정된 정보를 저장합니다.       
	 * @param   : NfPgmDVO
	 */
	public int updateProgramCmnty(NfPgmDVO nfPgmCmnty) {
		
		return (int) update(NAMESPACE + "updateProgramCmnty", nfPgmCmnty);
	}

	/**
	 * @title   : 프로그램 게시판 삭제      
	 * @method  : deleteProgramCmnty
	 * @comment : 프로그램 게시물 정보를 삭제합니다.       
	 * @param   : NfPgmDVO
	 */
	public int deleteProgramCmnty(NfPgmDVO nfPgmCmnty) {
		
		return (int) delete(NAMESPACE + "deleteProgramCmnty", nfPgmCmnty);
	}
	
	/**
	 * @title   : 프로그램 게시판 조회수 증가      
	 * @method  : updateBoardViewCnt
	 * @comment : 프로그램 게시물 조회수를 증가시킵니다.       
	 * @param   : NfPgmDVO
	 */
	public int updateBoardViewCnt(NfPgmDVO nfPgmCmnty) {
		
		return (int) update(NAMESPACE + "updateBoardViewCnt", nfPgmCmnty);
	}
	
	/**
	 * @title   : 프로그램 신청      
	 * @method  : insertProgramCmnty
	 * @comment : 프로그램 신청한 유저 정보를 저장합니다.       
	 * @param   : NfPgmDVO
	 */
	public int insertProgramAppMember(NfPgmDVO nfPgmDVO) {
		
		return (int) insert(NAMESPACE + "insertProgramAppMember", nfPgmDVO);
	}

	/**
	 * @title   : 프로그램 신청      
	 * @method  : deleteProgramAppMember
	 * @comment : 프로그램 신청한 유저 정보를 삭제합니다.       
	 * @param   : NfPgmDVO
	 */
	public int deleteProgramAppMember(NfPgmDVO nfPgmDVO) {
		
		return (int) delete(NAMESPACE + "deleteProgramAppMember", nfPgmDVO);
	}

	/**
	 * @title   : 프로그램 신청자 명단 조회    
	 * @method  : selectProgramAppMember
	 * @comment : 프로그램 신청한 유저 정보를 조회합니다.       
	 * @param   : NfPgmDVO
	 */
	public List<NfPgmDVO> selectProgramAppMember(NfPgmDVO nfPgmDVO) {
		
		return (List<NfPgmDVO>) selectList(NAMESPACE + "selectProgramAppMember", nfPgmDVO);
	}
}
