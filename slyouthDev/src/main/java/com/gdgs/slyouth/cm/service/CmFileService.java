package com.gdgs.slyouth.cm.service;


import org.springframework.core.io.Resource;

import com.gdgs.slyouth.cm.vo.CmFileDVO;

/**
 * @title	: [공통] 파일관리 Service 인터페이스	  
 * @author	: mosekim
 * @create	: 2021.06.11
 */
public interface CmFileService {

	/**
	 * @title	: 첨부파일 업로드
	 * @method	: uploadFile()
	 * @comment	: 첨부파일 업로드
	 * @param	: cmFileDVO
	 * @return	: cmFileDVO
	 */
	public CmFileDVO uploadFile(CmFileDVO cmFileDVO) throws Exception;
	
	/**
	 * @title	: 썸머노트 이미지 업로드
	 * @method	: uploadSummernoteImageFile()
	 * @comment	: 썸머노트 이미지 업로드 
	 * @param	: cmFileDVO
	 * @return	: cmFileDVO
	 */
	public CmFileDVO uploadSummernoteImageFile(CmFileDVO cmFileDVO) throws Exception;

	/**
	 * @title	: 파일 정보 조회 	  
	 * @method	: selectFileInfoNo	 
	 * @comment	: 첨부파일번호로 파일정보 조회 
	 * @param	: cmFileDVO
	 * @return	: cmFileDVO
	 */
	public CmFileDVO selectFileInfoNo(CmFileDVO cmFileDVO) throws Exception;

	/**
	 * @title	: 파일 리소스 읽기 및 반환
	 * @method	: loadAsResource	 
	 * @comment	: 저장된 파일명으로 파일 리소스를 읽어서 반환한다.		 
	 * @param	: saveFileNm
	 * @return	: Resource
	 */
	public Resource loadAsResource(String saveFileNm) throws Exception;

	/**
	 * @title	: 파일 정보 조회 	  
	 * @method	: selectFileInfoRef	 
	 * @comment	: 참조키로 파일정보 조회 
	 * @param	: cmFileDVO
	 * @return	: cmFileDVO
	 */
	public CmFileDVO selectFileInfoRef(CmFileDVO cmFileDVO) throws Exception;

	/**
	 * @title	: 첨부파일정보 삭제
	 * @method	: deleteFileInfo	 
	 * @comment	: 첨부파일 정보와 실제 업로드된 파일을 삭제한다.
	 * @param	: cmFileDVO
	 * @return	: N/A
	 */
	public void deleteFileInfo(CmFileDVO cmFileDVO) throws Exception;

}
