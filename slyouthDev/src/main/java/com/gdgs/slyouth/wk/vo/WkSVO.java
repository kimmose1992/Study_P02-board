package com.gdgs.slyouth.wk.vo;

import java.util.List;

import com.gdgs.slyouth.cm.vo.CmPagingOutDVO;

/**
 * @title   : [업무] 전체 SVO 클래스     
 * @author  : gypig
 * @create  : 2021.06.24
 */
public class WkSVO {

	/**
	 * 봉사부서 조회 리스트
	 */
	private List<WkVoluntaryDVO> wkVoluntaryDVOList;
	
	/**
	 * 봉사부서 단건 데이터
	 */
	private WkVoluntaryDVO wkVoluntaryDVO;
	
	/**
	 * 페이징 출력 VO
	 */
	private CmPagingOutDVO cmPagingOutDVO;

	public List<WkVoluntaryDVO> getWkVoluntaryDVOList() {
		return wkVoluntaryDVOList;
	}

	public void setWkVoluntaryDVOList(List<WkVoluntaryDVO> wkVoluntaryDVOList) {
		this.wkVoluntaryDVOList = wkVoluntaryDVOList;
	}

	public WkVoluntaryDVO getWkVoluntaryDVO() {
		return wkVoluntaryDVO;
	}

	public void setWkVoluntaryDVO(WkVoluntaryDVO wkVoluntaryDVO) {
		this.wkVoluntaryDVO = wkVoluntaryDVO;
	}

	public CmPagingOutDVO getCmPagingOutDVO() {
		return cmPagingOutDVO;
	}

	public void setCmPagingOutDVO(CmPagingOutDVO cmPagingOutDVO) {
		this.cmPagingOutDVO = cmPagingOutDVO;
	}
}
