package com.gdgs.slyouth.cm.service.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.gdgs.slyouth.cm.vo.CmFileDVO;

/**
 * @title	: [공통] 파일관리 DAO 클래스	  
 * @author	: mosekim
 * @create	: 2021.06.16
 */
@Component
@Repository("cmFileDAO")
public class CmFileDAO extends AbstractDAO {

	private static final String NAMESPACE = "cm.file.";

	/**
	 * @title	: 파일업로드 정보 저장	  
	 * @method	: saveFile() 	 
	 * @comment	: 파일업로드 정보를 저장한다.		 
	 * @param	: cmFileDVO
	 * @return  : fileSeq
	 */
	public int saveFileInfo(CmFileDVO cmFileDVO) {
		return (int) insert(NAMESPACE + "saveFileInfo", cmFileDVO);
	}

	/**
	 * @title	: 파일정보 조회 	  
	 * @method	: selectFileInfoNo	 
	 * @comment	: 첨부파일번호로 파일정보 조회 
	 * @param	: cmFileDVO
	 * @return	: cmFileDVO
	 */
	public CmFileDVO selectFileInfoNo(CmFileDVO cmFileDVO) {
		return (CmFileDVO) select(NAMESPACE + "selectFileInfoNo", cmFileDVO);
	}

	/**
	 * @title	: 파일정보 조회 	  
	 * @method	: selectFileInfoRef	 
	 * @comment	: 참조키로 파일정보 조회 
	 * @param	: cmFileDVO
	 * @return	: cmFileDVO
	 */
	public CmFileDVO selectFileInfoRef(CmFileDVO cmFileDVO) {
		return (CmFileDVO) select(NAMESPACE + "selectFileInfoRef", cmFileDVO);
	}

	/**
	 * @title	: 파일정보 삭제 	  
	 * @method	: selectFileInfoRef	 
	 * @comment	: 첨부파일번호로 파일정보 삭제 
	 * @param	: cmFileDVO
	 * @return	: cmFileDVO
	 */
	public void deleteFileInfoNo(CmFileDVO cmFileDVO) {
		delete(NAMESPACE + "deleteFileInfoNo", cmFileDVO);
	}
	
}
