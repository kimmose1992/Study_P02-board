package com.gdgs.slyouth.nf.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gdgs.slyouth.cm.utils.CmConvKeyUtils;
import com.gdgs.slyouth.cm.vo.CmFileDVO;
import com.gdgs.slyouth.nf.service.NfPgmService;
import com.gdgs.slyouth.nf.vo.NfPgmDVO;
import com.gdgs.slyouth.nf.vo.NfPgmSVO;
import com.gdgs.slyouth.nt.vo.NtCircleDVO;
import com.gdgs.slyouth.nt.vo.NtCircleSVO;
import com.gdgs.slyouth.um.vo.UmMemberDVO;

/**
 * @title  : [양육과훈련] 프로그램 Controller 클래스
 * @author : 김모세
 * @create : 2021.08.02
 */
@RestController
@RequestMapping("/nf/")
public class NfPgmController {
	
	@Autowired
	private NfPgmService nfPgmService;

	/**
	 * @title   : 프로그램 목록 조회
	 * @method  : pgmList
	 * @comment : 프로그램 목록 조회 페이지로 이동한다.
	 * @param   : NfPgmDVO
	 */
	@RequestMapping("pgmList")
	public ModelAndView pgmList(NfPgmDVO nfPgmDVO, HttpServletRequest request, ModelAndView mav) throws Exception {

		// 프로그램 기본정보 조회
		nfPgmDVO.setSlyouthTbKey(new CmConvKeyUtils().getTbKey(request.getRequestURI()));
		
		// 프로그램 목록 조회
		NfPgmSVO returnSVO = nfPgmService.pgmList(nfPgmDVO);
		
		mav.addObject("returnSVO", returnSVO);
		mav.setViewName("slyouth/nf/VWNF0003");
		return mav;
	}
	
	/**
	 * @title   : 프로그램 상세
	 * @method  : pgmDetail
	 * @comment : 프로그램 상세 페이지로 이동한다.
	 * @param   : NfPgmDVO
	 */
	@RequestMapping("pgmDetail")
	public ModelAndView pgmDetail(NfPgmDVO nfPgmDVO, ModelAndView mav) throws Exception {
		
		// 프로그램 상세 조회
		NfPgmSVO returnSVO = nfPgmService.pgmDetail(nfPgmDVO);
		
		mav.addObject("returnSVO", returnSVO);
		mav.setViewName("slyouth/nf/VWNF0004");
		return mav;
	}
	
	/**
	 * @title   : 프로그램 작성
	 * @method  : pgmEdit
	 * @comment : 프로그램 작성 페이지로 이동한다.
	 * @param   : NfPgmDVO
	 */
	@RequestMapping("pgmEdit")
	public ModelAndView pgmEdit(NfPgmDVO nfPgmDVO, ModelAndView mav) throws Exception {
		
		NfPgmSVO returnSVO = nfPgmService.pgmEdit(nfPgmDVO);
		
		mav.addObject("returnSVO", returnSVO);
		mav.setViewName("slyouth/nf/VWNF0005");
		return mav;
	}
	
	/**
	 * @title   : 프로그램 저장
	 * @method  : pgmSave
	 * @comment : 프로그램 정보를 저장합니다.
	 * @param   : NfPgmDVO
	 */
	@PostMapping("pgmSave")
	public NfPgmDVO pgmSave(NfPgmDVO nfPgmDVO, CmFileDVO cmFileDVO) throws Exception {
		
		NfPgmSVO paramSVO = new NfPgmSVO();
		paramSVO.setNfPgmDVO(nfPgmDVO);
		paramSVO.setCmFileDVO(cmFileDVO);
		
		return nfPgmService.pgmSave(paramSVO);
	}
	
	/**
	 * @title   : 프로그램 삭제
	 * @method  : pgmDel
	 * @comment : 프로그램 정보를 삭제합니다.
	 * @param   : NfPgmDVO
	 */
	@PostMapping("pgmDel")
	public NfPgmDVO pgmDel(NfPgmDVO nfPgmDVO) throws Exception {
		
		return null;
	}
	
