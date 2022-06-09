package com.gdgs.slyouth.cm.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdgs.slyouth.cm.service.CmLoginService;
import com.gdgs.slyouth.cm.service.dao.CmLoginDAO;
import com.gdgs.slyouth.cm.utils.CmConvKeyUtils;
import com.gdgs.slyouth.cm.vo.CmLoginDVO;
import com.gdgs.slyouth.cm.vo.CmLoginSVO;
import com.gdgs.slyouth.um.service.dao.UmMemberDAO;

/**
 * @title    : [공통] 회원가입 및 서비스 Service 구현 클래스     
 * @author   : gypig
 * @create   : 2021.06.19
 * @update   : 2021.07.25
 */
@Component
@Service("cmLoginService")
public class CmLoginServiceImpl  implements CmLoginService {

	private static final Logger logger = LoggerFactory.getLogger(CmLoginServiceImpl.class);
	
	@Autowired
	private CmLoginDAO cmLoginDAO;
	
	@Autowired
	private UmMemberDAO umMemberDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/**
	 * @title	: 인증번호 생성   
	 * @method	: authNoGen()
	 * @comment	: 인증번호를 생성 및 조회 합니다.		 
	 * @param	: CmLoginDVO
	 */
	@Override
	public CmLoginDVO authNoGen(CmLoginDVO cmLoginDVO) throws Exception {
		
		CmLoginDVO returnDVO = null;
		
		try {
			// 교적 존재유무 체크
			returnDVO = cmLoginDAO.selectCertMember(cmLoginDVO);
			
			// 교적 정보에 있는 경우에만 인증번호 생성
			if (returnDVO != null) {
				
				String authNo = "";
				
				// 인증번호 생성 (6자리)
				for(int i=0; i<6; i++) {
					authNo += (int) (Math.random() * 10);
				};
				
				// 인증번호 출력
				logger.debug("#############################");
				logger.debug("## 인증번호 : " + authNo);
				logger.debug("#############################");
				
				// 인증번호 암호화
				String authNoEncrypt = passwordEncoder.encode(authNo);
				
				// 인증번호 설정
				cmLoginDVO.setAuthNo(authNo);
				cmLoginDVO.setAuthNoEncrypt(authNoEncrypt);
				
				// 본인인증 정보 저장
				int authNoCnt = cmLoginDAO.saveAuthInfo(cmLoginDVO);
				
				if (authNoCnt == 0) {
					throw new Exception("인증번호 저장 오류");
				};
				
				returnDVO.setAuthNoCnt(authNoCnt);
			}
		} catch (Exception e) {
			logger.debug("#############################");
			logger.debug("## " + e.getMessage());
			logger.debug("#############################");
		}
		
		return returnDVO;
	}

	/**
	 * @title	: 본인인증 번호 확인
	 * @method	: authNoCheck()
	 * @comment	: 발급된 인증번호와 사용자가 입력한 본인인증 번호 일치여부를 확인한다.
	 * @param	: CmLoginDVO
	 */
	@Override
	public CmLoginDVO authNoCheck(CmLoginDVO cmLoginDVO) throws Exception {
		CmLoginDVO returnDVO = new CmLoginDVO();
		
		boolean isAuthPass = false; 
		
		try {
			// 교적 존재유무 체크
			returnDVO = cmLoginDAO.selectCertMember(cmLoginDVO);
			
			if (returnDVO == null) {
				throw new Exception("사용자 정보 조회오류");
			}
			
			// 발급 인증번호 정보 
			CmLoginDVO authInfo = cmLoginDAO.selectAuthInfo(cmLoginDVO);
			
			if (authInfo != null) {
				
				// 인증번호 일치여부 체크
				if (passwordEncoder.matches(cmLoginDVO.getCertNo(), authInfo.getAuthNoEncrypt())) {
					isAuthPass = true;
				}
			} else {
				throw new Exception("인증번호 조회 오류");
			}
			
			
		} catch (Exception e) {
			logger.debug("#############################");
			logger.debug("## " + e.getMessage());
			logger.debug("#############################");
		}
		
		returnDVO.setIsAuthPass(isAuthPass);
		return returnDVO;
	}

