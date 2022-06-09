package com.gdgs.slyouth.ws.service;

import com.gdgs.slyouth.cm.vo.CmVideoDVO;
import com.gdgs.slyouth.ws.vo.WsVideoSVO;

/**
 * @title   : [예배영상] Service 클래스
 * @author  : 송근영
 * @create  : 2021.05.22
 * @update  : 2021.07.09
 */
public interface WsVideoService {

	/**
	 * @title	: 영상 정보 저장   
	 * @method	: videoSave()	 
	 * @comment	: 영상 정보를 등록 및 수정한다.
	 * @param	: CmVideoDVO
	 */
	public int videoSave(CmVideoDVO cmVideoDVO) throws Exception;
	
	/**
	 * @title 	: 영상 정보(리스트) 조회 페이지
	 * @method 	: videoList()
	 * @comment : 영상 정보 조회 화면으로 이동한다. (주일예배/특별집회)
	 * @param 	: CmVideoDVO
	 */
	public WsVideoSVO selectVideoList(CmVideoDVO cmVideoDVO) throws Exception;

	/**
	 * @title 	: 영상 정보(단건) 조회
	 * @method 	: selectVideo()
	 * @comment : 영상 정보 등록/수정 화면으로 이동한다. (주일예배/특별집회)
	 * @param 	: CmVideoDVO
	 */
	public WsVideoSVO selectVideo(CmVideoDVO cmVideoDVO) throws Exception;

	/**
	 * @title 	: 영상 정보 삭제
	 * @method 	: videoDel()
	 * @comment	: 영상 정보를 삭제한다.
	 * @param 	: CmVideoDVO
	 */
	public int videoDel(CmVideoDVO cmVideoDVO) throws Exception;
}
