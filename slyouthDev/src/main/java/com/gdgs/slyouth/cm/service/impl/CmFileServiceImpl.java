package com.gdgs.slyouth.cm.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidParameterException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.gdgs.slyouth.cm.service.CmFileService;
import com.gdgs.slyouth.cm.service.dao.CmFileDAO;
import com.gdgs.slyouth.cm.utils.CmFileUtils;
import com.gdgs.slyouth.cm.vo.CmFileDVO;

/**
 * @title	: [공통] 파일관리 Service 구현 클래스	  
 * @author	: mosekim
 * @create	: 2021.06.11
 */
@Component
@Service("cmFileService")
public class CmFileServiceImpl implements CmFileService {

	private static final Logger logger = LoggerFactory.getLogger(CmFileServiceImpl.class);
	
	private final Path uploadPath;
	
    @Autowired
    public CmFileServiceImpl(String uploadPath) {
        this.uploadPath = Paths.get(uploadPath);
    }
    
    @Autowired
    private CmFileDAO cmFileDAO;

	/**
	 * @title	: 파일 업로드 	  
	 * @method	: uploadFile()	 
	 * @comment	: 파일 업로드		 
	 * @param	: cmFileDVO
	 * @return	: cmFileDVO
	 */
	@Override
	public CmFileDVO uploadFile(CmFileDVO cmFileDVO) throws Exception {
		
		CmFileDVO returnFile = null;
		
		try {
			if (cmFileDVO == null) {
				throw new InvalidParameterException();
			}

			MultipartFile file = cmFileDVO.getUploadFile();
			
			if (file.isEmpty()) {
				throw new FileNotFoundException();
			}
			
            String saveFileNm = CmFileUtils.fileSave(uploadPath.toString(), file);
            
            if (saveFileNm.toCharArray()[0] == '/') {
            	saveFileNm = saveFileNm.substring(1);
            }
            
            Resource resource = loadAsResource(saveFileNm);
            
            cmFileDVO.setSaveFileNm(saveFileNm);
            cmFileDVO.setFileNm(file.getOriginalFilename());
            cmFileDVO.setFileType(file.getContentType());
            cmFileDVO.setSavePth((uploadPath.toString() + File.separator + saveFileNm).replace(File.separatorChar, '/'));
            cmFileDVO.setFileSize(((org.springframework.core.io.Resource) resource).contentLength());
            
            /**
             * 1. 파일정보 저장
             * 2. 파일 일련번호 채번
             */
            cmFileDAO.saveFileInfo(cmFileDVO);
            
            returnFile = new CmFileDVO();
            returnFile.setFileNo(cmFileDVO.getFileNo());
        } catch (InvalidParameterException e1) {
        	logger.debug("업로드 정보가 올바르지 않습니다.");
        } catch (FileNotFoundException e2) {
        	logger.debug("파일 정보를 찾을 수 없습니다.");
        } catch (IOException e3) {
        	logger.debug("파일 업로드에 실패하였습니다.");
        } catch (Exception e) {
        	logger.debug(e.getMessage());
        }
		
		return returnFile;
	}
	
