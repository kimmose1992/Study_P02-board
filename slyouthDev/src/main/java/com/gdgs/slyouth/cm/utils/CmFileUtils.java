package com.gdgs.slyouth.cm.utils;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.gdgs.slyouth.cm.vo.CmFileDVO;

public class CmFileUtils {
    
    private static final Logger logger = LoggerFactory.getLogger(CmFileUtils.class);
    
    /**
     * 파일 저장 메소드
     * 
     * @param uploadPath
     * @param multipartFile
     * @return saveFileNm
     * @throws IllegalStateException
     * @throws IOException
     */
    public static String fileSave(String uploadPath, MultipartFile file) throws Exception {
        
        File uploadPathDir = new File(uploadPath);
        
        if (!uploadPathDir.exists()) {
            uploadPathDir.mkdirs();
        }
        
        String fileId = UUID.randomUUID().toString();
        fileId = fileId.replace("-", "");
        
        String originalfileName = file.getOriginalFilename();
        String fileExtension = getExtension(originalfileName);
        String saveFileName = fileId + "." + fileExtension;
        
        String savePath = calcPath(uploadPath);
        
        logger.debug("##### File Upload Info ###########################");
        logger.debug("## originalfileName : " + originalfileName);
        logger.debug("## fileExtension 	  : " + fileExtension);
        logger.debug("## saveFileName 	  : " + saveFileName);
        logger.debug("## savePath 		  : " + savePath);
        logger.debug("##################################################");
        
        File target = new File(uploadPath + savePath, saveFileName);
        
        FileCopyUtils.copy(file.getBytes(), target);
        
        return makeFilePath(uploadPath, savePath, saveFileName);
    }
    
    /**
     * 확장자 반환 메소드
     * 
     * @param fileName 
     * @return 확장자
     */
    public static String getExtension(String originalfileName) {
        int dotPosition = originalfileName.lastIndexOf('.');
        
        if (-1 != dotPosition && originalfileName.length() - 1 > dotPosition) {
            return originalfileName.substring(dotPosition + 1);
        } else {
            return "";
        }
    }
    
    /**
     * 저장 경로 조회 메소드
     * 
     * @param 	: uploadPath 
     * @comment : 경로가 존재하지 않을 경우, 폴더 생성 메소드를 호출한다.
     * @return 	: 일자별 저장 경로
     */
    private static String calcPath(String uploadPath) {
        Calendar cal = Calendar.getInstance();
        
        String yearPath = File.separator + cal.get(Calendar.YEAR);
        String monthPath = yearPath + File.separator + new DecimalFormat("00").format((cal.get(Calendar.MONTH) + 1));
        String datePath = monthPath + File.separator + new DecimalFormat("00").format(cal.get(Calendar.DATE));
        
        makeDir(uploadPath, yearPath, monthPath, datePath);
        
        return datePath;
    }

    /**
     * 저장 경로 생성 메소드
     * 
     * @param 	: uploadPath, paths
     * @comment : 일자별 경로를 생성한다.
     */
    private static void makeDir(String uploadPath, String... paths) {
    	
        System.out.println(paths[paths.length - 1] + " : " + new File(paths[paths.length - 1]).exists());
        if (new File(paths[paths.length - 1]).exists()) {
            return;
        }
        
        for (String path : paths) {
            File dirPath = new File(uploadPath + path);
            
            if (!dirPath.exists()) {
                dirPath.mkdir();
            }
        }
    }
    
    private static String makeFilePath(String uploadPath, String path, String fileName) throws IOException {
        String filePath = uploadPath + path + File.separator + fileName;
        return filePath.substring(uploadPath.length()).replace(File.separatorChar, '/');
    }

    /**
     * 파일 삭제 메소드
     * 
     * @param uploadPath
     * @param CmFileDVO
     * @throws IllegalStateException
     * @throws IOException
     */
	public static void fileDel(CmFileDVO cmFileDVO) throws Exception {

		// 파일 삭제
		File deleteFile = new File(cmFileDVO.getSavePth());
        
        if (deleteFile.exists()) {
        	deleteFile.delete();
        }
	}
    
}
