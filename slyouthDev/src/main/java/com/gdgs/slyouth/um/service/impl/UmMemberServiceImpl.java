package com.gdgs.slyouth.um.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdgs.slyouth.cm.service.CmFileService;
import com.gdgs.slyouth.cm.vo.CmFileDVO;
import com.gdgs.slyouth.cm.vo.CmPagingOutDVO;
import com.gdgs.slyouth.um.service.UmMemberService;
import com.gdgs.slyouth.um.service.dao.UmMemberDAO;
import com.gdgs.slyouth.um.vo.UmMemberDVO;
import com.gdgs.slyouth.um.vo.UmMemberSVO;

/**
 * @title  : 공동체관리 Service 구현
 * @author : 송근영
 * @create : 2021.05.24
 * @update : 2021.08.21
 */
@Component
@Service("umMemberService")
public class UmMemberServiceImpl implements UmMemberService {

	private static final Logger logger = LoggerFactory.getLogger(UmMemberServiceImpl.class);

	@Autowired
	private UmMemberDAO umMemberDAO;
	
	@Autowired
	private CmFileService cmFileService;
	
	/**
	 * @title   : 교적검색 및 조회
	 * @method  : memberList
	 * @comment : 데이터 베이스에 교인정보를 검색 및 조회합니다
	 * @param   : UmMemberDVO
	 */
	@Override
	public UmMemberSVO memberList(UmMemberDVO umMemberDVO) {

		UmMemberSVO returnSVO = new UmMemberSVO();
		
		// 교인정보
		List<UmMemberDVO> memberList = null;
		
		// 전체 데이터 갯수
		int memberTotalCnt = umMemberDAO.memberTotalCnt(umMemberDVO);
		
		if(memberTotalCnt > 0) {
			
			// 교인정보
			memberList = umMemberDAO.memberList(umMemberDVO);
			
			// 페이징 설정
			CmPagingOutDVO cmPagingOutDVO = new CmPagingOutDVO(umMemberDVO);
			cmPagingOutDVO.setTotalDataCnt(memberTotalCnt); 
			returnSVO.setCmPagingOutDVO(cmPagingOutDVO);
		}
		
		returnSVO.setUmMemberDVOList(memberList);
		return returnSVO;
	}

	/**
	 * @title   : 교적 단건
	 * @method  : memberDetail
	 * @comment : 데이터 베이스에 교인정보를 단건으로 가져옵니다
	 * @param   : UmMemberDVO
	 */
	@Override
	public UmMemberSVO memberDetail(UmMemberDVO umMemberDVO) {

		UmMemberSVO returnSVO = new UmMemberSVO();

		// 교인단건
		UmMemberDVO returnDVO = umMemberDAO.selectMember(umMemberDVO);
		
		// 페이지 번호 세팅
		returnDVO.setPageNo(umMemberDVO.getPageNo());
		
		// 첨부파일 조회
		CmFileDVO imgFile = umMemberDAO.selectMemberImage(umMemberDVO);
		
		if ( imgFile == null ) {
			imgFile = new CmFileDVO();
		}
		
		returnSVO.setCmFileDVO(imgFile);
		returnSVO.setUmMemberDVO(returnDVO);
		return returnSVO;
	}

	/**
	 * @title	: 교인 검색 단건 등록수정   
	 * @method	: memberEdit()	 
	 * @comment	: 교인을 조회한다
	 * @param	: UmMemberDVO
	 */
	@Override
	public UmMemberSVO memberEdit(UmMemberDVO umMemberDVO) {

		UmMemberSVO returnSVO = new UmMemberSVO();

		// 교인단건
		UmMemberDVO returnDVO = new UmMemberDVO();
		
		// 상세조회와 수정 뷰의 분기처리
		if ( !("I".equals(umMemberDVO.getEditDivCd())) ) {
			returnDVO = umMemberDAO.selectMember(umMemberDVO);
		}
		
		// 저장 구분 코드(I, U) 세팅
		returnDVO.setEditDivCd(umMemberDVO.getEditDivCd());
		
		// 페이지 번호 세팅
		returnDVO.setPageNo(umMemberDVO.getPageNo());
		
		// 첨부파일 조회
		CmFileDVO imgFile = umMemberDAO.selectMemberImage(umMemberDVO);
		
		if ( imgFile == null ) {
			imgFile = new CmFileDVO();
		}
		
		returnSVO.setCmFileDVO(imgFile);
		returnSVO.setUmMemberDVO(returnDVO);
		return returnSVO;
	}

