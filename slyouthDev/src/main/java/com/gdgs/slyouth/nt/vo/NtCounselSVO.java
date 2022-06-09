package com.gdgs.slyouth.nt.vo;

import java.util.List;

import com.gdgs.slyouth.cm.vo.CmPagingOutDVO;

/**
 * @title	: [커뮤니티] 상담 SVO 클래스  
 * @author	: srar2
 * @create	: 2021. 6. 26.
 */
public class NtCounselSVO {
	
	/**
	 * 페이징 출력 VO
	 */
	private CmPagingOutDVO cmPagingOutDVO;
	
	/**
	 * 상담 VO
	 */
	private NtCounselDVO ntCounselDVO;
	
	/**
	 * 상담 조회 리스트
	 */
	private List<NtCounselDVO> ntCounselDVOList;

	public CmPagingOutDVO getCmPagingOutDVO() {
		return cmPagingOutDVO;
	}

	public void setCmPagingOutDVO(CmPagingOutDVO cmPagingOutDVO) {
		this.cmPagingOutDVO = cmPagingOutDVO;
	}

	public NtCounselDVO getNtCounselDVO() {
		return ntCounselDVO;
	}

	public void setNtCounselDVO(NtCounselDVO ntCounselDVO) {
		this.ntCounselDVO = ntCounselDVO;
	}

	public List<NtCounselDVO> getNtCounselDVOList() {
		return ntCounselDVOList;
	}

	public void setNtCounselDVOList(List<NtCounselDVO> ntCounselDVOList) {
		this.ntCounselDVOList = ntCounselDVOList;
	}
}
