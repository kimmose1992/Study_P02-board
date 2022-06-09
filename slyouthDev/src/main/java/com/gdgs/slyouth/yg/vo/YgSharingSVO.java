package com.gdgs.slyouth.yg.vo;

import java.util.List;

import com.gdgs.slyouth.cm.vo.CmPagingOutDVO;

public class YgSharingSVO {
	private CmPagingOutDVO	cmPagingOutDVO;
	private YgSharingDVO ygSharingDVO;
	private List<YgSharingDVO> ygSharingDVOList;
	
	public CmPagingOutDVO getCmPagingOutDVO() {
		return cmPagingOutDVO;
	}
	public void setCmPagingOutDVO(CmPagingOutDVO cmPagingOutDVO) {
		this.cmPagingOutDVO = cmPagingOutDVO;
	}
	public YgSharingDVO getYgSharingDVO() {
		return ygSharingDVO;
	}
	public void setYgSharingDVO(YgSharingDVO ygSharingDVO) {
		this.ygSharingDVO = ygSharingDVO;
	}
	public List<YgSharingDVO> getYgSharingDVOList() {
		return ygSharingDVOList;
	}
	public void setYgSharingDVOList(List<YgSharingDVO> ygSharingDVOList) {
		this.ygSharingDVOList = ygSharingDVOList;
	}
	
	
}
