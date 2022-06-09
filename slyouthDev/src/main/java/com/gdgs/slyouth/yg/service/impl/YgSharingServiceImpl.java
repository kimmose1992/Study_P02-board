package com.gdgs.slyouth.yg.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdgs.slyouth.cm.vo.CmPagingOutDVO;
import com.gdgs.slyouth.yg.service.YgSharingService;
import com.gdgs.slyouth.yg.service.dao.YgSharingDAO;
import com.gdgs.slyouth.yg.vo.YgSharingDVO;
import com.gdgs.slyouth.yg.vo.YgSharingSVO;


/**
 * @title    : [사랑방] 자료나눔게시판 Service 구현 클래스      
 * @author   : 김예림
 * @create   : 2021. 9. 1.
 */
@Component
@Service("ygSharingService")
public class YgSharingServiceImpl implements YgSharingService{
	private static final Logger logger = LoggerFactory.getLogger(YgSharingServiceImpl.class);
	
	@Autowired
	private YgSharingDAO ygSharingDAO;
	
	/**
	 * @title	: 나눔자료게시판 목록조회
	 * @method	: sharingList
	 * @comment	: 나눔자료게시판 목록 정보 조회 
	 * @param	: YgSharingDVO
	 */
	@Override
	public YgSharingSVO sharingList(YgSharingDVO ygSharingDVO) throws Exception {
		YgSharingSVO returnSVO = new YgSharingSVO();
		List<YgSharingDVO> ygSharingList= null;
		CmPagingOutDVO cmPagingOutDVO = null;
		int totalCnt = ygSharingDAO.selectSharingTotalCnt(ygSharingDVO);
		if(totalCnt>0) {
			ygSharingList = ygSharingDAO.selectSharingList(ygSharingDVO);
			
			cmPagingOutDVO = new CmPagingOutDVO(ygSharingDVO);
			cmPagingOutDVO.setTotalDataCnt(totalCnt);
		}
		
		returnSVO.setYgSharingDVO(ygSharingDVO);
		returnSVO.setYgSharingDVOList(ygSharingList);
		returnSVO.setCmPagingOutDVO(cmPagingOutDVO);
		
		return returnSVO;
	}
	
	/**
	 * @title	: 나눔자료게시판 상세 조회
	 * @method	: sharingDetail
	 * @comment	: 나눔자료게시판 게시글의 상세 정보 조회 
	 * @param	: YgSharingDVO
	 */
	@Override
	public YgSharingSVO sharingDetail(YgSharingDVO ygSharingDVO) throws Exception {
		YgSharingSVO returnSVO = new YgSharingSVO();
		
		YgSharingDVO sharingInfo = ygSharingDAO.selectSharingInfo(ygSharingDVO);
		
		//페이지 번호 (
		sharingInfo.setPageNo(ygSharingDVO.getPageNo());
		
		returnSVO.setYgSharingDVO(sharingInfo);
		return returnSVO;
	}

	/**
	 * @title	: 나눔자료게시판 게시글 삭제
	 * @method	: sharingDelete
	 * @comment	: 나눔자료게시판 게시글 삭제 
	 * @param	: YgSharingDVO
	 */
	@Override
	public YgSharingDVO sharingDelete(YgSharingDVO ygSharingDVO) throws Exception {
		YgSharingDVO returnDVO = new YgSharingDVO();
		int resultCnt=0;
		try {
			resultCnt = ygSharingDAO.deleteSharingInfo(ygSharingDVO);
		} catch (Exception e) {
			logger.debug("#############################");
			logger.debug("## " + e.getMessage());
			logger.debug("#############################");
			
			throw new RuntimeException();
		}
		returnDVO.setResultCnt(resultCnt);
		return returnDVO;
	}
	
	/**
	 * @title	: 나눔자료게시판 등록/수정
	 * @method	: sharingEdit
	 * @comment	: 나눔자료게시판 게시글 등록/수정 화면 조회 
	 * @param	: YgSharingDVO
	 */
	@Override
	public YgSharingSVO sharingEdit(YgSharingDVO ygSharingDVO) throws Exception {
		YgSharingSVO returnSVO = new YgSharingSVO();
		YgSharingDVO sharingDetail = null;
		
		if("I".equals(ygSharingDVO.getEditDivCd())) {
			sharingDetail = ygSharingDVO;
		}
		else if("U".equals(ygSharingDVO.getEditDivCd())){
			sharingDetail = ygSharingDAO.selectSharingInfo(ygSharingDVO);
		}
		
		sharingDetail.setEditDivCd(ygSharingDVO.getEditDivCd());
		returnSVO.setYgSharingDVO(sharingDetail);
		return returnSVO;
	}
	
	/**
	 * @title	: 나눔자료게시판 등록/수정 후 저장
	 * @method	: sharingSave
	 * @comment	: 나눔자료게시판 게시글 등록/수정 후 저장 
	 * @param	: YgSharingDVO
	 */
	@Override
	@Transactional
	public YgSharingDVO sharingSave(YgSharingDVO ygSharingDVO) throws Exception {
		YgSharingDVO returnDVO = new YgSharingDVO();
		int resultCnt = 0;
		try {
			if("I".equals(ygSharingDVO.getEditDivCd())) {
				resultCnt = ygSharingDAO.insertSharingInfo(ygSharingDVO);
			}
			else if("U".equals(ygSharingDVO.getEditDivCd())){
				resultCnt = ygSharingDAO.updateSharingInfo(ygSharingDVO);
			}
		} catch (Exception e) {
			logger.debug("#############################");
			logger.debug("## " + e.getMessage());
			logger.debug("#############################");
			
			throw new RuntimeException();
		}
		returnDVO.setResultCnt(resultCnt);
		return returnDVO;
	}
	
}
