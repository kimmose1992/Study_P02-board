package com.gdgs.slyouth.nm.service;

import com.gdgs.slyouth.nm.vo.NmBookDVO;
import com.gdgs.slyouth.nm.vo.NmBookSVO;

/**
 * @title  : [새가족] 새가족교재 Service 인터페이스
 * @author : 김예림
 * @create : 2021.07.18
 * @update : 2021.07.22
 */

public interface NmBookService {

	/**
	 * @title	: 새가족교재 목록
	 * @method	: bookList()
	 * @comment	: 새가족교재 목록을 조회한다.
	 * @param	: NmBookDVO
	 */
	public NmBookSVO bookList(NmBookDVO nmBookDVO)throws Exception;
	
	/**
	 * @title	: 새가족교재 상세조회 페이지
	 * @method	: bookDetail()
	 * @comment	: 새가족교재에서 선택한 게시글 화면 조회
	 * @param	: NmBookDVO
	 */
	public NmBookSVO bookDetail(NmBookDVO nmBookDVO)throws Exception;
	
	/**
	 * @title	: 새가족교재 등록 및 수정
	 * @method	: bookSave()
	 * @comment	: 새가족교재 게시글 등록 및 수정
	 * @param	: NmBookDVO
	 */
	public int bookSave(NmBookDVO nmBookDVO)throws Exception;
	
	/**
	 * @title : 새가족교재 삭제
	 * @method : deleteBook()
	 * @comment : 공지사항 글을 삭제합니다.
	 * @param : NmBookDVO
	 */
	public int deleteBook(NmBookDVO nmBookDVO) throws Exception;

}
