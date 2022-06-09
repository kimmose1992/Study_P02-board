package com.gdgs.slyouth.um.service.dataUtil;

import com.gdgs.slyouth.um.vo.UmMemberDVO;

/**
 * @title   : 영상 엑셀 데이터 전처리     
 * @author  : gypig
 * @create  : 2021.06.15
 */
public class DataPreProcess {

	/**
	 * @title   : 교적 목록조회 데이터 변환
	 * @method  : dataToMemberList
	 * @comment : 목록조회에서 각각의 DVO의 코드 값을 데이터 형태로 매핑시켜서 바꿔주는 메소드
	 * @param   : UmMemberDVO
	 */
	public UmMemberDVO dataToMemberList(UmMemberDVO data){
		
		String temp = null;
		
		// 성별 코드 값 적용
		temp = data.getGndrDivCd();
		switch (temp) {
		case "M":
			data.setGndrDivCd("남");
			break;
		case "W":
			data.setGndrDivCd("여");
			break;
		default:
			data.setGndrDivCd("");
			break;
		}
		
		// 교인구분 값 세팅
		temp = data.getChrDivCd();
		switch (temp) {
		case "TRC":
			data.setChrDivCd("교역자");
			break;
		case "YTH":
			data.setChrDivCd("청년");
			break;
		case "STD":
			data.setChrDivCd("학생");
			break;
		case "PSC":
			data.setChrDivCd("미취학");
			break;
		default:
			data.setChrDivCd("");
			break;
		}
		
		// 직책 값 세팅
		temp = data.getPosDivCd();
		switch (temp) {
		case "PST":
			data.setPosDivCd("목사");
			break;
		case "MSN":
			data.setPosDivCd("전도사");
			break;
		case "EXC":
			data.setPosDivCd("임원");
			break;
		case "LDR":
			data.setPosDivCd("리더");
			break;
		case "NOL":
			data.setPosDivCd("일반");
			break;
		default:
			break;
		}
		
		// 직책 상세 값 세팅
		temp = data.getPosDtlCd();
		switch (temp) {
		case "PRS":
			data.setPosDtlCd("회장");
			break;
		case "VRS":
			data.setPosDtlCd("부회장");
			break;
		case "MNG":
			data.setPosDtlCd("총무");
			break;
		case "ACN":
			data.setPosDtlCd("회계");
			break;
		case "CLR":
			data.setPosDtlCd("서기");
			break;
		case "PWG":
			data.setPosDtlCd("양육부장");
			break;
		case "DWS":
			data.setPosDtlCd("예배부장");
			break;
		case "HHH":
			data.setPosDtlCd("가장");
			break;
		case "VHH":
			data.setPosDtlCd("부가장");
			break;
		case "NFM":
			data.setPosDtlCd("새가족");
			break;
		default:
			data.setPosDtlCd("");
			break;
		}
		
		// 세례 값 세팅
		temp = data.getBptStCd();
		switch(temp) {
		case "BPT":
			data.setBptStCd("세례");
			break;
		case "ENR":
			data.setBptStCd("입교");
			break;
		default:
			data.setBptStCd("");
			break;
		}
		return data;
	}
	
	/**
	 * @title   : 교적 상세조회 데이터 변환
	 * @method  : dataToMember
	 * @comment : 상세조회에서 DVO의 코드 값을 데이터 형태로 매핑시켜서 바꿔주는 메소드
	 * @param   : UmMemberDVO
	 */
	public UmMemberDVO dataToMember(UmMemberDVO data){
		
		String temp = null;
		
		// 성별 코드 값 적용
		temp = data.getGndrDivCd();
		switch (temp) {
		case "M":
			data.setGndrDivCd("남");
			break;
		case "W":
			data.setGndrDivCd("여");
			break;
		default:
			data.setGndrDivCd("");
			break;
		}
		
		// 교인구분 값 세팅
		temp = data.getChrDivCd();
		switch (temp) {
		case "TRC":
			data.setChrDivCd("교역자");
			break;
		case "YTH":
			data.setChrDivCd("청년");
			break;
		case "STD":
			data.setChrDivCd("학생");
			break;
		case "PSC":
			data.setChrDivCd("미취학");
			break;
		default:
			data.setChrDivCd("");
			break;
		}
				
		// 직책 값 세팅
		temp = data.getPosDivCd();
		switch (temp) {
		case "PST":
			data.setPosDivCd("목사");
			break;
		case "MSN":
			data.setPosDivCd("전도사");
			break;
		case "EXC":
			data.setPosDivCd("임원");
			break;
		case "LDR":
			data.setPosDivCd("리더");
			break;
		case "NOL":
			data.setPosDivCd("일반");
			break;
		default:
			break;
		}
		
		// 직책 상세 값 세팅
		temp = data.getPosDtlCd();
		switch (temp) {
		case "PRS":
			data.setPosDtlCd("회장");
			break;
		case "VRS":
			data.setPosDtlCd("부회장");
			break;
		case "MNG":
			data.setPosDtlCd("총무");
			break;
		case "ACN":
			data.setPosDtlCd("회계");
			break;
		case "CLR":
			data.setPosDtlCd("서기");
			break;
		case "PWG":
			data.setPosDtlCd("양육부장");
			break;
		case "DWS":
			data.setPosDtlCd("예배부장");
			break;
		case "HHH":
			data.setPosDtlCd("가장");
			break;
		case "VHH":
			data.setPosDtlCd("부가장");
			break;
		case "NFM":
			data.setPosDtlCd("새가족");
			break;
		default:
			data.setPosDtlCd("");
			break;
		}
		
		// 세례 값 세팅
		temp = data.getBptStCd();
		switch(temp) {
		case "BPT":
			data.setBptStCd("세례");
			break;
		case "ENR":
			data.setBptStCd("입교");
			break;
		default:
			data.setBptStCd("");
			break;
		}
		
		// 결혼 상태 값 세팅
		temp = data.getMrgStCd();
		switch(temp) {
		case "MRD":
			data.setMrgStCd("기혼");
			break;
		case "SNG":
			data.setMrgStCd("미혼");
			break;
		default:
			data.setMrgStCd("");
			break;
		}
		
		// 학력 상태 값 세팅
		temp = data.getEduDivCd();
		switch(temp) {
		case "GRD":
			data.setEduDivCd("졸업");
			break;
		case "ATN":
			data.setEduDivCd("재학");
			break;
		case "LAB":
			data.setEduDivCd("휴학");
			break;
		default:
			data.setEduDivCd("");
			break;
		}
		
		return data;
	}
	
