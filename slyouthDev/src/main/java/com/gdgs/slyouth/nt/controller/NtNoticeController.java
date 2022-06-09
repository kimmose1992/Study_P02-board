package com.gdgs.slyouth.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gdgs.slyouth.nt.service.NtNoticeService;
import com.gdgs.slyouth.nt.vo.NtNoticeDVO;
import com.gdgs.slyouth.nt.vo.NtNoticeSVO;

/**
 * @title  : [커뮤니티] 공지사항 Controller 클래스
 * @author : 신지현
 * @create : 2021.07.01
 */
@RestController
@RequestMapping("/nt/")
public class NtNoticeController {

	@Autowired
	private NtNoticeService ntNoticeService;

	/**
	 * @title : 공지사항 조회 화면
	 * @method : noticeList()
	 * @comment : 공지사항 등록에서 입력된 정보를 공지사항 리스트로 조회합니다.
	 * @param : NtNoticeDVO
	 */
	@RequestMapping("noticeList")
	public ModelAndView noticeList(NtNoticeDVO ntNoticeDVO) throws Exception {
		ModelAndView mav = new ModelAndView();

		// 공지사항 조회
		NtNoticeSVO returnSVO = ntNoticeService.noticeList(ntNoticeDVO);

		mav.addObject("returnSVO", returnSVO);
		mav.setViewName("slyouth/nt/VWNT0001");
		return mav;
	}

	/**
	 * @title : 공지사항 상세조회 화면
	 * @method : noticeDetail()
	 * @comment : 공지사항 상세조회 화면 입니다.
	 * @param : NtNoticeDVO
	 */
	@RequestMapping("noticeDetail")
	public ModelAndView noticeDetail(NtNoticeDVO ntNoticeDVO) throws Exception {
		ModelAndView mav = new ModelAndView();

		// 공지사항 조회
		NtNoticeSVO returnSVO = ntNoticeService.noticeDetail(ntNoticeDVO);

		mav.addObject("returnSVO", returnSVO);
		mav.setViewName("slyouth/nt/VWNT0002");
		return mav;
	}

	/**
	 * @title : 공지사항 등록&수정 화면
	 * @method : noticeEdit()
	 * @comment : 공지사항 등록 및 수정 화면 입니다.
	 * @param : NtNoticeDVO
	 */
	@RequestMapping("noticeEdit")
	public ModelAndView noticetEdit(NtNoticeDVO ntNoticeDVO) throws Exception {
		ModelAndView mav = new ModelAndView();

		NtNoticeSVO returnSVO = ntNoticeService.noticeDetail(ntNoticeDVO);
		
		mav.addObject("returnSVO", returnSVO);
		mav.setViewName("slyouth/nt/VWNT0003");
		return mav;
	}

	/**
	 * @title : 공지사항 등록&수정
	 * @method : noticeSave()
	 * @comment : 공지사항 글을 등록&수정합니다.
	 * @param : NtNoticeDVO
	 */
	@PostMapping("noticeSave")
	public int noticeSave(NtNoticeDVO ntNoticeDVO) throws Exception {
		
		return ntNoticeService.noticeSave(ntNoticeDVO);
	}
		 
	/**
	 * @title : 공지사항 삭제
	 * @method : removeNotice()
	 * @comment : 공지사항 글을 삭제합니다.
	 * @param : NtNoticeDVO
	 */
	@PostMapping("removeNotice")
	public int removeNotice(NtNoticeDVO ntNoticeDVO) throws Exception {
		int resultNum = ntNoticeService.removeNotice(ntNoticeDVO);

		return resultNum;
	}
}
