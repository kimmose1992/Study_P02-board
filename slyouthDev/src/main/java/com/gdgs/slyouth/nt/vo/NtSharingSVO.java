package com.gdgs.slyouth.nt.vo;

import java.util.List;

import com.gdgs.slyouth.cm.vo.CmPagingOutDVO;

/**
 * @title    : [커뮤니티] 나눔 SVO 클래스       
 * @author   : 신지현
 * @create   : 2021.06.09
 */
public class NtSharingSVO {
	
	/**
	 * 나눔 VO
	 */
	private NtSharingDVO ntSharingDVO;
	
	/**
	 * 나눔 리스트
	 */
	private List<NtSharingDVO> ntSharingDVOList;

	/**
	 * 페이징 출력 VO
	 */
	private CmPagingOutDVO cmPagingOutDVO;

	public List<NtSharingDVO> getNtSharingDVOList() {
		return ntSharingDVOList;
	}

	public void setNtSharingDVOList(List<NtSharingDVO> ntSharingDVOList) {
		this.ntSharingDVOList = ntSharingDVOList;
	}

	public NtSharingDVO getNtSharingDVO() {
		return ntSharingDVO;
	}

	public void setNtSharingDVO(NtSharingDVO ntSharingDVO) {
		this.ntSharingDVO = ntSharingDVO;
	}

	public CmPagingOutDVO getCmPagingOutDVO() {
		return cmPagingOutDVO;
	}

	public void setCmPagingOutDVO(CmPagingOutDVO cmPagingOutDVO) {
		this.cmPagingOutDVO = cmPagingOutDVO;
	}

}
