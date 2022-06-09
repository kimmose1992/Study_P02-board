package com.gdgs.slyouth.cm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gdgs.slyouth.cm.service.CmLoginService;
import com.gdgs.slyouth.cm.vo.CmLoginDVO;
import com.gdgs.slyouth.cm.vo.CmLoginSVO;

/** 
 * @title    : [공통] 회원가입 및 로그인 컨트롤러     
 * @author   : gypig
 * @create   : 2021.06.19
 * @update   : 2021.07.25
 */

@RestController
@RequestMapping("/cm/")
public class CmLoginController {

	private static final Logger logger = LoggerFactory.getLogger(CmLoginController.class);
	
	@Autowired
	private CmLoginService cmLoginService;
	
	/**
	 * @title	: 회원가입 페이지 이동  
	 * @method	: join()
	 * @comment	: 회원가입 화면으로 이동한다.		 
	 * @param	: N/A
	 */
	@RequestMapping("join")
	public ModelAndView join(ModelAndView mav) throws Exception {

		mav.setViewName("slyouth/cm/VWCM0002");
		return mav;
	}
	
	/**
	 * @title	: 본인인증 번호 생성  
	 * @method	: authNoGen()
	 * @comment	: 본인인증번호 생성 및 알림톡 서비스를 호출합니다.(비즈톡 구현 예정)		 
	 * @param	: CmLoginDVO
	 */
	@PostMapping("authNoGen")
	public CmLoginDVO authNoGen(CmLoginDVO cmLoginDVO) throws Exception {
		
		return cmLoginService.authNoGen(cmLoginDVO);
	}
	
	/**
	 * @title	: 본인인증 번호 확인
	 * @method	: authNoCheck()
	 * @comment	: 발급된 인증번호와 사용자가 입력한 본인인증 번호 일치여부를 확인한다.
	 * @param	: CmLoginDVO
	 */
	@PostMapping("authNoCheck")
	public CmLoginDVO joinAuthNoCheck(CmLoginDVO cmLoginDVO) throws Exception {
		
		return cmLoginService.authNoCheck(cmLoginDVO);
	}
	
	/**
	 * @title	: 회원가입 정보 저장  
	 * @method	: joinSave
	 * @comment	: 회원가입 정보를 저장한다.
	 * @param	: CmLoginDVO
	 */
	@PostMapping("joinSave")
	public boolean joinSave(CmLoginDVO cmLoginDVO) throws Exception {
		return cmLoginService.joinSave(cmLoginDVO);
	}
	
	/**
	 * @title	: 로그인 페이지 이동  
	 * @method	: login()
	 * @comment	: 로그인 화면으로 이동한다.		 
	 * @param	: N/A
	 */
	@RequestMapping("login")
	public ModelAndView login(ModelAndView mav) throws Exception {
		
		mav.setViewName("slyouth/cm/VWCM0001");
		return mav;
	}
	
	/**
	 * @title	: 로그인 확인   
	 * @method	: loginCheck()
	 * @comment	: 로그인을 진행합니다.		 
	 * @param	: CmLoginDVO, HttpServletRequest
	 */
	@PostMapping("loginCheck")
	public CmLoginSVO loginCheck(CmLoginDVO cmLoginDVO, HttpServletRequest request) throws Exception {
		
		CmLoginSVO returnSVO = null;
		
		try {
			
			// 페이지에서 세션 받기 및 생성
			HttpSession session = request.getSession();
			
			returnSVO = cmLoginService.loginCheck(cmLoginDVO);
			
			if (returnSVO != null) {
				// 세션에 값 저장
				session.setAttribute("userInfo", returnSVO.getCmLoginDVO());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return returnSVO;
	}
	
	/**
	 * @title	: 로그아웃
	 * @method	: logout()
	 * @comment	: 로그아웃을 진행합니다.		 
	 * @param	: request, response
	 */
	@GetMapping("logout")
	public void logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CmLoginDVO userInfo = (CmLoginDVO) authentication.getPrincipal();
		String usrId = userInfo.getUsrId();
		
		// 시큐리티 권한이 있는 경우 로그아웃 처리
		if (authentication != null) {
			new SecurityContextLogoutHandler().logout(request, response, authentication);
		}
	
		logger.debug("############################################");
        logger.debug("## Logout Success");
        logger.debug("## usrId :: " + usrId);
		logger.debug("############################################");
		
		response.sendRedirect("/");
	}
	
	/**
	 * @title	: 아이디/비밀번호 찾기 페이지  
	 * @method	: findUserInfo()
	 * @comment	: 비밀번호 찾기 페이지로이동한다.		 
	 * @param	: N/A
	 */
	@RequestMapping("findUserInfo")
	public ModelAndView findUserInfo(ModelAndView mav) throws Exception {
		
		mav.setViewName("slyouth/cm/VWCM0003");
		return mav;
	}
	
	/**
	 * @title	: Id 확인
	 * @method	: checkId
	 * @comment	: ID로 DB에 등록되어있는 유저가 있는지 확인합니다.	 
	 * @param	: CmLoginDVO
	 */
	@PostMapping("checkId")
	public CmLoginDVO checkId(CmLoginDVO cmLoginDVO) throws Exception {
		
		return cmLoginService.checkId(cmLoginDVO);
	}
	
	/**
	 * @title	: 비밀번호 변경 
	 * @method	: changePassword()
	 * @comment	: 비밀번호를 DB에 저장합니다.		 
	 * @param	: CmLoginDVO
	 */
	@PostMapping("changePassword")
	public int changePassword(CmLoginDVO cmLoginDVO) throws Exception {
		
		return cmLoginService.changePassword(cmLoginDVO);
	}

	/**
	 * @title	: 예외처리 페이지
	 * @method	: accessDenied()
	 * @comment	: 접근권한이 없는 페이지에 접근 시, 예외처리 페이지로 이동한다.		 
	 * @param	: exception, deniedMsg
	 */
	@PostMapping("/accessDenied")
	public ModelAndView accessDenied(@RequestParam("deniedMsg") String deniedMsg, ModelAndView mav) throws Exception {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		CmLoginDVO userInfo = (CmLoginDVO) authentication.getPrincipal();
		
		mav.addObject("usrNm", userInfo.getUsrNm());
		mav.addObject("deniedMsg", deniedMsg);
		mav.addObject("slyouth/cm/VWCM9999");
		return mav;
	}
}
