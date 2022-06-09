package com.gdgs.slyouth.ws.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gdgs.slyouth.cm.utils.CmConvKeyUtils;
import com.gdgs.slyouth.cm.vo.CmFileDVO;
import com.gdgs.slyouth.ws.service.WsBulletinService;
import com.gdgs.slyouth.ws.vo.WsBulletinDVO;
import com.gdgs.slyouth.ws.vo.WsBulletinSVO;
	
/**
 * @title   : [예배와 찬양] 주보 Controller 클래스    
 * @author  : gypig
 * @create  : 2021.06.16
 */
@RestController
@RequestMapping("/ws/")
public class WsBulletinController {
	
	@Autowired
	private WsBulletinService wsBulletinService;
	
	/**
	 * @title	: 주보(조회메인) 
	 * @method	: bulletinList()
	 * @comment	: 주보 게시판 및 게시물을 조회합니다.		 
	 * @param	: WsBulletinDVO
	 */
	@RequestMapping("bulletinList")
	public ModelAndView bulletinList(WsBulletinDVO wsBulletinDVO, HttpServletRequest request) throws Exception {
		WsBulletinSVO returnSVO = new WsBulletinSVO();
		
		// 주보 테이블키
		wsBulletinDVO.setSlyouthTbKey(new CmConvKeyUtils().getTbKey(request.getRequestURI()));
		// 주보 조회
		returnSVO = wsBulletinService.bulletinList(wsBulletinDVO);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("returnSVO" , returnSVO);
		mav.setViewName("slyouth/ws/VWWS0006");
		
		return mav;
	}
	
	/**
	 * @title	: 주보(등록&수정) 
	 * @method	: bulletinEdit()
	 * @comment	: 주보를 등록&수정하는 화면으로 이동합니다.		 
	 * @param	: WsBulletinDVO
	 */
	@RequestMapping("bulletinEdit")
	public ModelAndView bulletinEdit(WsBulletinDVO wsBulletinDVO, HttpServletRequest request) throws Exception {
		
		// 주보 상세조회
		WsBulletinSVO returnSVO = new WsBulletinSVO();
		
		// 조회구분코드(U: update)
		String selDivCd = wsBulletinDVO.getSelDivCd();
		// 주보 테이블키
		wsBulletinDVO.setSlyouthTbKey(new CmConvKeyUtils().getTbKey(request.getRequestURI()));
		
		if(selDivCd != null && selDivCd.equals("U")) {
			returnSVO = wsBulletinService.bulletinDetail(wsBulletinDVO);
		}else {
			returnSVO.setWsBulletinDVO(wsBulletinDVO);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("returnSVO", returnSVO);
		mav.setViewName("slyouth/ws/VWWS0008");
		return mav;
	}
	
	/**
	 * @title	: 주보(저장)
	 * @method	: bulletinSave()
	 * @comment	: 주보 정보를 저장합니다.	 
	 * @param	: WsBulletinDVO
	 */
	@PostMapping("bulletinSave")
	public WsBulletinDVO bulletinSave(WsBulletinDVO wsBulletinDVO, CmFileDVO cmFileDVO) throws Exception{
		WsBulletinSVO paramSVO = new WsBulletinSVO();
		
		paramSVO.setWsBulletinDVO(wsBulletinDVO);
		paramSVO.setCmFileDVO(cmFileDVO);
		return wsBulletinService.bulletinSave(paramSVO);
	}

	/**
	 * @title	: 주보(상세조회) 
	 * @method	: bulletinDetail()
	 * @comment	: 주보를 상세조회 할 수 있습니다.		 
	 * @param	: WsBulletinDVO
	 */
	@PostMapping("bulletinDetail")
	public ModelAndView bulletinDetail(WsBulletinDVO wsBulletinDVO, HttpServletRequest request) throws Exception {
		
		// 주보 테이블키
		wsBulletinDVO.setSlyouthTbKey(new CmConvKeyUtils().getTbKey(request.getRequestURI()));
		// 주보 상세조회
		WsBulletinSVO returnSVO = wsBulletinService.bulletinDetail(wsBulletinDVO);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("returnSVO", returnSVO);
		mav.setViewName("slyouth/ws/VWWS0007");
		
		return mav;
	}
	
	/**
	 * @title	: 주보(삭제) 
	 * @method	: bulletinDelete()
	 * @comment	: 교역자와 임원에 한에서 주보를 삭제할 수 있습니다.		 
	 * @param	: WsBulletinDVO
	 */
	@PostMapping("bulletinDelete")
	public WsBulletinDVO bulletinDelete(WsBulletinDVO wsBulletinDVO) throws Exception {
		return wsBulletinService.bulletinDelete(wsBulletinDVO);
	}
}
