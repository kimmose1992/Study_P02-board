package com.gdgs.slyouth.nt.vo;

import com.gdgs.slyouth.cm.vo.CmBaseVO;

/**
 * @title	: [커뮤니티] 자유게시판 DVO 클래스
 * @author	: srar2
 * @create	: 2021. 8. 1.
 */
public class NtChatDVO extends CmBaseVO {
	
	/** 테이블 변수 */
	private int cmntyNo;		// 커뮤니티번호
	private String cmntyDivCd;	// 커뮤니티구분코드
	private String wrtDivCd;	// 작성구분코드
	private String title;		// 제목
	private String content;		// 내용
	private int viewCnt;		// 조회수
	
	/** 참조 테이블 변수 */
	private String name;		// (교적) 이름
	
	/** 출력 변수 */
	private int resultCnt;		// 결과건수
	private String wrtDivNm; 	// 작성구분

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
	public int getResultCnt() {
		return resultCnt;
	}
	public void setResultCnt(int resultCnt) {
		this.resultCnt = resultCnt;
	}
	public String getWrtDivNm() {
		return wrtDivNm;
	}
	public void setWrtDivNm(String wrtDivNm) {
		this.wrtDivNm = wrtDivNm;
	}
}