	/**
	 * @title	: 썸머노트 이미지 업로드
	 * @method	: uploadSummernoteImageFile()
	 * @comment	: 썸머노트 이미지 업로드 
	 * @param	: cmFileDVO
	 * @return	: cmFileDVO
	 */
	@Override
	public CmFileDVO uploadSummernoteImageFile(CmFileDVO cmFileDVO) throws Exception {
		
		CmFileDVO returnFile = null;
		
		try {
			if (cmFileDVO == null) {
				throw new InvalidParameterException();
			}

			MultipartFile file = cmFileDVO.getUploadFile();
			
			if (file.isEmpty()) {
				throw new FileNotFoundException();
			}
			
            String saveFileNm = CmFileUtils.fileSave(uploadPath.toString(), file);
            
            if (saveFileNm.toCharArray()[0] == '/') {
            	saveFileNm = saveFileNm.substring(1);
            }
            
            Resource resource = loadAsResource(saveFileNm);
            
            cmFileDVO.setSaveFileNm(saveFileNm);
            cmFileDVO.setFileNm(file.getOriginalFilename());
            cmFileDVO.setFileType(file.getContentType());
            cmFileDVO.setSavePth((uploadPath.toString() + File.separator + saveFileNm).replace(File.separatorChar, '/'));
            cmFileDVO.setFileSize(((org.springframework.core.io.Resource) resource).contentLength());
            
            /**
             * 1. 파일정보 저장
             * 2. 파일 일련번호 채번
             */
            cmFileDAO.saveFileInfo(cmFileDVO);
            
            returnFile = new CmFileDVO();
            returnFile.setFileNo(cmFileDVO.getFileNo());
            returnFile.setFileUrl("/cm/viewImage/" + cmFileDVO.getFileNo());
        } catch (InvalidParameterException e1) {
        	logger.debug("업로드 정보가 올바르지 않습니다.");
        } catch (FileNotFoundException e2) {
        	logger.debug("파일 정보를 찾을 수 없습니다.");
        } catch (IOException e3) {
        	logger.debug("파일 업로드에 실패하였습니다.");
        } catch (Exception e) {
        	logger.debug(e.getMessage());
        }
		
		return returnFile;
	}

	/**
	 * @title	: 파일 리소스 읽기 및 반환
	 * @method	: loadAsResource	 
	 * @comment	: 저장된 파일명으로 파일 리소스를 읽어서 반환한다.		 
	 * @param	: saveFileNm
	 * @return	: Resource
	 */
    public Resource loadAsResource(String fileName) throws Exception {
        try {
            if (fileName.toCharArray()[0] == '/') {
                fileName = fileName.substring(1);
            }
            
            Path file = loadPath(fileName);
            Resource resource = new UrlResource(file.toUri());
            
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new Exception("파일을 읽을 수 없습니다 [파일명] :: " + fileName);
            }
        } catch (Exception e) {
            throw new Exception("파일을 읽을 수 없습니다 [파일명] :: " + fileName);
        }
    }
    
    private Path loadPath(String fileName) {
        return uploadPath.resolve(fileName);
    }

	/**
	 * @title	: 파일 정보 조회 	  
	 * @method	: selectFileInfoNo	 
	 * @comment	: 첨부파일번호로 파일정보 조회	 
	 * @param	: cmFileDVO
	 * @return	: cmFileDVO
	 */
	@Override
	public CmFileDVO selectFileInfoNo(CmFileDVO cmFileDVO) throws Exception {
		return cmFileDAO.selectFileInfoNo(cmFileDVO);
	}

	/**
	 * @title	: 파일 정보 조회 	  
	 * @method	: selectFileInfoNo	 
	 * @comment	: 참조키로 파일정보 조회	 
	 * @param	: cmFileDVO
	 * @return	: cmFileDVO
	 */
	@Override
	public CmFileDVO selectFileInfoRef(CmFileDVO cmFileDVO) throws Exception {
		return cmFileDAO.selectFileInfoRef(cmFileDVO);
	}

	/**
	 * @title	: 첨부파일정보 삭제
	 * @method	: deleteFileInfo	 
	 * @comment	: 첨부파일 정보와 실제 업로드된 파일을 삭제한다.
	 * @param	: cmFileDVO
	 * @return	: N/A
	 */
	@Override
	public void deleteFileInfo(CmFileDVO cmFileDVO) throws Exception {
		
		logger.debug("##### File Delete Info ###########################");
        logger.debug("## fileNo 	: " + cmFileDVO.getFileNo());
        logger.debug("## filePath 	: " + cmFileDVO.getSavePth());
        logger.debug("##################################################");
		
		// 파일정보 삭제
		cmFileDAO.deleteFileInfoNo(cmFileDVO);
		
		// 업로드 파일 삭제
		CmFileUtils.fileDel(cmFileDVO);
	}

}
