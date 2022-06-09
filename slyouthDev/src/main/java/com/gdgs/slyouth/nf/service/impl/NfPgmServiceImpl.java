package com.gdgs.slyouth.nf.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.gdgs.slyouth.cm.service.CmFileService;
import com.gdgs.slyouth.cm.vo.CmFileDVO;
import com.gdgs.slyouth.cm.vo.CmPagingOutDVO;
import com.gdgs.slyouth.nf.service.NfPgmService;
import com.gdgs.slyouth.nf.service.dao.NfPgmDAO;
import com.gdgs.slyouth.nf.vo.NfPgmDVO;
import com.gdgs.slyouth.nf.vo.NfPgmSVO;

/**
 * @title  : [양육과훈련] 프로그램 Service 구현 클래스
 * @author : 송근영
 * @create : 2021.08.02
 */
@Component
@Service("nfPgmService")
public class NfPgmServiceImpl implements NfPgmService {

	private static final Logger logger = LoggerFactory.getLogger(NfPgmServiceImpl.class);
	
	@Autowired
	private NfPgmDAO nfPgmDAO;
	
	@Autowired
	private CmFileService cmFileService;

	/**
	 * @title   : 프로그램 목록 조회
	 * @method  : pgmList
	 * @comment : 프로그램 목록 정보를 조회한다.
	 * @param   : NfPgmDVO
	 */
	@Override
	public NfPgmSVO pgmList(NfPgmDVO nfPgmDVO) throws Exception {
		NfPgmSVO returnSVO = new NfPgmSVO();
		NfPgmDVO returnDVO = new NfPgmDVO();
		
		// 프로그램 목록 갯수 조회
		int totalCnt = nfPgmDAO.selectPgmListTotalCnt(nfPgmDVO);
		
		if ( totalCnt > 0 ) {
			// 프로그램 목록 정보를 조회
			List<NfPgmDVO> pgmList = nfPgmDAO.selectPgmList(nfPgmDVO);
			returnSVO.setPgmList(pgmList);
			
			// 페이징 설정
			CmPagingOutDVO cmPagingOutDVO = new CmPagingOutDVO(nfPgmDVO);
			cmPagingOutDVO.setTotalDataCnt(totalCnt);
			returnSVO.setCmPagingOutDVO(cmPagingOutDVO);
		}
		
		// 검색어 재할당
		if ( nfPgmDVO.getEventNm() != null ) {
			returnDVO.setEventNm(nfPgmDVO.getEventNm());
		}
	
		returnSVO.setNfPgmDVO(returnDVO);
		return returnSVO;
	}

	/**
	 * @title   : 프로그램 상세 조회
	 * @method  : pgmDetail
	 * @comment : 프로그램 목록 정보를 조회한다.
	 * @param   : NfPgmDVO
	 */
	@Override
	public NfPgmSVO pgmDetail(NfPgmDVO nfPgmDVO) throws Exception {
		NfPgmSVO returnSVO = new NfPgmSVO();
		
		// 프로그램 상세정보
		NfPgmDVO pgmInfo = nfPgmDAO.selectPgmDetail(nfPgmDVO);
		
		if ( pgmInfo == null ) {
			throw new Exception("게시물 조회에 실패했습니다.");
		}
		
		// 프로그램 상세 첨부파일 조회
		// 첨부파일 변수
		NfPgmDVO pgmFile = new NfPgmDVO();
		
		// 첨부파일 개수 조회
		int fileCnt = nfPgmDAO.selectPgmFileTotalCnt(nfPgmDVO);
		
		if ( fileCnt > 0 ) {
			pgmFile = nfPgmDAO.selectPgmFile(nfPgmDVO);
		}
		
		// 공지사항 게시판 조회
		int cmntyCnt = nfPgmDAO.selectPgmCmntyListTotalCnt(nfPgmDVO);
		
		if ( cmntyCnt > 0 ) {
			List<NfPgmDVO> cmntyList = nfPgmDAO.selectPgmCmntyList(nfPgmDVO);
			returnSVO.setNfPgmCmntyList(cmntyList);
		}
		
		// 활동게시판 조회
		int actCmntyCnt = nfPgmDAO.selectPgmActCmntyListTotalCnt(nfPgmDVO);
		
		if ( actCmntyCnt > 0 ) {
			List<NfPgmDVO> actCmntyList = nfPgmDAO.selectPgmActCmntyList(nfPgmDVO);
			returnSVO.setNfPgmActCmntyList(actCmntyList);
		}
		
		returnSVO.setNfPgmFile(pgmFile);
		returnSVO.setNfPgmDVO(pgmInfo);
		return returnSVO;
	}

