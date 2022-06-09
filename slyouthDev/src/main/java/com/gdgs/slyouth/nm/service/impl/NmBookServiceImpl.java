package com.gdgs.slyouth.nm.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdgs.slyouth.cm.vo.CmPagingOutDVO;
import com.gdgs.slyouth.nm.service.NmBookService;
import com.gdgs.slyouth.nm.service.dao.NmBookDAO;
import com.gdgs.slyouth.nm.vo.NmBookDVO;
import com.gdgs.slyouth.nm.vo.NmBookSVO;


/**
 * @title  : [새가족] 새가족교재 Service 구현 클래스
 * @author : 김예림
 * @create : 2021.07.18
 * @update : 2021.07.29
 */

@Component
@Service("nmBookService")
public class NmBookServiceImpl implements NmBookService {

	@Autowired
	private NmBookDAO nmBookDAO;

	/**
	 * @title	: 새가족교재 목록
	 * @method	: bookList()
	 * @comment	: 새가족교재 목록을 조회한다.
	 * @param	: NmBookDVO
	 */
	@Override
	public NmBookSVO bookList(NmBookDVO nmBookDVO) throws Exception {
		
		NmBookSVO returnSVO = new NmBookSVO();
		
		List<NmBookDVO> nmBookList = null;
		
		int totalDataCnt = nmBookDAO.selectBookTotalCnt(nmBookDVO);
		
		if(totalDataCnt > 0) {

			nmBookList = nmBookDAO.nmBookList(nmBookDVO);
			
			CmPagingOutDVO cmPagingOutDVO = new CmPagingOutDVO(nmBookDVO);
			cmPagingOutDVO.setTotalDataCnt(totalDataCnt);
			returnSVO.setCmPagingOutDVO(cmPagingOutDVO);
		} 
		
		returnSVO.setNmBookDVO(nmBookDVO);
		returnSVO.setNmBookDVOList(nmBookList);
		
		return returnSVO;
	}

	/**
	 * @title	: 새가족교재 상세조회 페이지
	 * @method	: bookDetail()
	 * @comment	: 새가족교재에서 선택한 게시글 화면 조회
	 * @param	: NmBookDVO
	 */
	@Override
	@Transactional
	public NmBookSVO bookDetail(NmBookDVO nmBookDVO) throws Exception {
		NmBookSVO returnSVO = new NmBookSVO();
		NmBookDVO paramDVO = new NmBookDVO();
		
		nmBookDAO.nmBookCnt(nmBookDVO);

		if (!("I".equals(nmBookDVO.getEditDivCd()))) {
			// 공지사항 상세조회
			paramDVO = nmBookDAO.nmBookDetail(nmBookDVO); //화면에서 넘어온 친구
		}
		paramDVO.setEditDivCd(nmBookDVO.getEditDivCd());
		returnSVO.setNmBookDVO(paramDVO);
		return returnSVO;
	}


	/**
	 * @title : 새가족교재 삭제
	 * @method : deleteBook()
	 * @comment : 새가족교재 글 삭제
	 * @param : NmBookDVO
	 */
	@Override
	public int deleteBook(NmBookDVO nmBookDVO) throws Exception {
		int resultNum = nmBookDAO.deleteBook(nmBookDVO);
		return resultNum;
	}

	/**
	 * @title	: 새가족교재 등록 및 수정
	 * @method	: bookSave()
	 * @comment	: 새가족교재 게시글 등록 및 수정
	 * @param	: NmBookDVO
	 */
	@Override
	@Transactional
	public int bookSave(NmBookDVO nmBookDVO) throws Exception {
		int returnValue = 0;

		if ("I".equals(nmBookDVO.getEditDivCd())) {

			nmBookDVO.setFrsRegDt(LocalDateTime.now());
			returnValue = nmBookDAO.insertBook(nmBookDVO);
			
		} else if ("U".equals(nmBookDVO.getEditDivCd())) {
			returnValue = nmBookDAO.updateBook(nmBookDVO);
		}

		return returnValue;
	}
	
	
	

}


