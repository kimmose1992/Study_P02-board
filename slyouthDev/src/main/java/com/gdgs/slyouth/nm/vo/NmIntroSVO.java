package com.gdgs.slyouth.nm.vo;

import com.gdgs.slyouth.cm.vo.CmFileDVO;

/**
 * @title    : [새가족] 새가족조회 SVO 클래스 
 * @author   : 이하은
 * @create   : 2021.07.03
 */
public class NmIntroSVO {
	
	// 새가족소개 DVO
	private NmIntroDVO nmIntroDVO;
	
	// 파일첨부 DVO
	private CmFileDVO cmFileDVO;

	public NmIntroDVO getNmIntroDVO() {
		return nmIntroDVO;
	}

	public void setNmIntroDVO(NmIntroDVO nmIntroDVO) {
		this.nmIntroDVO = nmIntroDVO;
	}

	public CmFileDVO getCmFileDVO() {
		return cmFileDVO;
	}

	public void setCmFileDVO(CmFileDVO cmFileDVO) {
		this.cmFileDVO = cmFileDVO;
	}

}
