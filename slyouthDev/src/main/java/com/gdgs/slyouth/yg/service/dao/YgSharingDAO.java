package com.gdgs.slyouth.yg.service.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.gdgs.slyouth.cm.service.dao.AbstractDAO;
import com.gdgs.slyouth.yg.vo.YgSharingDVO;

/** 
 * @title    : [사랑방] 나눔자료공유게시판 DAO 클래스      
 * @author   : 김예림
 * @create   : 2021. 8. 29.
 */
@Component
@Repository("ygSharingDAO")
@SuppressWarnings("unchecked")
public class YgSharingDAO extends AbstractDAO{
	
	public static final String NAMESPACE ="yg.sharing.";
	
	/**
	 * @title 	: 자료 목록 조회
	 * @method 	: selectSharingList()
	 * @comment	: 나눔자료 게시글을 리스트 형태로 조회
	 * @param 	: YgSharingDAO
	 */
	public List<YgSharingDVO> selectSharingList(YgSharingDVO ygSharingDVO){
		return (List<YgSharingDVO>) selectList(NAMESPACE+"selectSharingList", ygSharingDVO);
	}
	
	/**
	 * @title 	: 자료 목록 건수 조회
	 * @method 	: selectSharingTotalCnt()
	 * @comment	: 나눔자료 게시글 데이터 건수 리턴
	 * @param 	: YgSharingDAO
	 */
	public int selectSharingTotalCnt(YgSharingDVO ygSharingDVO){
		return (int) select(NAMESPACE+"selectSharingTotalCnt", ygSharingDVO);
	}	
	
	/**
	 * @title 	: 자료 게시물 상세 조회
	 * @method 	: selectSharingInfo()
	 * @comment	: 나눔자료 게시글의 상세정보 리턴
	 * @param 	: YgSharingDAO
	 */
	public YgSharingDVO selectSharingInfo(YgSharingDVO ygSharingDVO){
		return (YgSharingDVO) select(NAMESPACE+"selectSharingInfo", ygSharingDVO);
	}
	
	/**
	 * @title 	: 자료 게시물 등록
	 * @method 	: insertSharingInfo()
	 * @comment	: 나눔자료게시판에서 입력된 정보로 게시글 등록
	 * @param 	: YgSharingDAO
	 */
	public int insertSharingInfo(YgSharingDVO ygSharingDVO){
		return (int) insert(NAMESPACE+"insertSharingInfo", ygSharingDVO);
	}
	
	/**
	 * @title 	: 자료 게시물 수정
	 * @method 	: updateSharingInfo()
	 * @comment	: 나눔자료게시판에서 입력된 정보로 게시글 수정
	 * @param 	: YgSharingDAO
	 */
	public int updateSharingInfo(YgSharingDVO ygSharingDVO){
		return (int) insert(NAMESPACE+"updateSharingInfo", ygSharingDVO);
	}
	
	/**
	 * @title 	: 자료 게시물 삭제
	 * @method 	: deleteSharingInfo()
	 * @comment	: 나눔자료 게시글 삭제
	 * @param 	: YgSharingDAO
	 */
	public int deleteSharingInfo(YgSharingDVO ygSharingDVO){
		return (int) delete(NAMESPACE+"deleteSharingInfo", ygSharingDVO);
	}
	
}
