package com.study.board.bd.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.board.bd.vo.BdNoticeVO;

/**
 * @title	: [게시판] 공지사항 DAO 클래스	  
 * @author	: 김모세
 * @create	: 2022.06.08
 */
@Repository
public class BdNoticeDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	private static final String NAMESPACE = "bd.notice.";
	
	/**
	 * @title	: 게시판 목록 조회 
	 * @author	: 꼬북
	 * @create	: 2022.06.09
	 */
	public List<BdNoticeVO> boardList(BdNoticeVO param) throws Exception {
		return sqlSession.selectList(NAMESPACE + "boardList", param);
	}

}
