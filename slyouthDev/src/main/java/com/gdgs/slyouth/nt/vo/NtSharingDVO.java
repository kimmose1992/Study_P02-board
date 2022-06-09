package com.gdgs.slyouth.nt.vo;

import java.time.LocalDateTime;

import com.gdgs.slyouth.cm.vo.CmBaseVO;

/**
 * @title    : [커뮤니티] 나눔 DVO 클래스      
 * @author   : 신지현
 * @create   : 2021.07.01
 */
public class NtSharingDVO extends CmBaseVO{
	/** 테이블 변수*/
	private int cmntyNo;			// 커뮤니티 번호
	private String tskDivCd;		// 업무구분코드
	private String cmntyDivCd; 		// 커뮤니티구분코드
	private String wrtDivCd;		// 작성구분코드
	private String title;			// 제목
	private String content;			// 내용
	private int viewCnt;			// 조회수
	private int frsRegNo;			// 최초등록자번호
	private LocalDateTime frsRegDt; // 최초등록일시
	private int lstMdfNo;			// 최종수정자번호
	private LocalDateTime lstMdtDt;	// 최종수정일시
	
	/** 참조 테이블 변수*/
	private String name; 		// (교적) 이름
	
	/** 출력 변수*/
	private String editDivCd;	// 등록수정구분코드
	private int resultCnt;		// 결과건수
	
	public int getCmntyNo() {
		return cmntyNo;
	}
	public void setCmntyNo(int cmntyNo) {
		this.cmntyNo = cmntyNo;
	}
	public String getTskDivCd() {
		return tskDivCd;
	}
	public void setTskDivCd(String tskDivCd) {
		this.tskDivCd = tskDivCd;
	}
	public String getCmntyDivCd() {
		return cmntyDivCd;
	}
	public void setCmntyDivCd(String cmntyDivCd) {
		this.cmntyDivCd = cmntyDivCd;
	}
	public String getWrtDivCd() {
		return wrtDivCd;
	}
	public void setWrtDivCd(String wrtDivCd) {
		this.wrtDivCd = wrtDivCd;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public int getFrsRegNo() {
		return frsRegNo;
	}
	public void setFrsRegNo(int frsRegNo) {
		this.frsRegNo = frsRegNo;
	}
	public LocalDateTime getFrsRegDt() {
		return frsRegDt;
	}
	public void setFrsRegDt(LocalDateTime frsRegDt) {
		this.frsRegDt = frsRegDt;
	}
	public int getLstMdfNo() {
		return lstMdfNo;
	}
	public void setLstMdfNo(int lstMdfNo) {
		this.lstMdfNo = lstMdfNo;
	}
	public LocalDateTime getLstMdtDt() {
		return lstMdtDt;
	}
	public void setLstMdtDt(LocalDateTime lstMdtDt) {
		this.lstMdtDt = lstMdtDt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEditDivCd() {
		return editDivCd;
	}
	public void setEditDivCd(String editDivCd) {
		this.editDivCd = editDivCd;
	}
	public int getResultCnt() {
		return resultCnt;
	}
	public void setResultCnt(int resultCnt) {
		this.resultCnt = resultCnt;
	}
	@Override
	public String toString() {
		return "NtSharingDVO [cmntyNo=" + cmntyNo + ", tskDivCd=" + tskDivCd + ", cmntyDivCd=" + cmntyDivCd
				+ ", wrtDivCd=" + wrtDivCd + ", title=" + title + ", content=" + content + ", viewCnt=" + viewCnt
				+ ", frsRegNo=" + frsRegNo + ", frsRegDt=" + frsRegDt + ", lstMdfNo=" + lstMdfNo + ", lstMdtDt="
				+ lstMdtDt + ", name=" + name + ", editDivCd=" + editDivCd + ", resultCnt=" + resultCnt
				+ ", getChrNo()=" + getChrNo() + ", getUsrId()=" + getUsrId() + ", getNickname()=" + getNickname()
				+ "]";
	}
	
		
}
