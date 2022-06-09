package com.gdgs.slyouth.ws.service.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.gdgs.slyouth.cm.service.dao.AbstractDAO;
import com.gdgs.slyouth.ws.vo.WsBulletinDVO;

/**
 * @title   : [예배와 찬양] DAO 주보 클래스      
 * @author   : gypig
 * @create   : 2021.06.16
 */
@Component
@Repository("wsBulletinDAO")
@SuppressWarnings("unchecked")
public class WsBulletinDAO extends AbstractDAO {
	
	private static final String NAMESPACE = "ws.bulletin.";
	
	/**
	 * @title	: 주보 데이터 리스트 조회
	 * @method	: bulletinList()
	 * @comment	: 주보 데이터를 list 형태로 조회한다.
	 * @param	: WsBulletinDVO
	 */
	public List<WsBulletinDVO> bulletinList(WsBulletinDVO wsBulletinDVO) {
		return (List<WsBulletinDVO>) selectList(NAMESPACE + "bulletinList", wsBulletinDVO);
	}
	
	/**
	 * @title	: 주보 목록 건수 조회	  
	 * @method	: selectBulletinTotalDataCnt()	 
	 * @comment	: 주보 화면에서 입력된 정보로 조회된 데이터의 건수를 조회합니다.	 
	 * @param	: WsBulletinDVO
	 */
	public int selectBulletinTotalDataCnt(WsBulletinDVO wsBulletinDVO) {
		return (int) select(NAMESPACE + "selectBulletinTotalDataCnt", wsBulletinDVO);
	}
	
	/**
	 * @title : 주보 등록
	 * @method : bulletinRegist()
	 * @comment : 주보를 등록합니다.
	 * @param : WsBulletinDVO
	 */
	public int bulletinRegist(WsBulletinDVO wsBulletinDVO){
		return (int) insert(NAMESPACE + "bulletinRegist", wsBulletinDVO);
	}
	
	/**
	 * @title	: 주보 수정 
	 * @method	: bulletinUpdate()
	 * @comment	: 주보를 수정할 수 있습니다.		 
	 * @param	: WsBulletinDVO
	 */
	public int bulletinUpdate(WsBulletinDVO wsBulletinDVO) {
		return (int) update(NAMESPACE + "bulletinUpdate", wsBulletinDVO);
	}
	
	/**
	 * @title : 주보 상세조회
	 * @method : bulletinDetail()
	 * @comment : 주보를 상세조회할 수 있습니다.
	 * @param : WsBulletinDVO
	 */
	public WsBulletinDVO bulletinDetail(WsBulletinDVO wsBulletinDVO) {
		return (WsBulletinDVO) select(NAMESPACE + "bulletinDetail", wsBulletinDVO);
	}
	
	/**
	 * @title : 주보 상세조회 조회수 증가
	 * @method : bulletinViewCnt()
	 * @comment : 주보를 상세조회할 때마다 조회수가 +1 증가합니다.
	 * @param : WsBulletinDVO
	 */
	public void bulletinViewCnt(WsBulletinDVO wsBulletinDVO) {
		update(NAMESPACE + "bulletinViewCnt", wsBulletinDVO);
	}
	
	/**
	 * @title	: 주보 첨부파일 조회
	 * @method	: selectBulletinFile() 
	 * @comment	: 주보 첨부파일을 리스트로 조회하는 쿼리입니다.		 
	 * @param	: WsBulletinDVO
	 */
	public List<WsBulletinDVO> selectBulletinFile(WsBulletinDVO wsBulletinDVO){
		return (List<WsBulletinDVO>) selectList(NAMESPACE + "selectBulletinFile", wsBulletinDVO);
	}
	
	/**
	 * @title : 주보 삭제
	 * @method : bulletinDelete()
	 * @comment : 주보를 삭제할 수 있습니다.
	 * @param : WsBulletinDVO
	 */
	public int bulletinDelete(WsBulletinDVO wsBulletinDVO) {
		return (int) delete(NAMESPACE + "bulletinDelete", wsBulletinDVO);
	}
}
