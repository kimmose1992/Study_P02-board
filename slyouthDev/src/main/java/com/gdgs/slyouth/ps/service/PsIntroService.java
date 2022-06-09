package com.gdgs.slyouth.ps.service;

import com.gdgs.slyouth.ps.vo.PsIntroDVO;
import com.gdgs.slyouth.ps.vo.PsIntroSVO;

/**
 * @title  : [찬양과셀라] 셀라소개 Service 인터페이스
 * @author : 김예림
 * @create : 2021.06.30
 */
public interface PsIntroService {

	/**
	 * @title   : 셀라소개 기본정보 조회
	 * @method  : selahInfo()
	 * @comment : 셀라소개 기본정보를 조회해온다.
	 * @param   : psIntroDVO
	 */
	public PsIntroSVO selahInfo(PsIntroDVO psIntroDVO) throws Exception;

	/**
	 * @title	: 셀라소개 정보 수정
	 * @method	: saveSelahInfo
	 * @comment	: 셀라소개 기본정보 수정과 변경 이미지를 업로드한다.
	 * @param	: PsIntroDVO
	 */
	public PsIntroDVO saveSelahInfo(PsIntroSVO paramSVO) throws Exception;
}
