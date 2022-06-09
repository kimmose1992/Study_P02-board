package com.gdgs.slyouth.nt.service.impl;

import java.util.ArrayList;
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
import com.gdgs.slyouth.nt.service.NtCircleService;
import com.gdgs.slyouth.nt.service.dao.NtCircleDAO;
import com.gdgs.slyouth.nt.vo.NtCircleDVO;
import com.gdgs.slyouth.nt.vo.NtCircleSVO;
import com.gdgs.slyouth.um.service.UmMemberService;
import com.gdgs.slyouth.um.vo.UmMemberDVO;

/**
 * @title   : [커뮤니티] 동아리 Service 구현 클래스     
 * @author  : 송근영
 * @create  : 2021.07.25
 * @update  : 2021.08.16
 */

@Component
@Service
public class NtCircleServiceImpl implements NtCircleService{

	private static final Logger logger = LoggerFactory.getLogger(NtCircleServiceImpl.class);
	
	@Autowired
	private NtCircleDAO ntCircleDAO;
	
	@Autowired
	private CmFileService cmFileService;
	
	@Autowired
	private UmMemberService umMemberService;
	
	/**
	 * @title   : 동아리 목록조회
	 * @method  : circleList()
	 * @comment : 동아리 목록을 가져옵니다.
	 * @param   : NtCircleDVO
	 */
	public NtCircleSVO circleList(NtCircleDVO ntCircleDVO) throws Exception{
		
		NtCircleSVO returnSVO = new NtCircleSVO();
		NtCircleDVO returnDVO = new NtCircleDVO();
		
		logger.debug(ntCircleDVO.toString());
		
		// 동아리 목록 변수 선언
		List<NtCircleDVO> cirlcleList = new ArrayList<NtCircleDVO>();
		
		// 동아리 목록 갯수
		int totalDataCnt = ntCircleDAO.selectCircleTotalCnt(ntCircleDVO);
		
		// 목록 갯수가 존재하면 데이터 조회
		if ( totalDataCnt > 0 ) {
			
			cirlcleList = ntCircleDAO.circleList(ntCircleDVO);

			// 페이징 설정
			CmPagingOutDVO cmPagingOutDVO = new CmPagingOutDVO(ntCircleDVO);
			cmPagingOutDVO.setTotalDataCnt(totalDataCnt);
			returnSVO.setCmPagingOutDVO(cmPagingOutDVO);
		}
		
		// 검색어 재설정
		if ( ntCircleDVO.getEventNm() != null ) {
			returnDVO.setEventNm(ntCircleDVO.getEventNm());
		}
		
		returnSVO.setNtCircleDVO(ntCircleDVO);
		returnSVO.setNtCircleList(cirlcleList);
		return returnSVO;
	}
	
	/**
	 * @title   : 동아리 상세조회(단건)
	 * @method  : circleDetail()
	 * @comment : 동아리 상세 데이터(동아리 정보, 게시판, 리스트)를 가져옵니다.
	 * @param   : NtCircleDVO
	 */
	@Override
	public NtCircleSVO circleDetail(NtCircleDVO ntCircleDVO) throws Exception{

		NtCircleSVO returnSVO = new NtCircleSVO();

		// 동아리 단건 조회
		NtCircleDVO circleInfo = ntCircleDAO.selectCircleInfo(ntCircleDVO);
		
		// 동아리 조회에 실패한 경우
		if ( circleInfo == null ) {
			throw new Exception("동아리 정보 조회에 실패했습니다.");
		}
		
		// 동아리 첨부파일 변수
		NtCircleDVO circleFile = null;
		
		// 동아리 첨부파일 갯수 조회
		int fileTotalCnt = ntCircleDAO.selectCircleFileTotalCnt(ntCircleDVO);
		
		// 동아리 파일 갯수가 있다면
		if ( fileTotalCnt > 0 ) {
			
			// 동아리 첨부파일 조회
			circleFile = ntCircleDAO.selectCircleFile(ntCircleDVO);
		}
		
		// 동아리 게시판 목록 변수
		List<NtCircleDVO> circleCmntyList = null;

		// 페이징 변수
		CmPagingOutDVO cmPagingOutDVO = null;
		
		// 동아리 게시판 목록 갯수 조회
		int listCmntyCnt = ntCircleDAO.selectCircleBoardListTotalCnt(ntCircleDVO);
		
		// 동아리 게시판 목록 갯수가 있다면
		if ( listCmntyCnt > 0 ) {
			
			// 페이징 전체갯수 및 객체 설정
			cmPagingOutDVO = new CmPagingOutDVO(ntCircleDVO);
			cmPagingOutDVO.setTotalDataCnt(listCmntyCnt);
			
			// 동아리 게시판 목록 조회
			circleCmntyList = ntCircleDAO.selectCircleBoardList(ntCircleDVO);
		}
		
		// 신청자 목록 변수
		List<NtCircleDVO> circleAppMemberList = null;
		
		// 신청자 목록 갯수 조회
		int listMemberCnt = ntCircleDAO.selectCircleAppMemberListTotalCnt(ntCircleDVO);
		
		// 신청자 목록 갯수가 있다면
		if ( listMemberCnt > 0 ) {
			
			// 신청자 목록 조회
			circleAppMemberList = ntCircleDAO.selectCircleAppMemberList(ntCircleDVO);
		}
		
		returnSVO.setNtCircleFile(circleFile);
		returnSVO.setNtCircleCmntyList(circleCmntyList);
		returnSVO.setNtCircleAppMemberList(circleAppMemberList);
		returnSVO.setCmPagingOutDVO(cmPagingOutDVO);
		returnSVO.setNtCircleDVO(circleInfo);
		return returnSVO;
	}

