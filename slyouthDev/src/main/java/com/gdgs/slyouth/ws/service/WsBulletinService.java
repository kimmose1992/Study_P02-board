package com.gdgs.slyouth.ws.service;

import com.gdgs.slyouth.ws.vo.WsBulletinDVO;
import com.gdgs.slyouth.ws.vo.WsBulletinSVO;

/**
 * @title   : 주보 Service 인터페이스
 * @author   : srar2
 * @create   : 2021.04.29
 */
public interface WsBulletinService {

	/**
	 * @title : 주보 리스트 데이터 조회
	 * @method : bulletinList()
	 * @comment : 주보 게시판의 게시물을 조회할 수 있도록 데이터를 가져온다.
	 * @param : WsBulletinDVO
	 */
	public WsBulletinSVO bulletinList(WsBulletinDVO wsBulletinDVO) throws Exception;
	
	/**
	 * @title : 주보 등록&수정
	 * @method : bulletinSave()
	 * @comment : 주보를 등록&수정합니다.
	 * @param : WsBulletinSVO
	 */
	public WsBulletinDVO bulletinSave(WsBulletinSVO wsBulletinSVO) throws Exception;
	
	/**
	 * @title : 주보 상세조회
	 * @method : bulletinDetail()
	 * @comment : 주보를 상세조회 할 수 있습니다.
	 * @param : WsBulletinDVO
	 */
	public WsBulletinSVO bulletinDetail(WsBulletinDVO wsBulletinDVO) throws Exception;
	
	/**
	 * @title	: 주보 삭제 
	 * @method	: bulletinDelete()
	 * @comment	: 주보를 삭제할 수 있습니다.		 
	 * @param	: WsBulletinDVO
	 */
	public WsBulletinDVO bulletinDelete(WsBulletinDVO wsBulletinDVO) throws Exception;
}
