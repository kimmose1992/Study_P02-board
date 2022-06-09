package com.gdgs.slyouth.mi.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gdgs.slyouth.cm.utils.CmConvKeyUtils;
import com.gdgs.slyouth.mi.service.MiIntroService;
import com.gdgs.slyouth.mi.vo.MiIntroDVO;
import com.gdgs.slyouth.mi.vo.MiIntroSVO;

/**
 * @title  : [교회소개] 메인 Controller 클래스
 * @author : 신지현
 * @create : 2021.07.1
 */

@RestController
@RequestMapping("/mi/")
public class MiIntroController {
	
	@Autowired
	private MiIntroService miIntroService;

	/**
	 * @title   : 교회소개(메인) 화면 조회
	 * @method  : mainPage()
	 * @comment : 교회 소개 메인 조회 화면이다.
	 * @param   : N/A
	 */
	@RequestMapping("main")
	public ModelAndView mainPage() throws Exception {
		MiIntroSVO returnSVO = miIntroService.selectMainIntro();		
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("returnSVO", returnSVO);
		mav.setViewName("slyouth/mi/VWMI0001");
		return mav;
	}

	/**
	 * @title   : 교회소개(메인) 화면 수정 화면
	 * @method  : introEdit()
	 * @comment : 교회 소개 메인 수정 화면을 불러옵니다.
	 * @param   : N/A
	 */
	@RequestMapping("mainEdit")
	public ModelAndView mainEdit() throws Exception {
		MiIntroSVO returnSVO = miIntroService.selectMainIntro();

		ModelAndView mav = new ModelAndView();
		mav.addObject("returnSVO", returnSVO.getMiIntroDVO());
		mav.setViewName("slyouth/mi/VWMI0002");
		return mav;
	}

	/**
	 * @title : 교회소개(메인) 화면 수정 완료
	 * @method : introSave()
	 * @comment : 교회 소개 메인 수정을 한 뒤에 DB에 갖다옵니다.
	 * @param : MiIntroDVO
	 */
	@PostMapping("introSave")
	public int introSave(MiIntroDVO miIntroDVO) throws Exception {
		int returnNum = miIntroService.updateMiIntro(miIntroDVO);

		return returnNum;
	}

	/**
	 * @title : 예배안내 메인
	 * @method : worshipInfo()
	 * @comment : 예배 안내 조회 화면 입니다.
	 * @param : N/A
	 */
	@RequestMapping("worshipInfo")
	public ModelAndView worshipInfo() throws Exception {
		ModelAndView mav = new ModelAndView();
		
		MiIntroSVO returnSVO = miIntroService.worshipInfo();

		mav.addObject("returnSVO",returnSVO);
		mav.setViewName("slyouth/mi/VWMI0009");
		return mav;
	}
	
	/**
	 * @title : 예배안내 수정 화면
	 * @method : worshipInfoEdit()
	 * @comment : 예배 안내 수정 화면으로 이동합니다.
	 * @param : N/A
	 */
	@RequestMapping("worshipInfoEdit")
	public ModelAndView worshipInfoEdit() throws Exception {
		ModelAndView mav = new ModelAndView();
		
		MiIntroSVO returnSVO = miIntroService.worshipInfo();
		
		mav.addObject("returnSVO", returnSVO);
		mav.setViewName("slyouth/mi/VWMI0010");
		return mav;
	}
	
	/**
	 * @title : 예배안내 수정 
	 * @method : worshipInfoSave()
	 * @comment : 예배 안내를 수정한 뒤에 DB로 이동합니다.
	 * @param : MiIntroDVO
	 */
	@PostMapping("worshipInfoSave")
	public MiIntroDVO worshipInfoSave(MiIntroDVO miIntroDVO) throws Exception {
		return miIntroService.worshipInfoSave(miIntroDVO);
	}
	

	/**
	 * @title	: 오시는 길  
	 * @method	: location()
	 * @comment	: 오시는 길 화면으로 이동합니다.		 
	 * @param	: N/A
	 */
	@GetMapping("location")
	public ModelAndView location() throws Exception{
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("slyouth/mi/VWMI0011");
		
		return mav;
	}
	
	/**
	 * @title	: 인사말 메인  
	 * @method	: greeting()
	 * @comment	: 인사말 메인화면으로 이동합니다.		 
	 * @param	: N/A
	 */
	@GetMapping("greeting")
	public ModelAndView greeting() throws Exception{

		MiIntroSVO returnSVO = miIntroService.greeting();

		ModelAndView mav = new ModelAndView();
		mav.addObject("returnSVO", returnSVO);
		mav.setViewName("slyouth/mi/VWMI0003");
		
		return mav;
	}
	
	/**
	 * @title	: 인사말 수정 
	 * @method	: greetingEdit()
	 * @comment	: 인사말 수정화면으로 이동합니다.		 
	 * @param	: N/A
	 */
	@GetMapping("greetingEdit")
	public ModelAndView greetingEdit() throws Exception {
				
		MiIntroSVO returnSVO = miIntroService.greeting();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("returnSVO", returnSVO);
		mav.setViewName("slyouth/mi/VWMI0004");
		
		return mav;
	}
	
	/**
	 * @title	: 인사말 수정
	 * @method	: greetingSave()
	 * @comment	: 인사말을 수정할 수 있습니다.		 
	 * @param	: MiIntroDVO
	 */
	@PostMapping("greetingSave")
	public MiIntroDVO greetingSave(MiIntroDVO miIntroDVO) throws Exception {

		return miIntroService.greetingSave(miIntroDVO);
	}
	
	/**
	 * @title   : 섬기는사람들 조회 페이지
	 * @method  : serveGroup()
	 * @comment : 섬기는사람들 조회 페이지로 이동한다.
	 * @param   : N/A
	 */
	@RequestMapping("serveGroup")
	public ModelAndView serveGroup() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("slyouth/mi/VWMI0005");
		return mav;
	}

	/**
	 * @title   : 섬기는사람들 수정 페이지
	 * @method  : serveGroupEdit()
	 * @comment : 섬기는사람들 수정 페이지로 이동한다.
	 * @param   : N/A
	 */
	@RequestMapping("serveGroupEdit")
	public ModelAndView serveGroupEdit() throws Exception {
		//TODO
		return null;
	}

	/**
	 * @title   : 청년부임원 조회 페이지
	 * @method  : youthLeader()
	 * @comment : 청년부임원 조회 페이지로 이동한다.
	 * @param   : N/A
	 */
	@RequestMapping("youthLeader")
	public ModelAndView youthLeader() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("slyouth/mi/VWMI0007");
		return mav;
	}
	
	/**
	 * @title	: 새가족반소개 기본정보 조회
	 * @method	: newcomerInfo
	 * @comment	: 새가족반소개 기본정보를 조회해온다.
	 * @param	: NmIntroDVO
	 */
	@RequestMapping("newcomer")
	public ModelAndView newcomerInfo(MiIntroDVO miIntroDVO, HttpServletRequest request, ModelAndView mav) throws Exception {
		
		// 새가족소개 기본정보 조회
		miIntroDVO.setSlyouthTbKey(new CmConvKeyUtils().getTbKey(request.getRequestURI()));
		MiIntroSVO returnSVO = miIntroService.newcomerInfo(miIntroDVO);
		
		mav.addObject("returnSVO", returnSVO);
		mav.setViewName("slyouth/mi/VWMI0008");
		return mav;
	}
}
