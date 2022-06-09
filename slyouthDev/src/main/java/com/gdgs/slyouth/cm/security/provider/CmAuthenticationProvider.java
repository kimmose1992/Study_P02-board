package com.gdgs.slyouth.cm.security.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gdgs.slyouth.cm.security.context.CmUserContext;
import com.gdgs.slyouth.cm.service.dao.CmLoginDAO;
import com.gdgs.slyouth.cm.vo.CmLoginDVO;

/**
 * @title	: Spring Security AuthenticationProvider 구현 클래스	  
 * @author	: mosekim
 * @create	: 2021.04.14
 */
public class CmAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private CmLoginDAO cmLoginDAO;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = authentication.getName();
		String password = (String) authentication.getCredentials();
		
		CmUserContext context = (CmUserContext) userDetailsService.loadUserByUsername(username);
		CmLoginDVO cmLoginDVO = context.getCmLoginDVO();
		
		// 비밀번호 오류 횟수 체크 (5회 이상인 경우 Exception 발생)
		if (cmLoginDVO.getPwErrCnt() >= 5) {
			throw new LockedException("LockedException");
		}
		
		// 비밀번호 일치여부 체크
		if (!passwordEncoder.matches(password, cmLoginDVO.getUsrPw())) {
			
			// 비밀번호 오류 횟수 업데이트
			cmLoginDVO.setLoginPass(false);
			cmLoginDAO.updatePwErrCnt(cmLoginDVO);
			
			throw new BadCredentialsException("BadCredentialsException");
		}
		
		// 비밀번호 오류 횟수 초기화
		cmLoginDVO.setLoginPass(true);
		cmLoginDAO.updatePwErrCnt(cmLoginDVO);
		
		// 로그인 횟수 업데이트
		cmLoginDAO.updateLoginCnt(cmLoginDVO);
		
		// 토큰 생성
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(cmLoginDVO, null, context.getAuthorities());
		return token;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
