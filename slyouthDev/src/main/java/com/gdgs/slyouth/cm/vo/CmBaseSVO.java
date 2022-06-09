package com.gdgs.slyouth.cm.vo;

/**
 * @title	: [공통] SVO 기본 클래스	  
 * @author	: mosekim
 * @create	: 2021.07.16
 */
public class CmBaseSVO {
	
	/** 예외처리 */
	private String errMsg;	// 에러메세지

	/** 작업처리 */
	private int resultCnt;	// 결과건수
	
	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public int getResultCnt() {
		return resultCnt;
	}

	public void setResultCnt(int resultCnt) {
		this.resultCnt = resultCnt;
	}

}
