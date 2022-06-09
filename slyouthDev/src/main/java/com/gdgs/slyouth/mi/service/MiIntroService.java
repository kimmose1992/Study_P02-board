package com.gdgs.slyouth.mi.service;

import com.gdgs.slyouth.mi.vo.MiIntroDVO;
import com.gdgs.slyouth.mi.vo.MiIntroSVO;

/**
 * @title  : 교회소개(메인) Service 인터페이스
 * @author : 신지현
 * @create : 2021.05.25
 */
public interface MiIntroService {
	
	/**
	 * @title	: 교회소개(메인) 화면 조회   
	 * @method	: selectMainIntro()	 
	 * @comment	: 소개 메인 조회를 한다.
	 * @param	: N/A
	 */
	public MiIntroSVO selectMainIntro() throws Exception;

	/**
	 * @title	: 교회소개(메인) 수정 완료
	 * @method	: updateMiIntro
	 * @comment	: 교회 소개를 수정하고 DB에 갔다옵니다.
	 * @param	: MiIntroDVO
	 */
	public int updateMiIntro(MiIntroDVO miIntroVO) throws Exception;
	
	/**
	 * @title	: 인사말 메인  
	 * @method	: greeting()
	 * @comment	: 인사말 조회를 합니다.		 
	 * @param	: N/A
	 */
	public MiIntroSVO greeting() throws Exception;
	
	/**
	 * @title	: 인사말 수정
	 * @method	: greetingSave()
	 * @comment	: 인사말을 수정할 수 있습니다.		 
	 * @param	: MiIntroDVO
	 */
	public MiIntroDVO greetingSave(MiIntroDVO miIntroDVO) throws Exception;
	
	/**
	 * @title	: 예배안내 메인
	 * @method	: worshipInfo()
	 * @comment	: 예배안내를 조회합니다.	 
	 * @param	: N/A
	 */
	public MiIntroSVO worshipInfo() throws Exception;
	
	/**
	 * @title	: 예배안내 수정
	 * @method	: worshipInfoSave()
	 * @comment	: 예배안내를 수정합니다.	 
	 * @param	: MiIntroDVO
	 * @return	: MiIntroDVO
	 */
	public MiIntroDVO worshipInfoSave(MiIntroDVO miIntroDVO) throws Exception;

	/**
	 * @title	: 새가족반소개 기본정보 조회
	 * @method	: newcomerInfo
	 * @comment	: 새가족반소개 기본정보를 조회해온다.
	 * @param	: MiIntroDVO
	 */
	public MiIntroSVO newcomerInfo(MiIntroDVO miIntroDVO) throws Exception;
}