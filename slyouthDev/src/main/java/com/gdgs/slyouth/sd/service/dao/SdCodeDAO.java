package com.gdgs.slyouth.sd.service.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.gdgs.slyouth.cm.service.dao.AbstractDAO;
import com.gdgs.slyouth.sd.vo.SdCodeDVO;

/**
 * @title	: [기준정보] 코드관리 DAO 클래스	  
 * @author	: gypig
 * @create	: 2021.06.16
 */
@Component
@Repository("sdCodeDAO")
@SuppressWarnings("unchecked")
public class SdCodeDAO extends AbstractDAO {

	private static final String NAMESPACE = "sd.code.";

	/**
	 * @title	: 코드 목록 건수 조회	  
	 * @method	: selectCodeTotalDataCnt()	 
	 * @comment	: 코드관리 화면에서 입력된 정보로 조회된 데이터의 건수를 리턴한다.	 
	 * @param	: sdCodeDVO
	 */
	public int selectCodeTotalDataCnt(SdCodeDVO sdCodeDVO) {
		return (int) select(NAMESPACE + "selectCodeTotalDataCnt", sdCodeDVO);
	}
	
	/**
	 * @title	: 코드 목록 조회	  
	 * @method	: selectCodeList()	 
	 * @comment	: 코드관리 화면에서 입력된 정보로 코드 목록을 조회한다.	  
	 * @param	: sdCodeDVO
	 */
	public List<SdCodeDVO> selectCodeList(SdCodeDVO sdCodeDVO) {
		return (List<SdCodeDVO>) selectList(NAMESPACE + "selectCodeList", sdCodeDVO);
	}

	/**
	 * @title	: 코드 상세 조회	  
	 * @method	: selectCodeDetail()	 
	 * @comment	: 코드 조회 목록에서 선택한 코드의 상세정보를 조회한다.	  
	 * @param	: sdCodeDVO
	 */
	public SdCodeDVO selectCodeDetail(SdCodeDVO paramVO) {
		return (SdCodeDVO) select(NAMESPACE + "selectCodeDetail", paramVO);
	}

}
