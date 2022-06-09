package com.gdgs.slyouth.nm.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.gdgs.slyouth.cm.service.CmFileService;
import com.gdgs.slyouth.cm.vo.CmFileDVO;
import com.gdgs.slyouth.nm.service.NmIntroService;
import com.gdgs.slyouth.nm.service.dao.NmIntroDAO;
import com.gdgs.slyouth.nm.vo.NmIntroDVO;
import com.gdgs.slyouth.nm.vo.NmIntroSVO;

/**
 * @title   : [새가족] 새가족조회 Service 구현 클래스
 * @author  : 이하은
 * @create  : 2021.06.30
 */
@Component
@Service("nmIntroService")
public class NmIntroServiceImpl implements NmIntroService {
	
	private static final Logger logger = LoggerFactory.getLogger(NmIntroServiceImpl.class);
	
	@Autowired
	private NmIntroDAO nmIntroDAO;

	@Autowired 
	private CmFileService cmFileService;
	
	/**
	 * @title	: 새가족소개 기본정보 조회  
	 * @method	: memberInfo
	 * @comment	: 새가족소개 기본정보를 가져온다.
	 * @param	: nmIntroDVO
	 */
	@Override
	public NmIntroSVO memberInfo(NmIntroDVO nmIntroDVO) throws Exception {
		NmIntroSVO returnSVO = new NmIntroSVO();
		
		// 새가족소개 기본정보 조회
		NmIntroDVO memberInfo = nmIntroDAO.selectMemberInfo(nmIntroDVO);
		
		returnSVO.setNmIntroDVO(memberInfo);
		return returnSVO;
	}

	/**
	 * @title	: 새가족소개 정보 수정
	 * @method	: saveMemberInfo
	 * @comment	: 새가족소개 기본정보 수정과 변경 이미지를 업로드한다.
	 * @param	: NmIntroSVO
	 */
	@Override
	public NmIntroDVO saveMemberInfo(NmIntroSVO paramSVO) throws Exception {
		NmIntroDVO returnDVO = new NmIntroDVO();
		CmFileDVO cmFileDVO = paramSVO.getCmFileDVO();
		
		// 파일정보 객체 (ORG: 기존, CHG: 변경)
		CmFileDVO orgFileInfo;
		CmFileDVO chgFileInfo;
		
		try {
			// 새가족소개 수정이력 업데이트
			int resultCnt = nmIntroDAO.updateIntroInfo(paramSVO.getNmIntroDVO());
			
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
	}

}
