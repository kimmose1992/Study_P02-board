package com.gdgs.slyouth.nm.service.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.gdgs.slyouth.cm.service.dao.AbstractDAO;
import com.gdgs.slyouth.nm.vo.NmBookDVO;

/**
 * @title  : [새가족] 새가족교재 DAO 클래스
 * @author : 김예림
 * @create : 2021.07.18
 * @update : 2021.07.22
 */

@Component
@Repository("nmBookDAO")
@SuppressWarnings("unchecked")
public class NmBookDAO extends AbstractDAO {

	private static final String NAMESPACE = "nm.bookList.";

	/**
	 * @title	: 새가족교재 목록 조회
	 * @method	: nmbookList()
	 * @comment	: 새가족교재 목록을 조회한다.
	 * @param	: NmBookDVO
	 */
	public List<NmBookDVO> nmBookList(NmBookDVO nmBookDVO) {
		return (List<NmBookDVO>) selectList(NAMESPACE + "nmBookList", nmBookDVO);
	}

	/**
	 * @title	: 새가족교재 리스트 조회 수 증가
	 * @method	: nmBookCnt()
	 * @comment	: 게시물 상세 조회 할 때 마다 조회 수 증가
	 * @param	: NmBookDVO
	 */
	public void nmBookCnt(NmBookDVO nmBookDVO) throws Exception{
		update(NAMESPACE+"nmBookCnt", nmBookDVO);
	}
	
	/**
	 * @title	: 새가족교재 목록 건수 조회
	 * @method	: selectBookTotalCnt()
	 * @comment	: 새가족교재 화면에서 입력된 정보로 조회된 데이터 건수를 리턴한다.
	 * @param	: NmBookDVO
	 */
	public int selectBookTotalCnt(NmBookDVO nmBookDVO) {
		return (int)select(NAMESPACE + "selectBookTotalCnt", nmBookDVO);
	}
	
	/**
	 * @title	: 새가족교재 목록 상세 조회
	 * @method	: nmNoticeDetail()
	 * @comment	: 상세조회 화면
	 * @param	: NmBookDVO
	 */
	public NmBookDVO nmBookDetail(NmBookDVO nmBookDVO) {
		return (NmBookDVO) select(NAMESPACE + "nmBookDetail", nmBookDVO);
	}
	
	/**
	 * @title	: 새가족교재 등록
	 * @method	: insertBook()
	 * @comment	: 교재 게시물 등록
	 * @param	: NmBookDVO
	 */
	public int insertBook(NmBookDVO nmBookDVO) {
		return (int) insert(NAMESPACE + "nmBookInsert", nmBookDVO);
	}
	
	/**
	 * @title	: 새가족교재 수정
	 * @method	: updateBook()
	 * @comment	: 교재 게시물 수정
	 * @param	: NmBookDVO
	 */
	public int updateBook(NmBookDVO nmBookDVO) {
		return (int) update(NAMESPACE + "nmBookUpdate", nmBookDVO);
	}
	
	/**
	 * @title	: 새가족 교재 삭제
	 * @method	: deleteBook()
	 * @comment	: 공지사항을 삭제합니다.
	 * @param	: NmBookDVO
	 */
	public int deleteBook(NmBookDVO nmBookDVO) {
		return (int) delete(NAMESPACE+"nmBookDelete", nmBookDVO);
	}
}
