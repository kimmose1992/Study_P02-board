package com.gdgs.slyouth.nt.service.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.gdgs.slyouth.cm.service.dao.AbstractDAO;
import com.gdgs.slyouth.nt.vo.NtCircleDVO;

/**
 * @title   : [커뮤니티] 동아리 DAO 클래스     
 * @author  : gypig
 * @create  : 2021.07.25
 * @update  : 2021.08.11
 */
@Component
@Repository
public class NtCircleDAO extends AbstractDAO{

	public static final String NAMESPACE = "nt.circle.";

	/**
	 * @title   : 동아리 목록조회
	 * @method  : circleList()
	 * @comment : 동아리 목록을 DB에서 조회합니다.
	 * @param   : NtCircleDVO
	 */
	public List<NtCircleDVO> circleList(NtCircleDVO ntCircleDVO) {
		
		return (List<NtCircleDVO>) selectList(NAMESPACE + "circleList", ntCircleDVO);
	}
	
	/**
	 * @title   : 동아리 목록 갯수조회
	 * @method  : selectCircleTotalCnt()
	 * @comment : 동아리 목록의 갯수를 DB에서 조회합니다.
	 * @param   : NtCircleDVO
	 */
	public int selectCircleTotalCnt(NtCircleDVO ntCircleDVO) {
		
		return (int) select(NAMESPACE + "selectCircleTotalCnt", ntCircleDVO);
	}

	/**
	 * @title   : 동아리 정보 단건 조회
	 * @method  : selectCircleInfo()
	 * @comment : 동아리 상세 내역을 DB에서 조회합니다.
	 * @param   : NtCircleDVO
	 */
	public NtCircleDVO selectCircleInfo(NtCircleDVO ntCircleDVO) {
		
		return (NtCircleDVO) select(NAMESPACE + "selectCircleInfo", ntCircleDVO);
	}

	/**
	 * @title   : 동아리 등록
	 * @method  : insertCircle()
	 * @comment : 동아리 정보를 등록 후 등록된 동아리번호를 가져옵니다.
	 * @param   : NtCircleDVO
	 */
	public int insertCircle(NtCircleDVO ntCircleDVO) {
		
		return (int) insert(NAMESPACE + "insertCircle", ntCircleDVO);
	}

	/**
	 * @title   : 동아리 수정
	 * @method  : updateCircle()
	 * @comment : 동아리 정보를 수정합니다.
	 * @param   : NtCircleDVO
	 */
	public int updateCircle(NtCircleDVO ntCircleDVO) {
		
		return (int) update(NAMESPACE + "updateCircle", ntCircleDVO);
	}
	
	/**
	 * @title   : 동아리 메인 이미지 번호 저장
	 * @method  : updateCircleThumbNo()
	 * @comment : 동아리 메인 이미지 정보를 수정합니다.
	 * @param   : NtCircleDVO
	 */
	public int updateCircleThumbNo(NtCircleDVO ntCircleDVO) {
		
		return (int) update(NAMESPACE + "updateCircleThumbNo", ntCircleDVO);
	}
	
	/**
	 * @title   : 동아리 첨부파일 갯수조회
	 * @method  : selectCircleFileTotalCnt()
	 * @comment : 동아리 첨부파일 갯수를 조회합니다.
	 * @param   : NtCircleDVO
	 */
	public int selectCircleFileTotalCnt(NtCircleDVO ntCircleDVO) {
		
		return (int) select(NAMESPACE + "selectCircleFileTotalCnt", ntCircleDVO);
	}
	
	/**
	 * @title   : 동아리 첨부파일 조회
	 * @method  : selectCircleFile()
	 * @comment : 동아리 첨부파일을 조회합니다.
	 * @param   : NtCircleDVO
	 */
	public NtCircleDVO selectCircleFile(NtCircleDVO ntCircleDVO) {
		
		return (NtCircleDVO) select(NAMESPACE + "selectCircleFile", ntCircleDVO);
	}
	
	/**
	 * @title   : 동아리 커뮤니티 관리 등록
	 * @method  : insertCircleCmntyMng()
	 * @comment : 동아리 커뮤니티를 DB의 관리테이블에 등록합니다.
	 * @param   : NtCircleDVO
	 */
	public int insertCircleCmntyMng(NtCircleDVO ntCircleDVO) {
		
		return (int) insert(NAMESPACE + "insertCircleCmntyMng", ntCircleDVO);
	}
	
	/**
	 * @title   : 동아리 게시판 목록 갯수
	 * @method  : selectCircleBoardListTotalCnt()
	 * @comment : 동아리 게시판의 목록 갯수를 DB에서 가져옵니다.
	 * @param   : NtCircleDVO
	 */
	public int selectCircleBoardListTotalCnt(NtCircleDVO ntCircleDVO) {
		
		return (int) select(NAMESPACE + "selectCircleBoardListTotalCnt", ntCircleDVO);
	}
	
