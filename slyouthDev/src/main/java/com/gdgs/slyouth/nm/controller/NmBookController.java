package com.gdgs.slyouth.nm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gdgs.slyouth.nm.service.NmBookService;
import com.gdgs.slyouth.nm.vo.NmBookDVO;
import com.gdgs.slyouth.nm.vo.NmBookSVO;


/**
 * @title  : [새가족] 새가족교재 Controller 클래스
 * @author : 김예림
 * @create : 2021.07.18
 * @update : 2021.07.29
 */

@RestController
@RequestMapping("/nm/")
public class NmBookController {
	
	@Autowired
	private NmBookService nmBookService;
	
	/**
	 * @title	: 새가족교재 목록 조회 화면
	 * @method	: bookList
	 * @comment	: 새가족교재 목록을 조회한다.
	 * @param	: NmBookDVO
	 */
	@RequestMapping("bookList")
	public ModelAndView bookList(NmBookDVO nmBookDVO, ModelAndView mav) throws Exception {
		NmBookSVO returnSVO = nmBookService.bookList(nmBookDVO);
		
		mav.addObject("returnSVO", returnSVO);
		mav.setViewName("slyouth/nm/VWNM0003");
		
		return mav;
	}
	
	/**
	 * @title	: 새가족교재 상세조회 화면
	 * @method	: bookDetail()
	 * @comment	: 새가족교재 글 상세 조회
	 * @param	: NmBookDVO
	 */
	@RequestMapping("bookDetail")
	public ModelAndView bookDetail(NmBookDVO nmBookDVO, ModelAndView mav) throws Exception {
		
		NmBookSVO returnSVO = nmBookService.bookDetail(nmBookDVO);

		mav.addObject("returnSVO", returnSVO);
		mav.setViewName("slyouth/nm/VWNM0004");
		return mav;
	}
	
	/**
	 * @title	: 새가족교재 삭제
	 * @method	: deleteBook()
	 * @comment	: 새가족교재 글 삭제
	 * @param	: NmBookDVO
	 */
	@PostMapping("deleteBook")
	public int deleteBook(NmBookDVO nmBookDVO) throws Exception {
		int resultNum = nmBookService.deleteBook(nmBookDVO);
		return resultNum;
	}
	
		
	/**
	 * @title	: 새가족교재 등록&수정 화면 이동
	 * @method	: bookEdit()
	 * @comment	: 새가족교재 글 등록 및 수정 페이지로 이동
	 * @param	: NmBookDVO
	 */
	@RequestMapping("bookEdit")
	public ModelAndView bookEdit(NmBookDVO nmBookDVO, ModelAndView mav) throws Exception {
		NmBookSVO returnSVO = nmBookService.bookDetail(nmBookDVO);
		
		mav.addObject("returnSVO", returnSVO);
		mav.setViewName("slyouth/nm/VWNM0005");
		
		return mav;
	}
	
	/**
	 * @title	: 새가족교재 등록&수정
	 * @method	: bookSave()
	 * @comment	: 수정 및 등록한 게시글 저장
	 * @param	: NmBookDVO
	 */
	@PostMapping("bookSave")
	public int bookSave(NmBookDVO nmBookDVO) throws Exception {
		return nmBookService.bookSave(nmBookDVO);
	}
	
		
}
