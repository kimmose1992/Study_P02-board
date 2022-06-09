package com.gdgs.slyouth.nt.service.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.gdgs.slyouth.cm.service.dao.AbstractDAO;
import com.gdgs.slyouth.nt.vo.NtSharingDVO;

/**
 * @title    : [커뮤니티] 나눔 DAO 클래스	    
 * @author   : 신지현
 * @create   : 2021.06.24
 */
@Component
@Repository("ntSharingDAO")
@SuppressWarnings("unchecked")
public class NtSharingDAO extends AbstractDAO {

	private static final String NAMESPACE = "nt.shr.";
	
	/**
	 * @title	: 나눔 목록 조회  
	 * @method	: ntSharingList()
	 * @comment	: 나눔 등록에서 입력된 정보를 나눔 리스트로 조회합니다.		 
	 * @param	: NtSharingDVO
	 */
	public List<NtSharingDVO> ntSharingList(NtSharingDVO ntSharingDVO) {
		
		return (List<NtSharingDVO>) selectList(NAMESPACE + "ntSharingList", ntSharingDVO);
	}
	
	/**
	 * @title	: 나눔 목록 건수 조회	  
	 * @method	: selectSharingTotalCnt()	 
	 * @comment	: 나눔 화면에서 입력된 정보로 조회된 데이터의 건수를 리턴한다.	 
	 * @param	: NtSharingDVO
	 */
	public int selectSharingTotalCnt(NtSharingDVO ntSharingDVO) {
		
		return (int) select(NAMESPACE + "selectSharingTotalCnt", ntSharingDVO);
	}
	
	/**
	 * @title	: 나눔 목록 상세 조회  
	 * @method	: ntSharingList()
	 * @comment	: 나눔 리스트를 누르면 상세화면으로 조회됩니다.		 
	 * @param	: NtSharingDVO
	 */
	public NtSharingDVO ntSharingDetail(NtSharingDVO ntSharingDVO) {
		
		return (NtSharingDVO) select(NAMESPACE + "ntSharingDetail", ntSharingDVO );
	}
	
	/**
	 * @title	: 나눔 조회수  
	 * @method	: ntSharingCnt()
	 * @comment	: 나눔 리스트를 눌러 상세화면으로 가면 조회수가 증가합니다.	 
	 * @param	: NtSharingDVO
	 */	
	public void ntSharingCnt(NtSharingDVO ntSharingDVO) throws Exception {
		
		update(NAMESPACE + "ntSharingCnt", ntSharingDVO);
	}
	
	/**
	 * @title	: 나눔 등록  
	 * @method	: insertSharing()
	 * @comment	: 나눔 글을 등록합니다.		 
	 * @param	: NtSharingDVO
	 */
	public int insertSharing(NtSharingDVO ntSharingDVO) {
		
		return (int) insert(NAMESPACE + "ntSharingInsert", ntSharingDVO);
	}
	
	/**
	 * @title	: 나눔 수정  
	 * @method	: updateSharing()
	 * @comment	: 나눔 글을 수정합니다.		 
	 * @param	: NtSharingDVO
	 */
	public int updateSharing(NtSharingDVO ntSharingDVO) {
		
		return (int) update(NAMESPACE + "ntSharingUpdate", ntSharingDVO);
	}

	/**
	 * @title	: 나눔 삭제 
	 * @method	: deleteSharing()
	 * @comment	: 나눔 글을 삭제합니다.		 
	 * @param	: NtSharingDVO
	 */
	public int deleteSharing(NtSharingDVO ntShainrgDVO) {
		
		return (int) delete(NAMESPACE + "ntSharingDelete", ntShainrgDVO); 
	}
	
	/**
	 * @title	: 나눔 좋아요 증가
	 * @method	: updateSharingLikeCnt()
	 * @comment	: 좋아요를 누르면 증가 합니다.		 
	 * @param	: NtSharingDVO
	 */
	public int updateSharingLikePlus(NtSharingDVO ntSharingDVO) throws Exception {
		
		return (int) update(NAMESPACE + "ntSharingLikePlus", ntSharingDVO);
	}
	
	/**
	 * @title	: 나눔 좋아요 감소
	 * @method	: updateSharingLikeMinus()
	 * @comment	: 좋아요를 누르면 감소 합니다.		 
	 * @param	: NtSharingDVO
	 */
	public int updateSharingLikeMinus(NtSharingDVO ntSharingDVO) throws Exception {
		
		return (int) update(NAMESPACE + "ntSharingLikeMinus", ntSharingDVO);
	}
	
	/**
	 * @title	: 나눔 좋아요 조회
	 * @method	: ntSharingLikeResult()
	 * @comment	: 좋아요를 누른 뒤의 값을 가져옵니다.		 
	 * @param	: NtSharingDVO
	 */
	public int ntSharingLikeResult(NtSharingDVO ntSharingDVO) throws Exception {
		
		return (int) select(NAMESPACE + "ntSharingLikeResult", ntSharingDVO);
	}
	
}
