package com.gdgs.slyouth.nt.vo;

import java.util.List;

import com.gdgs.slyouth.cm.vo.CmFileDVO;
import com.gdgs.slyouth.cm.vo.CmPagingOutDVO;

/**
 * @title   : [커뮤니티] 동아리 SVO 클래스     
 * @author  : 송근영
 * @create  : 2021.07.25
 * @update  : 2021.08.16
 */
public class NtCircleSVO {

	/**
	 * 동아리 단건
	 */ 
	private NtCircleDVO ntCircleDVO;
	
	/**
	 * 동아리 목록
	 */
	private List<NtCircleDVO> ntCircleList;
	
	/**
	 * 동아리 첨부파일 
	 */
	private NtCircleDVO ntCircleFile;
	
	/**
	 * 동아리 신청자 목록
	 */
	private List<NtCircleDVO> ntCircleAppMemberList;
	
	/**
	 * 동아리 게시판 단건
	 */ 
	private NtCircleDVO ntCircleCmnty;
	
	/**
	 * 동아리 게시판 목록
	 */
	private List<NtCircleDVO> ntCircleCmntyList;
	
	/**
	 * 동아리 게시판 첨부파일 
	 */
	private NtCircleDVO ntCircleCmntyFile;
	
	/**
	 * 페이징 출력 VO
	 */
	private CmPagingOutDVO cmPagingOutDVO;
	
	/**
	 * 첨부파일 VO
	 */
	private CmFileDVO cmFileDVO;

	public NtCircleDVO getNtCircleDVO() {
		return ntCircleDVO;
	}

	public void setNtCircleDVO(NtCircleDVO ntCircleDVO) {
		this.ntCircleDVO = ntCircleDVO;
	}

	public List<NtCircleDVO> getNtCircleList() {
		return ntCircleList;
	}

	public void setNtCircleList(List<NtCircleDVO> ntCircleList) {
		this.ntCircleList = ntCircleList;
	}

	public NtCircleDVO getNtCircleFile() {
		return ntCircleFile;
	}

	public void setNtCircleFile(NtCircleDVO ntCircleFile) {
		this.ntCircleFile = ntCircleFile;
	}

	public List<NtCircleDVO> getNtCircleAppMemberList() {
		return ntCircleAppMemberList;
	}

	public void setNtCircleAppMemberList(List<NtCircleDVO> ntCircleAppMemberList) {
		this.ntCircleAppMemberList = ntCircleAppMemberList;
	}

	public NtCircleDVO getNtCircleCmnty() {
		return ntCircleCmnty;
	}

	public void setNtCircleCmnty(NtCircleDVO ntCircleCmnty) {
		this.ntCircleCmnty = ntCircleCmnty;
	}

	public List<NtCircleDVO> getNtCircleCmntyList() {
		return ntCircleCmntyList;
	}

	public void setNtCircleCmntyList(List<NtCircleDVO> ntCircleCmntyList) {
		this.ntCircleCmntyList = ntCircleCmntyList;
	}

	public NtCircleDVO getNtCircleCmntyFile() {
		return ntCircleCmntyFile;
	}

	public void setNtCircleCmntyFile(NtCircleDVO ntCircleCmntyFile) {
		this.ntCircleCmntyFile = ntCircleCmntyFile;
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
