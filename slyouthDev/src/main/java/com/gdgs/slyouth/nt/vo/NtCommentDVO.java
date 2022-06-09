package com.gdgs.slyouth.nt.vo;

import com.gdgs.slyouth.cm.vo.CmBaseVO;

/**
 * @title	: [커뮤니티] 댓글 DVO 클래스
 * @author	: srar2
 * @create	: 2021. 8. 5.
 */
public class NtCommentDVO extends CmBaseVO {
	
	/** 테이블 변수 */
	private int commentNo;		// 댓글번호
	private int refNo;			// 참조번호
	private String refDivCd;	// 참조구분코드
	private String refTbKey;	// 참조테이블키
	private String content;		// 내용
	private int grpOrd;			// 그룹순서
	private int grpNo;			// 그룹번호
	
	/** 참조 테이블 변수 */
	private String name;		// (교적) 이름
	
	/** 출력 변수 */
	private int resultCnt;		// 결과건수

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public int getRefNo() {
		return refNo;
	}

	public void setRefNo(int refNo) {
		this.refNo = refNo;
	}

	public String getRefDivCd() {
		return refDivCd;
	}

	public void setRefDivCd(String refDivCd) {
		this.refDivCd = refDivCd;
	}

	public String getRefTbKey() {
		return refTbKey;
	}

	public void setRefTbKey(String refTbKey) {
		this.refTbKey = refTbKey;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getGrpOrd() {
		return grpOrd;
	}

	public void setGrpOrd(int grpOrd) {
		this.grpOrd = grpOrd;
	}

	public int getGrpNo() {
		return grpNo;
	}

	public void setGrpNo(int grpNo) {
		this.grpNo = grpNo;
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

	@Override
	public String toString() {
		return "NtCommentDVO [commentNo=" + commentNo + ", refNo=" + refNo + ", refDivCd=" + refDivCd + ", refTbKey="
				+ refTbKey + ", content=" + content + ", grpOrd=" + grpOrd + ", grpNo=" + grpNo + ", name=" + name
				+ ", resultCnt=" + resultCnt + "]";
	}

}
