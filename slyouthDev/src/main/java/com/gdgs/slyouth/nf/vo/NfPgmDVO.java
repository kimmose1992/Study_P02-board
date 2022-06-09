package com.gdgs.slyouth.nf.vo;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.gdgs.slyouth.cm.vo.CmBaseVO;

/**
 * @title  : [양육과훈련] 프로그램 DVO 클래스
 * @author : 송근영
 * @create : 2021.08.02
 * @update : 2021.09.16
 */
public class NfPgmDVO extends CmBaseVO {
	
	/** 테이블 변수(행사) */
	private int eventNo;			// 행사번호(프로그램번호)
	private String eventDivCd;		// 행사구분코드
	private String eventNm;			// 행사명(프로그램명)
	private String eventIntro;		// 행사소개(프로그램소개)
	private int repImgNo;		// 행사이미지번호
	private int mngNo;				// 담당자번호(교적번호)
	private int peopleNum;			// 인원수
	private String strYmd;			// 시작일자(프로그램시작일자)
	private String strTm; 			// 시작시각(프로그램시작시각)
	private String endYmd;			// 종료일자(프로그램종료일자)
	private String endTm;			// 종료시각(프로그램종료시각)
	private String place;			// 장소
	private String remark;			// 비고
	private String appStrYmd;		// 신청시작일자(프로그램신청시작일자)
	private String appStrTm;		// 신청시작시각(프로그램신청시작시각)
	private String appEndYmd; 		// 신청종료일자(프로그램신청종료일자)
	private String appEndTm;		// 신청종료시각(프로그램신청종료시각)	
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime appStrDt; // 접수시작일시
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime appEndDt; // 접수종료일시

	/** 테이블 변수(커뮤니티) */
	private int cmntyNo;			// 커뮤니티번호
	private String cmntyDivCd;		// 커뮤니티구분코드
	private String cmntyMngCd;		// 커뮤니티관리번호
	private String title;			// 제목
	private String content;			// 내용
	private int viewCnt;			// 조회수
	private char topFixYn;			// 공개여부
	
	/** 참조 테이블 변수 */
	private String appYn;			// 승인여부 
	private int cmntyMngNo;			// 커뮤니티 관리번호 
	private String useYn; 			// 커뮤니티 사용여부
	private String name;			// 교적이름
	private String grade;			// 기수
	private int fileNo;				// (첨부파일) 파일번호
	private String fileNm;			// (첨부파일) 파일이름
	private int refNo;				// (첨부파일) 참조번호
	private String refDivCd;		// (첨부파일) 참조구분코드
	private String refTbKey;		// (첨부파일) 참조키
	private String savePth;			// (첨부파일) 저장경로
	public int getEventNo() {
		return eventNo;
	}
	public void setEventNo(int eventNo) {
		this.eventNo = eventNo;
	}
	public String getEventDivCd() {
		return eventDivCd;
	}
	public void setEventDivCd(String eventDivCd) {
		this.eventDivCd = eventDivCd;
	}
	public String getEventNm() {
		return eventNm;
	}
	public void setEventNm(String eventNm) {
		this.eventNm = eventNm;
	}
	public String getEventIntro() {
		return eventIntro;
	}
	public void setEventIntro(String eventIntro) {
		this.eventIntro = eventIntro;
	}
	public int getRepImgNo() {
		return repImgNo;
	}
	public void setRepImgNo(int repImgNo) {
		this.repImgNo = repImgNo;
	}
	public int getMngNo() {
		return mngNo;
	}
	public void setMngNo(int mngNo) {
		this.mngNo = mngNo;
	}
	public int getPeopleNum() {
		return peopleNum;
	}
	public void setPeopleNum(int peopleNum) {
		this.peopleNum = peopleNum;
	}
	public String getStrYmd() {
		return strYmd;
	}
	public void setStrYmd(String strYmd) {
		this.strYmd = strYmd;
	}
	public String getStrTm() {
		return strTm;
	}
	public void setStrTm(String strTm) {
		this.strTm = strTm;
	}
	public String getEndYmd() {
		return endYmd;
	}
	public void setEndYmd(String endYmd) {
		this.endYmd = endYmd;
	}
	public String getEndTm() {
		return endTm;
	}
	public void setEndTm(String endTm) {
		this.endTm = endTm;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getAppStrYmd() {
		return appStrYmd;
	}
	public void setAppStrYmd(String appStrYmd) {
		this.appStrYmd = appStrYmd;
	}
	public String getAppStrTm() {
		return appStrTm;
	}
	public void setAppStrTm(String appStrTm) {
		this.appStrTm = appStrTm;
	}
	public String getAppEndYmd() {
		return appEndYmd;
	}
	public void setAppEndYmd(String appEndYmd) {
		this.appEndYmd = appEndYmd;
	}
	public String getAppEndTm() {
		return appEndTm;
	}
	public void setAppEndTm(String appEndTm) {
		this.appEndTm = appEndTm;
	}
	public LocalDateTime getAppStrDt() {
		return appStrDt;
	}
	public void setAppStrDt(LocalDateTime appStrDt) {
		this.appStrDt = appStrDt;
	}
	public LocalDateTime getAppEndDt() {
		return appEndDt;
	}
	public void setAppEndDt(LocalDateTime appEndDt) {
		this.appEndDt = appEndDt;
	}
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
	public String getCmntyMngCd() {
		return cmntyMngCd;
	}
	public void setCmntyMngCd(String cmntyMngCd) {
		this.cmntyMngCd = cmntyMngCd;
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
	public char getTopFixYn() {
		return topFixYn;
	}
	public void setTopFixYn(char topFixYn) {
		this.topFixYn = topFixYn;
	}
	public String getAppYn() {
		return appYn;
	}
	public void setAppYn(String appYn) {
		this.appYn = appYn;
	}
	public int getCmntyMngNo() {
		return cmntyMngNo;
	}
	public void setCmntyMngNo(int cmntyMngNo) {
		this.cmntyMngNo = cmntyMngNo;
	}
	public String getUseYn() {
		return useYn;
	}
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
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
	public String getSavePth() {
		return savePth;
	}
	public void setSavePth(String savePth) {
		this.savePth = savePth;
	}
	
}
