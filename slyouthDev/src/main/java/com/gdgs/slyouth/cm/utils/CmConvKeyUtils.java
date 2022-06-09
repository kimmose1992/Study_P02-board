package com.gdgs.slyouth.cm.utils;

import com.gdgs.slyouth.cm.vo.CmLoginDVO;
import com.gdgs.slyouth.cm.vo.CmVideoDVO;

/**
 * @title	: [공통] 시스템 키 생성 유틸 클래스	  
 * @author	: mosekim
 * @create	: 2021.07.04
 * @update 	: 2021.08.09 (srar2)
 */
public class CmConvKeyUtils {

	/**
	 * [테이블 키]
	 * 
	 * - INTRO : 소개
	 * - VIDEO : 영상
	 * - CMNTY : 커뮤니티
	 * - EVENT : 행사
	 * - CHR : 교적
	 */
	private final String TB_NM_1 = "INTRO";
	private final String TB_NM_2 = "VIDEO";
	private final String TB_NM_3 = "CMNTY";
	private final String TB_NM_4 = "EVENT";
	private final String TB_NM_5 = "CHR";
	
	/**
	 * [영상 타입 키]
	 * 
	 * - WS : 예배 
	 * - SP : 특송
	 * - SY : 승리청년
	 */
	private final String VD_TYPE_1 = "WS";
	private final String VD_TYPE_2 = "SP";
	private final String VD_TYPE_3 = "SY";
	
	/** 
	 * [영상 타이틀 키]
	 * 
	 * - VD_WS_TIT : 예배 영상 타이틀
	 * - VD_SP_TIT : 특송 영상 타이틀
	 * - VD_SY_TIT : 승리청년 영상 타이틀
	 */
	private final String VD_WS_TIT_1 = "설교자";
	private final String VD_WS_TIT_2 = "설교본문";
	private final String VD_WS_TIT_3 = "설교제목";
	
	private final String VD_SP_TIT_1 = "특송자";
	private final String VD_SP_TIT_2 = "특송곡";
	private final String VD_SP_TIT_3 = "특송특송";

	private final String VD_SY_TIT_1 = "승리청년1";
	private final String VD_SY_TIT_2 = "승리청년2";
	private final String VD_SY_TIT_3 = "승리청년3";
	
	/**
	 * [사용자 권한]
	 * 
	 * - USR_ROLE_1 : 관리자
	 * - USR_ROLE_2 : 교역자
	 * - USR_ROLE_3 : 임원
	 * - USR_ROLE_4 : 리더
	 * - USR_ROLE_5 : 일반
	 */
	private final String USR_ROLE_1 = "ROLE_ADM";
	private final String USR_ROLE_2 = "ROLE_TRC";
	private final String USR_ROLE_3 = "ROLE_EXC";
	private final String USR_ROLE_4 = "ROLE_LDR";
	private final String USR_ROLE_5 = "ROLE_NOL";

	/**
	 * @title	: 테이블 키 생성	  
	 * @method	: getTbKey	 
	 * @comment	: URI에 해당되는 테이블키를 리턴한다.		 
	 * @param	: request.getRequestURI()
	 */
	public String getTbKey(String URI) {
		String tbKey = "NONE";
		
		if (URI != null) {
			// [공동체소개] 메인
			if (URI.contains("/mi/main")) {
				tbKey = TB_NM_1;
			}
			// [공동체소개] 섬기는사람들
			else if (URI.contains("/mi/serveGroup")) {
				tbKey = TB_NM_1;
			}
			// [공동체소개] 청년부임원
			else if (URI.contains("/mi/youthLeader")) {
				tbKey = TB_NM_1;
			}
			// [공동체소개] 예배안내
			else if (URI.contains("/mi/worshipInfo")) {
				tbKey = TB_NM_1;
			}
			// [예배와말씀] 주일예배/특별예배
			else if (URI.contains("/ws/video")) {
				tbKey = TB_NM_2;
			}
			// [예배와말씀] 주보
			else if (URI.contains("/ws/bulletin")) {
				tbKey = TB_NM_3;
			}
			// [찬양과셀라] 셀라소개
			else if (URI.contains("/ps/selah")) {
				tbKey = TB_NM_1;
			}
			// [찬양과셀라] 주일찬양/말씀후찬양/특송
			else if (URI.contains("/ps/video")) {
				tbKey = TB_NM_2;
			}
			// [새가족] 새가족소개
			else if (URI.contains("/nm/member")) {
				tbKey = TB_NM_1;
			}
			// [새가족] 교재
			else if (URI.contains("/nm/book")) {
				tbKey = TB_NM_3;
			}
			// [커뮤니티] 공지사항 
			else if (URI.contains("/nt/notice")) {
				tbKey = TB_NM_3;
			}
			// [커뮤니티] QT나눔
			else if (URI.contains("/nt/qt")) {
				tbKey = TB_NM_3;
			}
			// [커뮤니티] 승리청년채널
			else if (URI.contains("/nt/video")) {
				tbKey = TB_NM_3;
			}
			// [커뮤니티] 동아리
			else if (URI.contains("/nt/circle")) {
				tbKey = TB_NM_4;
			}		
			// [양육과훈련] 승리청년비전
			else if (URI.contains("/nf/vision")) {
				tbKey = TB_NM_1;
			}
			// [양육과훈련] 프로그램
			else if (URI.contains("/nf/pgm")) {
				tbKey = TB_NM_4;
			}
			// [공동체관리]
			else if (URI.contains("/um/member")) {
				tbKey = TB_NM_5;
			}
		}
		
		return tbKey;
	}
	