	/**
	 * @title	: 회원가입 정보 저장  
	 * @method	: joinSave
	 * @comment	: 회원가입 정보를 저장한다.
	 * @param	: CmLoginDVO
	 * @return	: CmLoginSVO
	 */
	@Override
	@Transactional
	public boolean joinSave(CmLoginDVO cmLoginDVO) throws Exception {
		
		int resultCnt;
		boolean isJoinPass = true; 
		
		try {
			// 비밀번호 암호화
			cmLoginDVO.setUsrPw(passwordEncoder.encode(cmLoginDVO.getUsrPw())); 
			
			// 사용자 권한 키 설정
			new CmConvKeyUtils().setUsrRoleKey(cmLoginDVO);			
			
			// 회원정보 저장
			resultCnt = cmLoginDAO.insertUser(cmLoginDVO);
			
			if (resultCnt <= 0) {
				isJoinPass = false;
				throw new Exception("회원정보 저장 오류");
			}
			
			// 교적정보에 사용자ID 업데이트
			resultCnt = umMemberDAO.updateMemberId(cmLoginDVO);
			
			if (resultCnt <= 0) {
				isJoinPass = false;
				throw new Exception("교정정보 업데이트 오류");
			}
		} catch (Exception e) {
			isJoinPass = false;

			logger.debug("#############################");
			logger.debug("## " + e.getMessage());
			logger.debug("#############################");
			
			throw new RuntimeException();
		}
		
		return isJoinPass;
	}
	
	/**
	 * @title	: 로그인 체크
	 * @method	: loginCheck()
	 * @comment	: 입력받은 ID와 PW를 체크합니다		 
	 * @param	: CmLoginDVO
	 */
	@Override
	public CmLoginSVO loginCheck(CmLoginDVO cmLoginDVO) throws Exception {
		
		CmLoginSVO returnSVO = new CmLoginSVO();
		CmLoginDVO returnDVO;
		
		try {
			
			// id가 존재한다면 로그인 정보 가져오기
			returnDVO = cmLoginDAO.findByUsrId(cmLoginDVO);
			
			if (returnDVO != null && returnDVO.getUsrPw() != null) {
				
				// 비밀번호 시도 횟수가 5회 이상의 경우에 따른 분기
				if (returnDVO.getPwErrCnt() >= 5) {
					throw new Exception("비밀번호가 5회 이상 틀린 계정입니다. 교역자에게 문의하세요.");
				}
				
				// 입력받은 pw와 DB의 pw를 비교해서 같지 않다면 초기화
				if (!passwordEncoder.matches(cmLoginDVO.getUsrPw(), returnDVO.getUsrPw())) {
					
					// 패스워트 오류 횟수 증가
//					cmLoginDAO.updateLoginFailInfo(cmLoginDVO);
					
					throw new Exception("패스워드가 올바르지 않습니다. 다시 시도해주세요.");
					
				} else {
					
					// DVO 세팅
					returnSVO.setCmLoginDVO(returnDVO);
					
					// 로그인 횟수 증가
//					cmLoginDAO.updateLoginSuccessInfo(cmLoginDVO);
				}
			} else {
				throw new Exception("아이디가 존재하지 않습니다.");
			}
		} catch (Exception e) {
			
			// 에러 메세지 설정
			returnSVO.setErrMsg(e.getMessage());
		}
		
		return returnSVO;
	}

	/**
	 * @title	: 비밀번호 변경   
	 * @method	: changePassword()
	 * @comment	: 비밀번호를 변경합니다.		 
	 * @param	: CmLoginDVO
	 */
	@Override
	public int changePassword(CmLoginDVO cmLoginDVO) throws Exception {
		
		int returnValue = 0;
		
		try {
			
			// 비밀번호 암호화
			cmLoginDVO.setUsrPw(passwordEncoder.encode(cmLoginDVO.getUsrPw()));
			
			// 비밀번호 변경
			returnValue = cmLoginDAO.updatePassword(cmLoginDVO);
					
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return returnValue;
	}

	/**
	 * @title	: ID 확인
	 * @method	: checkId()
	 * @comment	: ID로 DB에 등록되어있는 유저가 있는지 확인합니다.		 
	 * @param	: CmLoginDVO
	 */
	@Override
	public CmLoginDVO checkId(CmLoginDVO cmLoginDVO) throws Exception {
		
		return cmLoginDAO.checkId(cmLoginDVO);
	}

}
