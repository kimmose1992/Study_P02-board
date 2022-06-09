package com.gdgs.slyouth.nf.service.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.gdgs.slyouth.cm.service.dao.AbstractDAO;
import com.gdgs.slyouth.nf.vo.NfVisionDVO;

/**
 * @title  : [양육과훈련] 승리청년비전 DAO 클래스
 * @author : 김모세
 * @create : 2021.08.02
 */
@Component
@Repository("nfVisionDAO")
public class NfVisionDAO extends AbstractDAO {
	
	private static final String NAMESPACE = "nf.vision.";
	
	/**
	 * @title   : 승리청년비전 정보 조회
	 * @method  : selectVisionInfo
	 * @comment : 승리청년비전 정보를 조회한다.
	 * @param   : NfVisionDVO
	 */
	public NfVisionDVO selectVisionInfo(NfVisionDVO nfVisionDVO) {
		// TODO Auto-generated method stub
		return null;
	}
}
