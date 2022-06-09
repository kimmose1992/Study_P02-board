package com.gdgs.slyouth.nt.service.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.gdgs.slyouth.cm.service.dao.AbstractDAO;
import com.gdgs.slyouth.nt.vo.NtCounselDVO;

/**
 * @title	: [커뮤니티] 상담 DAO 클래스  
 * @author	: srar2
 * @create	: 2021. 6. 26.
 */
@Component
@Repository("ntCounselDAO")
@SuppressWarnings("unchecked")
public class NtCounselDAO extends AbstractDAO {
	
	private static final String NAMESPACE = "nt.counsel.";
	
	/**
	 * @title	: 상담 목록 건수 조회
	 * @method	: selectCounselTotalDataCnt()
	 * @comment	: 상담 화면에서 입력된 정보로 조회된 데이터의 건수를 리턴한다.		 
	 * @param	: NtCounselDVOs
	 */
	public int selectCounselTotalDataCnt(NtCounselDVO ntCounselDVO) {
		return (int) select(NAMESPACE + "selectCounselTotalDataCnt", ntCounselDVO);
	}
	
	/**
	 * @title	: 상담 목록 조회
	 * @method	: counselList() 
	 * @comment	: 상담 화면에서 입력된 정보로 상담 목록을 조회한다.		 
	 * @param	: NtCounselDVO
	 */
	public List<NtCounselDVO> counselList(NtCounselDVO ntCounselDVO){
		return (List<NtCounselDVO>) selectList(NAMESPACE + "counselList", ntCounselDVO);
	}
	
	/**
	 * @title	: 상담 상세 조회
	 * @method	: counselDetail() 
	 * @comment	: 상담 목록에서 선택한 코드의 상세정보를 조회한다.		 
	 * @param	: NtCounselDVO
	 */
	public NtCounselDVO counselDetail(NtCounselDVO ntCounselDVO) {
		return (NtCounselDVO) select(NAMESPACE + "counselDetail", ntCounselDVO);
	}
	
	/**
	 * @title	: 상담 그룹 별 글 조회
	 * @method	: counselCount()
	 * @comment	: 상담 삭제를 위한 그룹 별 글의 수를 조회한다.	 
	 * @param	: NtCounselDVO
	 */
	public int counselCount(NtCounselDVO ntCounselDVO) {
		return (int) select(NAMESPACE + "counselCount", ntCounselDVO);
	}
	
	/**
	 * @title	: 상담 글 등록
	 * @method	: counselRegist()
	 * @comment	: 상담 글을 등록한다.
	 * @param	: NtCounselDVO
	 */
	public int counselRegist(NtCounselDVO ntCounselDVO) {
		return (int) insert(NAMESPACE + "counselRegist", ntCounselDVO);
	}
	
	/**
	 * @title	: 상담 글 수정
	 * @method	: counselUpdate()
	 * @comment	: 상담 글을 수정한다.
	 * @param	: NtCounselDVO
	 */
	public int counselUpdate(NtCounselDVO ntCounselDVO) {
		return (int) update(NAMESPACE + "counselUpdate", ntCounselDVO);
	}
	
	/**
	 * @title	: 상담 익명, 공개여부 수정
	 * @method	: counselSubUpdate()
	 * @comment	: 상담 본 글의 수정경우 익명, 공개여부는 답글에도 영향을 끼친다. 
	 * @param	: NtCounselDVO
	 */
	public int counselSubUpdate(NtCounselDVO ntCounselDVO) {
		return (int) update(NAMESPACE + "counselSubUpdate", ntCounselDVO);
	}
	
	/**
	 * @title	: 상담 답글 등록
	 * @method	: counselReply()
	 * @comment	: 상담 답글을 등록한다. 
	 * @param	: NtCounselDVO
	 */
	public int counselReply(NtCounselDVO ntCounselDVO) {
		return (int) insert(NAMESPACE + "counselReply", ntCounselDVO);
	}
	/**
	 * @title	: 상담 삭제
	 * @method	: counselDelete()
	 * @comment	: 상담 상세조회 페이지에서 선택한 코드의 상세정보를 삭제한다.
	 * @param	: NtCounselDVO
	 */
	public int counselDelete(NtCounselDVO ntCounselDVO) {
		return (int) delete(NAMESPACE + "counselDelete", ntCounselDVO);
	}
}
