package com.gdgs.slyouth.mi.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdgs.slyouth.mi.service.MiIntroService;
import com.gdgs.slyouth.mi.service.dao.MiIntroDAO;
import com.gdgs.slyouth.mi.vo.MiIntroDVO;
import com.gdgs.slyouth.mi.vo.MiIntroSVO;
import com.gdgs.slyouth.nt.service.dao.NtNoticeDAO;
import com.gdgs.slyouth.nt.vo.NtNoticeDVO;

/**
 * @title 	: 교회소개(메인) 화면
 * @author	: gypig
 * @create 	: 2021.06.16
 */
@Component
@Service("miIntroService")
public class MiIntroServiceImpl implements MiIntroService {
	
	private static final Logger logger = LoggerFactory.getLogger(MiIntroServiceImpl.class);

	@Autowired
	private MiIntroDAO miIntroDAO;
	
	@Autowired
	private NtNoticeDAO ntNoticeDAO;

	/**
	 * @title	: 교회소개(메인) 화면 조회   
	 * @method	: selectMainIntro()	 
	 * @comment	: 소개 메인 조회를 한다.
	 * @param	: N/A
	 */
	@Override
	public MiIntroSVO selectMainIntro() throws Exception {
		
		MiIntroSVO returnSVO = new MiIntroSVO();
		// 메인 화면 조회
		MiIntroDVO miIntroView = miIntroDAO.selectIntroMain();
		
		List<NtNoticeDVO> ntList = ntNoticeDAO.ntNoticeSubList();
		
		returnSVO.setMiIntroDVO(miIntroView);
		returnSVO.setNtList(ntList);
		return returnSVO;
	}
	
	/**
	 * @title	: 교회소개(메인) 화면 수정 완료 
	 * @method  : updateMiIntro()    
	 * @comment	: 교회 소개 메인 수정을 한 뒤에 DB에 갖다옵니다.
	 * @param   : MiIntroDVO
	 */
	@Override
	public int updateMiIntro(MiIntroDVO miIntroDVO) throws Exception {
		
		return miIntroDAO.updateIntroMain(miIntroDVO);
	}
	
	/**
	 * @title	: 인사말 메인  
	 * @method	: greeting()
	 * @comment	: 인사말 조회를 합니다.		 
	 * @param	: N/A
	 */
	@Override
	public MiIntroSVO greeting() throws Exception {
		
		MiIntroSVO returnSVO = new MiIntroSVO();
		MiIntroDVO returnDVO = miIntroDAO.greetingView();
		
		returnSVO.setMiIntroDVO(returnDVO);
		return returnSVO;
	}

	/**
	 * @title	: 인사말 수정
	 * @method	: greetingSave()
	 * @comment	: 인사말을 수정할 수 있습니다.		 
	 * @param	: MiIntroDVO
	 */
	@Override
	@Transactional
	public MiIntroDVO greetingSave(MiIntroDVO miIntroDVO) throws Exception{
		MiIntroDVO returnDVO = new MiIntroDVO();
		
		int resultCnt = 0;
		try {
			resultCnt = miIntroDAO.greetingUpdate(miIntroDVO);
			
			returnDVO.setResultCnt(resultCnt);
		}catch(Exception e) {
			
			e.printStackTrace();
			
			logger.debug("########################################");
			logger.debug("DB 에러가 발생하였습니다.");
			logger.debug("########################################");
		}

		return returnDVO;
	}

	/**
	 * @title	: 예배안내 메인
	 * @method	: worshipInfo()
	 * @comment	: 예배안내를 조회합니다.		 
	 * @param	: MiIntroDVO
	 */
	@Override
	public MiIntroSVO worshipInfo() throws Exception {
		MiIntroSVO returnSVO = new MiIntroSVO();
		
		// 예배정보 조회
		MiIntroDVO worshipInfo = miIntroDAO.selectWorshipInfo();
		
		returnSVO.setMiIntroDVO(worshipInfo);
		return returnSVO;
	}

	/**
	 * @title	: 예배안내 수정
	 * @method	: worshipInfoSave()
	 * @comment	: 예배안내를 수정합니다.		 
	 * @param	: MiIntroDVO
	 * @return	: MiIntroDVO
	 */
	@Override
	@Transactional
	public MiIntroDVO worshipInfoSave(MiIntroDVO miIntroDVO) throws Exception {
		MiIntroDVO returnDVO = new MiIntroDVO();

		int resultCnt = miIntroDAO.worshipInfoUpdate(miIntroDVO);
		
		returnDVO.setResultCnt(resultCnt);
		return returnDVO;
	}

	/**
	 * @title	: 새가족반소개 기본정보 조회
	 * @method	: newcomerInfo
	 * @comment	: 새가족반소개 기본정보를 조회해온다.
	 * @param	: MiIntroDVO
	 */
	@Override
	public MiIntroSVO newcomerInfo(MiIntroDVO miIntroDVO) throws Exception {
		MiIntroSVO returnSVO = new MiIntroSVO();
		
		// 새가족소개 기본정보 조회
		MiIntroDVO newcomerInfo = miIntroDAO.selectNewcomerInfo(miIntroDVO);
		
		returnSVO.setMiIntroDVO(newcomerInfo);
		return returnSVO;
	}
}

