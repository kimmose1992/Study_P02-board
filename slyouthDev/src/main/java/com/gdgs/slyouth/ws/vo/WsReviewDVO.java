package com.gdgs.slyouth.ws.vo;

import com.gdgs.slyouth.cm.vo.CmBaseVO;

/**
 * @title    : [예배와 말씀] 말씀후기 DVO 클래스     
 * @author   : gypig
 * @create   : 2021.07.01
 * @update   : 2021.07.09
 */
public class WsReviewDVO extends CmBaseVO{
	
	/**
	 * 커뮤니티번호
	 */
	private int cmntyNo;
	
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
	 * 그룹번호
	 */
	private int grpNo;
	
	/**
	 * 조회수
	 */
	private int viewCnt;
	
	/**
	 * (교적) 이름
	 */
	private String name;
	
	/**
	 * (파일) 파일번호
	 */
	private String fileNo;
	
	/**
	 * 조회구분코드
	 */
	private String selDivCd;
	
	/**
	 * 등록/수정 구분 코드(임시값)
	 */
	private String editDivCd;

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

	public String getFileNo() {
		return fileNo;
	}

	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}

	public String getSelDivCd() {
		return selDivCd;
	}

	public void setSelDivCd(String selDivCd) {
		this.selDivCd = selDivCd;
	}

	public String getEditDivCd() {
		return editDivCd;
	}

	public void setEditDivCd(String editDivCd) {
		this.editDivCd = editDivCd;
	}
	
	@Override
	public String toString() {
		return "WsReviewDVO [cmntyNo=" + cmntyNo + ", cmntyDivCd=" + cmntyDivCd + ", wrtDivCd=" + wrtDivCd + ", title="
				+ title + ", content=" + content + ", grpNo=" + grpNo + ", viewCnt=" + viewCnt + ", name=" + name
				+ ", fileNo=" + fileNo + ", selDivCd=" + selDivCd + ", editDivCd=" + editDivCd + "]";
	}
}
