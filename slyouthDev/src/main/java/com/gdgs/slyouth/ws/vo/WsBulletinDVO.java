package com.gdgs.slyouth.ws.vo;

import com.gdgs.slyouth.cm.vo.CmBaseVO;

/**
 * @title   : 주보 VO 클래스    
 * @author   : srar2
 * @create   : 2021.04.28
 * @update	 : 2021.07.30
 */
public class WsBulletinDVO extends CmBaseVO {
	
	/** 테이블 변수 */
	private int cmntyNo;		// 커뮤니티번호
	private String cmntyDivCd;	// 커뮤니티구분코드
	private String title;		// 제목
	private String content;		// 내용
	private int grpNo;			// 그룹번호
	private int viewCnt;		// 조회수
	
	/** 참조 테이블 변수 */
	private String name;		// (교적) 이름
	private int fileNo;			// (첨부파일) 파일번호
	private String fileNm;		// (첨부파일) 파일이름
	
	/** 출력 변수 */
	private String selDivCd;	// 조회구분코드
	private int resultCnt;		// 결과건수
	public int getCmntyNo() {
		return cmntyNo;
	}
	
	public void setCmntyNo(int cmntyNo) {
		this.cmntyNo = cmntyNo;
	}
	public String getCmntyDivCd() {
		return cmntyDivCd;
	}
	public void setCmntyDivCd(String cmntyDivCd) {
		this.cmntyDivCd = cmntyDivCd;
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
	public int getGrpNo() {
		return grpNo;
	}
	public void setGrpNo(int grpNo) {
		this.grpNo = grpNo;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getFileNo() {
		return fileNo;
	}
	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}
	public String getFileNm() {
		return fileNm;
	}
	public void setFileNm(String fileNm) {
		this.fileNm = fileNm;
	}
	public String getSelDivCd() {
		return selDivCd;
	}
	public void setSelDivCd(String selDivCd) {
		this.selDivCd = selDivCd;
	}
	public int getResultCnt() {
		return resultCnt;
	}
	public void setResultCnt(int resultCnt) {
		this.resultCnt = resultCnt;
	}

	@Override
	public String toString() {
		return "WsBulletinDVO [cmntyNo=" + cmntyNo + ", cmntyDivCd=" + cmntyDivCd + ", title=" + title + ", content="
				+ content + ", grpNo=" + grpNo + ", viewCnt=" + viewCnt + ", name=" + name + ", fileNo=" + fileNo
				+ ", fileNm=" + fileNm + ", selDivCd=" + selDivCd + ", resultCnt=" + resultCnt + "]";
	}
	
}
