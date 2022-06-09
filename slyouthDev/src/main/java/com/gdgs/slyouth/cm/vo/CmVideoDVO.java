package com.gdgs.slyouth.cm.vo;

/**
 * @title   : [공통] 영상관리 DVO 클래스      
 * @author  : 송근영
 * @create  : 2021.04.30
 * @update  : 2021.07.08
 */
public class CmVideoDVO extends CmBaseVO {
	
	/** 테이블 변수 */
	private int videoNo;			// 영상번호
	private String videoDivCd;		// 영상구분코드
	private String videoTypeCd;		// 영상타입코드
	private String title;			// 제목
	private String content;			// 내용
	private String remark;			// 비고
	private String ytbAdr;			// 유튜브링크
	private String ytbThumbAdr;		// 유투브 썸네일 링크
	private String editDivCd;		// 등록&수정 구분 코드(임시값)

	/** 출력 변수 */
	private String titleLb;			// 제목 라벨
	private String contentLb;		// 내용 라벨
	private String remarkLb;		// 비고 라벨
	private String videoMainUrl;	// 영상기본URL
	
	public int getVideoNo() {
		return videoNo;
	}
	
	public void setVideoNo(int videoNo) {
		this.videoNo = videoNo;
	}
	
	public String getVideoDivCd() {
		return videoDivCd;
	}
	
	public void setVideoDivCd(String videoDivCd) {
		this.videoDivCd = videoDivCd;
	}
	
	public String getVideoTypeCd() {
		return videoTypeCd;
	}

	public void setVideoTypeCd(String videoTypeCd) {
		this.videoTypeCd = videoTypeCd;
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
	
	public String getRemark() {
		return remark;
	}
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getYtbAdr() {
		return ytbAdr;
	}
	
	public void setYtbAdr(String ytbAdr) {
		this.ytbAdr = ytbAdr;
	}
	
	public String getYtbThumbAdr() {
		return ytbThumbAdr;
	}
	
	public void setYtbThumbAdr(String ytbThumbAdr) {
		this.ytbThumbAdr = ytbThumbAdr;
	}
	
	public String getEditDivCd() {
		return editDivCd;
	}
	
	public void setEditDivCd(String editDivCd) {
		this.editDivCd = editDivCd;
	}
	
	public String getTitleLb() {
		return titleLb;
	}
	
	public void setTitleLb(String titleLb) {
		this.titleLb = titleLb;
	}
	
	public String getContentLb() {
		return contentLb;
	}
	
	public void setContentLb(String contentLb) {
		this.contentLb = contentLb;
	}
	
	public String getRemarkLb() {
		return remarkLb;
	}

	public void setRemarkLb(String remarkLb) {
		this.remarkLb = remarkLb;
	}

	public String getVideoMainUrl() {
		return videoMainUrl;
	}

	public void setVideoMainUrl(String videoMainUrl) {
		this.videoMainUrl = videoMainUrl;
	}
	
}