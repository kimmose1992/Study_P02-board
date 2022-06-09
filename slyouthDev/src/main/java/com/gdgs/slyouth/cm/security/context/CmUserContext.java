package com.gdgs.slyouth.cm.security.context;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.gdgs.slyouth.cm.vo.CmLoginDVO;

/**
 * @title	: Spring Security User 구현 클래스	 
 * @author	: mosekim
 * @create	: 2021.04.13
 */
@SuppressWarnings("serial")
public class CmUserContext extends User {

	private final CmLoginDVO cmLoginDVO;
	
	/**
	 * @param username
	 * @param password
	 * @param authorities
	 */
	public CmUserContext(CmLoginDVO cmLoginDVO, Collection<? extends GrantedAuthority> authorities) {
		super(cmLoginDVO.getUsrId(), cmLoginDVO.getUsrPw(), authorities);
		this.cmLoginDVO = cmLoginDVO;
	}

	public CmLoginDVO getCmLoginDVO() {
		return cmLoginDVO;
	}
	
}