	/**
	 * @title   : 동아리 등록수정
	 * @method  : circleEdit()
	 * @comment : 동아리 등록/수정 페이지 정보를 가져옵니다.
	 * @param   : NtCircleDVO
	 */
	@Override
	public NtCircleSVO circleEdit(NtCircleDVO ntCircleDVO) throws Exception{
		
		NtCircleSVO returnSVO = new NtCircleSVO();
		
		// 동아리 단건 변수
		NtCircleDVO circleInfo = new NtCircleDVO();
		
		// 등록의 경우 이벤트 구분코드 재설정
		circleInfo.setEventDivCd(ntCircleDVO.getEventDivCd());
		
		// 동아리 첨부파일 변수
		NtCircleDVO circleFile = new NtCircleDVO();
		
		// 수정인 경우 데이터 조회 
		if ( "U".equals(ntCircleDVO.getEditDivCd()) ) {
			
			// 동아리 단건 조회
			circleInfo = ntCircleDAO.selectCircleInfo(ntCircleDVO);
			
			// 동아리 첨부파일 갯수 조회
			int fileTotalCnt = ntCircleDAO.selectCircleFileTotalCnt(ntCircleDVO);
			
			// 동아리 파일 갯수가 있다면
			if ( fileTotalCnt > 0 ) {
				
				// 동아리 첨부파일 조회
				circleFile = ntCircleDAO.selectCircleFile(ntCircleDVO);
			}
		}
		
		// 저장을 위해 화면 hidden에 집어넣을 작성 구분코드 재설정
		circleInfo.setEditDivCd(ntCircleDVO.getEditDivCd());
		
		returnSVO.setNtCircleFile(circleFile);
		returnSVO.setNtCircleDVO(circleInfo);
		return returnSVO;
	}
	
	/**
	 * @title   : 동아리 삭제
	 * @method  : circleDel()
	 * @comment : 동아리와 관련된 모든 정보를 삭제합니다.
	 * @param   : NtCircleSVO
	 */
	@Override
	@Transactional
	public int circleDel(NtCircleSVO paramSVO) throws Exception {
		
		int returnValue = 0;
		
		try {
			
			
			
		} catch (Exception e) {
			
			logger.debug(e.getMessage());
		}
		
		return returnValue;
	}

