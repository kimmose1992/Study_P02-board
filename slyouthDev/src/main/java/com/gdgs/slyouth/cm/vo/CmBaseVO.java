package com.gdgs.slyouth.cm.vo;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @title	: 공통 VO 기본 클래스	  
 * @author	: mosekim
 * @create	: 2021.04.13
 * @update	: 2021.06.24
 */
public class CmBaseVO extends CmPagingInDVO {
	
	/** 계정 */
	private int chrNo;				// 교적번호
	private String usrId;			// 사용자 아이디
	private String nickname;		// 닉네임
	private String tskDivCd;		// 업무구분코드
	
	/** 첨부파일 */
	private String tmpFileId;		// 임시파일ID
	private String slyouthTbKey;	// 테이블키
	
	/** 작성이력 */
	private int frsRegNo;			// 최초등록자번호
	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime frsRegDt;	// 최초등록일시
	private int lstMdfNo;			// 최종수정자번호
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime lstMdfDt;	// 최종수정일시
	
	/** 구분 */
	private String editDivCd; 		// 작성구분(I:등록, U:수정)

	public int getChrNo() {
		return chrNo;
	}

	public void setChrNo(int chrNo) {
		this.chrNo = chrNo;
	}

	public String getUsrId() {
		return usrId;
	}

	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getTskDivCd() {
		return tskDivCd;
	}

	public void setTskDivCd(String tskDivCd) {
		this.tskDivCd = tskDivCd;
	}

	public String getTmpFileId() {
		return tmpFileId;
	}

	public void setTmpFileId(String tmpFileId) {
		this.tmpFileId = tmpFileId;
	}

	public String getSlyouthTbKey() {
		return slyouthTbKey;
	}

	public void setSlyouthTbKey(String slyouthTbKey) {
		this.slyouthTbKey = slyouthTbKey;
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

	public LocalDateTime getLstMdfDt() {
		return lstMdfDt;
	}

	public void setLstMdfDt(LocalDateTime lstMdfDt) {
		this.lstMdfDt = lstMdfDt;
	}

	public String getEditDivCd() {
		return editDivCd;
	}

	public void setEditDivCd(String editDivCd) {
		this.editDivCd = editDivCd;
	}

}
