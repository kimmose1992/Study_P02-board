package com.gdgs.slyouth.nt.vo;

import com.gdgs.slyouth.cm.vo.CmBaseVO;

/**
 * @title	: [커뮤니티] 상담 DVO 클래스  
 * @author	: srar2
 * @create	: 2021. 6. 26.
 */
public class NtCounselDVO extends CmBaseVO {
	
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
	 * 그룹순서
	 */
	private int grpOrd;
	
	/**
	 * 공개여부
	 */
	private String openYn;
	
	/**
	 * 익명여부
	 */
	private String annyYn;
	
	/**
	 * 조회수
	 */
	private int viewCnt;
	
	/**
	 * 담당자번호
	 */
	private int mngNo;
	
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
	 * 담당자이름
	 */
	private String mngNm;
	
	/**
	 * 그룹번호 별 글 수
	 */
	private int grpCount;
	
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

	public int getGrpOrd() {
		return grpOrd;
	}

	public void setGrpOrd(int grpOrd) {
		this.grpOrd = grpOrd;
	}

	public String getOpenYn() {
		return openYn;
	}

	public void setOpenYn(String openYn) {
		this.openYn = openYn;
	}

	public String getAnnyYn() {
		return annyYn;
	}

	public void setAnnyYn(String annyYn) {
		this.annyYn = annyYn;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public int getMngNo() {
		return mngNo;
	}

	public void setMngNo(int mngNo) {
		this.mngNo = mngNo;
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
	
	public String getMngNm() {
		return mngNm;
	}

	public void setMngNm(String mngNm) {
		this.mngNm = mngNm;
	}
	
	public int getGrpCount() {
		return grpCount;
	}

	public void setGrpCount(int grpCount) {
		this.grpCount = grpCount;
	}

	@Override
	public String toString() {
		return "NtCounselDVO [cmntyNo=" + cmntyNo + ", tskDivCd=" + tskDivCd + ", cmntyDivCd=" + cmntyDivCd + ", title="
				+ title + ", content=" + content + ", grpNo=" + grpNo + ", grpOrd=" + grpOrd + ", openYn=" + openYn
				+ ", annyYn=" + annyYn + ", viewCnt=" + viewCnt + ", mngNo=" + mngNo + ", name=" + name + ", fileNo="
				+ fileNo + ", selDivCd=" + selDivCd + ", mngNm=" + mngNm + ", grpCount=" + grpCount + "]";
	}
}