	/**
	 * @title   : 교적 DB형태로 변환
	 * @method  : memberToData
	 * @comment : 입력 및 수정 데이터를 
	 * @param   : UmMemberDVO
	 */
	public UmMemberDVO memberToData(UmMemberDVO member){
		
		String temp = null;
		
		// 성별 코드 값 적용
		temp = member.getGndrDivCd();
		switch(temp) {
		case "남":
			member.setGndrDivCd("M");
			break;
		case "여":
			member.setGndrDivCd("W");
			break;
		default:
			break;
		}
		
		// 교인구분 코드 값 적용
		temp = member.getChrDivCd();
		switch(temp) {
		case "교역자":
			member.setChrDivCd("TRC");
			break;
		case "청년":
			member.setChrDivCd("YTH");
			break;
		case "학생":
			member.setChrDivCd("STD");
			break;
		case "미취학":
			member.setChrDivCd("PSC");
			break;
		default:
			break;
		}
		
		// 직책구분 코드 값 적용
		temp = member.getPosDivCd();
		switch (temp) {
		case "목사":
			member.setPosDivCd("PST");
			break;
		case "전도사":
			member.setPosDivCd("MSN");
			break;
		case "임원":
			member.setPosDivCd("EXC");
			break;
		case "리더":
			member.setPosDivCd("LDR");
			break;
		case "일반":
			member.setPosDivCd("NOL");
			break;
		default:
			break;
		}
		
		// 직책상세 코드 값 적용
		temp = member.getPosDtlCd();
		switch (temp) {
		case "회장":
			member.setPosDtlCd("PRS");
			break;
		case "부회장":
			member.setPosDtlCd("VRS");
			break;
		case "총무":
			member.setPosDtlCd("MNG");
			break;
		case "회계":
			member.setPosDtlCd("ACN");
			break;
		case "서기":
			member.setPosDtlCd("CLR");
			break;
		case "양육부장":
			member.setPosDtlCd("PMG");
			break;
		case "예배부장":
			member.setPosDtlCd("DWS");
			break;
		case "가장":
			member.setPosDtlCd("HHH");
			break;
		case "부가장":
			member.setPosDtlCd("VHH");
			break;
		case "새가족":
			member.setPosDtlCd("NFM");
			break;
		default:
			break;
		}
		
		// 세례 코드 값 적용
		temp = member.getBptStCd();
		switch (temp) {
		case "세례":
			member.setBptStCd("BPT");
			break;
		case "입교":
			member.setBptStCd("ENR");
			break;
		default:
			break;
		}
		
		// 결혼 코드 값 적용
		temp = member.getMrgStCd();
		switch (temp) {
		case "기혼":
			member.setMrgStCd("MRD");
			break;
		case "미혼":
			member.setMrgStCd("SNG");
			break;
		default:
			break;
		}
		
		// 학력 코드 값 적용
		temp = member.getEduDivCd();
		switch (temp) {
		case "졸업":
			member.setEduDivCd("GRD");
			break;
		case "재학":
			member.setEduDivCd("ATN");
			break;
		case "휴학":
			member.setEduDivCd("LAB");
			break;
		default:
			break;
		}
		
		return member;
	}
}
