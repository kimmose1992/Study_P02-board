package com.gdgs.slyouth.nm.vo;

import java.util.List;

import com.gdgs.slyouth.cm.vo.CmPagingOutDVO;

/**
 * @title : [새가족교재] 새가족교재 SVO 클래스
 * @author : 이하은
 * @create : 2021.07.18
 */

public class NmBookSVO {

	/**
	 * 새가족교재 VO
	 */
	private NmBookDVO nmBookDVO;

	/**
	 * 새가족교재 리스트
	 */
	private List<NmBookDVO> nmBookDVOList;

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

	public NmBookDVO getNmBookDVO() {
		return nmBookDVO;
	}

	public void setNmBookDVO(NmBookDVO nmBookDVO) {
		this.nmBookDVO = nmBookDVO;
	}
	
	public List<NmBookDVO> getNmBookDVOList() {
		return nmBookDVOList;
	}

	public void setNmBookDVOList(List<NmBookDVO> nmBookDVOList) {
		this.nmBookDVOList = nmBookDVOList;
	}

}
