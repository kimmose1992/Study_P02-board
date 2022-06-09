package com.gdgs.slyouth.nm.vo;

import com.gdgs.slyouth.cm.vo.CmBaseVO;

/**
 * @title    : [새가족] 새가족소개 DVO 클래스      
 * @author   : 이하은
 * @create   : 2021.07.03
 */

public class NmIntroDVO extends CmBaseVO {

	/** 테이블 변수 */
	private String introDivCd;	// 소개구분코드
	private String introNo;		// 소개번호
	private String title;		// 제목
	private String subject;		// 주제
	private String content;		// 내용
	private String remark;		// 비고

	/** 참조 테이블 변수 */	
	private int fileNo;			// (첨부파일) 파일번호

	public String getIntroDivCd() {
		return introDivCd;
	}

	public void setIntroDivCd(String introDivCd) {
		this.introDivCd = introDivCd;
	}

	public String getIntroNo() {
		return introNo;
	}

	public void setIntroNo(String introNo) {
		this.introNo = introNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

}
