package com.study.board.bd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.board.bd.dao.BdNoticeDAO;
import com.study.board.bd.service.BdNoticeService;
import com.study.board.bd.vo.BdNoticeVO;

/**
 * @title	: [게시판] 공지사항 Service 구현 클래스	  
 * @author	: 김모세
 * @create	: 2022.06.08
 */
@Service
public class BdNoticeServiceImpl implements BdNoticeService {

	@Autowired
	private BdNoticeDAO bdNoticeDAO;
	
	/**
	 * @title	: 게시판 목록 조회 
	 * @author	: 꼬북
	 * @create	: 2022.06.08
	 */
	@Override
	public List<BdNoticeVO> boardList(BdNoticeVO param) throws Exception {
		bdNoticeDAO.boardList(param);
		return null;
	}

}