	/**
	 * @title   : 동아리 저장
	 * @method  : circleSave()
	 * @comment : 동아리 정보를 저장합니다.
	 * @param   : NtCircleSVO
	 */
	@Override
	@Transactional
	public NtCircleDVO circleSave(NtCircleSVO paramSVO) throws Exception{
		
		NtCircleDVO returnDVO = new NtCircleDVO();
		CmFileDVO cmFileDVO = paramSVO.getCmFileDVO();
		
		// 파일정보 객체 (ORG: 기존, CHG: 변경)
		CmFileDVO orgFileInfo;
		CmFileDVO chgFileInfo;
		
		try {
			
			// 쿼리 수행 리턴값
			int resultCnt = 0;
			
			// DB 데이터 길이 맞춰서 값 변경
			paramSVO.getNtCircleDVO().setStrYmd(paramSVO.getNtCircleDVO().getStrYmd().replace("-", "")); // 시작일자
			
			
			if ( "I".equals(paramSVO.getNtCircleDVO().getEditDivCd()) ) {
				
				// 동아리 등록
				resultCnt = ntCircleDAO.insertCircle(paramSVO.getNtCircleDVO());
				
				// 동아리 정상등록 확인
				if ( resultCnt == 0 ) {
					throw new Exception("동아리 정보 저장을 실패했습니다.");
				}
				
				// 동아리 등록 후 페이지 이동을 위한 동아리 번호 재설정
				returnDVO.setEventNo(paramSVO.getNtCircleDVO().getEventNo());
				
				// 등록된 동아리 번호를 첨부파일 참조번호에 재설정
				cmFileDVO.setRefNo(paramSVO.getNtCircleDVO().getEventNo());
				
				// 임시등록자 번호(지울거임)
				paramSVO.getNtCircleDVO().setChrNo(1);
				
				// 동아리장을 신청자 테이블에 등록
				resultCnt = ntCircleDAO.insertCircleAppMember(paramSVO.getNtCircleDVO());
				
				// 동아리장 신청인원 등록 에러
				if ( resultCnt == 0 ) {
					throw new Exception("동아리장 등록을 실패했습니다.");
				}
				
				// 게시판 관리테이블에 게시판 등록
				resultCnt = ntCircleDAO.insertCircleCmntyMng(paramSVO.getNtCircleDVO());
				
				// 게시판 관리테이블에 정상 저장 확인
				if ( resultCnt == 0 ) {
					throw new Exception("게시판 등록에 실패했습니다.");
				}
				
				// 동아리 대표 이미지 업로드
				chgFileInfo = cmFileService.uploadFile(cmFileDVO);
				
				// 업로드된 번호
				int chgFileNo = chgFileInfo.getFileNo(); 
				logger.debug("upload FileNo :: " + chgFileNo);
				
				if ( chgFileNo == 0 ) {
					throw new Exception("이미지 파일 저장에 실패했습니다.");
				}
				
				// 동아리 메인 이미지 파일번호 세팅
				paramSVO.getNtCircleDVO().setFileNo(chgFileNo);
				
				// 메인 이미지 번호 수정
				resultCnt = ntCircleDAO.updateCircleThumbNo(paramSVO.getNtCircleDVO());
				
				if ( resultCnt == 0 ) {
					throw new Exception("동아리 메인 이미지 저장에 실패했습니다.");
				}
				
				// 첨부파일 저장
				for( MultipartFile file : paramSVO.getCmFileDVO().getUploadFiles() ){
					// 파일 유무 확인 
					boolean isFileEmpty = file.isEmpty();
					
					// 비어있지 않다면
					if ( !isFileEmpty ) {
						// 첨부파일 꺼내서 파일 DVO 세팅
						paramSVO.getCmFileDVO().setUploadFile(file);
						
						// 파일 업로드
						chgFileInfo = cmFileService.uploadFile(cmFileDVO);
						
						// 업로드된 번호
						chgFileNo = chgFileInfo.getFileNo(); 
						logger.debug("upload FileNo :: " + chgFileNo);
						
						// 업로드 확인
						if ( chgFileNo == 0 ) {
							throw new Exception("동아리 첨부파일 저장을 실패했습니다.");
						}
					}
				}
				
			} else if ( "U".equals(paramSVO.getNtCircleDVO().getEditDivCd()) ) {
				
				// 동아리 수정
				resultCnt = ntCircleDAO.updateCircle(paramSVO.getNtCircleDVO());
				
				// 동아리 수정 후 페이지 이동을 위한 동아리 번호 재설정
				returnDVO.setEventNo(paramSVO.getNtCircleDVO().getEventNo());
				
				// 동아리 수정 확인
				if ( resultCnt == 0 ) {
					throw new Exception("동아리 정보 저장을 실패했습니다.");
				}
				
				// 저장할 이미지 파일 존재유무 확인 변수
				boolean isImgEmpty = cmFileDVO.getUploadFile().isEmpty();
				
				// 파일 번호 임시저장(첨부파일 번호)
				int tempFileNo = cmFileDVO.getFileNo();
				
				// 이미지 파일 번호
				int imgFileNo = paramSVO.getNtCircleDVO().getRepImgNo();
				
				// 기존 이미지 파일이 존재한다면
				if ( !isImgEmpty && imgFileNo > 0 ) {
					// 이미지 파일번호 세팅
					cmFileDVO.setFileNo(imgFileNo);
					
					// 기존 파일번호 조회
					orgFileInfo = cmFileService.selectFileInfoNo(cmFileDVO);
					
					if ( orgFileInfo != null ) {
						// 기존 파일 삭제
						cmFileService.deleteFileInfo(orgFileInfo);
					}
				}
				
				// 이미지 파일 저장
				if ( !isImgEmpty ) {
					// 변경 이미지 업로드
					chgFileInfo = cmFileService.uploadFile(cmFileDVO);
					
					// 변경 이미지 번호
					int chgFileNo = chgFileInfo.getFileNo(); 
					logger.debug("upload FileNo :: " + chgFileNo);
					
					if ( chgFileNo == 0 ) {
						throw new Exception("이미지 저장에 실패하였습니다.");
					}
					
					// 동아리 메인 이미지 번호 세팅
					paramSVO.getNtCircleDVO().setFileNo(chgFileNo);
					
					// 동아리 메인 이미지 번호 저장
					resultCnt = ntCircleDAO.updateCircleThumbNo(paramSVO.getNtCircleDVO());
					
					// 저장 확인 유무
					if ( resultCnt == 0 ) {
						throw new Exception("메인 썸네일 저장에 실패했습니다.");
					}
				}
				
				// 첨부파일 저장
				for( MultipartFile file : paramSVO.getCmFileDVO().getUploadFiles() ){
					// 저장할 첨부파일 존재유무 확인 변수
					boolean isFileEmpty = file.isEmpty();
					
					// 기존 첨부파일이 존재한다면
					if ( !isFileEmpty && tempFileNo > 0 ) {
						// 첨부파일번호 세팅
						cmFileDVO.setFileNo(tempFileNo);
						
						// 기존 파일번호 조회
						orgFileInfo = cmFileService.selectFileInfoNo(cmFileDVO);
						
						if ( orgFileInfo != null ) {
							// 기존 파일 삭제
							cmFileService.deleteFileInfo(orgFileInfo);
						}
					}
					
					// 첨부파일 업로드
					if ( !isFileEmpty ) {
						
						// 파일 세팅
						cmFileDVO.setUploadFile(file);
						
						// 변경 이미지 업로드
						chgFileInfo = cmFileService.uploadFile(cmFileDVO);
						
						// 변경 이미지 번호
						int chgFileNo = chgFileInfo.getFileNo(); 
						logger.debug("upload FileNo :: " + chgFileNo);
						
						if ( chgFileNo == 0 ) {
							throw new Exception("이미지 저장에 실패하였습니다.");
						}
					}
				}
			}
		} catch(Exception e) {
			
			logger.debug(e.getMessage());
			
			throw new RuntimeException(e.getMessage());
		}
		
		return returnDVO;
	}
	
