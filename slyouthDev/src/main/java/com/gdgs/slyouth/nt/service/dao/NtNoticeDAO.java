package com.gdgs.slyouth.nt.service.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.gdgs.slyouth.cm.service.dao.AbstractDAO;
import com.gdgs.slyouth.nt.vo.NtNoticeDVO;

/**
 * @title    : [커뮤니티] 공지사항 DAO 클래스		      
 * @author   : gypig
 * @create   : 2021.06.16
 */
@Component
@Repository("ntNoticeDAO")
@SuppressWarnings("unchecked")
public class NtNoticeDAO extends AbstractDAO {
	
	private static final String NAMESPACE = "nt.ntc.";

	/**
	 * @title	: 공지사항 목록 조회  
	 * @method	: ntNoticeList()
	 * @comment	: 공지사항 등록에서 입력된 정보를 공지사항 리스트로 조회합니다.		 
	 * @param	: N/A
	 */
	public List<NtNoticeDVO> ntNoticeList(NtNoticeDVO ntNoticeDVO) {

		return (List<NtNoticeDVO>) selectList(NAMESPACE + "ntNoticeList", ntNoticeDVO); 
	}
	/**
	 * @title	: 공지사항 상단 목록 조회  
	 * @method	: ntNoticeList()
	 * @comment	: 공지사항 등록에서 입력된 정보를 공지사항 리스트로 조회합니다.		 
	 * @param	: N/A
	 */
	public List<NtNoticeDVO> ntNoticeTopList() {

		return (List<NtNoticeDVO>) selectList(NAMESPACE + "ntNoticeTopList"); 
	}
	
	/**
	 * @title	: 메인화면 공지사항 목록 조회  
	 * @method	: ntNoticeSubList()
	 * @comment	: 공지사항 등록에서 입력된 정보를 공지사항 리스트로 조회합니다.		 
	 * @param	: N/A
	 */
	public List<NtNoticeDVO> ntNoticeSubList() {
		
		return (List<NtNoticeDVO>) selectList(NAMESPACE + "ntNoticeSubList");
	}
	
	/**
	 * @title	: 공지사항 목록 건수 조회	  
	 * @method	: selectNoticeTotalCnt()	 
	 * @comment	: 공지사항 화면에서 입력된 정보로 조회된 데이터의 건수를 리턴한다.	 
	 * @param	: NtNoticeDVO
	 */
	public int selectNoticeTotalCnt(NtNoticeDVO ntNoticeDVO) {
		
		return (int) select(NAMESPACE + "selectNoticeTotalCnt", ntNoticeDVO);
	}
	
	/**
	 * @title	: 공지사항 상세 조회  
	 * @method	: ntNoticeDetail()
	 * @comment	: 공지사항 리스트를 누르면 상세조회 화면에서 조회됩니다.			 
	 * @param	: NtNoticeDVO
	 */
	public NtNoticeDVO ntNoticeDetail(NtNoticeDVO ntNoticeDVO) {
		
		return (NtNoticeDVO) select(NAMESPACE + "ntNoticeDetail", ntNoticeDVO);
	}
	
	/**
	 * @title	: 공지사항 조회수 증가
	 * @method	: ntNoticeCnt()
	 * @comment	: 게시물 상세보기를 할 때마다 조회수가 증가합니다.		 
	 * @param	: NtNoticeDVO
	 */
	public void ntNoticeCnt(NtNoticeDVO ntNoticeDVO) throws Exception {
		
		update(NAMESPACE+"ntNoticeCnt", ntNoticeDVO);
	}
	

	/**
	 * @title	: 공지사항 등록
	 * @method	: insertNotice
	 * @comment	: 공지사항을 등록합니다.
	 * @param	: NtNoticeDVO
	 */
	public int insertNotice(NtNoticeDVO ntNoticeDVO) {
		
		return (int) insert(NAMESPACE+"ntNoticeInsert", ntNoticeDVO);
	}
	
	/**
	 * @title	: 공지사항 수정
	 * @method	: updateNotice
	 * @comment	: 공지사항을 수정합니다.
	 * @param	: NtNoticeDVO
	 */
	public int updateNotice(NtNoticeDVO ntNoticeDVO) {
			
		return (int) update(NAMESPACE+"ntNoticeUpdate", ntNoticeDVO);
	}
	
	/**
	 * @title	: 공지사항 삭제
	 * @method	: deleteNotice
	 * @comment	: 공지사항을 삭제합니다.
	 * @param	: NtNoticeDVO
	 */
	public int deleteNotice(NtNoticeDVO ntNoticeDVO) {
		
		return (int) delete(NAMESPACE+"ntNoticeDelete", ntNoticeDVO);
	}
}
