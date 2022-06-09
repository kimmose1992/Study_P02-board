package com.gdgs.slyouth.ws.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdgs.slyouth.cm.service.CmFileService;
import com.gdgs.slyouth.cm.vo.CmFileDVO;
import com.gdgs.slyouth.cm.vo.CmPagingOutDVO;
import com.gdgs.slyouth.ws.service.WsBulletinService;
import com.gdgs.slyouth.ws.service.dao.WsBulletinDAO;
import com.gdgs.slyouth.ws.vo.WsBulletinDVO;
import com.gdgs.slyouth.ws.vo.WsBulletinSVO;

/**
 * @title   : 주보 Service 구현 클래스     
 * @author  : srar2
 * @create  : 2021.04.29
 */
@Component
@Service("wsBulletinService")
public class WsBulletinServiceImpl implements WsBulletinService {
	
	private static final Logger logger = LoggerFactory.getLogger(WsBulletinServiceImpl.class);
	
	@Autowired
	private WsBulletinDAO wsBulletinDAO;
	
	@Autowired 
	private CmFileService cmFileService;
	
	/**
	 * @title : 주보 리스트 데이터 조회
	 * @method : bulletinList()
	 * @comment : 주보 게시판의 게시물을 조회할 수 있도록 데이터를 가져온다.
	 * @param : WsBulletinDVO
	 */
	@Override
	public WsBulletinSVO bulletinList(WsBulletinDVO wsBulletinDVO) throws Exception {
		WsBulletinSVO returnSVO = new WsBulletinSVO();
		
		// 리스트 초기화
		List<WsBulletinDVO> wsBulletinList = null;
		
		int totalDataCnt = wsBulletinDAO.selectBulletinTotalDataCnt(wsBulletinDVO);
		
		if(totalDataCnt > 0) {
			
			// 주보 목록 조회
			wsBulletinList = wsBulletinDAO.bulletinList(wsBulletinDVO);
			
			// 페이징 설정
			CmPagingOutDVO cmPagingOutDVO = new CmPagingOutDVO(wsBulletinDVO);
			cmPagingOutDVO.setTotalDataCnt(totalDataCnt);
			returnSVO.setCmPagingOutDVO(cmPagingOutDVO);
		}
		
		returnSVO.setWsBulletinDVO(wsBulletinDVO);
		returnSVO.setWsBulletinDVOList(wsBulletinList);
		return returnSVO;
	}

	/**
	 * @title : 주보 등록&수정
	 * @method : bulletinSave()
	 * @comment : 주보를 등록&수정합니다.
	 * @param : WsBulletinSVO
	 */
	@Override
	@Transactional
	public WsBulletinDVO bulletinSave(WsBulletinSVO wsBulletinSVO) throws Exception{
		WsBulletinDVO returnDVO = new WsBulletinDVO();
		CmFileDVO cmFileDVO = wsBulletinSVO.getCmFileDVO();
		
		// 파일정보 객체
		CmFileDVO orgFileInfo;
		CmFileDVO chgFileInfo;
		
		try {
			int resultCnt = 0;
			int cmntyNo = wsBulletinSVO.getWsBulletinDVO().getCmntyNo();
			
			if(cmntyNo == 0) {
				// 주보 등록
				resultCnt = wsBulletinDAO.bulletinRegist(wsBulletinSVO.getWsBulletinDVO());
				
				// 주보 등록시 생성되는 커뮤니티 번호
				int registNo = wsBulletinSVO.getWsBulletinDVO().getCmntyNo();
				// 주보 정상등록 확인
				if(registNo == 0) {
					throw new Exception();
				}
				
				// 등록된 주보 번호를 첨부파일 참조번호에 세팅
				cmFileDVO.setRefNo(registNo);
				
				if (resultCnt > 0) {
					// 변경 이미지 업로드
					chgFileInfo = cmFileService.uploadFile(cmFileDVO);
					
					int chgFileNo = chgFileInfo.getFileNo(); 
					logger.debug("upload FileNo :: " + chgFileNo);
				} else {
					throw new Exception();
				}
			}else {
				// 주보 수정
				resultCnt = wsBulletinDAO.bulletinUpdate(wsBulletinSVO.getWsBulletinDVO());
				returnDVO.setCmntyNo(cmntyNo);
				
				if(resultCnt > 0) {
					// 기존 파일번호 조회
					orgFileInfo = cmFileService.selectFileInfoRef(cmFileDVO);
					
					// 변경 이미지 업로드
					chgFileInfo = cmFileService.uploadFile(cmFileDVO);
					
					int chgFileNo = chgFileInfo.getFileNo();
					logger.debug("upload FileNo ::" + chgFileNo);
					
					// 업로드 성공 시, 기존 이미지 삭제
					if(chgFileNo != 0) {
						returnDVO.setFileNo(chgFileNo);
						cmFileService.deleteFileInfo(orgFileInfo);
					} else {
						throw new Exception();
					}
				}
			}
	
			returnDVO.setResultCnt(resultCnt);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return returnDVO;
	}
	
	/**
	 * @title : 주보 상세조회
	 * @method : bulletinDetail()
	 * @comment : 주보를 상세조회 할 수 있습니다.
	 * @param : WsBulletinDVO
	 */
	@Override
	public WsBulletinSVO bulletinDetail(WsBulletinDVO wsBulletinDVO) throws Exception{
		WsBulletinSVO returnSVO = new WsBulletinSVO();
		WsBulletinDVO returnDVO = new WsBulletinDVO();

		// 조회수 증가는 세션이 완료되면 구현할 예정이다.
		// wsBulletinDAO.bulletinViewCnt(wsBulletinDVO);
		
		// 주보 상세조회
		returnDVO = wsBulletinDAO.bulletinDetail(wsBulletinDVO);
		
		// 첨부파일 조회
		List<WsBulletinDVO> bulletinFile = wsBulletinDAO.selectBulletinFile(wsBulletinDVO);
		
		returnSVO.setWsBulletinFile(bulletinFile);
		returnSVO.setWsBulletinDVO(returnDVO);
		return returnSVO;
	}
	
	/**
	 * @title	: 주보 삭제 
	 * @method	: bulletinDelete()
	 * @comment	: 주보를 삭제할 수 있습니다.		 
	 * @param	: WsBulletinDVO
	 */
	@Override
	@Transactional
	public WsBulletinDVO bulletinDelete(WsBulletinDVO wsBulletinDVO) throws Exception{
		WsBulletinDVO returnDVO = new WsBulletinDVO();
		
		int resultCnt = 0;
		try {
			resultCnt = wsBulletinDAO.bulletinDelete(wsBulletinDVO);
			returnDVO.setResultCnt(resultCnt);
		}catch(Exception e) {
			
			e.printStackTrace();
			
			logger.debug("########################################");
			logger.debug("DB 에러가 발생하였습니다.");
			logger.debug("########################################");
		}
		
		return returnDVO;
	}
}
