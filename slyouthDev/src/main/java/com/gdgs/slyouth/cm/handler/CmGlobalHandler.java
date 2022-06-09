package com.gdgs.slyouth.cm.handler;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.gdgs.slyouth.cm.utils.CmConvKeyUtils;
import com.gdgs.slyouth.cm.vo.CmLoginDVO;

/**
 * @title	: [공통] HandlerInterceptor 구현 클래스	  
 * @author	: mosekim
 * @create	: 2021.07.05
 */
public class CmGlobalHandler implements HandlerInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(CmGlobalHandler.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.info("==================================================");
		logger.info("[Start Request URI] :: " + request.getRequestURI());
		logger.info("==================================================");
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		
		String requestUri = request.getRequestURI();
		String slyouthTbKey = new CmConvKeyUtils().getTbKey(requestUri);
		String tmpFileId = UUID.randomUUID().toString().replace("-", "");
		
		// 테이블 키 설정
		if (!(modelAndView == null || "NONE".equals(slyouthTbKey))) {
			modelAndView.addObject("slyouthTbKey", slyouthTbKey);
			modelAndView.addObject("tmpFileId", tmpFileId);
		}
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		// 시큐리티 세션이 있는 경우에만, 사용자 키 설정
		if (!(authentication == null || "anonymousUser".equals(authentication.getPrincipal()))) {
			CmLoginDVO userInfo = (CmLoginDVO) authentication.getPrincipal();
			request.setAttribute("usrId", userInfo.getUsrId());
			request.setAttribute("nickname", userInfo.getNickname());
			request.setAttribute("chrNo", userInfo.getChrNo());
		}
		
		logger.info("==================================================");
		logger.info("[End Request URI] :: " + requestUri);
		logger.info("==================================================");
		
		
	}
}
