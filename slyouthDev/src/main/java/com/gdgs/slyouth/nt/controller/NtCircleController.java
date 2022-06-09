package com.gdgs.slyouth.nt.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gdgs.slyouth.cm.utils.CmConvKeyUtils;
import com.gdgs.slyouth.cm.vo.CmFileDVO;
import com.gdgs.slyouth.nt.service.NtCircleService;
import com.gdgs.slyouth.nt.vo.NtCircleDVO;
import com.gdgs.slyouth.nt.vo.NtCircleSVO;
import com.gdgs.slyouth.um.vo.UmMemberDVO;

/**
 * @title   : [커뮤니티] 동아리 Controller 클래스     
 * @author  : 송근영
 * @create  : 2021.07.25
 * @update  : 2021.08.16
 */
@RestController
@RequestMapping("/nt/")
public class NtCircleController {

	@Autowired
	private NtCircleService ntCircleService;
	
	/**
	 * @title   : 동아리 목록조회
	 * @method  : circleList()
	 * @comment : 동아리 목록을 조회하는 페이지로 이동합니다.
	 * @param   : NtCircleDVO
	 * @throws Exception 
	 */
	@RequestMapping("circleList")
	public ModelAndView circleList(NtCircleDVO ntCircleDVO, ModelAndView mav, HttpServletRequest request) throws Exception {

		// 동아리 기본정보 조회
		ntCircleDVO.setSlyouthTbKey(new CmConvKeyUtils().getTbKey(request.getRequestURI()));
		
		// 동아리 목록 조회
		NtCircleSVO returnSVO = ntCircleService.circleList(ntCircleDVO);
		
		mav.setViewName("slyouth/nt/VWNT0015");
		mav.addObject("returnSVO", returnSVO);
		return mav;
	}
	
	/**
	 * @title   : 동아리 상세조회
	 * @method  : circleDetail()
	 * @comment : 동아리 상세 페이지로 이동합니다.
	 * @param   : NtCircleDVO
	 * @throws Exception 
	 */
	@RequestMapping("circleDetail")
	public ModelAndView circleDetail(NtCircleDVO ntCircleDVO, ModelAndView mav) throws Exception {	

		// 동아리 단건 조회
		NtCircleSVO returnSVO = ntCircleService.circleDetail(ntCircleDVO);
		
		mav.setViewName("slyouth/nt/VWNT0016");
		mav.addObject("returnSVO", returnSVO);
		return mav;
	}
	
	/**
	 * @title   : 동아리 등록/수정
	 * @method  : circleEdit()
	 * @comment : 동아리 등록/수정 페이지로 이동합니다.
	 * @param   : NtCircleDVO, HttpServletRequest
	 * @throws Exception 
	 */
	@RequestMapping("circleEdit")
	public ModelAndView circleEdit(NtCircleDVO ntCircleDVO, HttpServletRequest request) throws Exception {	
		
		ModelAndView mav = new ModelAndView();
		
		// 동아리 기본정보 조회
		ntCircleDVO.setSlyouthTbKey(new CmConvKeyUtils().getTbKey(request.getRequestURI()));
		
		// 동아리 단건 조회
		NtCircleSVO returnSVO = ntCircleService.circleEdit(ntCircleDVO);
		
		mav.setViewName("slyouth/nt/VWNT0017");
		mav.addObject("returnSVO", returnSVO);
		return mav;
	}
	
	/**
	 * @title   : 동아리 저장
	 * @method  : circleSave()
	 * @comment : 동아리 정보를 저장합니다.
	 * @param   : NtCircleDVO, CmFileDVO
	 * @throws Exception 
	 */
	@PostMapping("circleSave")
	public NtCircleDVO circleSave(NtCircleDVO ntCircleDVO, CmFileDVO cmFileDVO) throws Exception{
		
		NtCircleSVO paramSVO = new NtCircleSVO();
		paramSVO.setNtCircleDVO(ntCircleDVO);
		paramSVO.setCmFileDVO(cmFileDVO);
		
		return ntCircleService.circleSave(paramSVO);
	}
	
	/**
	 * @title   : 동아리 삭제
	 * @method  : circleDel()
	 * @comment : 동아리 정보를 삭제합니다.
	 * @param   : NtCircleDVO, CmFileDVO
	 * @throws Exception 
	 */
	@PostMapping("circleDel")
	public int circleDel(NtCircleDVO ntCircleDVO) throws Exception{
		
		NtCircleSVO paramSVO = new NtCircleSVO();
		paramSVO.setNtCircleDVO(ntCircleDVO);
		
		return ntCircleService.circleDel(paramSVO);
	}
	