	/**
	 * @title   : 프로그램 작성     
	 * @method  : pgmEdit
	 * @comment : 프로그램 작성/수정 정보를 조회합니다.       
	 * @param   : NfPgmDVO
	 */
	@Override
	public NfPgmSVO pgmEdit(NfPgmDVO nfPgmDVO) {
		NfPgmSVO returnSVO = new NfPgmSVO();
		
		// 프로그램 생성 페이지인 경우
		NfPgmDVO returnDVO = new NfPgmDVO();
		
		// 이벤트 구분코드 재설정
		returnDVO.setEventDivCd(nfPgmDVO.getEventDivCd());
		
		// 수정페이지인 경우에 값 할당
		if ( "U".equals(nfPgmDVO.getEditDivCd()) ) {
			returnDVO = nfPgmDAO.selectPgmDetail(nfPgmDVO);
		}
		
		// 작성구분코드 재설정
		returnDVO.setEditDivCd(nfPgmDVO.getEditDivCd());
		
		// 프로그램 상세 첨부파일 조회
		NfPgmDVO pgmFile = new NfPgmDVO();
		
		int fileCnt = nfPgmDAO.selectPgmFileTotalCnt(nfPgmDVO);
		
		if ( fileCnt > 0 ) {
			pgmFile = nfPgmDAO.selectPgmFile(nfPgmDVO);
		}
		
		returnSVO.setNfPgmFile(pgmFile);
		returnSVO.setNfPgmDVO(returnDVO);
		return returnSVO;
	}

