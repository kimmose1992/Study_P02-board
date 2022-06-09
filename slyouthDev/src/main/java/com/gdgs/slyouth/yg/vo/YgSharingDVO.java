package com.gdgs.slyouth.yg.vo;

import java.time.LocalDateTime;

import com.gdgs.slyouth.cm.vo.CmBaseVO;

/** 
 * @title    : [사랑방] 나눔자료공유게시판 DVO 클래스      
 * @author   : 김예림
 * @create   : 2021. 8. 29.
 */
public class YgSharingDVO extends CmBaseVO{
	
	/** 테이블 변수*/
	private int cmntyNo;		// 커뮤니티번호
	private String cmntyDivCd; 	// 커뮤니티구분코드
	private String title;		// 제목
	private String content;		// 내용
	private int viewCnt; 		// 조회수
	private String cmntyMngCd;	// 커뮤니티관리번호
	private LocalDateTime frsRegDt;	// 최초등록일시
	private LocalDateTime lstMdtDt;	// 최종수정일시
	
	/** 참조 테이블 변수 */
	private int cmntyMngNo;		// 커뮤니티 관리번호 
	private int fileNo;			// (첨부파일) 파일번호
	private String fileNm;		// (첨부파일) 파일이름
	private int refNo;			// (첨부파일) 참조번호
	private String refDivCd;	// (첨부파일) 참조구분코드
	private String refTbKey;	// (첨부파일) 참조키
	private String savePth;		// (첨부파일) 저장경로
	
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
	public String getCmntyMngCd() {
		return cmntyMngCd;
	}
	public void setCmntyMngCd(String cmntyMngCd) {
		this.cmntyMngCd = cmntyMngCd;
	}
	public LocalDateTime getFrsRegDt() {
		return frsRegDt;
	}
	public void setFrsRegDt(LocalDateTime frsRegDt) {
		this.frsRegDt = frsRegDt;
	}
	public LocalDateTime getLstMdtDt() {
		return lstMdtDt;
	}
	public void setLstMdtDt(LocalDateTime lstMdtDt) {
		this.lstMdtDt = lstMdtDt;
	}
	public int getCmntyMngNo() {
		return cmntyMngNo;
	}
	public void setCmntyMngNo(int cmntyMngNo) {
		this.cmntyMngNo = cmntyMngNo;
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
