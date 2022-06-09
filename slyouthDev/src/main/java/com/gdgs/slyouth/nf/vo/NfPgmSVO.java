package com.gdgs.slyouth.nf.vo;

import java.util.List;

import com.gdgs.slyouth.cm.vo.CmFileDVO;
import com.gdgs.slyouth.cm.vo.CmPagingOutDVO;

/**
 * @title  : [양육과훈련] 프로그램 SVO 클래스
 * @author : 송근영
 * @create : 2021.08.02
 * @update : 2021.09.16
 */
public class NfPgmSVO {
	
	/**
	 * 프로그램 목록 
	 */
	private List<NfPgmDVO> pgmList;
	
	/**
	 * 프로그램 단건 
	 */
	private NfPgmDVO nfPgmDVO;
	
	/**
	 * 프로그램 첨부파일 조회
	 */
	private NfPgmDVO nfPgmFile;
	
	/**
	 * 프로그램 신청자 목록
	 */
	private List<NfPgmDVO> pgmAppMemberList;
	
	/**
	 * 프로그램 게시판 단건
	 */ 
	private NfPgmDVO nfPgmCmnty;
	
	/**
	 * 프로그램 게시판 첨부파일 
	 */
	private NfPgmDVO nfPgmCmntyFile;
	
	/**
	 * 프로그램 공지사항 목록
	 */
	private List<NfPgmDVO> nfPgmCmntyList;
	
	/**
	 * 프로그램 활동게시판 목록
	 */
	private List<NfPgmDVO> nfPgmActCmntyList;
	
	/**
	 * 페이징 출력 VO
	 */
	private CmPagingOutDVO cmPagingOutDVO;
	
	/**
	 * 첨부파일 VO
	 */
	private CmFileDVO cmFileDVO;

	public List<NfPgmDVO> getPgmList() {
		return pgmList;
	}

	public void setPgmList(List<NfPgmDVO> pgmList) {
		this.pgmList = pgmList;
	}

	public NfPgmDVO getNfPgmDVO() {
		return nfPgmDVO;
	}

	public void setNfPgmDVO(NfPgmDVO nfPgmDVO) {
		this.nfPgmDVO = nfPgmDVO;
	}

	public NfPgmDVO getNfPgmFile() {
		return nfPgmFile;
	}

	public void setNfPgmFile(NfPgmDVO nfPgmFile) {
		this.nfPgmFile = nfPgmFile;
	}

	public List<NfPgmDVO> getPgmAppMemberList() {
		return pgmAppMemberList;
	}

	public void setPgmAppMemberList(List<NfPgmDVO> pgmAppMemberList) {
		this.pgmAppMemberList = pgmAppMemberList;
	}

	public NfPgmDVO getNfPgmCmnty() {
		return nfPgmCmnty;
	}

	public void setNfPgmCmnty(NfPgmDVO nfPgmCmnty) {
		this.nfPgmCmnty = nfPgmCmnty;
	}

	public NfPgmDVO getNfPgmCmntyFile() {
		return nfPgmCmntyFile;
	}

	public void setNfPgmCmntyFile(NfPgmDVO nfPgmCmntyFile) {
		this.nfPgmCmntyFile = nfPgmCmntyFile;
	}

	public List<NfPgmDVO> getNfPgmCmntyList() {
		return nfPgmCmntyList;
	}

	public void setNfPgmCmntyList(List<NfPgmDVO> nfPgmCmntyList) {
		this.nfPgmCmntyList = nfPgmCmntyList;
	}

	public List<NfPgmDVO> getNfPgmActCmntyList() {
		return nfPgmActCmntyList;
	}

	public void setNfPgmActCmntyList(List<NfPgmDVO> nfPgmActCmntyList) {
		this.nfPgmActCmntyList = nfPgmActCmntyList;
	}

	public CmPagingOutDVO getCmPagingOutDVO() {
		return cmPagingOutDVO;
	}

	public void setCmPagingOutDVO(CmPagingOutDVO cmPagingOutDVO) {
		this.cmPagingOutDVO = cmPagingOutDVO;
	}

	public CmFileDVO getCmFileDVO() {
		return cmFileDVO;
	}

	public void setCmFileDVO(CmFileDVO cmFileDVO) {
		this.cmFileDVO = cmFileDVO;
	}
}
