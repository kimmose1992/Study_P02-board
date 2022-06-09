package com.gdgs.slyouth.nt.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gdgs.slyouth.nt.service.NtSharingService;
import com.gdgs.slyouth.nt.vo.NtSharingDVO;
import com.gdgs.slyouth.nt.vo.NtSharingSVO;

/**
 * @title    : [커뮤니티] 나눔 Controller     
 * @author   : 신지현	
 * @create   : 2021.06.24
 */
@RestController
@RequestMapping("/nt/")
public class NtSharingController {
	
	private static final Logger logger = LoggerFactory.getLogger(NtSharingController.class);
	
	@Autowired
	private NtSharingService ntSharingService;

	/**
	 * @title	: 나눔 조회 화면  
	 * @method	: sharingList()
	 * @comment	: 나눔 등록에서 입력된 정보를 나눔 리스트로 조회합니다.		 
	 * @param	: NtSharingDVO
	 */
	@RequestMapping("sharingList")
	public ModelAndView sharingList(NtSharingDVO ntSharingDVO) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		// 나눔 조회
		NtSharingSVO returnSVO = ntSharingService.sharingList(ntSharingDVO);
		
		mav.addObject("returnSVO",returnSVO);
		mav.setViewName("slyouth/nt/VWNT0010");
		return mav;
	}
	
	/**
	 * @title	: 나눔 상세조회 화면  
	 * @method	: sharingDetail()
	 * @comment	: 나눔 리스트를 누르면 상세조회 화면으로 이동합니다.		 
	 * @param	: NtSharingDVO
	 */
	@RequestMapping("sharingDetail")
	public ModelAndView sharingDetail(NtSharingDVO ntSharingDVO) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		// 나눔 상세조회
		NtSharingSVO returnSVO = ntSharingService.sharingDetail(ntSharingDVO);
		
		mav.addObject("returnSVO",returnSVO);
		mav.setViewName("slyouth/nt/VWNT0011");
		return mav;
	}
	
	/**
	 * @title	: 나눔 등록&수정 화면
	 * @method	: sharingEdit()
	 * @comment	: 나눔 글을 등록 및 수정하는 화면입니다.	 
	 * @param	: NtSharingDVO
	 */
	@RequestMapping("sharingEdit")
	public ModelAndView sharingEdit(NtSharingDVO ntSharingDVO) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		NtSharingSVO returnSVO = ntSharingService.sharingEdit(ntSharingDVO);
		
		mav.addObject("returnSVO",returnSVO);
		mav.setViewName("slyouth/nt/VWNT0012");
		return mav;
	}
	
	/**
	 * @title	: 나눔 등록&수정 
	 * @method	: sharingSave()
	 * @comment	: 나눔 글을 등록 및 수정합니다.	 
	 * @param	: NtSharingDVO
	 */
	@PostMapping("sharingSave")
	public NtSharingDVO sharingSave(NtSharingDVO ntSharingDVO) throws Exception {
		return ntSharingService.sharingSave(ntSharingDVO);
	}
	
	/**
	 * @title	: 나눔 삭제 
	 * @method	: removeSharing()
	 * @comment	: 나눔 글을 삭제 합니다.	 
	 * @param	: NtSharingDVO
	 */
	@PostMapping("removeSharing")
	public NtSharingDVO removeSharing(NtSharingDVO ntSharingDVO) throws Exception {
		
		return ntSharingService.removeSharing(ntSharingDVO);
		
	}
	

	/**
	 * @title	: 나눔 좋아요 증가 및 조회
	 * @method	: updateLikePuls()
	 * @comment	: 좋아요 버튼을 누르면 1증가합니다.	 
	 * @param	: NtSharingDVO
	 */
	@PostMapping("updateLikePuls")
	public int updateLikePuls(NtSharingDVO ntSharingDVO) throws Exception {
		int resultNum = ntSharingService.updateLikePuls(ntSharingDVO);
		
		return resultNum;
	}
	
	/**
	 * @title	: 나눔 좋아요 감소 및 조회
	 * @method	: updateLikeCnt()
	 * @comment	: 이미 좋아요한 버튼을 누르면 1감소합니다.
	 * @param	: NtSharingDVO
	 */
	@PostMapping("updateLikeMinus")
	public int updateLikeMinus(NtSharingDVO ntSharingDVO) throws Exception {
		int resultNum = ntSharingService.updateLikeMinus(ntSharingDVO);
		
		return resultNum;
	}
}