	/**
	 * @title   : 프로그램 저장      
	 * @method  : pgmSave 
	 * @comment : 프로그램 정보를 저장합니다.
	 * @param   : NfPgmDVO
	 */
	@Override
	@Transactional
	public NfPgmDVO pgmSave(NfPgmSVO paramSVO) {
		
		NfPgmDVO returnDVO = new NfPgmDVO();
		CmFileDVO cmFileDVO = paramSVO.getCmFileDVO();
		
		// 파일정보 객체 (ORG: 기존, CHG: 변경)
		CmFileDVO orgFileInfo;
		CmFileDVO chgFileInfo;
		
		try {
			
			// 쿼리 수행 리턴값
			int resultCnt = 0;
			
			// DB 데이터 길이 맞춰서 값 변경
			paramSVO.getNfPgmDVO().setStrYmd(paramSVO.getNfPgmDVO().getStrYmd().replace("-", "")); // 시작일자
			paramSVO.getNfPgmDVO().setEndYmd(paramSVO.getNfPgmDVO().getEndYmd().replace("-", "")); // 시작일자
			
			if ( "I".equals(paramSVO.getNfPgmDVO().getEditDivCd()) ) {
				
				// 프로그램 등록
				resultCnt = nfPgmDAO.insertProgram(paramSVO.getNfPgmDVO());
				
				// 프로그램 정상등록 확인
				if ( resultCnt == 0 ) {
					throw new Exception("동아리 정보 저장을 실패했습니다.");
				}
				
				// 프로그램 등록 후 페이지 이동을 위한 프로그램 번호 재설정
				returnDVO.setEventNo(paramSVO.getNfPgmDVO().getEventNo());
				
				// 등록된 프로그램 번호를 첨부파일 참조번호에 재설정
				cmFileDVO.setRefNo(paramSVO.getNfPgmDVO().getEventNo());
				
				// 임시등록자 번호(지울거임)
				paramSVO.getNfPgmDVO().setChrNo(1);
				
				// 게시판 관리테이블에 게시판 등록
				resultCnt = nfPgmDAO.insertPgmCmntyMng(paramSVO.getNfPgmDVO());
				
				// 프로그램 게시판 관리테이블 정상등록 확인
				if ( resultCnt == 0 ) {
					throw new Exception("프로그램 게시판 등록을 실패했습니다.");
				}
				
				// 게시판 관리테이블에 정상 저장이라면 이미지 저장 및 첨부파일 저장
				// 프로그램 대표 이미지 업로드
				chgFileInfo = cmFileService.uploadFile(cmFileDVO);
				
				// 업로드된 번호
				int chgFileNo = chgFileInfo.getFileNo(); 
				logger.debug("upload FileNo :: " + chgFileNo);
				
				// 프로그램 메인 이미지 파일번호 세팅
				paramSVO.getNfPgmDVO().setFileNo(chgFileNo);
				
				// 메인 이미지 번호 수정
				resultCnt = nfPgmDAO.updateProgramThumbNo(paramSVO.getNfPgmDVO());
				
				// 프로그램 게시판 관리테이블 정상등록 확인
				if ( resultCnt == 0 ) {
					throw new Exception("프로그램 이미지 등록에 실패했습니다.");
				}
				
				// 첨부파일 저장
				for( MultipartFile file : paramSVO.getCmFileDVO().getUploadFiles() ){
					
					// 파일 존재유무 체크
					if ( file.isEmpty() ) {
						continue;
					}
					
					paramSVO.getCmFileDVO().setUploadFile(file);
					
					chgFileInfo = cmFileService.uploadFile(cmFileDVO);
					
					// 업로드된 번호
					chgFileNo = chgFileInfo.getFileNo(); 
					logger.debug("upload FileNo :: " + chgFileNo);
					
					if ( chgFileNo == 0 ) {
						throw new Exception("프로그램 첨부파일 저장을 실패했습니다.");
					}
				}
				
			} else {
				
				// 프로그램 수정
				resultCnt = nfPgmDAO.updateProgram(paramSVO.getNfPgmDVO());
				
				// 프로그램 수정여부 확인
				if ( resultCnt == 0 ) {
					throw new Exception("프로그램 정보수정에 실패했습니다.");
				}
				
				// 프로그램 수정 후 페이지 이동을 위한 동아리 번호 재설정
				returnDVO.setEventNo(paramSVO.getNfPgmDVO().getEventNo());
				
				// 이미지 파일 유무
				boolean imgFileIsEmpty = cmFileDVO.getUploadFile().isEmpty();
				
				// 첨부파일 번호 임시
				int tempFileNo = cmFileDVO.getFileNo();
				
				// 변경된 이미지 첨부파일이 존재하면 기존 파일 삭제
				if ( !imgFileIsEmpty && paramSVO.getNfPgmDVO().getRepImgNo() > 0 ) {
					
					// 이미지 파일번호 세팅
					cmFileDVO.setFileNo(paramSVO.getNfPgmDVO().getRepImgNo());
					
					// 기존 첨부 건 조회
					orgFileInfo = cmFileService.selectFileInfoNo(cmFileDVO);
					
					// 기존 첨부 건 삭제
					cmFileService.deleteFileInfo(orgFileInfo);
				}
				
				// 수정된 첨부파일 저장
				if ( !imgFileIsEmpty ) {
					// 첨부파일 저장
					chgFileInfo = cmFileService.uploadFile(cmFileDVO);
					
					// 업로드된 번호
					int chgFileNo = chgFileInfo.getFileNo(); 
					logger.debug("upload FileNo :: " + chgFileNo);
					
					if ( chgFileNo == 0 ) {
						throw new Exception("프로그램 이미지 첨부파일 저장을 실패했습니다.");
					}
					
					// 메인 이미지 파일번호 변경
					returnDVO.setFileNo(chgFileNo);
					
					nfPgmDAO.updateProgramThumbNo(returnDVO);
				}
				
				// 첨부파일번호 세팅
				cmFileDVO.setFileNo(tempFileNo);
				
				// 첨부파일 저장
				for( MultipartFile file : paramSVO.getCmFileDVO().getUploadFiles() ){
					
					// 이미지 파일 유무
					boolean fileIsEmpty = file.isEmpty();
					
					// 첨부파일 세팅
					cmFileDVO.setUploadFile(file);
					
					// 기존 첨부파일이 존재하는 경우
					if ( !fileIsEmpty && cmFileDVO.getFileNo() > 0 ) {
						
						// 기존 파일번호 조회
						orgFileInfo = cmFileService.selectFileInfoRef(cmFileDVO);
						
						// 변경 첨부파일 업로드
						chgFileInfo = cmFileService.uploadFile(cmFileDVO);
						
						// 변경 이미지 번호
						int chgFileNo = chgFileInfo.getFileNo(); 
						logger.debug("upload FileNo :: " + chgFileNo);
						
						// 업로드 성공 시, 기존 이미지 삭제
						if (chgFileNo != 0) {
							cmFileService.deleteFileInfo(orgFileInfo);
						}
					} else if ( !fileIsEmpty ) { // 첨부파일을 새로 등록하는 경우
						// 첨부파일 업로드
						chgFileInfo = cmFileService.uploadFile(cmFileDVO);
						
						// 변경 이미지 번호
						int chgFileNo = chgFileInfo.getFileNo(); 
						logger.debug("upload FileNo :: " + chgFileNo);
						
						if ( chgFileNo == 0 ) {
							throw new Exception("첨부파일을 저장하지 못했습니다.");
						}
					}
				}
			}
			
		} catch(Exception e) {
			
			logger.debug(e.getMessage());
			
			throw new RuntimeException();
		}
		
		return returnDVO;
	}

