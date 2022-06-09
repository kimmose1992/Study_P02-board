package com.gdgs.slyouth.um.vo;

import java.util.List;

import com.gdgs.slyouth.cm.vo.CmFileDVO;
import com.gdgs.slyouth.cm.vo.CmPagingOutDVO;
import com.gdgs.slyouth.wk.vo.WkVoluntaryDVO;

/**
 * @title   : [교적관리] SVO 클래스     
 * @author  : 송근영
 * @create  : 2021.06.24
 */
public class UmMemberSVO {
	
	/**
	 * 교적 단건
	 */
	private UmMemberDVO umMemberDVO;
	
	/**
	 * 교적 리스트
	 */
	private List<UmMemberDVO> umMemberDVOList;
	
	/**
	 * 페이징 출력 DVO
	 */
	private CmPagingOutDVO cmPagingOutDVO;
	
	/**
	 * 봉사부서 콤보
	 */
	private List<WkVoluntaryDVO> volDeptComboList;
	
	/**
	 * 파일 DVO
	 */
	private CmFileDVO cmFileDVO;
	

	public UmMemberDVO getUmMemberDVO() {
		return umMemberDVO;
	}

	public void setUmMemberDVO(UmMemberDVO umMemberDVO) {
		this.umMemberDVO = umMemberDVO;
	}

	public List<UmMemberDVO> getUmMemberDVOList() {
		return umMemberDVOList;
	}

	public void setUmMemberDVOList(List<UmMemberDVO> umMemberDVOList) {
		this.umMemberDVOList = umMemberDVOList;
	}

	public CmPagingOutDVO getCmPagingOutDVO() {
		return cmPagingOutDVO;
	}

	public void setCmPagingOutDVO(CmPagingOutDVO cmPagingOutDVO) {
		this.cmPagingOutDVO = cmPagingOutDVO;
	}

	public List<WkVoluntaryDVO> getVolDeptComboList() {
		return volDeptComboList;
	}

	public void setVolDeptComboList(List<WkVoluntaryDVO> volDeptComboList) {
		this.volDeptComboList = volDeptComboList;
	}

	public CmFileDVO getCmFileDVO() {
		return cmFileDVO;
	}

	public void setCmFileDVO(CmFileDVO cmFileDVO) {
		this.cmFileDVO = cmFileDVO;
	}
}