	/**
	 * @title   : 동아리 게시판 상세조회
	 * @method  : circleBoardDetail()
	 * @comment : 동아리 게시판 상세 페이지로 이동합니다.
	 * @param   : NtCircleDVO
	 * @throws Exception 
	 */
	@RequestMapping("circleBoardDetail")
	public ModelAndView circleBoardDetail(NtCircleDVO ntCircleDVO, ModelAndView mav) throws Exception {	

		// 동아리 단건 조회
		NtCircleSVO returnSVO = ntCircleService.circleBoardDetail(ntCircleDVO);
		
		mav.setViewName("slyouth/nt/VWNT0018");
		mav.addObject("returnSVO", returnSVO);
		return mav;
	}
	
	/**
	 * @title   : 동아리 게시판 수정
	 * @method  : circleBoardEdit()
	 * @comment : 동아리 등록/수정 페이지로 이동합니다.
	 * @param   : NtCircleDVO
	 * @throws Exception 
	 */
	@RequestMapping("circleBoardEdit")
	public ModelAndView circleBoardEdit(NtCircleDVO ntCircleDVO, ModelAndView mav) throws Exception {	
		
		// 동아리 단건 조회
		NtCircleSVO returnSVO = ntCircleService.circleBoardEdit(ntCircleDVO);
		
		mav.setViewName("slyouth/nt/VWNT0019");
		mav.addObject("returnSVO", returnSVO);
		return mav;
	}
	
	/**
	 * @title   : 동아리 게시판 저장
	 * @method  : circleBoardSave()
	 * @comment : 동아리 등록/수정 페이지로 이동합니다.
	 * @param   : NtCircleDVO
	 * @throws Exception 
	 */
	@PostMapping("circleBoardSave")
	public NtCircleDVO circleBoardSave(NtCircleDVO ntCircleDVO, CmFileDVO cmFileDVO, HttpServletRequest request) throws Exception {
		
		// 동아리 기본정보 조회
		ntCircleDVO.setSlyouthTbKey(new CmConvKeyUtils().getTbKey(request.getRequestURI()));
		cmFileDVO.setRefTbKey(new CmConvKeyUtils().getTbKey(request.getRequestURI()));
		
		NtCircleSVO paramSVO = new NtCircleSVO();
		paramSVO.setCmFileDVO(cmFileDVO);
		paramSVO.setNtCircleCmnty(ntCircleDVO);
		
		return ntCircleService.circleBoardSave(paramSVO);
	}
	
	/**
	 * @title   : 동아리 게시판 삭제
	 * @method  : circleBoardeDel()
	 * @comment : 동아리 게사판 정보를 삭제합니다.
	 * @param   : NtCircleDVO, HttpServletRequest
	 * @throws Exception 
	 */
	@PostMapping("circleBoardDel")
	public int circleBoardDel(NtCircleDVO ntCircleDVO, HttpServletRequest request) throws Exception{
		
		// 동아리 기본정보 조회
		ntCircleDVO.setSlyouthTbKey(new CmConvKeyUtils().getTbKey(request.getRequestURI()));
		
		return ntCircleService.circleBoardDel(ntCircleDVO);
	}
	
	/**
	 * @title   : 신청자 인원 조회(모달)
	 * @method  : selectChrMemberModal()
	 * @comment : 동아리 참여 신청 가능인원을 조회합니다.
	 * @param   : NtCircleDVO
	 * @throws Exception 
	 */
	@PostMapping("selectChrMemberModal")
	public List<UmMemberDVO> selectChrMemberModal() throws Exception{
		
		return ntCircleService.selectChrMemberModal();
	}
	
	/**
	 * @title   : 신청자 인원 저장
	 * @method  : memberModalSave()
	 * @comment : 동아리 신청인원을 저장합니다.
	 * @param   : String
	 * @throws Exception 
	 */
	@PostMapping("memberModalSave")
	public int memberModalSave(@RequestParam(value="arr") String appMember) throws Exception{
		
		// 저장할 멤버 리스트 만들기
		// 페이지에서 넘겨받은 json배열 파싱하기
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(appMember);
		JSONArray jsonArr = (JSONArray) obj;
		
		// 저장할 멤버 리스트 변수
		List<NtCircleDVO> memberList = new ArrayList<NtCircleDVO>();
		
		// json 배열을 하나씩 꺼내서 json객체로 만든후 dvo에 매핑
		for(int i=0; i<jsonArr.size(); i++) {
			// 배열에서 하나 꺼내서 json 객체로 변환
			JSONObject json = (JSONObject) jsonArr.get(i);
			
			// DVO 객체 만든 후 매핑 후 list에 추가
			NtCircleDVO member = new NtCircleDVO();
			member.setChrNo(Integer.parseInt(json.get("chrNo").toString()));
			member.setEventNo(Integer.parseInt(json.get("eventNo").toString()));
			memberList.add(member);
		}
		
		return ntCircleService.memberModalSave(memberList);
	}
}
