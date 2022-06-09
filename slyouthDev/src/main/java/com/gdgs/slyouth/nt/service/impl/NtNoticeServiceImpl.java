package com.gdgs.slyouth.nt.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdgs.slyouth.cm.vo.CmPagingOutDVO;
import com.gdgs.slyouth.nt.service.NtNoticeService;
import com.gdgs.slyouth.nt.service.dao.NtNoticeDAO;
import com.gdgs.slyouth.nt.vo.NtNoticeDVO;
import com.gdgs.slyouth.nt.vo.NtNoticeSVO;

/**
 * @title : [커뮤니티] 공지사항 Service 구현 클래스
 * @author : 신지현
 * @create : 2021.07.01
 */
@Component
@Service("ntNoticeService")
public class NtNoticeServiceImpl implements NtNoticeService {

	@Autowired
	private NtNoticeDAO ntNoticeDAO;

	/**
	 * @title : 공지사항 조회 페이지
	 * @method : NoticeList()
	 * @comment : 공지사항 등록에서 입력된 정보를 공지사항 리스트로 조회합니다.
	 * @param : NtNoticeDVO
	 */
	@Override
	public NtNoticeSVO noticeList(NtNoticeDVO ntNoticeDVO) throws Exception {
		NtNoticeSVO returnSVO = new NtNoticeSVO();

		// 공지사항 리스트 초기화
		List<NtNoticeDVO> ntNoticeList = null;
		List<NtNoticeDVO> ntNoticeTopList = null;

		int totalDataCnt = ntNoticeDAO.selectNoticeTotalCnt(ntNoticeDVO);

		if (totalDataCnt > 0) {

			// 공지사항 목록 조회
			ntNoticeList = ntNoticeDAO.ntNoticeList(ntNoticeDVO);
			ntNoticeTopList = ntNoticeDAO.ntNoticeTopList();

			// 페이징 설정
			CmPagingOutDVO cmPagingOutDVO = new CmPagingOutDVO(ntNoticeDVO);
			cmPagingOutDVO.setTotalDataCnt(totalDataCnt);
			returnSVO.setCmPagingOutDVO(cmPagingOutDVO);
		} else {

			CmPagingOutDVO cmPagingOutDVO = new CmPagingOutDVO(ntNoticeDVO);
			cmPagingOutDVO.setTotalDataCnt(0);
			returnSVO.setCmPagingOutDVO(cmPagingOutDVO);
		}

		returnSVO.setNtNoticeDVO(ntNoticeDVO);
		returnSVO.setNtNoticeDVOList(ntNoticeList);
		returnSVO.setNtNoticeDVOTopList(ntNoticeTopList);
		return returnSVO;
	}

	/**
	 * @title : 공지사항 상세조회 페이지
	 * @method : noticeDetail()
	 * @comment : 공지사항 등록에서 입력된 정보를 공지사항 리스트로 조회합니다.
	 * @param : NtNoticeDVO
	 */
	@Override
	@Transactional
	public NtNoticeSVO noticeDetail(NtNoticeDVO ntNoticeDVO) throws Exception { 
		NtNoticeSVO returnSVO = new NtNoticeSVO();
		NtNoticeDVO paramDVO = new NtNoticeDVO();

		// 조회수 증가
		ntNoticeDAO.ntNoticeCnt(ntNoticeDVO);

		if (!("I".equals(ntNoticeDVO.getEditDivCd()))) {
			// 공지사항 상세조회
			paramDVO = ntNoticeDAO.ntNoticeDetail(ntNoticeDVO); //화면에서 넘어온 친구
		}
		paramDVO.setEditDivCd(ntNoticeDVO.getEditDivCd());
		returnSVO.setNtNoticeDVO(paramDVO);
		return returnSVO;
	}

	/**
	 * @title : 공지사항 등록&수정
	 * @method : noticeSave()
	 * @comment : 공지사항 글을 등록 및 수정합니다.
	 * @param : NtNoticeDVO
	 */
	@Override
	@Transactional
	public int noticeSave(NtNoticeDVO ntNoticeDVO) throws Exception {

		int returnValue = 0;

		if ("I".equals(ntNoticeDVO.getEditDivCd())) {

			// 글 등록일
			ntNoticeDVO.setFrsRegDt(LocalDateTime.now());

			// 공지사항 등록
			returnValue = ntNoticeDAO.insertNotice(ntNoticeDVO);
			
		} else if ("U".equals(ntNoticeDVO.getEditDivCd())) {
			// 공지사항 수정
			returnValue = ntNoticeDAO.updateNotice(ntNoticeDVO);
		}

		returnValue = ntNoticeDVO.getCmntyNo();
		return returnValue;
	}

	/**
	 * @title : 공지사항 삭제
	 * @method : removeNotice()
	 * @comment : 공지사항 글을 삭제합니다.
	 * @param : NtNoticeDVO
	 */
	@Override
	public int removeNotice(NtNoticeDVO ntNoticeDVO) throws Exception {
		int resultNum = ntNoticeDAO.deleteNotice(ntNoticeDVO);

		return resultNum;
	}

}
