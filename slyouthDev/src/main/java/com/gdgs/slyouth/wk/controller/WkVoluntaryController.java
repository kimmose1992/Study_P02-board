package com.gdgs.slyouth.wk.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gdgs.slyouth.wk.service.WkVoluntaryService;
import com.gdgs.slyouth.wk.vo.WkSVO;
import com.gdgs.slyouth.wk.vo.WkVoluntaryDVO;

/**
 * @title   : [업무] 봉사부서 관리 Controller 클래스    
 * @author  : gypig
 * @create  : 2021.06.29
 */
@RestController	
@RequestMapping("/wk/")
public class WkVoluntaryController {
	
	private static final Logger logger = LoggerFactory.getLogger(WkVoluntaryController.class);
	
	@Autowired
	private WkVoluntaryService wkVoluntaryService;

	/**
	 * @title	: 봉사부서관리페이지조회  
	 * @method	: volDeptList()
	 * @comment	: 봉사부서에 대한 모든 관리를 총괄하는 페이지로 이동합니다.	 
	 * @param	: N/A
	 */
	@RequestMapping("volDeptList")
	public ModelAndView volDeptList() throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("slyouth/wk/VWWK0001");
		return mav;
	}
	
	/**
	 * @title	: 봉사부서관리데이터조회  
	 * @method	: volDeptDataList()
	 * @comment	: 봉사부서에 대한 검색 및 조회 데이터를 가져옵니다.	 
	 * @param	: WkVoluntaryDVO
	 */
	@PostMapping("volDeptDataList")
	public WkSVO volDeptDataList(WkVoluntaryDVO wkVoluntaryDVO) throws Exception {
		
		return wkVoluntaryService.selectVolDeptList(wkVoluntaryDVO);
	}
	
	/**
	 * @title	: 봉사부서 등록/수정
	 * @method	: volDeptSave()
	 * @comment	: 봉사부서를 추가합니다	 
	 * @param	: WkVoluntaryDVO 
	 */
	@RequestMapping("volDeptSave")
	public WkVoluntaryDVO insertVolDept(WkVoluntaryDVO wkVoluntaryDVO) throws Exception {
		
		WkVoluntaryDVO returnDVO = wkVoluntaryService.volDeptSave(wkVoluntaryDVO);
		
		return returnDVO;
	}
}
