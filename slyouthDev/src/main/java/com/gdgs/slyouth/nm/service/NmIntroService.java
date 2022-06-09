package com.gdgs.slyouth.nm.service;

import com.gdgs.slyouth.nm.vo.NmIntroDVO;
import com.gdgs.slyouth.nm.vo.NmIntroSVO;

/**
 * @title   : [새가족] 새가족조회 Service 인터페이스
 * @author  : 이하은
 * @create  : 2021.06.30
 */
public interface NmIntroService {

	/**
	 * @title	: 새가족소개 기본정보 조회  
	 * @method	: memberInfo
	 * @comment	: 새가족소개 기본정보를 가져온다.
	 * @param	: nmIntroDVO
	 */
	public NmIntroSVO memberInfo(NmIntroDVO nmIntroDVO) throws Exception;

	/**
	 * @title	: 새가족소개 정보 수정
	 * @method	: saveMemberInfo
	 * @comment	: 새가족소개 기본정보 수정과 변경 이미지를 업로드한다.
	 * @param	: NmIntroSVO
	 */
	public NmIntroDVO saveMemberInfo(NmIntroSVO paramSVO) throws Exception;

}
