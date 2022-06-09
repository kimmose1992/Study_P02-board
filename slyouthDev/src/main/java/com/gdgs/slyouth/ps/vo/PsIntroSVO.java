package com.gdgs.slyouth.ps.vo;

import com.gdgs.slyouth.cm.vo.CmFileDVO;

/**
 * @title   : [찬양과셀라] 셀라소개 SVO 클래스     
 * @author  : 김예림
 * @create  : 2021.07.03
 * @update	: 2021.07.17
 */
public class PsIntroSVO {
	
	// 셀라소개 DVO
	private PsIntroDVO psIntroDVO;

	// 파일첨부 DVO
	private CmFileDVO cmFileDVO;

	public PsIntroDVO getPsIntroDVO() {
		return psIntroDVO;
	}

	public void setPsIntroDVO(PsIntroDVO psIntroDVO) {
		this.psIntroDVO = psIntroDVO;
	}

	public CmFileDVO getCmFileDVO() {
		return cmFileDVO;
	}

	public void setCmFileDVO(CmFileDVO cmFileDVO) {
		this.cmFileDVO = cmFileDVO;
	}
	
}