	/**
	 * @title   : 동아리 게시판 상세
	 * @method  : circleBoardDetail()
	 * @comment : 동아리 게시판 상세정보를 조회합니다.
	 * @param   : NtCircleDVO
	 */
	@Override
	@Transactional
	public NtCircleSVO circleBoardDetail(NtCircleDVO ntCircleDVO) throws Exception {

		NtCircleSVO returnSVO = new NtCircleSVO();
		
		// 게시판 상세 조회수 증가, 상세 조회를 제외한 등록 및 수정에서 돌아왔을때는 조회수가 증
		int resultCnt = ntCircleDAO.updateBoardViewCnt(ntCircleDVO);
		
		// 조회수 증가 못하면 에러
		if ( resultCnt == 0 ) {
			throw new Exception("조회수 증가를 실패했습니다.");
		}
		
		// 동아리 게시판 단건 조회
		NtCircleDVO circleBoardInfo =  ntCircleDAO.selectCircleBoard(ntCircleDVO);

		// 동아리 게시판 단건 조회를 못하면
		if ( circleBoardInfo == null ) {
			throw new Exception("동아리 게시판 상세 조회를 실패했습니다.");
		}
		
		// 동아리 게시판 첨부파일 변수
		NtCircleDVO circleBoardFile = null;
		
		// 첨부파일 갯수 조회
		int boardFileCnt = ntCircleDAO.selectCircleBoardFileTotalCnt(ntCircleDVO);
		
		// 만약 첨부파일이 있다면
		if ( boardFileCnt > 0 ) {
			// 첨부파일조회
			circleBoardFile = ntCircleDAO.selectCircleBoardFile(ntCircleDVO);
			
			if ( circleBoardFile == null ) {
				throw new Exception("게시판 상세 파일조회를 실패했습니다.");
			}
		}
		
		returnSVO.setNtCircleCmntyFile(circleBoardFile);
		returnSVO.setNtCircleCmnty(circleBoardInfo);
		return returnSVO;
	}

