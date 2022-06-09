package com.gdgs.slyouth.cm.vo;

import java.time.LocalDateTime;

import org.springframework.web.multipart.MultipartFile;

/**
 * @title	: [공통] 파일첨부 DVO 클래스	  
 * @author	: mosekim
 * @create	: 2021.06.09
 */
public class CmFileDVO {
	
	/** 테이블 변수 */
	private int fileNo;			            // 파일번호
	private int refNo;			            // 참조번호
	private String refDivCd;	            // 참조구분코드
	private String refTbKey;	            // 참조테이블키
	private String fileNm;		            // 파일명
	private String fileType;	            // 파일타입
	private long fileSize;		            // 파일크기
	private String savePth;		            // 저장경로
	private String saveFileNm;			    // 저장파일명
	private String downCnt;				    // 다운로드횟수
	private String tmpFileId;				// 임시파일ID
	private LocalDateTime fileRegDt;		// 파일등록일시
	
	/** 입력 변수 */
	private MultipartFile uploadFile;		// 첨부파일 (단건)
	private MultipartFile[] uploadFiles;	// 첨부파일 (다건)

	/** 출력 변수 */
	private String fileUrl;					// 파일 URL

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
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

	public String getFileNm() {
		return fileNm;
	}

	public void setFileNm(String fileNm) {
		this.fileNm = fileNm;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public String getSavePth() {
		return savePth;
	}

	public void setSavePth(String savePth) {
		this.savePth = savePth;
	}

	public String getSaveFileNm() {
		return saveFileNm;
	}

	public void setSaveFileNm(String saveFileNm) {
		this.saveFileNm = saveFileNm;
	}

	public String getDownCnt() {
		return downCnt;
	}

	public void setDownCnt(String downCnt) {
		this.downCnt = downCnt;
	}

	public String getTmpFileId() {
		return tmpFileId;
	}

	public void setTmpFileId(String tmpFileId) {
		this.tmpFileId = tmpFileId;
	}

	public LocalDateTime getFileRegDt() {
		return fileRegDt;
	}

	public void setFileRegDt(LocalDateTime fileRegDt) {
		this.fileRegDt = fileRegDt;
	}

	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	public MultipartFile[] getUploadFiles() {
		return uploadFiles;
	}

	public void setUploadFiles(MultipartFile[] uploadFiles) {
		this.uploadFiles = uploadFiles;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	
}
