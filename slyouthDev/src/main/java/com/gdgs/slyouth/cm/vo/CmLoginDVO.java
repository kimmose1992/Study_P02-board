package com.gdgs.slyouth.cm.vo;

/**
 * @title    : [공통] 로그인 DVO   
 * @author   : gypig
 * @create   : 2021.07.12
 * @update   : 2021.07.16
 */
public class CmLoginDVO extends CmBaseVO {

	/** 테이블 변수 */
	private int usrNo;				// 사용자번호 
	private String usrPw;			// 사용자 비밀번호
	private String usrRole;			// 사용자 권한
	private String acntStCd;		// 계정상태코드
	private int pwErrCnt;			// 패스워드오류횟수
	private int loginCnt;			// 로그인횟수
	
	/** 참조 변수 */
	private String authNo;			// 본인인증번호
	private String authNoEncrypt;	// 본인인증번호(암호화)
	private int authNoCnt; 			// 본인인증번호(결과건수)
	private String chrDivCd; 		// (교적)교적구분코드
	private String posDivCd; 		// (교적)직책구분코드
	
	/** 입력 변수 */
	private String certName;		// 이름
	private String certBirth;		// 생년월일
	private String certPhone;		// 핸드폰번호
	private String certNo;			// 본인인증번호(입력)
	
	/** 조건 변수 */
	private boolean isLoginPass;	// 로그인 성공여부
	private boolean isAuthPass;		// 본인인증 성공여부
	private boolean isJoinPass;		// 회원가입 성공여부
	
	/** 출력 변수 */
	private String usrNm;			// 사용자 이름

	public int getUsrNo() {
		return usrNo;
	}

	public void setUsrNo(int usrNo) {
		this.usrNo = usrNo;
	}

	public String getUsrPw() {
		return usrPw;
	}

	public void setUsrPw(String usrPw) {
		this.usrPw = usrPw;
	}

	public String getUsrRole() {
		return usrRole;
	}

	public void setUsrRole(String usrRole) {
		this.usrRole = usrRole;
	}

	public String getAcntStCd() {
		return acntStCd;
	}

	public void setAcntStCd(String acntStCd) {
		this.acntStCd = acntStCd;
	}

	public int getPwErrCnt() {
		return pwErrCnt;
	}

	public void setPwErrCnt(int pwErrCnt) {
		this.pwErrCnt = pwErrCnt;
	}

	public int getLoginCnt() {
		return loginCnt;
	}

	public void setLoginCnt(int loginCnt) {
		this.loginCnt = loginCnt;
	}

	public String getAuthNo() {
		return authNo;
	}

	public void setAuthNo(String authNo) {
		this.authNo = authNo;
	}

	public String getAuthNoEncrypt() {
		return authNoEncrypt;
	}

	public void setAuthNoEncrypt(String authNoEncrypt) {
		this.authNoEncrypt = authNoEncrypt;
	}

	public int getAuthNoCnt() {
		return authNoCnt;
	}

	public void setAuthNoCnt(int authNoCnt) {
		this.authNoCnt = authNoCnt;
	}

	public String getChrDivCd() {
		return chrDivCd;
	}

	public void setChrDivCd(String chrDivCd) {
		this.chrDivCd = chrDivCd;
	}

	public String getPosDivCd() {
		return posDivCd;
	}

	public void setPosDivCd(String posDivCd) {
		this.posDivCd = posDivCd;
	}

	public String getCertName() {
		return certName;
	}

	public void setCertName(String certName) {
		this.certName = certName;
	}

	public String getCertBirth() {
		return certBirth;
	}

	public void setCertBirth(String certBirth) {
		this.certBirth = certBirth;
	}

	public String getCertPhone() {
		return certPhone;
	}

	public void setCertPhone(String certPhone) {
		this.certPhone = certPhone;
	}

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public boolean isLoginPass() {
		return isLoginPass;
	}

	public void setLoginPass(boolean isLoginPass) {
		this.isLoginPass = isLoginPass;
	}

	public boolean getIsAuthPass() {
		return isAuthPass;
	}

	public void setIsAuthPass(boolean isAuthPass) {
		this.isAuthPass = isAuthPass;
	}

	public boolean isJoinPass() {
		return isJoinPass;
	}

	public void setJoinPass(boolean isJoinPass) {
		this.isJoinPass = isJoinPass;
	}

	public String getUsrNm() {
		return usrNm;
	}

	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	
}
