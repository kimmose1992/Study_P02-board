package com.gdgs.slyouth.sd.service;

import com.gdgs.slyouth.sd.vo.SdCodeDVO;
import com.gdgs.slyouth.sd.vo.SdCodeSVO;

/**
 * @title	: [기준정보] 코드관리 Service 인터페이스	  
 * @author	: mosekim
 * @create	: 2021.04.21
 */
public interface SdCodeService {

	/**
	 * @title	: 코드 목록 조회	  
	 * @method	: selectCodeList()	 
	 * @comment	: 코드관리 화면에서 입력된 정보로 코드 목록을 조회한다.	  
	 * @param	: paramSVO
	 */
	public SdCodeSVO selectCodeList(SdCodeDVO sdCodeDVO) throws Exception;

	/**
	 * @title	: 코드 상세 조회	  
	 * @method	: selectCodeDetail()	 
	 * @comment	: 코드 조회 목록에서 선택한 코드의 상세정보를 조회한다.	  
	 * @param	: sdCodeDVO
	 */
	public SdCodeSVO selectCodeDetail(SdCodeDVO sdCodeDVO) throws Exception;

}