	/**
	 * @title   : 프로그램 게시판 상세      
	 * @method  : pgmBoardDetail    
	 * @comment : 게시판(활동게시판, 공지사항) 상세 정보를 조회합니다.       
	 * @param   : NfPgmDVO
	 * @throws Exception 
	 */
	@Override
	@Transactional
	public NfPgmSVO pgmBoardDetail(NfPgmDVO nfPgmDVO) throws Exception {
		NfPgmSVO returnSVO = new NfPgmSVO();
		
		// 조회수 증가
		if ( !"I".equals(nfPgmDVO.getEditDivCd()) && !"U".equals(nfPgmDVO.getEditDivCd()) ) {
			nfPgmDAO.updateBoardViewCnt(nfPgmDVO);
		}
		
		// 게시판 단건 조회
		NfPgmDVO programBoardInfo = nfPgmDAO.selectProgramBoard(nfPgmDVO);
		
		if ( programBoardInfo == null ) {
			throw new Exception("프로그램 게시판 정보를 조회하지 못했습니다.");
		}
		
		// 활동게시판, 공지사항의 구분코드 재설정
		programBoardInfo.setTopFixYn(nfPgmDVO.getTopFixYn());
		
		// 프로그램 게시판 첨부파일 변수
		NfPgmDVO programBoardFile = null;
		
		// 첨부파일 갯수 조회
		int boardFileCnt = nfPgmDAO.selectPgmBoardFileTotalCnt(nfPgmDVO);
		
		// 첨부파일이 존재한다면
		if ( boardFileCnt > 0 ) {
			// 첨부파일조회
			programBoardFile = nfPgmDAO.selectPgmBoardFile(nfPgmDVO);
			
			// 조회 실패 시
			if ( programBoardFile == null ) {
				throw new Exception("첨부파일을 조회하지 못했습니다.");
			}
		}
		
		returnSVO.setNfPgmCmntyFile(programBoardFile);
		returnSVO.setNfPgmCmnty(programBoardInfo);
		return returnSVO;
	}

	/**
	 * @title   : 프로그램 게시판 작성     
	 * @method  : pgmBoardEdit    
	 * @comment : 프로그램 게시판 작성페이지 정보를 조회합니다.       
	 * @param   : NfPgmDVO
	 */
	@Override
	public NfPgmSVO pgmBoardEdit(NfPgmDVO nfPgmDVO) throws Exception{
		NfPgmSVO returnSVO = new NfPgmSVO();
		
		// 게시물 첨부파일 변수
		NfPgmDVO file = null;
		
		// 게시물 정보 변수, 등록 페이지의 경우
		NfPgmDVO returnDVO = new NfPgmDVO();
		
		// 이벤트 구분코드 재설정(프로그램)
		returnDVO.setEventDivCd(nfPgmDVO.getEventDivCd());
		
		// 이벤트 번호설정
		returnDVO.setEventNo(nfPgmDVO.getEventNo());
		
		// 수정 페이지의 경우
		if ( "U".equals(nfPgmDVO.getEditDivCd()) ) {
			// 게시물 정보 조회
			returnDVO = nfPgmDAO.selectProgramBoard(nfPgmDVO);
			
			if ( returnDVO == null ) {
				throw new Exception("게시물 정보를 조회하지 못했습니다.");
			}
			
			// 게시물 첨부파일 갯수
			int fileCnt = nfPgmDAO.selectPgmBoardFileTotalCnt(nfPgmDVO);
						
			// 파일이 존재한다면
			if ( fileCnt > 0 ) {
				// 파일조회
				file = nfPgmDAO.selectPgmBoardFile(nfPgmDVO);
				
				// 조회 실패의 경우
				if ( file == null ) {
					throw new Exception("첨부파일을 조회하지 못했습니다.");
				}
			}
		}
		
		// 활동게시판, 공지사항의 구분코드 재설정
		returnDVO.setTopFixYn(nfPgmDVO.getTopFixYn());

		// 작성구분코드 재설정
		returnDVO.setEditDivCd(nfPgmDVO.getEditDivCd());
		
		returnSVO.setNfPgmCmntyFile(file);
		returnSVO.setNfPgmCmnty(returnDVO);
		return returnSVO;
	}

