package com.gdgs.slyouth.cm.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

/**
 * @title	: [공통] 로그인 AuthenticationFailureHandler 구현 클래스	  	  
 * @author	: mosekim
 * @create	: 2021.08.08
 */
@Component
public class CmLoginFailureHandler implements AuthenticationFailureHandler {

	private static final Logger logger = LoggerFactory.getLogger(CmLoginFailureHandler.class);
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
		
		String usrId = request.getParameter("usrId");
        String usrPw = request.getParameter("usrPw");
        String loginFailMsg = null;
        
        // 예외처리 메세지 설정
        if (exception instanceof UsernameNotFoundException) {
        	loginFailMsg = "가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.";
        } else if(exception instanceof BadCredentialsException) {
        	loginFailMsg = "가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.";
        } else if(exception instanceof LockedException) {
        	loginFailMsg = "비밀번호가 5회 이상 틀린 계정입니다. 교역자에게 문의하세요.";
        }

        logger.debug("############################################");
        logger.debug("## usrId :: " + usrId);
        logger.debug("## usrPw :: " + usrPw);
		logger.debug("## loginFailMsg :: " + loginFailMsg);
		logger.debug("############################################");
		
		// 파라미터 설정
		request.setAttribute("usrId", usrId);
		request.setAttribute("usrPw", usrPw);
		request.setAttribute("loginFailMsg", loginFailMsg);
		
		// 로그인 페이지 이동
		request.getRequestDispatcher("/cm/login").forward(request, response);
	}

}
