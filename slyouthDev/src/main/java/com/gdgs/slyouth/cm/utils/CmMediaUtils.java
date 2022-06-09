package com.gdgs.slyouth.cm.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;

/**
 * @title	: 미디어 타입 관리 유틸 클래스 	  
 * @author	: mosekim
 * @create	: 2021.06.16
 */
public class CmMediaUtils {

	private static Map<String, MediaType> mediaImageMap;
	private static Map<String, MediaType> mediaFileMap;
	
	static {
		mediaImageMap = new HashMap<>();
	    
		mediaImageMap.put("JPEG", MediaType.IMAGE_JPEG);
		mediaImageMap.put("JPG", MediaType.IMAGE_JPEG);
		mediaImageMap.put("GIF", MediaType.IMAGE_GIF);
		mediaImageMap.put("PNG", MediaType.IMAGE_PNG);
		
		mediaFileMap = new HashMap<>();
	    
		mediaFileMap.put("JPEG", MediaType.IMAGE_JPEG);
		mediaFileMap.put("JPG", MediaType.IMAGE_JPEG);
		mediaFileMap.put("GIF", MediaType.IMAGE_GIF);
		mediaFileMap.put("PNG", MediaType.IMAGE_PNG);
		mediaFileMap.put("TXT", MediaType.TEXT_PLAIN);
		mediaFileMap.put("PDF", MediaType.APPLICATION_PDF);
	}
	
	public static MediaType getMediaImageType(String type) {
	    return mediaImageMap.get(type.toUpperCase());
	}

	public static MediaType getMediaFileType(String type) {
		return mediaFileMap.get(type.toUpperCase());
	}

	public static boolean containsImageMediaType(String mediaType) {
	    return mediaImageMap.values().contains(MediaType.valueOf(mediaType));
	}

	public static boolean containsFileMediaType(String mediaType) {
		return mediaFileMap.values().contains(MediaType.valueOf(mediaType));
	}
}