	/**
	 * @title   : 프로그램 게시판 저장     
	 * @method  : pgmBoardSave    
	 * @comment : 프로그램 게시판 작성페이지 정보를 저장합니다.       
	 * @param   : NfPgmSVO
	 */
	@Override
	@Transactional
	public NfPgmDVO pgmBoardSave(NfPgmSVO paramSVO) {
		
		NfPgmDVO returnDVO = new NfPgmDVO();
		CmFileDVO cmFileDVO = paramSVO.getCmFileDVO();
		
		// 파일정보 객체 (ORG: 기존, CHG: 변경)
		CmFileDVO orgFileInfo;
		CmFileDVO chgFileInfo;
		
		try {
			
			// 쿼리 수행 리턴값
			int resultCnt = 0;
			
			// 등록 페이지의 경우
			if ( "I".equals(paramSVO.getNfPgmCmnty().getEditDivCd()) ) {
				
				// 게시판 등록
				resultCnt = nfPgmDAO.insertProgramCmnty(paramSVO.getNfPgmCmnty());
				
				// 게시판 정상등록 확인
				if ( resultCnt == 0 ) {
					throw new Exception("게시물 저장에 실패하였습니다.");
				}
				
				// 콜백에서 페이지 이동을 위한 최근 등록된 게시물 번호 세팅
				returnDVO.setCmntyNo(paramSVO.getNfPgmCmnty().getCmntyNo());
				
				// 등록된 게시물 번호를 첨부파일 참조번호에 세팅
				cmFileDVO.setRefNo(paramSVO.getNfPgmCmnty().getCmntyNo());
				
				// 첨부파일 저장
				chgFileInfo = cmFileService.uploadFile(cmFileDVO);
				
				// 업로드된 번호
				int chgFileNo = chgFileInfo.getFileNo(); 
				logger.debug("upload FileNo :: " + chgFileNo);
				
				if ( chgFileNo == 0 ) {
					throw new Exception("프로그램 첨부파일 저장을 실패했습니다.");
				}
				
			} else { // 수정 페이지의 경우
				// 게시판 수정
				resultCnt = nfPgmDAO.updateProgramCmnty(paramSVO.getNfPgmCmnty());
				
				// 게시판 수정 확인
				if ( resultCnt == 0 ) {
					throw new Exception("게시물 저장에 실패하였습니다.");
				}
				
				// 첨부파일 변경 유무 확인
				boolean isFileEmpty = cmFileDVO.getUploadFile().isEmpty();
				
				// 변경된 첨부파일이 존재하면 기존 파일 삭제
				if ( !isFileEmpty && cmFileDVO.getFileNo() > 0 ) {
					
					// 기존 첨부 건 조회
					orgFileInfo = cmFileService.selectFileInfoNo(cmFileDVO);
					
					// 기존 첨부 건 삭제
					cmFileService.deleteFileInfo(orgFileInfo);
				}
				
				// 수정된 첨부파일 저장
				if ( !isFileEmpty ) {
					// 첨부파일 저장
					chgFileInfo = cmFileService.uploadFile(cmFileDVO);
					
					// 업로드된 번호
					int chgFileNo = chgFileInfo.getFileNo(); 
					logger.debug("upload FileNo :: " + chgFileNo);
					
					if ( chgFileNo == 0 ) {
						throw new Exception("프로그램 첨부파일 저장을 실패했습니다.");
					}
				}
				
				returnDVO.setCmntyNo(paramSVO.getNfPgmCmnty().getCmntyNo());
			}
			
		} catch (Exception e) {
			
			logger.debug(e.getMessage());
			
			throw new RuntimeException();
		}
		
		// 작성 구분 코드
		returnDVO.setEditDivCd(paramSVO.getNfPgmCmnty().getEditDivCd());
		
		return returnDVO;
	}

