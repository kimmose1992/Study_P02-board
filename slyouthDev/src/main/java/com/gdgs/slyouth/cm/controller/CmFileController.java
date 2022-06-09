package com.gdgs.slyouth.cm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gdgs.slyouth.cm.service.CmFileService;
import com.gdgs.slyouth.cm.utils.CmMediaUtils;
import com.gdgs.slyouth.cm.vo.CmFileDVO;

/**
 * @title	: [공통] 파일관리 Controller 클래스	  
 * @author	: mosekim
 * @create	: 2021.06.11
 */
@RestController
@RequestMapping("/cm/")
public class CmFileController {

	@Autowired
	private CmFileService cmFileService;
	
	/**
	 * @title	: 썸머노트 이미지 업로드
	 * @method	: uploadSummernoteImageFile()
	 * @comment	: 썸머노트 이미지 업로드 
	 * @param	: cmFileDVO
	 * @return	: cmFileDVO
	 */
	@PostMapping("uploadSummernoteImageFile")
	public CmFileDVO uploadSummernoteImageFile(CmFileDVO cmFileDVO) throws Exception {
		return cmFileService.uploadSummernoteImageFile(cmFileDVO);
	}

	/**
	 * @title	: 이미지 출력
	 * @method	: viewImage()
	 * @comment	: 이미지 출력 
	 * @param	: cmFileDVO
	 */
	@GetMapping("viewImage/{fileNo}")
	public ResponseEntity<?> viewImage(CmFileDVO cmFileDVO) throws Exception {
		try {
			cmFileDVO = cmFileService.selectFileInfoNo(cmFileDVO);
            HttpHeaders headers = new HttpHeaders();
            
            Resource resource = cmFileService.loadAsResource(cmFileDVO.getSaveFileNm());
            String fileName = cmFileDVO.getFileNm();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
 
            if (CmMediaUtils.containsImageMediaType(cmFileDVO.getFileType())) {
                headers.setContentType(MediaType.valueOf(cmFileDVO.getFileType()));
            } else {
                headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            }
            
            return ResponseEntity.ok().headers(headers).body(resource);
            
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
	}

	/**
	 * @title	: 파일 다운로드
	 * @method	: fileDownload()
	 * @comment	: 파일 다운로드
	 * @param	: cmFileDVO
	 */
	@GetMapping("fileDownload/{fileNo}")
	public ResponseEntity<?> fileDownload(CmFileDVO cmFileDVO) throws Exception {
		try {
			cmFileDVO = cmFileService.selectFileInfoNo(cmFileDVO);
			HttpHeaders headers = new HttpHeaders();
			
			Resource resource = cmFileService.loadAsResource(cmFileDVO.getSaveFileNm());
			String fileName = cmFileDVO.getFileNm();
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
			
			if (CmMediaUtils.containsFileMediaType(cmFileDVO.getFileType())) {
				headers.setContentType(MediaType.valueOf(cmFileDVO.getFileType()));
			} else {
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			}
			
			return ResponseEntity.ok().headers(headers).body(resource);
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}
}
