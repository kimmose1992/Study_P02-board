package com.gdgs.slyouth.nf.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gdgs.slyouth.nf.service.NfVisionService;
import com.gdgs.slyouth.nf.service.dao.NfVisionDAO;
import com.gdgs.slyouth.nf.vo.NfVisionDVO;
import com.gdgs.slyouth.nf.vo.NfVisionSVO;

/**
 * @title  : [양육과훈련] 승리청년비전 Service 구현 클래스
 * @author : 김모세
 * @create : 2021.08.02
 */
@Component
@Service("nfVisionService")
public class NfVisionServiceImpl implements NfVisionService {

	private static final Logger logger = LoggerFactory.getLogger(NfVisionServiceImpl.class);
	
	@Autowired
	private NfVisionDAO nfVisionDAO;

	/**
	 * @title   : 승리청년비전 정보 조회
	 * @method  : visionInfo
	 * @comment : 승리청년비전 정보를 조회한다.
	 * @param   : NfVisionDVO
	 */
	@Override
	public NfVisionSVO visionInfo(NfVisionDVO nfVisionDVO) throws Exception {
		NfVisionSVO returnSVO = new NfVisionSVO();
		
		// 승리청년비전 정보를 조회
		NfVisionDVO visionInfo = nfVisionDAO.selectVisionInfo(nfVisionDVO);
		
		//returnSVO.setNfPgmDVO();
		return returnSVO;
	}

}
