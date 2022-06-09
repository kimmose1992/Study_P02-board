package com.gdgs.slyouth.cm.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

/**
 * @title	: [공통] 로그인 AuthenticationSuccessHandler 구현 클래스	  
 * @author	: mosekim
 * @create	: 2021.08.08
 */
@Component
public class CmLoginSuccessHandler implements AuthenticationSuccessHandler {

	private static final Logger logger = LoggerFactory.getLogger(CmLoginSuccessHandler.class);
	
	private RequestCache requestCache = new HttpSessionRequestCache();
    private RedirectStrategy redirectStratgy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

		String usrId = request.getParameter("usrId");

        logger.debug("############################################");
        logger.debug("## Login Success");
        logger.debug("## usrId :: " + usrId);
		logger.debug("############################################");
		
		// Redirect URL 설정
		this.resultRedirectStrategy(request, response, authentication);
		
		// 로그인 실패 에러 세션 제거
		this.clearAuthenticationAttributes(request);
	}

	/**
	 * @title	: Redirect URL 설정	  
	 * @method	: resultRedirectStrategy	 
	 * @comment	: 로그인 성공 후, Redirect 될 URL을 설정한다.		 
	 * @param	: request, response, authentication
	 */
	protected void resultRedirectStrategy(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		
		SavedRequest savedRequest = requestCache.getRequest(request, response);
        
		// Redirect Default URL 설정
		String redirectUrl = "/";
		
		/** 
		 * 로그인 접근 경로에 따른 Redirect URL 설정
		 * - savedRequest == null : 로그인 화면에서 접근한 경우
		 * - savedRequest != null : 인증 권한이 필요한 페이지에서 접근한 경우
		 */
        if (savedRequest != null) {
            redirectUrl = savedRequest.getRedirectUrl();
            redirectStratgy.sendRedirect(request, response, redirectUrl);
        } else {
            redirectStratgy.sendRedirect(request, response, redirectUrl);
        }
        
        logger.debug("############################################");
        logger.debug("## Call Method :: resultRedirectStrategy");
        logger.debug("## redirectUrl :: " + redirectUrl);
		logger.debug("############################################");
	}

	/**
	 * @title	: 로그인 실패 에러 세션 제거
	 * @method	: clearAuthenticationAttributes	 
	 * @comment	: 로그인 성공 전 실패된 경우가 있을 경우, 에러 정보가 같이 넘어가지 않도록 에러 세션 제거
	 * @param	: request
	 */
	protected void clearAuthenticationAttributes(HttpServletRequest request) {
		
		// 에러 세션 가져오기
		HttpSession session = request.getSession(false);
        
		// 에러 세션이 없는 경우 리턴 
		if (session == null) return;
		
		// 에러 세션 정보 제거
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}
}
