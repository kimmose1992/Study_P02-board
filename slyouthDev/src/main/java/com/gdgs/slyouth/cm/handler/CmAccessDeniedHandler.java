package com.gdgs.slyouth.cm.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

/**
 * @title	: [공통] 권한 AccessDeniedHandler 구현 클래스	  
 * @author	: mosekim
 * @create	: 2021.08.13
 */
@Component
public class CmAccessDeniedHandler implements AccessDeniedHandler {

	private static final Logger logger = LoggerFactory.getLogger(CmAccessDeniedHandler.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
		String deniedMsg = accessDeniedException.getMessage();
		
		logger.debug("############################################");
        logger.debug("## deniedMsg :: " + deniedMsg);
		logger.debug("############################################");
		
		request.setAttribute("deniedMsg", deniedMsg);
		response.sendRedirect("/cm/accessDenied");
	}
	
}
