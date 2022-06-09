package com.gdgs.slyouth.nt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdgs.slyouth.cm.service.CmVideoService;
import com.gdgs.slyouth.cm.utils.CmConvKeyUtils;
import com.gdgs.slyouth.cm.vo.CmVideoDVO;
import com.gdgs.slyouth.cm.vo.CmVideoSVO;
import com.gdgs.slyouth.nt.service.NtVideoService;
import com.gdgs.slyouth.nt.vo.NtVideoSVO;

/**
 * @title  : [커뮤니티] 영상 Service 구현 클래스
 * @author : 김모세
 * @create : 2021.08.01
 */
@Component
@Service("ntVideoService")
public class NtVideoServiceImpl implements NtVideoService {

	@Autowired
	private CmVideoService cmVideoService;

	/**
	 * @title	: 영상 정보 저장   
	 * @method	: videoSave()	 
	 * @comment	: 영상 정보를 등록 및 수정한다.
	 * @param	: CmVideoDVO
	 */
	@Override
	@Transactional
	public int videoSave(CmVideoDVO cmVideoDVO) throws Exception {
		return cmVideoService.videoSave(cmVideoDVO);
	}
	
	/**
	 * @title 	: 영상 정보 조회 페이지
	 * @method 	: videoList()
	 * @comment : 영상 정보 조회 화면으로 이동한다. (주일예배/특별집회)
	 * @param 	: CmVideoDVO
	 */
	@Override
	public NtVideoSVO selectVideoList(CmVideoDVO cmVideoDVO) throws Exception {
		NtVideoSVO returnSVO = new NtVideoSVO();

		// 영상 정보 조회
		CmVideoSVO cmVideoSVO = cmVideoService.selectVideoList(cmVideoDVO);

		returnSVO.setCmVideoSVO(cmVideoSVO);
		return returnSVO;
	}

	/**
	 * @title 	: 영상 정보(단건) 조회
	 * @method 	: selectVideo()
	 * @comment : 영상 정보 등록/수정 화면으로 이동한다. (주일예배/특별집회)
	 * @param 	: CmVideoDVO
	 */
	@Override
	public NtVideoSVO selectVideo(CmVideoDVO cmVideoDVO) throws Exception {
		NtVideoSVO returnSVO = new NtVideoSVO();
		CmVideoSVO cmVideoSVO = new CmVideoSVO();

		// 등록
		if ("I".equals(cmVideoDVO.getEditDivCd())) {
			cmVideoSVO.setCmVideoDVO(cmVideoDVO);
		} 
		// 수정
		else if ("U".equals(cmVideoDVO.getEditDivCd())) {
			cmVideoSVO = cmVideoService.selectVideo(cmVideoDVO);
		}
		
		// 등록, 수정 작업 시 필요한 메인 정보 설정
		cmVideoSVO.getCmVideoDVO().setVideoMainUrl(cmVideoDVO.getVideoMainUrl()); 	// 영상 메인 URL
		cmVideoSVO.getCmVideoDVO().setEditDivCd(cmVideoDVO.getEditDivCd());			// 작업 구분 코드
		cmVideoSVO.getCmVideoDVO().setVideoTypeCd(cmVideoDVO.getVideoTypeCd());		// 영상 타입 코드
		
		// 영상 타이틀 키 설정
		new CmConvKeyUtils().setVdTitKey(cmVideoSVO.getCmVideoDVO());

		returnSVO.setCmVideoSVO(cmVideoSVO);
		return returnSVO;
	}

	/**
	 * @title 	: 영상 정보 삭제
	 * @method 	: videoDel()
	 * @comment	: 영상 정보를 삭제한다.
	 * @param 	: CmVideoDVO
	 */
	@Override
	public int videoDel(CmVideoDVO cmVideoDVO) throws Exception {
		return cmVideoService.videoDel(cmVideoDVO);
	}
}
