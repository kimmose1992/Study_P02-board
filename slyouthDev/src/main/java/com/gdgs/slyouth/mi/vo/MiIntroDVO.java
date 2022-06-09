package com.gdgs.slyouth.mi.vo;

import com.gdgs.slyouth.cm.vo.CmBaseVO;

/**
* @title   :  소개 메인 DVO 클래스    
* @author   : 신지현
* @create   : 2021.06.26
*/
public class MiIntroDVO extends CmBaseVO {

	/** 테이블 변수 */
	private String introDivCd;	// 소개구분코드
	private String introNo;		// 소개번호
	private String title;		// 제목
	private String subject;		// 주제
	private String content;		// 내용
	private String remark;		// 비고

	/** 참조 테이블 변수 */
	private String chrNm;		// (교적) 이름
	private String cdNm;		// (교적) 교역자 구분
	private int fileNo;			// (첨부파일) 파일번호
	
	/** 출력 변수 */
	private int resultCnt;		// 결과건수

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

	public String getChrNm() {
		return chrNm;
	}

	public void setChrNm(String chrNm) {
		this.chrNm = chrNm;
	}

	public String getCdNm() {
		return cdNm;
	}

	public void setCdNm(String cdNm) {
		this.cdNm = cdNm;
	}

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	public int getResultCnt() {
		return resultCnt;
	}

	public void setResultCnt(int resultCnt) {
		this.resultCnt = resultCnt;
	}
	
}
