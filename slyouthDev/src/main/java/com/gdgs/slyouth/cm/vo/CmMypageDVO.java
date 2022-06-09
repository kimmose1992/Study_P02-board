package com.gdgs.slyouth.cm.vo;

/**
 * @title	: [공통] 마이페이지 DVO 클래스  
 * @author	: srar2
 * @create	: 2021. 8. 11.
 */
public class CmMypageDVO extends CmBaseVO {

	/** 참조 변수 */
	private String mbTelNo;		// (교적) 핸드폰번호
	private String email;		// (교적) 이메일
	private String orgUsrPw;	// 기존 사용자 비밀번호
	private String chgUsrPw;	// 새 사용자 비밀번호	

	/** 출력정보 */
	private String name;		// (교적) 이름
	private String grade;		// (교적) 기수
	
	/** 조건 변수 */
	private boolean isPasswordPass; // 기존 비밀번호 일치여부
	
	/** 출력 변수 */
	private int resultCnt;		// 결과건수

	public String getMbTelNo() {
		return mbTelNo;
	}

	public void setMbTelNo(String mbTelNo) {
		this.mbTelNo = mbTelNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOrgUsrPw() {
		return orgUsrPw;
	}

	public void setOrgUsrPw(String orgUsrPw) {
		this.orgUsrPw = orgUsrPw;
	}

	public String getChgUsrPw() {
		return chgUsrPw;
	}

	public void setChgUsrPw(String chgUsrPw) {
		this.chgUsrPw = chgUsrPw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public boolean isPasswordPass() {
		return isPasswordPass;
	}

	public void setPasswordPass(boolean isPasswordPass) {
		this.isPasswordPass = isPasswordPass;
	}

	public int getResultCnt() {
		return resultCnt;
	}

	public void setResultCnt(int resultCnt) {
		this.resultCnt = resultCnt;
	}
	
}
