package com.gdgs.slyouth.ps.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gdgs.slyouth.cm.service.CmFileService;
import com.gdgs.slyouth.cm.vo.CmFileDVO;
import com.gdgs.slyouth.ps.service.PsIntroService;
import com.gdgs.slyouth.ps.service.dao.PsIntroDAO;
import com.gdgs.slyouth.ps.vo.PsIntroDVO;
import com.gdgs.slyouth.ps.vo.PsIntroSVO;

/**
 * @title   : [찬양과셀라] 셀라조회 Service 구현 클래스
 * @author  : 김예림
 * @create  : 2021. 07. 03.
 */
@Component
@Service("psIntroService")
public class PsIntroServiceImpl implements PsIntroService {

	private static final Logger logger = LoggerFactory.getLogger(PsIntroServiceImpl.class);
	
	@Autowired
	private PsIntroDAO psIntroDAO;

	@Autowired 
	private CmFileService cmFileService;
	
	/**
	 * @title   : 셀라소개 기본정보 조회
	 * @method  : selahInfo()
	 * @comment : 셀라소개 기본정보를 조회해온다.
	 * @param   : psIntroDVO
	 */
	@Override
	public PsIntroSVO selahInfo(PsIntroDVO psIntroDVO) throws Exception {
		PsIntroSVO returnSVO = new PsIntroSVO();
		
		// 셀라소개 기본정보 조회
		PsIntroDVO selahInfo = psIntroDAO.selectSelahInfo(psIntroDVO);
		
		returnSVO.setPsIntroDVO(selahInfo);
		return returnSVO;
	}

	/**
	 * @title	: 셀라소개 정보 수정
	 * @method	: saveSelahInfo
	 * @comment	: 셀라소개 기본정보 수정과 변경 이미지를 업로드한다.
	 * @param	: PsIntroDVO
	 */
	@Override
	public PsIntroDVO saveSelahInfo(PsIntroSVO paramSVO) throws Exception {
		PsIntroDVO returnDVO = new PsIntroDVO();
		CmFileDVO cmFileDVO = paramSVO.getCmFileDVO();
		
		// 파일정보 객체 (ORG: 기존, CHG: 변경)
		CmFileDVO orgFileInfo;
		CmFileDVO chgFileInfo;
		
		try {
			// 셀라소개 수정이력 업데이트
			int resultCnt = psIntroDAO.updateIntroInfo(paramSVO.getPsIntroDVO());
			
			if (resultCnt > 0) {
				// 기존 파일번호 조회
				orgFileInfo = cmFileService.selectFileInfoRef(cmFileDVO);
				
				// 변경 이미지 업로드
				chgFileInfo = cmFileService.uploadFile(cmFileDVO);
				
				int chgFileNo = chgFileInfo.getFileNo(); 
				logger.debug("upload FileNo :: " + chgFileNo);
				
				// 업로드 성공 시, 기존 이미지 삭제
				if (chgFileNo != 0) {
					returnDVO.setFileNo(chgFileNo);
					cmFileService.deleteFileInfo(orgFileInfo);
				}
			} else {
				throw new Exception();
			}
		} catch(Exception e) {
			
		}
		
		return returnDVO;
	};
}
