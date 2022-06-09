package com.gdgs.slyouth.sd.vo;

import com.gdgs.slyouth.cm.vo.CmBaseVO;

/**
 * @title	: [기준정보] 코드관리 DVO 클래스	  
 * @author	: mosekim
 * @create	: 2021.04.21
 */
public class SdCodeDVO extends CmBaseVO {

	/**
	 * 코드번호
	 */
	private int codeNo;
	
	/**
	 * 업무구분코드
	 */
	private String tskDivCd;

	/**
	 * 업무구분명
	 */
	private String tskDivNm;
	
	/**
	 * 코드그룹ID
	 */
	private String cdGrpId;
	
	/**
	 * 코드그룹명
	 */
	private String cdGrpNm;
	
	/**
	 * 코드그룹키
	 */
	private String cdGrpKey;
	
	/**
	 * 상위코드그룹ID
	 */
	private String prnCdGrpId;
	
	/**
	 * 상위코드값
	 */
	private String prnCdVl;		

	/**
	 * 코드값
	 */
	private String cdVl;
	
	/**
	 * 코드명
	 */
	private String cdNm;	
	
	/**
	 * 코드순서
	 */
	private int cdOrd;
	
	/**
	 * 비고
	 */
	private String remark;

	/**
	 * 사용여부
	 */
	private String useYn;

	public int getCodeNo() {
		return codeNo;
	}

	public void setCodeNo(int codeNo) {
		this.codeNo = codeNo;
	}

	public String getTskDivCd() {
		return tskDivCd;
	}

	public void setTskDivCd(String tskDivCd) {
		this.tskDivCd = tskDivCd;
	}

	public String getTskDivNm() {
		return tskDivNm;
	}

	public void setTskDivNm(String tskDivNm) {
		this.tskDivNm = tskDivNm;
	}

	public String getCdGrpId() {
		return cdGrpId;
	}

	public void setCdGrpId(String cdGrpId) {
		this.cdGrpId = cdGrpId;
	}

	public String getCdGrpNm() {
		return cdGrpNm;
	}

	public void setCdGrpNm(String cdGrpNm) {
		this.cdGrpNm = cdGrpNm;
	}

	public String getCdGrpKey() {
		return cdGrpKey;
	}

	public void setCdGrpKey(String cdGrpKey) {
		this.cdGrpKey = cdGrpKey;
	}

	public String getPrnCdGrpId() {
		return prnCdGrpId;
	}

	public void setPrnCdGrpId(String prnCdGrpId) {
		this.prnCdGrpId = prnCdGrpId;
	}

	public String getPrnCdVl() {
		return prnCdVl;
	}

	public void setPrnCdVl(String prnCdVl) {
		this.prnCdVl = prnCdVl;
	}

	public String getCdVl() {
		return cdVl;
	}

	public void setCdVl(String cdVl) {
		this.cdVl = cdVl;
	}

	public String getCdNm() {
		return cdNm;
	}

	public void setCdNm(String cdNm) {
		this.cdNm = cdNm;
	}

	public int getCdOrd() {
		return cdOrd;
	}

	public void setCdOrd(int cdOrd) {
		this.cdOrd = cdOrd;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	@Override
	public String toString() {
		return "SdCodeDVO [codeNo=" + codeNo + ", tskDivCd=" + tskDivCd + ", tskDivNm=" + tskDivNm + ", cdGrpId="
				+ cdGrpId + ", cdGrpNm=" + cdGrpNm + ", cdGrpKey=" + cdGrpKey + ", prnCdGrpId=" + prnCdGrpId
				+ ", prnCdVl=" + prnCdVl + ", cdVl=" + cdVl + ", cdNm=" + cdNm + ", cdOrd=" + cdOrd + ", remark="
				+ remark + ", useYn=" + useYn + "]";
	}

}
