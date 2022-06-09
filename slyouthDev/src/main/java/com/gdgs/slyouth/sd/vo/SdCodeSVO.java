package com.gdgs.slyouth.sd.vo;

import java.util.List;

import com.gdgs.slyouth.cm.vo.CmPagingOutDVO;

/**
 * @title	: [기준정보] 코드관리 SVO 클래스	  
 * @author	: mosekim
 * @create	: 2021.05.01
 */
public class SdCodeSVO {

	/**
	 * 페이징 출력 VO
	 */
	private CmPagingOutDVO cmPagingOutDVO;
	
	/**
	 * 코드관리 VO
	 */
	private SdCodeDVO sdCodeDVO;
	
	/**
	 * 코드관리 조회 리스트
	 */
	private List<SdCodeDVO> sdCodeDVOList;

	public CmPagingOutDVO getCmPagingOutDVO() {
		return cmPagingOutDVO;
	}

	public void setCmPagingOutDVO(CmPagingOutDVO cmPagingOutDVO) {
		this.cmPagingOutDVO = cmPagingOutDVO;
	}

	public SdCodeDVO getSdCodeDVO() {
		return sdCodeDVO;
	}

	public void setSdCodeDVO(SdCodeDVO sdCodeDVO) {
		this.sdCodeDVO = sdCodeDVO;
	}

	public List<SdCodeDVO> getSdCodeDVOList() {
		return sdCodeDVOList;
	}

	public void setSdCodeDVOList(List<SdCodeDVO> sdCodeDVOList) {
		this.sdCodeDVOList = sdCodeDVOList;
	}
	
}
