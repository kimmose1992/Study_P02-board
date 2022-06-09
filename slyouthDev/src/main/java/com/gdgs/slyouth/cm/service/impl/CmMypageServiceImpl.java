package com.gdgs.slyouth.cm.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdgs.slyouth.cm.security.context.CmUserContext;
import com.gdgs.slyouth.cm.service.CmMypageService;
import com.gdgs.slyouth.cm.service.dao.CmMypageDAO;
import com.gdgs.slyouth.cm.vo.CmLoginDVO;
import com.gdgs.slyouth.cm.vo.CmMypageDVO;
import com.gdgs.slyouth.cm.vo.CmMypageSVO;

/**
 * @title	: [공통] 마이페이지 Service 구현 클래스  
 * @author	: srar2
 * @create	: 2021. 8. 11.
 */
@Component
@Service("cmMypageService")
public class CmMypageServiceImpl implements CmMypageService {
	
	private static final Logger logger = LoggerFactory.getLogger(CmMypageServiceImpl.class);
	
	@Autowired
	private CmMypageDAO cmMypageDAO;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/**
	 * @title	: [마이페이지] 상세조회
	 * @method	: mypageInfo()
	 * @comment	: 로그인한 사용자의 개인정보를 상세 조회한다.		 
	 * @param	: CmLoginDVO
	 */
	@Override
	public CmMypageSVO mypageInfo(CmMypageDVO cmMypageDVO) throws Exception {
		CmMypageSVO returnSVO = new CmMypageSVO();
		CmMypageDVO returnDVO = new CmMypageDVO();
		
		returnDVO = cmMypageDAO.mypageInfo(cmMypageDVO);
		returnDVO.setNickname(cmMypageDVO.getNickname());
		
		returnSVO.setCmMypageDVO(returnDVO);
		return returnSVO;
	}
	
	/**
	 * @title	: [마이페이지] 비밀번호 변경
	 * @method	: mypagePwModify()
	 * @comment	: 사용자의 비밀번호를 변경한다.		 
	 * @param	: CmMypageDVO
	 */
	@Override
	@Transactional
	public CmMypageDVO mypagePwModify(CmMypageDVO cmMypageDVO) throws Exception {
		CmMypageDVO returnDVO = new CmMypageDVO();
		
		String usrId = cmMypageDVO.getUsrId();
		
		CmUserContext context = (CmUserContext) userDetailsService.loadUserByUsername(usrId);
		String password = context.getPassword();
		
		// 기존 비밀번호 일치여부 체크
		if(!passwordEncoder.matches(cmMypageDVO.getOrgUsrPw(), password)) {
			returnDVO.setPasswordPass(false);
			return returnDVO;
		}
		
		int resultCnt = 0;
		try {
			// 비밀번호 암호화
			cmMypageDVO.setChgUsrPw(passwordEncoder.encode(cmMypageDVO.getChgUsrPw()));
			
			// 비밀번호 변경
			resultCnt = cmMypageDAO.mypagePwModify(cmMypageDVO);
			
			if(resultCnt <= 0) {
				throw new Exception("비밀번호 업데이트 오류");
			}
			
			returnDVO.setPasswordPass(true);
			returnDVO.setResultCnt(resultCnt);
		}catch(Exception e) {
			logger.debug("#############################");
			logger.debug("## " + e.getMessage());
			logger.debug("#############################");
			
			throw new RuntimeException();
		}
		return returnDVO;
	}
}
