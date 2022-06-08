package com.study.board.bd.service;

import java.util.List;

import com.study.board.bd.vo.BdNoticeVO;

/**
 * @title	: [게시판] 공지사항 Service 인터페이스	  
 * @author	: 김모세
 * @create	: 2022.06.08
 */
public interface BdNoticeService {

	List<BdNoticeVO> boardList() throws Exception;
}
