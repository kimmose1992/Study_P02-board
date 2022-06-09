package com.gdgs.slyouth.nt.vo;

import java.util.List;

import com.gdgs.slyouth.cm.vo.CmPagingOutDVO;

/**
 * @title    : [커뮤니티] 공지사항 SVO 클래스     
 * @author   : 신지현
 * @create   : 2021.05.15
 */

public class NtNoticeSVO {
	
	/**
	 * 공지사항 VO
	 */
	private NtNoticeDVO ntNoticeDVO;
	
	/**
	 * 공지사항 리스트
	 */
	private List<NtNoticeDVO> ntNoticeDVOList;
	
	/**
	 * 공지사항 상단리스트
	 */
	private List<NtNoticeDVO> ntNoticeDVOTopList;
	
	public List<NtNoticeDVO> getNtNoticeDVOTopList() {
		return ntNoticeDVOTopList;
	}

	public void setNtNoticeDVOTopList(List<NtNoticeDVO> ntNoticeDVOTopList) {
		this.ntNoticeDVOTopList = ntNoticeDVOTopList;
	}

	/**
	 * 페이징 출력 VO
	 */
	private CmPagingOutDVO cmPagingOutDVO;

	public CmPagingOutDVO getCmPagingOutDVO() {
		return cmPagingOutDVO;
	}

	public void setCmPagingOutDVO(CmPagingOutDVO cmPagingOutDVO) {
		this.cmPagingOutDVO = cmPagingOutDVO;
	}

	public NtNoticeDVO getNtNoticeDVO() {
		return ntNoticeDVO;
	}

	public void setNtNoticeDVO(NtNoticeDVO ntNoticeDVO) {
		this.ntNoticeDVO = ntNoticeDVO;
	}

	public List<NtNoticeDVO> getNtNoticeDVOList() {
		return ntNoticeDVOList;
	}

	public void setNtNoticeDVOList(List<NtNoticeDVO> ntNoticeDVOList) {
		this.ntNoticeDVOList = ntNoticeDVOList;
	}
	
}
