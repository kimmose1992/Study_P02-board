package com.gdgs.slyouth.cm.vo;

import java.util.List;

/**
 * @title   : [공통] 영상관리 SVO 클래스     
 * @author  : gypig
 * @create  : 2021.05.17
 */
public class CmVideoSVO extends CmBaseSVO {

	/**
	 * 영상 정보
	 */
	private CmVideoDVO cmVideoDVO;
	
	/**
	 * 영상 정보 리스트
	 */ 
	private List<CmVideoDVO> cmVideoDVOList;

	public CmVideoDVO getCmVideoDVO() {
		return cmVideoDVO;
	}

	public void setCmVideoDVO(CmVideoDVO cmVideoDVO) {
		this.cmVideoDVO = cmVideoDVO;
	}

	public List<CmVideoDVO> getCmVideoDVOList() {
		return cmVideoDVOList;
	}

	public void setCmVideoDVOList(List<CmVideoDVO> cmVideoDVOList) {
		this.cmVideoDVOList = cmVideoDVOList;
	}
	
	@Override
	public String toString() {
		return "CmVideoSVO [cmVideoDVO=" + cmVideoDVO + ", cmVideoDVOList=" + cmVideoDVOList + "]";
	}
}
