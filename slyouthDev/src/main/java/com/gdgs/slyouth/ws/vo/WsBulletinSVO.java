package com.gdgs.slyouth.ws.vo;

import java.util.List;

import com.gdgs.slyouth.cm.vo.CmFileDVO;
import com.gdgs.slyouth.cm.vo.CmPagingOutDVO;

/**
 * @title	: [예배와찬양] 주보 SVO 클래스	  
 * @author	: srar2
 * @create	: 2021.05.20
 */
public class WsBulletinSVO {
	
	// 페이징 출력 VO
	private CmPagingOutDVO cmPagingOutDVO;
	
	// 주보 VO
	private WsBulletinDVO wsBulletinDVO;
	
	// 첨부파일 VO 
	private CmFileDVO cmFileDVO;
	
	// 주보 조회 리스트
	private List<WsBulletinDVO> wsBulletinDVOList;
	
	// 주보 첨부파일
	private List<WsBulletinDVO> wsBulletinFile;

	public CmPagingOutDVO getCmPagingOutDVO() {
		return cmPagingOutDVO;
	}

	public void setCmPagingOutDVO(CmPagingOutDVO cmPagingOutDVO) {
		this.cmPagingOutDVO = cmPagingOutDVO;
	}

	public WsBulletinDVO getWsBulletinDVO() {
		return wsBulletinDVO;
	}

	public void setWsBulletinDVO(WsBulletinDVO wsBulletinDVO) {
		this.wsBulletinDVO = wsBulletinDVO;
	}

	public CmFileDVO getCmFileDVO() {
		return cmFileDVO;
	}

	public void setCmFileDVO(CmFileDVO cmFileDVO) {
		this.cmFileDVO = cmFileDVO;
	}

	public List<WsBulletinDVO> getWsBulletinDVOList() {
		return wsBulletinDVOList;
	}

	public void setWsBulletinDVOList(List<WsBulletinDVO> wsBulletinDVOList) {
		this.wsBulletinDVOList = wsBulletinDVOList;
	}

	public List<WsBulletinDVO> getWsBulletinFile() {
		return wsBulletinFile;
	}

	public void setWsBulletinFile(List<WsBulletinDVO> wsBulletinFile) {
		this.wsBulletinFile = wsBulletinFile;
	}
}
