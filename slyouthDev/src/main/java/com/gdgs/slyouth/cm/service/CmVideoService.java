package com.gdgs.slyouth.cm.service;

import com.gdgs.slyouth.cm.vo.CmVideoDVO;
import com.gdgs.slyouth.cm.vo.CmVideoSVO;

/**
 * @title   : [공통] 영상관리 Service 인터페이스     
 * @author  : 송근영
 * @create  : 2021.05.15
 */
public interface CmVideoService {

	/**
	 * @title   : 영상 리스트 조회        
	 * @method  : selectVideoList()    
	 * @comment : DB에서 메인 페이지에 그려질 상단영상과 영상리스트를 가져옵니다.       
	 * @param   : CmVideoDVO
	 */
	public CmVideoSVO selectVideoList(CmVideoDVO cmVideoDVO) throws Exception;

	/**
	 * @title 	: 영상 정보(단건) 조회
	 * @method 	: selectVideo()
	 * @comment : 영상 정보를 조회한다. 
	 * @param 	: CmVideoDVO
	 */
	public CmVideoSVO selectVideo(CmVideoDVO cmVideoDVO) throws Exception;

	/**
	 * @title	: 영상 정보 저장	  
	 * @method	: videoSave	 
	 * @comment	: 영상 정보를 등록 및 수정한다.		 
	 * @param	: cmVideoDVO
	 */
	public int videoSave(CmVideoDVO cmVideoDVO) throws Exception;

	/**
	 * @title 	: 영상 정보 삭제
	 * @method 	: videoDel()
	 * @comment	: 영상 정보를 삭제한다.
	 * @param 	: CmVideoDVO
	 */
	public int videoDel(CmVideoDVO cmVideoDVO) throws Exception;
}
