package com.gdgs.slyouth.wk.vo;

import com.gdgs.slyouth.cm.vo.CmBaseVO;

/**
 * @title   : [업무] 봉사부서 관리 DVO 클래스     
 * @author  : gypig
 * @update  : 2021.06.29
 */
public class WkVoluntaryDVO extends CmBaseVO{

	/**
	 * 부서 일련번호
	 */
	private String deptNo;
	
	/**
	 * 부서 이름
	 */
	private String deptNm;
	
	/**
	 * 사용유무
	 */
	private String useYn;
	
	/**
	 * 시작일자
	 */
	private String strYmd;
	
	/**
	 * 종료일자
	 */
	private String endYmd;

	public String getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptNm() {
		return deptNm;
	}

	public void setDeptNm(String deptNm) {
		this.deptNm = deptNm;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public String getStrYmd() {
		return strYmd;
	}

	public void setStrYmd(String strYmd) {
		this.strYmd = strYmd;
	}

	public String getEndYmd() {
		return endYmd;
	}

	public void setEndYmd(String endYmd) {
		this.endYmd = endYmd;
	}
}
