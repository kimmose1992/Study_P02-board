package com.gdgs.slyouth.cm.security.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gdgs.slyouth.cm.security.context.CmUserContext;
import com.gdgs.slyouth.cm.service.dao.CmLoginDAO;
import com.gdgs.slyouth.cm.vo.CmLoginDVO;

/**
 * @title	: Spring Security UserDetailService 구현 클래스	  
 * @author	: mosekim
 * @create	: 2021.04.132
 */
@Service("customUserDetailsService")
public class CmUserDetailsService implements UserDetailsService {

	@Autowired
	private CmLoginDAO cmLoginDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		CmLoginDVO paramDVO = new CmLoginDVO();
		paramDVO.setUsrId(username);
		
		CmLoginDVO cmLoginDVO = cmLoginDAO.findByUsrId(paramDVO);
		
		if (cmLoginDVO == null) {
			throw new UsernameNotFoundException("UsernameNotFoundException");
		}
		
		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add(new SimpleGrantedAuthority(cmLoginDVO.getUsrRole()));
		
		CmUserContext customUserContext = new CmUserContext(cmLoginDVO, roles);
		
		return customUserContext;
	}

}
