package com.gdgs.slyouth.ws.vo;

import com.gdgs.slyouth.cm.vo.CmPagingOutDVO;
import com.gdgs.slyouth.cm.vo.CmVideoSVO;

/**
 * @title   : [예배영상] SVO 클래스     
 * @author  : 송근영
 * @create  : 2021.05.22
 */
public class WsVideoSVO {

	// 영상 SVO 
	private CmVideoSVO cmVideoSVO;
	
	// 페이징 DVO
	private CmPagingOutDVO cmPagingDVO;

	public CmVideoSVO getCmVideoSVO() {
		return cmVideoSVO;
	}

	public void setCmVideoSVO(CmVideoSVO cmVideoSVO) {
		this.cmVideoSVO = cmVideoSVO;
	}

	public CmPagingOutDVO getCmPagingDVO() {
		return cmPagingDVO;
	}

	public void setCmPagingDVO(CmPagingOutDVO cmPagingDVO) {
		this.cmPagingDVO = cmPagingDVO;
	}

	@Override
	public String toString() {
		return "WsWorshipSVO [cmVideoSVO=" + cmVideoSVO + ", cmPagingDVO=" + cmPagingDVO + "]";
	}
}
