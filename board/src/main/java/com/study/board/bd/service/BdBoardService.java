package com.study.board.bd.service;

import java.util.List;

import com.study.board.bd.vo.BdBoardVO;

/**
 * @title	: 게시판 Service 인터페이스	  
 * @author	: 김모세
 * @create	: 2022.06.08
 */
public interface BdBoardService {

	List<BdBoardVO> boardList() throws Exception;
}
