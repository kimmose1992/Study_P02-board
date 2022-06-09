package com.gdgs.slyouth.um.vo;

import com.gdgs.slyouth.cm.vo.CmBaseVO;

/**
 * @title   : 교적관리 DVO 클래스     
 * @author  : 송근영
 * @create  : 2021.05.24
 * @update  : 2021.09.01
 */
public class UmMemberDVO extends CmBaseVO {
	
	/** 테이블 변수 */
	private String chrRegYmd;		// 교적등록일자
	private String chrDivCd;		// 교인구분코드
	private String posDivCd;		// 직책구분코드
	private String posDtlCd;		// 직책상세코드
	private String name;			// 이름
	private String birth;			// 생년월일
	private String grade;			// 기수
	private String age;				// 나이
	private String gndrDivCd;		// 성별구분코드
	private String mbTelNo;			// 핸드폰번호
	private String hmTelNo;			// 집전화번호
	private String baseAdr;			// 기본주소
	private String dtlAdr;			// 상세주소
	private String job;				// 직업
	private String email;			// 이메일
	private String eduDivCd;		// 학력구분코드
	private String school;			// 학교
	private String major;			// 전공
	private String mrgStCd;			// 결혼상세코드
	private String bptStCd;			// 세례상세코드
	private String remark;			// 비고
	private String cellNo; 			// 사랑방번호
	private String volDeptCd1;		// 봉사부서코드1
	private String volDeptCd2;		// 봉사부서코드2
	
	/** 참조 변수 */
	private int fileNo;				// 파일번호
	
	/** 출력 변수 */
	private String modalDivCd;		// 모달창 구분코드
	private String chrDivCdNm;		// 교인구분코드이름
	private String posDivCdNm;		// 직책구분코드이름
	private String posDtlCdNm;		// 직책상세코드이름
	private String gndrDivCdNm;		// 성별구분코드이름
	private String eduDivCdNm;		// 학력구분코드이름
	private String mrgStCdNm;		// 결혼상세코드이름
	private String bptStCdNm;		// 세례상세코드이름
	private String volDeptCdNm1;	// 봉사부서코드이름1
	private String volDeptCdNm2;	// 봉사부서코드이름2
	
