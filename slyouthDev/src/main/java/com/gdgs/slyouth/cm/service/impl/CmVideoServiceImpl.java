package com.gdgs.slyouth.cm.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gdgs.slyouth.cm.service.CmVideoService;
import com.gdgs.slyouth.cm.service.dao.CmVideoDAO;
import com.gdgs.slyouth.cm.utils.CmConvKeyUtils;
import com.gdgs.slyouth.cm.vo.CmVideoDVO;
import com.gdgs.slyouth.cm.vo.CmVideoSVO;

/**
 * @title   : [공통] 영상관리 Service 구현
 * @author  : 송근영
 * @create  : 2021.04.30
 * @update  : 2021.06.30
 */
@Component
@Service("cmVideoService")
public class CmVideoServiceImpl implements CmVideoService {
	
	private static final Logger logger = LoggerFactory.getLogger(CmVideoServiceImpl.class);
    
	@Autowired
	private CmVideoDAO cmVideoDAO;
	
	/**
	 * @title   : 영상 리스트 조회        
	 * @method  : selectVideoList()    
	 * @comment : DB에서 메인 페이지에 그려질 상단영상과 영상리스트를 가져옵니다.       
	 * @param   : CmVideoDVO
	 */
	@Override
	public CmVideoSVO selectVideoList(CmVideoDVO cmVideoDVO) throws Exception {
		
		CmVideoSVO returnSVO = new CmVideoSVO();
		
		// 상단 영상 메인
		CmVideoDVO videoMain = null;
		
		// 하단 영상 리스트
		List<CmVideoDVO> videoList = cmVideoDAO.selectVideoList(cmVideoDVO);
		
		// 영상 타이틀 설정
		if (videoList != null && videoList.size() > 0) {
			
			CmConvKeyUtils cmConvKeyUtils = new CmConvKeyUtils();
			
			// 하단 영상
			for(CmVideoDVO video : videoList) {
				cmConvKeyUtils.setVdTitKey(video);
			}
			
			// 리스트 상단 영상 설정 (기본값 첫번째 영상)
			videoMain = videoList.get(0);
			
			// 수정 작업에서 넘어온 경우, 영상 번호에 해당하는 영상으로 설정
			if ("U".equals(cmVideoDVO.getEditDivCd())) {
				for(CmVideoDVO video : videoList) {
					if (video.getVideoNo() == cmVideoDVO.getVideoNo()) {
						videoMain = video;
						break;
					}
				}
			}
		}
		
		returnSVO.setCmVideoDVO(videoMain); 
		returnSVO.setCmVideoDVOList(videoList);
		return returnSVO;
	}

	@Override
	public CmVideoSVO selectVideo(CmVideoDVO cmVideoDVO) throws Exception {
		CmVideoSVO returnSVO = new CmVideoSVO();
		
		// 해당하는 영상 데이터 가져오기
		CmVideoDVO video = cmVideoDAO.selectVideo(cmVideoDVO);
		
		// 가져온 영상데이터의 유투브 주소를 수정 페이지에서 보여질 url로 값 만들기
		video.setYtbAdr("https://www.youtube.com/watch?v=" + video.getYtbAdr());
		
		returnSVO.setCmVideoDVO(video);
		return returnSVO;
	}

	/**
	 * @title	: 영상 정보 저장	  
	 * @method	: videoSave	 
	 * @comment	: 영상 정보를 등록 및 수정한다.		 
	 * @param	: cmVideoDVO
	 */
	@Override
	public int videoSave(CmVideoDVO cmVideoDVO) throws Exception {
		
		int resultCnt = 0;
		
		try {
			// 유튜브 ID & 썸네일 생성
			String ytbFullAdr = cmVideoDVO.getYtbAdr();
			
			// 유튜브 ID
			String ytbRealAdr = null;
			
			// 입력받은 유튜브 URL 형식에 따른 분기
			if (ytbFullAdr.indexOf("&") < 0) {
				
				// 입력받은 youtube url 주소가 바뀌지 않고 그대로 입력된 경우 및 시크릿모드
				ytbRealAdr = ytbFullAdr.substring(ytbFullAdr.indexOf("=") + 1); 
			} else {
				
				// 입력받은 youtube url 주소가 새로운 full 경로인 경우
				ytbRealAdr = ytbFullAdr.substring(ytbFullAdr.indexOf("=") + 1, ytbFullAdr.indexOf("&")); 
			}
			
			// 유튜브 재생에 필요한 실제 ID 값 설정
			cmVideoDVO.setYtbAdr(ytbRealAdr);
			
			// 유튜브 썸네일 설정
			cmVideoDVO.setYtbThumbAdr("https://img.youtube.com/vi/" + ytbRealAdr + "/mqdefault.jpg");
			
			// 등록
			if ("I".equals(cmVideoDVO.getEditDivCd())) {
				resultCnt = cmVideoDAO.insertVideo(cmVideoDVO);
			}
			// 수정
			else if ("U".equals(cmVideoDVO.getEditDivCd())) {
				resultCnt = cmVideoDAO.updateVideo(cmVideoDVO);
			}
			
		} catch (Exception e) {
			logger.debug("########################################");
			logger.debug("영상 저장에 실패하셨습니다.");
			logger.debug("########################################");
		}
		
		return resultCnt;
	}

	@Override
	public int videoDel(CmVideoDVO cmVideoDVO) throws Exception {
		
		int resultCnt = 0;
		
		try {
			resultCnt = cmVideoDAO.deleteVideo(cmVideoDVO);
		} catch (Exception e) {
			logger.debug("########################################");
			logger.debug("영상 삭제에 실패하셨습니다.");
			logger.debug("########################################");
		}
		
		return resultCnt;
	}
}