	/**
	 * @title   : 동아리 게시판 작성
	 * @method  : circleBoardEdit()
	 * @comment : 동아리 게시판 작성 페이지정보를 조회합니다.
	 * @param   : NtCircleDVO
	 */
	@Override
	public NtCircleSVO circleBoardEdit(NtCircleDVO ntCircleDVO) throws Exception {
		
		NtCircleSVO returnSVO = new NtCircleSVO();
		
		// 게시판 단건 변수
		NtCircleDVO circleBoardInfo = new NtCircleDVO();
		
		// 첨부파일 변수
		NtCircleDVO circleBoardFile =  new NtCircleDVO();
		
		// 등록 페이지 경우 취소버튼을 위한 동아리 번호 및 구분코드 재설정
		circleBoardInfo.setEventNo(ntCircleDVO.getEventNo());
		circleBoardInfo.setEventDivCd(ntCircleDVO.getEventDivCd());
		
		// 수정인 경우
		if ( "U".equals(ntCircleDVO.getEditDivCd()) ) {
			
			// 게시판 단건 조회
			circleBoardInfo =  ntCircleDAO.selectCircleBoard(ntCircleDVO);
			
			// 첨부파일 갯수 조회
			int boardFileCnt = ntCircleDAO.selectCircleBoardFileTotalCnt(ntCircleDVO);
			
			if ( boardFileCnt > 0 ) {
				// 첨부파일조회
				circleBoardFile = ntCircleDAO.selectCircleBoardFile(ntCircleDVO);
			}
		}
		
		// 콜백 페이지 이동을 위한 작성구분코드 재설정
		circleBoardInfo.setEditDivCd(ntCircleDVO.getEditDivCd());
		
		returnSVO.setNtCircleCmntyFile(circleBoardFile);
		returnSVO.setNtCircleCmnty(circleBoardInfo);
		return returnSVO;
	}
	
	/**
	 * @title   : 동아리 게시판 저장
	 * @method  : circleBoardSave()
	 * @comment : 동아리 게시판 작성 내용을 저장합니다.
	 * @param   : NtCircleDVO
	 */
	@Override
	@Transactional
	public NtCircleDVO circleBoardSave(NtCircleSVO paramSVO) throws Exception {
		
		NtCircleDVO returnDVO = new NtCircleDVO();
		CmFileDVO cmFileDVO = paramSVO.getCmFileDVO();
		
		// 파일정보 객체 (ORG: 기존, CHG: 변경)
		CmFileDVO orgFileInfo;
		CmFileDVO chgFileInfo;
		
		try {
			
			// 쿼리 수행 리턴값
			int resultCnt = 0;
			
			if ( "I".equals(paramSVO.getNtCircleCmnty().getEditDivCd()) ) {
				
				// 게시판 등록
				resultCnt = ntCircleDAO.insertCircleBoard(paramSVO.getNtCircleCmnty());
				
				// 게시판 정상등록 확인
				if ( resultCnt == 0 ) {
					throw new Exception("게시물 저장에 실패하였습니다");
				}
				
				// 콜백에서 페이지 이동을 위한 최근 등록된 게시물 번호 세팅
				returnDVO.setCmntyNo(paramSVO.getNtCircleCmnty().getCmntyNo());
				
				// 첨부파일 유무 확인 변수
				boolean isFileEmpty = cmFileDVO.getUploadFile().isEmpty();
				
				if ( !isFileEmpty ) {
					// 등록된 게시물 번호를 첨부파일 참조번호에 세팅
					cmFileDVO.setRefNo(paramSVO.getNtCircleCmnty().getCmntyNo());

					// 첨부파일 저장;
					chgFileInfo = cmFileService.uploadFile(cmFileDVO);
					
					// 업로드된 번호
					int chgFileNo = chgFileInfo.getFileNo(); 
					logger.debug("upload FileNo :: " + chgFileNo);
					
					if ( chgFileNo == 0 ) {
						throw new Exception("게시물 첨부파일 저장을 실패했습니다.");
					}
				}
			} else if ( "U".equals(paramSVO.getNtCircleCmnty().getEditDivCd())) {
				
				// 동아리 게시판 수정
				resultCnt = ntCircleDAO.updateCircleBoard(paramSVO.getNtCircleCmnty());
				
				// 수정 확인
				if ( resultCnt == 0 ) {
					throw new Exception("게시물 수정에 실패했습니다.");
				}
				
				// 게시물 번호 재설정
				returnDVO.setCmntyNo(paramSVO.getNtCircleCmnty().getCmntyNo());
				
				// 첨부파일 유무 확인 변수
				boolean isFileEmpty = cmFileDVO.getUploadFile().isEmpty();
				
				// 기존 첨부파일이 있다면
				if ( !isFileEmpty && cmFileDVO.getFileNo() > 0 ) {
					// 기존 파일번호 조회
					orgFileInfo = cmFileService.selectFileInfoNo(cmFileDVO);
					
					// 파일정보를 조회했다면
					if ( orgFileInfo != null ) {
						// 파일 삭제
						cmFileService.deleteFileInfo(orgFileInfo);
					}
				}
				
				// 변경 첨부파일 업로드
				if ( !isFileEmpty ) {
					// 파일 업로드
					chgFileInfo = cmFileService.uploadFile(cmFileDVO);
					
					// 업로드된 파일 번호
					int chgFileNo = chgFileInfo.getFileNo(); 
					logger.debug("upload FileNo :: " + chgFileNo);
					
					// 업로드 여부확인
					if ( chgFileNo == 0) {
						throw new Exception("게시물 첨부파일 저장에 실패했습니다");
					}
				}
			}
		} catch(Exception e) {
			
			logger.debug(e.getMessage());
			
			throw new RuntimeException();
		}
		
		// 이벤트 구분 코드 재설정
		returnDVO.setEventDivCd(paramSVO.getNtCircleDVO().getCmntyDivCd());
		
		// 작성구분코드 재설정
		returnDVO.setEditDivCd(paramSVO.getNtCircleDVO().getEditDivCd());
		
		return returnDVO;
	}

