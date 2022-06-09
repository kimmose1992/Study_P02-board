package com.gdgs.slyouth.nt.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdgs.slyouth.cm.vo.CmPagingOutDVO;
import com.gdgs.slyouth.nt.service.NtSharingService;
import com.gdgs.slyouth.nt.service.dao.NtSharingDAO;
import com.gdgs.slyouth.nt.vo.NtSharingDVO;
import com.gdgs.slyouth.nt.vo.NtSharingSVO;

/**
 * @title : [커뮤니티] 나눔 Service 구현 클래스
 * @author : 신지현
 * @create : 2021.07.01
 */
@Component
@Service("ntSharingService")
public class NtSharingServiceImpl implements NtSharingService {
	
	private static final Logger logger = LoggerFactory.getLogger(NtSharingServiceImpl.class);

	@Autowired
	private NtSharingDAO ntSharingDAO;

	/**
	 * @title : 나눔 조회 페이지
	 * @method : sharingList()
	 * @comment : 나눔 등록에서 입력된 정보를 나눔 리스트로 조회합니다.
	 * @param : NtSharingDVO
	 */
	@Override
	public NtSharingSVO sharingList(NtSharingDVO ntSharingDVO) throws Exception {
		NtSharingSVO returnSVO = new NtSharingSVO();

		List<NtSharingDVO> ntSharingList = null; // 리스트 초기화
		CmPagingOutDVO cmPagingOutDVO = null;

		// 목록 전체 건수 조회
		int totalDataCnt = ntSharingDAO.selectSharingTotalCnt(ntSharingDVO);

		if (totalDataCnt > 0) {

			// 나눔 목록 조회
			ntSharingList = ntSharingDAO.ntSharingList(ntSharingDVO);

			// 페이징 설정
			cmPagingOutDVO = new CmPagingOutDVO(ntSharingDVO);
			cmPagingOutDVO.setTotalDataCnt(totalDataCnt);
		}

		returnSVO.setNtSharingDVO(ntSharingDVO);
		returnSVO.setNtSharingDVOList(ntSharingList);
		returnSVO.setCmPagingOutDVO(cmPagingOutDVO);
		return returnSVO;
	}

	/**
	 * @title : 나눔 상세조회 페이지
	 * @method : sharingDetail()
	 * @comment : 나눔 리스트를 누르면 상세화면에서 조회합니다.
	 * @param : NtSharingDVO
	 */
	@Override
	public NtSharingSVO sharingDetail(NtSharingDVO ntSharingDVO) throws Exception {
		NtSharingSVO returnSVO = new NtSharingSVO();

		// 조회수 증가
		ntSharingDAO.ntSharingCnt(ntSharingDVO);

		// 나눔 상세조회
		NtSharingDVO sharingDetail = ntSharingDAO.ntSharingDetail(ntSharingDVO);
		// 페이지 번호 설정
		sharingDetail.setPageNo(ntSharingDVO.getPageNo());

//		if(paramDVO == null) {
//			paramDVO = new NtSharingDVO();
//			paramDVO.setFrsRegNo(ntSharingDVO.getFrsRegNo());
//		}

		returnSVO.setNtSharingDVO(sharingDetail);
		return returnSVO;
	}

	/**
	 * @title : 나눔 등록 & 수정
	 * @method : sharingEdit()
	 * @comment : 나눔 글을 등록 및 수정에 필요한 정보를 조회합니다.
	 * @param : NtSharingDVO
	 */
	@Override
	public NtSharingSVO sharingEdit(NtSharingDVO ntSharingDVO) throws Exception {
		NtSharingSVO returnSVO = new NtSharingSVO();
		NtSharingDVO sharingDetail = null;

		// 등록
		if ("I".equals(ntSharingDVO.getEditDivCd())) {
			sharingDetail = ntSharingDVO;
		}
		// 수정
		else if ("U".equals(ntSharingDVO.getEditDivCd())) {
			sharingDetail = ntSharingDAO.ntSharingDetail(ntSharingDVO);
		}
		sharingDetail.setEditDivCd(ntSharingDVO.getEditDivCd());
		returnSVO.setNtSharingDVO(sharingDetail);
		return returnSVO;
	}

	/**
	 * @title : 나눔 등록 & 수정
	 * @method : sharingSave()
	 * @comment : 나눔 글을 등록 및 수정합니다.
	 * @param : NtSharingDVO
	 */
	@Override
	@Transactional
	public NtSharingDVO sharingSave(NtSharingDVO ntSharingDVO) throws Exception {
		NtSharingDVO returnDVO = new NtSharingDVO();
	    logger.debug(ntSharingDVO.toString());
		int resultCnt = 0;
		try {
		// 등록
		if ("I".equals(ntSharingDVO.getEditDivCd())) {
			resultCnt = ntSharingDAO.insertSharing(ntSharingDVO);
		} 
		// 수정
		else if ("U".equals(ntSharingDVO.getEditDivCd())) {
			resultCnt = ntSharingDAO.updateSharing(ntSharingDVO);
			returnDVO.setCmntyNo(ntSharingDVO.getCmntyNo());
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

	/**
	 * @title : 나눔 삭제
	 * @method : removeSharing()
	 * @comment : 나눔 글을 삭제합니다.
	 * @param : NtSharingDVO
	 */
	@Override
	public NtSharingDVO removeSharing(NtSharingDVO ntSharingDVO) throws Exception {
		NtSharingDVO returnDVO = new NtSharingDVO();

		int resultCnt = 0;

		try {
			resultCnt = ntSharingDAO.deleteSharing(ntSharingDVO);
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
	 * @title : 나눔 좋아요 증가 및 조회
	 * @method : updateLikeCnt()
	 * @comment : 좋아요를 증가시키고 조회합니다.
	 * @param : NtSharingDVO
	 */
	@Override
	@Transactional
	public int updateLikePuls(NtSharingDVO ntSharingDVO) throws Exception {
		ntSharingDAO.updateSharingLikePlus(ntSharingDVO);

		int resultNum = ntSharingDAO.ntSharingLikeResult(ntSharingDVO);

		return resultNum;
	}

	/**
	 * @title : 나눔 좋아요 감소 및 조회
	 * @method : updateLikeCnt()
	 * @comment : 좋아요를 감소시키고 조회합니다.
	 * @param : NtSharingDVO
	 */
	@Override
	@Transactional
	public int updateLikeMinus(NtSharingDVO ntSharingDVO) throws Exception {
		ntSharingDAO.updateSharingLikeMinus(ntSharingDVO);

		int resultNum = ntSharingDAO.ntSharingLikeResult(ntSharingDVO);

		return resultNum;
	}

}