	/**
	 * @title   : 동아리 게시판 목록
	 * @method  : selectCircleBoardList()
	 * @comment : 동아리 게시판의 목록을 DB에서 가져옵니다.
	 * @param   : NtCircleDVO
	 */
	public List<NtCircleDVO> selectCircleBoardList(NtCircleDVO ntCircleDVO) {
		
		return (List<NtCircleDVO>) selectList(NAMESPACE + "selectCircleBoardList", ntCircleDVO);
	}
	
	/**
	 * @title   : 동아리 게시판 상세 조회수 증가
	 * @method  : updateBoardViewCnt()
	 * @comment : 동아리 게시판 단건을 DB에서 가져옵니다.
	 * @param   : NtCircleDVO
	 */
	public int updateBoardViewCnt(NtCircleDVO ntCircleDVO) {
		
		return (int) update(NAMESPACE + "updateBoardViewCnt", ntCircleDVO);
	}
	
	/**
	 * @title   : 동아리 게시판 상세
	 * @method  : selectCircleBoard()
	 * @comment : 동아리 게시판 단건을 DB에서 가져옵니다.
	 * @param   : NtCircleDVO
	 */
	public NtCircleDVO selectCircleBoard(NtCircleDVO ntCircleDVO) {
		
		return (NtCircleDVO) select(NAMESPACE + "selectCircleBoard", ntCircleDVO);
	}
	
	/**
	 * @title   : 동아리 게시판 첨부파일 갯수 조회
	 * @method  : selectCircleBoardFileTotalCnt()
	 * @comment : 동아리 게시판 첨부파일 갯수를 DB에서 가져옵니다.
	 * @param   : NtCircleDVO
	 */
	public int selectCircleBoardFileTotalCnt(NtCircleDVO ntCircleDVO) {
		
		return (int) select(NAMESPACE + "selectCircleBoardFileTotalCnt", ntCircleDVO);
	}
	
	/**
	 * @title   : 동아리 게시판 첨부파일 조회
	 * @method  : selectCircleBoardFile()
	 * @comment : 동아리 게시판 첨부파일을 DB에서 가져옵니다.
	 * @param   : NtCircleDVO
	 */
	public NtCircleDVO selectCircleBoardFile(NtCircleDVO ntCircleDVO) {
		
		return (NtCircleDVO) select(NAMESPACE + "selectCircleBoardFile", ntCircleDVO);
	}
	
	/**
	 * @title   : 동아리 게시판 등록
	 * @method  : insertCircleBoard()
	 * @comment : 동아리 게시판 정보를 DB에 등록합니다.
	 * @param   : NtCircleDVO
	 */
	public int insertCircleBoard(NtCircleDVO ntCircleDVO) {
		
		return (int) insert(NAMESPACE + "insertCircleBoard", ntCircleDVO);
	}
	
	/**
	 * @title   : 동아리 게시판 수정
	 * @method  : updateCircleBoard()
	 * @comment : 동아리 게시판 정보를 DB에 수정합니다.
	 * @param   : NtCircleDVO
	 */
	public int updateCircleBoard(NtCircleDVO ntCircleDVO) {
		
		return (int) update(NAMESPACE + "updateCircleBoard", ntCircleDVO);
	}
	
	/**
	 * @title   : 동아리 게시판 삭제
	 * @method  : deleteCircleBoard()
	 * @comment : 동아리 게시판 정보를 DB에서 삭제합니다.
	 * @param   : NtCircleDVO
	 */
	public int deleteCircleBoard(NtCircleDVO ntCircleDVO) {
		
		return (int) delete(NAMESPACE + "deleteCircleBoard", ntCircleDVO);
	}
	
	/**
	 * @title   : 동아리 신청자등록
	 * @method  : insertCircleAppMember()
	 * @comment : 동아리 신청자를 등록합니다.
	 * @param   : NtCircleDVO
	 */
	public int insertCircleAppMember(NtCircleDVO ntCircleDVO) {
		
		return (int) insert(NAMESPACE + "insertCircleAppMember", ntCircleDVO);
	}
	
	/**
	 * @title   : 동아리 신청자 리스트 갯수
	 * @method  : selectCircleAppMemberListTotalCnt()
	 * @comment : 동아리 신청자를 등록합니다.
	 * @param   : NtCircleDVO
	 */
	public int selectCircleAppMemberListTotalCnt(NtCircleDVO ntCircleDVO) {
		
		return (int) select(NAMESPACE + "selectCircleAppMemberListTotalCnt", ntCircleDVO);
	}
	
	/**
	 * @title   : 동아리 신청자조회
	 * @method  : selectCircleAppMemberList()
	 * @comment : 동아리 신청자를 조회합니다.
	 * @param   : NtCircleDVO
	 */
	public List<NtCircleDVO> selectCircleAppMemberList(NtCircleDVO ntCircleDVO) {
		
		return (List<NtCircleDVO>) selectList(NAMESPACE + "selectCircleAppMemberList", ntCircleDVO);
	}

}
