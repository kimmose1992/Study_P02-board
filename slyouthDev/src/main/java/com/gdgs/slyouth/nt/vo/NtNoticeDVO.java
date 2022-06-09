package com.gdgs.slyouth.nt.vo;

import java.time.LocalDateTime;

import com.gdgs.slyouth.cm.vo.CmBaseVO;

/**
 * @title    : [커뮤니티] 공지사항 DVO 클래스     
 * @author   : 신지현
 * @create   : 2021.05.15
 */
public class NtNoticeDVO extends CmBaseVO{
	
	/**
	 * 커뮤니티번호
	 */
	private int cmntyNo;
	
	/**
	 * 업무구분코드
	 */
	private String tskDivCd;
	
	/**
	 * 커뮤니티구분코드
	 */
	private String cmntyDivCd; 
	
	/**
	 * 작성구분코드
	 */
	private String wrtDivCd;
	
	/**
	 * 제목
	 */
	private String title;
	
	/**
	 * 내용
	 */
	private String content;
	
	/**
	 * 상단고정여부
	 */
	private String topFixYn;
	
	/**
	 * 조회수
	 */
	private int viewCnt;
	
	/**
	 * 최초등록자번호
	 */
	private int frsRegNo;
	
	/**
	 * 최초등록일시
	 */
	private LocalDateTime frsRegDt;
	
	/**
	 * 최종수정자번호
	 */
	private int lstMdfNo;
	
	/**
	 * 최종수정일시
	 */
	private LocalDateTime lstMdtDt;
	
	/**
	 * (교적) 이름
	 */
	private String chrNm;
	
	/**
	 * (첨부파일) 일련번호
	 */
	private int fileNo;
	
	/**
	 * (교적) 이름
	 */
	private String name;
	
	// 등록수정코드 //
	private String editDivCd;

	public String getEditDivCd() {
		return editDivCd;
	}

	public void setEditDivCd(String editDivCd) {
		this.editDivCd = editDivCd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public String getTopFixYn() {
		return topFixYn;
	}

	public void setTopFixYn(String topFixYn) {
		this.topFixYn = topFixYn;
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

	public String getChrNm() {
		return chrNm;
	}

	public void setChrNm(String chrNm) {
		this.chrNm = chrNm;
	}

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	@Override
	public String toString() {
		return "NtNoticeDVO [cmntyNo=" + cmntyNo + ", tskDivCd=" + tskDivCd + ", cmntyDivCd=" + cmntyDivCd
				+ ", wrtDivCd=" + wrtDivCd + ", title=" + title + ", content=" + content + ", topFixYn=" + topFixYn
				+ ", viewCnt=" + viewCnt + ", frsRegNo=" + frsRegNo + ", frsRegDt=" + frsRegDt + ", lstMdfNo="
				+ lstMdfNo + ", lstMdtDt=" + lstMdtDt + ", chrNm=" + chrNm + ", fileNo=" + fileNo + "]";
	}
			
}