	/**
	 * @title   : 동아리 게시판 삭제
	 * @method  : circleBoardDel()
	 * @comment : 동아리 게시판 상세 내용을 삭제합니다.
	 * @param   : NtCircleDVO
	 */
	@Override
	@Transactional
	public int circleBoardDel(NtCircleDVO ntCircleDVO) throws Exception {

		int resultCnt = 0;
		
		try {
			
			// 첨부파일 갯수 조회
			int boardFileCnt = ntCircleDAO.selectCircleBoardFileTotalCnt(ntCircleDVO);
			
			// 첨부파일이 존재한다면 
			if ( boardFileCnt > 0 ) {
				// 파일 변수
				CmFileDVO file = new CmFileDVO();
				
				// 첨부파일 파일 번호 세팅
				file.setFileNo(ntCircleDVO.getFileNo());
				
				// 첨부파일 조회
				file = cmFileService.selectFileInfoNo(file);
				
				// 파일이 존재한다면
				if ( file != null ) {
					// 파일 삭제
					cmFileService.deleteFileInfo(file);
				}
				else {
					throw new Exception("파일 삭제에 실패했습니다.");
				}
			}
			
			resultCnt = ntCircleDAO.deleteCircleBoard(ntCircleDVO);
			
			if ( resultCnt == 0 ) {
				throw new Exception("게시판 정보 삭제를 실패했습니다.");
			}
			
		} catch (Exception e) {
			logger.debug(e.getMessage());
			
			throw new RuntimeException();
		}
		
		return resultCnt;
	}

	/**
	 * @title   : 동아리 신청가능 인원 조회
	 * @method  : selectChrMemberModal()
	 * @comment : 동아리 신청 가능한 인원을 조회합니다.
	 * @param   : N/A
	 * @throws Exception 
	 */
	@Override
	public List<UmMemberDVO> selectChrMemberModal() throws Exception {
		
		// 모달 구분코드 생성
		UmMemberDVO umMemberDVO = new UmMemberDVO();
		umMemberDVO.setModalDivCd("CIR");
		
		return (List<UmMemberDVO>) umMemberService.selectChrMemberModal(umMemberDVO);
	}

	/**
	 * @title   : 동아리 신청가능 인원 조회
	 * @method  : memberModalSave()
	 * @comment : 동아리 신청한 인원을 저장합니다.
	 * @param   : List<NtCircleDVO>
	 */
	@Override
	@Transactional
	public int memberModalSave(List<NtCircleDVO> appMember) {
		
		int resultCnt = 0;
		
		try {
			for(NtCircleDVO member : appMember) {
				resultCnt = ntCircleDAO.insertCircleAppMember(member);
				if ( resultCnt == 0 ) {
					throw new Exception("신청인원 저장에 실패했습니다.");
				}
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		
		return resultCnt;
	}

}