	/**
	 * @title   : 프로그램 게시판 삭제     
	 * @method  : pgmBoardDel    
	 * @comment : 프로그램 게시판 정보를 삭제합니다.       
	 * @param   : NfPgmSVO
	 */
	@Override
	@Transactional
	public NfPgmDVO pgmBoardDel(NfPgmSVO paramSVO) {
		
		NfPgmDVO returnDVO = new NfPgmDVO();
		CmFileDVO cmFileDVO = paramSVO.getCmFileDVO();
		
		// 파일정보 객체 (ORG: 기존)
		CmFileDVO orgFileInfo;
		
		try {
			
			// 결과값 변수
			int resultCnt = 0;
			
			// 게시물 삭제
			resultCnt = nfPgmDAO.deleteProgramCmnty(paramSVO.getNfPgmCmnty());
			
			// 삭제확인
			if ( resultCnt == 0 ) {
				throw new Exception("게시물 정보 삭제를 실패했습니다.");
			}
			
			// 첨부파일 삭제
			if ( cmFileDVO.getFileNo() > 0 ) {
				
				// 기존 첨부 건 조회
				orgFileInfo = cmFileService.selectFileInfoNo(cmFileDVO);
				
				// 기존 첨부 건 삭제
				cmFileService.deleteFileInfo(orgFileInfo);
			}
			
			// 성공여부 저장
			returnDVO.setCmntyNo(resultCnt);
			
			// 이벤트 번호
			returnDVO.setEventNo(paramSVO.getNfPgmCmnty().getEventNo());
			
		} catch (Exception e) {
			
			logger.debug(e.getMessage());
			
			throw new RuntimeException();
		}
		
		return returnDVO;
	}

	/**
	 * @title   : 프로그램 신청      
	 * @method  : pgmApply()
	 * @comment : 프로그램 참가자 명단에 자신을 추가합니다.       
	 * @param   : NfPgmDVO
	 */
	@Override
	@Transactional
	public int pgmApply(NfPgmDVO nfPgmDVO) {
		
		int resultNum = 0;
		
		try {
			
			// 프로그램 신청
			resultNum = nfPgmDAO.insertProgramAppMember(nfPgmDVO);
			
			if ( resultNum == 0 ) {
				throw new Exception("프로그램 신청 저장을 실패했습니다.");
			}
			
		} catch (Exception e) {
			logger.debug(e.getMessage());
			
			throw new RuntimeException();
		}
		
		return resultNum;
	}

	/**
	 * @title   : 프로그램 신청      
	 * @method  : pgmApplyCancel()
	 * @comment : 프로그램 참가자 명단에 자신을 추가합니다.       
	 * @param   : NfPgmDVO
	 */
	@Override
	@Transactional
	public int pgmApplyCancel(NfPgmDVO nfPgmDVO) {
		
		int resultNum = 0;
		
		try {
			
			// 프로그램 신청
			resultNum = nfPgmDAO.deleteProgramAppMember(nfPgmDVO);
			
			if ( resultNum == 0 ) {
				throw new Exception("프로그램 신청취소를 실패했습니다.");
			}
			
		} catch (Exception e) {
			logger.debug(e.getMessage());
			
			throw new RuntimeException();
		}
		
		return resultNum;
	}

	/**
	 * @title   : 프로그램 신청자 명단 조회      
	 * @method  : selectPgmAppMember    
	 * @comment : 프로그램 신청자 명단을 조회합니다.     
	 * @param   : 
	 */
	@Override
	public List<NfPgmDVO> selectPgmAppMember(NfPgmDVO nfPgmDVO) {
		
		return (List<NfPgmDVO>) nfPgmDAO.selectProgramAppMember(nfPgmDVO);
	}
}