	/**
	 * @title   : 교적등록/수정
	 * @method  : memberSave
	 * @comment : 데이터 베이스에 교인정보를 저장합니다.
	 * @param   : UmMemberSVO
	 */
	@Override
	@Transactional
	public UmMemberDVO memberSave(UmMemberSVO paramSVO) throws Exception {
		
		UmMemberDVO returnDVO = new UmMemberDVO();
		CmFileDVO cmFileDVO = paramSVO.getCmFileDVO();
		
		// 파일정보 객체 (ORG: 기존, CHG: 변경)
		CmFileDVO orgFileInfo;
		CmFileDVO chgFileInfo;
		
		try {
			
			// 쿼리 수행 결과값
			int resultCnt = 0;
			
			// 생년월일 데이터 '-' 처리
			paramSVO.getUmMemberDVO().setBirth(paramSVO.getUmMemberDVO().getBirth().replace("-", ""));
			
			// 등록일 데이터 '-' 처리
			paramSVO.getUmMemberDVO().setChrRegYmd(paramSVO.getUmMemberDVO().getChrRegYmd().replace("-", ""));
			
			if ( "I".equals(paramSVO.getUmMemberDVO().getEditDivCd()) ) {
				// 교적 등록
				resultCnt = umMemberDAO.insertMember(paramSVO.getUmMemberDVO());
				
				// 값 체크
				if ( resultCnt == 0) {
					throw new Exception("교적 등록 실패");
				}
				
				// 등록된 교적번호를 참조번호에 세팅
				cmFileDVO.setRefNo(paramSVO.getUmMemberDVO().getChrNo());
				
				// 등록된 교적번호를 돌려줄 dvo에 세팅
				returnDVO.setChrNo(paramSVO.getUmMemberDVO().getChrNo());
				
				// 첨부파일 유무확인
				Boolean isFileEmpty = cmFileDVO.getUploadFile().isEmpty();
				
				if ( !isFileEmpty ) {
					// 파일 업로드
					chgFileInfo = cmFileService.uploadFile(cmFileDVO);
					
					// 업로드된 번호
					int chgFileNo = chgFileInfo.getFileNo(); 
					logger.debug("upload FileNo :: " + chgFileNo);
					
					if ( chgFileNo == 0 ) {
						throw new Exception("교적 사진 저장을 실패했습니다.");
					}
				}
				
			} else if ( "U".equals(paramSVO.getUmMemberDVO().getEditDivCd()) ) {
				// 교적 수정
				resultCnt = umMemberDAO.updateMember(paramSVO.getUmMemberDVO());
				
				// 값 체크
				if ( resultCnt == 0) {
					throw new Exception("교적 수정 실패");
				}
				
				// 첨부파일 유무확인
				Boolean isFileEmpty = cmFileDVO.getUploadFile().isEmpty();
				
				// 기존 파일 삭제
				if ( !isFileEmpty && cmFileDVO.getFileNo() > 0 ) {
					
					// 기존 첨부 건 조회
					orgFileInfo = cmFileService.selectFileInfoNo(cmFileDVO);
					
					// 기존 첨부 건 삭제
					cmFileService.deleteFileInfo(orgFileInfo);
				}
				
				// 첨부파일 참조번호
				cmFileDVO.setRefNo(paramSVO.getUmMemberDVO().getChrNo());
				
				// 첨부파일 저장
				if ( !isFileEmpty ) {
					// 파일 업로드
					chgFileInfo = cmFileService.uploadFile(cmFileDVO);
					
					// 업로드된 번호
					int chgFileNo = chgFileInfo.getFileNo(); 
					logger.debug("upload FileNo :: " + chgFileNo);
					
					if ( chgFileNo == 0 ) {
						throw new Exception("교적 사진 저장을 실패했습니다.");
					}
				}
			}
			
		} catch (Exception e) {
			
			logger.debug(e.getMessage());
			
			throw new RuntimeException();
		}
		
		return returnDVO;
	}

	/**
	 * @title   : 교적삭제
	 * @method  : deleteMember()
	 * @comment : 데이터 베이스에 교인정보를 삭제합니다.
	 * @param   : umMemberDVO
	 */
	@Override
	@Transactional
	public int deleteMember(UmMemberDVO umMemberDVO) throws Exception {

		int returnValue = 0;

		try {

			returnValue = umMemberDAO.deleteMember(umMemberDVO);

		} catch (Exception e) {

			e.printStackTrace();
			logger.debug("########################################");
			logger.debug("교적삭제에 실패하였습니다");
			logger.debug("########################################");
		}

		return returnValue;
	}

	/**
	 * @title	: 모달 검색 조회   
	 * @method	: selectChrMemberModal()	 
	 * @comment	: 모달창에 띄울 교인을 조회한다
	 * @param	: UmMemberDVO
	 */
	public List<UmMemberDVO> selectChrMemberModal(UmMemberDVO umMemberDVO) {
		
		return (List<UmMemberDVO>) umMemberDAO.selectChrMemberModal(umMemberDVO);
	}
	
}