	/**
	 * @title	: 영상 타입 키 생성	  
	 * @method	: getVdTypeKey	 
	 * @comment	: URI와 영상 구분에 해당하는 영상 타입 키를 반환한다.	 
	 * @param	: videoDivCd
	 */
	public String getVdTypeKey(String URI, String videoDivCd) {
		String vdTypeKey = "NONE";
		
		if (URI != null && videoDivCd != null) {
			// [예배와말씀] 주일예배
			if (URI.contains("/ws/video") && videoDivCd.equals("SYW")) {
				vdTypeKey = VD_TYPE_1;
			}
			// [예배와말씀] 특별집회
			else if (URI.contains("/ws/video") && videoDivCd.equals("SYS")) {
				vdTypeKey = VD_TYPE_1;
			}
			// [찬양과셀라] 주일찬양
			else if (URI.contains("/ps/video") && videoDivCd.equals("WMS")) {
				vdTypeKey = VD_TYPE_1;
			}
			// [찬양과셀라] 말씀후찬양
			else if (URI.contains("/ps/video") && videoDivCd.equals("WAS")) {
				vdTypeKey = VD_TYPE_1;
			}
			// [찬양과셀라] 특송
			else if (URI.contains("/ps/video") && videoDivCd.equals("WSS")) {
				vdTypeKey = VD_TYPE_2;
			}
			// [커뮤니티] 승리청년채널
			else if (URI.contains("/nt/video") && videoDivCd.equals("SYC")) {
				vdTypeKey = VD_TYPE_3;
			}
		}
		
		return vdTypeKey;
	}
	
	/**
	 * @title	: 영상 타이틀 키 생성	  
	 * @method	: setVdTitKey	 
	 * @comment	: 영상 타입에 해당하는 타이틀 키를 반환한다.	 
	 * @param	: videoType
	 */
	public void setVdTitKey(CmVideoDVO video) {
		String videoTypeCd = video.getVideoTypeCd();
		
		// [예배] 관련 영상인 경우
		if ("WS".equals(videoTypeCd)) {
			video.setRemarkLb(VD_WS_TIT_1);
			video.setTitleLb(VD_WS_TIT_2);
			video.setContentLb(VD_WS_TIT_3);
		}
		// [특송] 관련 영상인 경우
		else if ("SP".equals(videoTypeCd)) {
			video.setRemarkLb(VD_SP_TIT_1);
			video.setTitleLb(VD_SP_TIT_2);
			video.setContentLb(VD_SP_TIT_3);
		}
		// [승리비전채널] 관련 영상인 경우
		else if ("SY".equals(videoTypeCd)) {
			video.setRemarkLb(VD_SY_TIT_1);
			video.setTitleLb(VD_SY_TIT_2);
			video.setContentLb(VD_SY_TIT_3);
		}
	}

	/**
	 * @title	: 사용자 권한 키 생성	  
	 * @method	: setVdTitKey	 
	 * @comment	: 영상 타입에 해당하는 타이틀 키를 반환한다.	 
	 * @param	: videoType
	 */
	public void setUsrRoleKey(CmLoginDVO cmLoginDVO) {
		String posDivCd = cmLoginDVO.getPosDivCd();
		
		// [관리자] 인 경우
		if ("ADMIN".equals(posDivCd)) {
			cmLoginDVO.setUsrRole(USR_ROLE_1);
		}
		// [목사/전도사] 인 경우
		else if ("PST".equals(posDivCd) || "MSN".equals(posDivCd)) {
			cmLoginDVO.setUsrRole(USR_ROLE_2);
		}
		// [임원] 인 경우
		else if ("EXC".equals(posDivCd)) {
			cmLoginDVO.setUsrRole(USR_ROLE_3);
		}
		// [리더] 인 경우
		else if ("LDR".equals(posDivCd)) {
			cmLoginDVO.setUsrRole(USR_ROLE_4);
		}
		// [일반/새가족] 인 경우
		else if ("NOL".equals(posDivCd)) {
			cmLoginDVO.setUsrRole(USR_ROLE_5);
		}
		
	}

}
