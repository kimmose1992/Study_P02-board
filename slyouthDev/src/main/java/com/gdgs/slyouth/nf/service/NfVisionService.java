package com.gdgs.slyouth.nf.service;

import com.gdgs.slyouth.nf.vo.NfVisionDVO;
import com.gdgs.slyouth.nf.vo.NfVisionSVO;

/**
 * @title  : [양육과훈련] 승리청년비전 Service 인터페이스
 * @author : 김모세
 * @create : 2021.08.02
 */
public interface NfVisionService {

	/**
	 * @title   : 승리청년비전 정보 조회
	 * @method  : visionInfo
	 * @comment : 승리청년비전 정보를 조회한다.
	 * @param   : NfVisionDVO
	 */
	public NfVisionSVO visionInfo(NfVisionDVO nfVisionDVO) throws Exception;
}