	public String getChrRegYmd() {
		return chrRegYmd;
	}
	public void setChrRegYmd(String chrRegYmd) {
		this.chrRegYmd = chrRegYmd;
	}
	public String getChrDivCd() {
		return chrDivCd;
	}
	public void setChrDivCd(String chrDivCd) {
		this.chrDivCd = chrDivCd;
	}
	public String getPosDivCd() {
		return posDivCd;
	}
	public void setPosDivCd(String posDivCd) {
		this.posDivCd = posDivCd;
	}
	public String getPosDtlCd() {
		return posDtlCd;
	}
	public void setPosDtlCd(String posDtlCd) {
		this.posDtlCd = posDtlCd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGndrDivCd() {
		return gndrDivCd;
	}
	public void setGndrDivCd(String gndrDivCd) {
		this.gndrDivCd = gndrDivCd;
	}
	public String getMbTelNo() {
		return mbTelNo;
	}
	public void setMbTelNo(String mbTelNo) {
		this.mbTelNo = mbTelNo;
	}
	public String getHmTelNo() {
		return hmTelNo;
	}
	public void setHmTelNo(String hmTelNo) {
		this.hmTelNo = hmTelNo;
	}
	public String getBaseAdr() {
		return baseAdr;
	}
	public void setBaseAdr(String baseAdr) {
		this.baseAdr = baseAdr;
	}
	public String getDtlAdr() {
		return dtlAdr;
	}
	public void setDtlAdr(String dtlAdr) {
		this.dtlAdr = dtlAdr;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEduDivCd() {
		return eduDivCd;
	}
	public void setEduDivCd(String eduDivCd) {
		this.eduDivCd = eduDivCd;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getMrgStCd() {
		return mrgStCd;
	}
	public void setMrgStCd(String mrgStCd) {
		this.mrgStCd = mrgStCd;
	}
	public String getBptStCd() {
		return bptStCd;
	}
	public void setBptStCd(String bptStCd) {
		this.bptStCd = bptStCd;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCellNo() {
		return cellNo;
	}
	public void setCellNo(String cellNo) {
		this.cellNo = cellNo;
	}
	public String getVolDeptCd1() {
		return volDeptCd1;
	}
	public void setVolDeptCd1(String volDeptCd1) {
		this.volDeptCd1 = volDeptCd1;
	}
	public String getVolDeptCd2() {
		return volDeptCd2;
	}
	public void setVolDeptCd2(String volDeptCd2) {
		this.volDeptCd2 = volDeptCd2;
	}
	public int getFileNo() {
		return fileNo;
	}
	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}
	public String getModalDivCd() {
		return modalDivCd;
	}
	public void setModalDivCd(String modalDivCd) {
		this.modalDivCd = modalDivCd;
	}
	public String getChrDivCdNm() {
		return chrDivCdNm;
	}
	public void setChrDivCdNm(String chrDivCdNm) {
		this.chrDivCdNm = chrDivCdNm;
	}
	public String getPosDivCdNm() {
		return posDivCdNm;
	}
	public void setPosDivCdNm(String posDivCdNm) {
		this.posDivCdNm = posDivCdNm;
	}
	public String getPosDtlCdNm() {
		return posDtlCdNm;
	}
	public void setPosDtlCdNm(String posDtlCdNm) {
		this.posDtlCdNm = posDtlCdNm;
	}
	public String getGndrDivCdNm() {
		return gndrDivCdNm;
	}
	public void setGndrDivCdNm(String gndrDivCdNm) {
		this.gndrDivCdNm = gndrDivCdNm;
	}
	public String getEduDivCdNm() {
		return eduDivCdNm;
	}
	public void setEduDivCdNm(String eduDivCdNm) {
		this.eduDivCdNm = eduDivCdNm;
	}
	public String getMrgStCdNm() {
		return mrgStCdNm;
	}
	public void setMrgStCdNm(String mrgStCdNm) {
		this.mrgStCdNm = mrgStCdNm;
	}
	public String getBptStCdNm() {
		return bptStCdNm;
	}
	public void setBptStCdNm(String bptStCdNm) {
		this.bptStCdNm = bptStCdNm;
	}
	public String getVolDeptCdNm1() {
		return volDeptCdNm1;
	}
	public void setVolDeptCdNm1(String volDeptCdNm1) {
		this.volDeptCdNm1 = volDeptCdNm1;
	}
	public String getVolDeptCdNm2() {
		return volDeptCdNm2;
	}
	public void setVolDeptCdNm2(String volDeptCdNm2) {
		this.volDeptCdNm2 = volDeptCdNm2;
	}

	@Override
	public String toString() {
		return "UmMemberDVO [chrRegYmd=" + chrRegYmd + ", chrDivCd=" + chrDivCd + ", posDivCd=" + posDivCd
				+ ", posDtlCd=" + posDtlCd + ", name=" + name + ", birth=" + birth + ", grade=" + grade + ", age=" + age
				+ ", gndrDivCd=" + gndrDivCd + ", mbTelNo=" + mbTelNo + ", hmTelNo=" + hmTelNo + ", baseAdr=" + baseAdr
				+ ", dtlAdr=" + dtlAdr + ", job=" + job + ", email=" + email + ", eduDivCd=" + eduDivCd + ", school="
				+ school + ", major=" + major + ", mrgStCd=" + mrgStCd + ", bptStCd=" + bptStCd + ", remark=" + remark
				+ ", cellNo=" + cellNo + ", volDeptCd1=" + volDeptCd1 + ", volDeptCd2=" + volDeptCd2 + ", fileNo="
				+ fileNo + ", modalDivCd=" + modalDivCd + ", chrDivCdNm=" + chrDivCdNm + ", posDivCdNm=" + posDivCdNm
				+ ", posDtlCdNm=" + posDtlCdNm + ", gndrDivCdNm=" + gndrDivCdNm + ", eduDivCdNm=" + eduDivCdNm
				+ ", mrgStCdNm=" + mrgStCdNm + ", bptStCdNm=" + bptStCdNm + ", volDeptCdNm1=" + volDeptCdNm1
				+ ", volDeptCdNm2=" + volDeptCdNm2 + "]";
	}
}