	/**
	 * @title   : 프로그램 게시판 상세
	 * @method  : pgmBoardDetail
	 * @comment : 프로그램 게시판 상세페이지로 이동합니다.
	 * @param   : NfPgmDVO
	 */
	@RequestMapping("pgmBoardDetail")
	public ModelAndView pgmBoardDetail(NfPgmDVO nfPgmDVO, ModelAndView mav) throws Exception {
		
		NfPgmSVO returnSVO = nfPgmService.pgmBoardDetail(nfPgmDVO);
		
		mav.addObject("returnSVO", returnSVO);
		mav.setViewName("slyouth/nf/VWNF0006");
		return mav;
	}
	
	/**
	 * @title   : 프로그램 게시판 작성
	 * @method  : pgmBoardEdit
	 * @comment : 프로그램 게시판 작성 페이지로 이동한다.
	 * @param   : NfPgmDVO
	 */
	@RequestMapping("pgmBoardEdit")
	public ModelAndView pgmBoardEdit(NfPgmDVO nfPgmDVO, ModelAndView mav) throws Exception {
		
		NfPgmSVO returnSVO = nfPgmService.pgmBoardEdit(nfPgmDVO);
		
		mav.addObject("returnSVO", returnSVO);
		mav.setViewName("slyouth/nf/VWNF0007");
		return mav;
	}
	
	/**
	 * @title   : 프로그램 게시판 저장
	 * @method  : pgmBoardSave()
	 * @comment : 프로그램 게시판 정보를 저장합니다.
	 * @param   : NfPgmDVO
	 * @throws Exception 
	 */
	@PostMapping("pgmBoardSave")
	public NfPgmDVO pgmBoardSave(NfPgmDVO nfPgmDVO, CmFileDVO cmFileDVO) throws Exception {
		
		NfPgmSVO paramSVO = new NfPgmSVO();
		paramSVO.setNfPgmCmnty(nfPgmDVO);
		paramSVO.setCmFileDVO(cmFileDVO);
		
		return nfPgmService.pgmBoardSave(paramSVO);
	}
	
	/**
	 * @title   : 프로그램 게시판 삭제
	 * @method  : pgmBoardDel()
	 * @comment : 프로그램 게시판 정보를 삭제합니다.
	 * @param   : NfPgmDVO
	 * @throws Exception 
	 */
	@PostMapping("pgmBoardDel")
	public NfPgmDVO pgmBoardDel(NfPgmDVO nfPgmDVO, CmFileDVO cmFileDVO) throws Exception {
		
		NfPgmSVO paramSVO = new NfPgmSVO();
		paramSVO.setNfPgmCmnty(nfPgmDVO);
		paramSVO.setCmFileDVO(cmFileDVO);
		
		return nfPgmService.pgmBoardDel(paramSVO);
	}
	
	/**
	 * @title   : 프로그램 신청하기
	 * @method  : pgmApply()
	 * @comment : 프로그램을 신청합니다.
	 * @param   : NfPgmDVO
	 * @throws Exception 
	 */
	@PostMapping("pgmApply")
	public int pgmApply(NfPgmDVO nfPgmDVO) throws Exception {
		
		return nfPgmService.pgmApply(nfPgmDVO);
	}
	
	/**
	 * @title   : 프로그램 신청취소하기
	 * @method  : pgmApplyCancel()
	 * @comment : 프로그램을 신청취소합니다.
	 * @param   : NfPgmDVO
	 * @throws Exception 
	 */
	@PostMapping("pgmApplyCancel")
	public int pgmApplyCancel(NfPgmDVO nfPgmDVO) throws Exception {
		
		return nfPgmService.pgmApplyCancel(nfPgmDVO);
	}
	
	/**
	 * @title   : 신청자 인원 조회(모달)
	 * @method  : selectPgmAppMember()
	 * @comment : 동아리 참여 신청 가능인원을 조회합니다.
	 * @param   : NfPgmDVO
	 * @throws Exception 
	 */
	@PostMapping("selectPgmAppMember")
	public List<NfPgmDVO> selectPgmAppMember(NfPgmDVO nfPgmDVO) throws Exception{
		
		return nfPgmService.selectPgmAppMember(nfPgmDVO);
	}
}
