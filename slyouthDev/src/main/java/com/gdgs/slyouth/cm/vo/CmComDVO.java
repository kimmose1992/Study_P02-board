package com.gdgs.slyouth.cm.vo;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @title	: [공통] 기능관리 DVO 클래스	  
 * @author	: mosekim
 * @create	: 2021.05.15
 */
public class CmComDVO {
	
	/**
	 * 코드
	 */
	private String code;
	
	/**
	 * 코드라벨
	 */
	private String codeLabel;

	/**
	 * 참조코드키
	 */
	private String codeRefKey;

	/**
	 * 참조코드값
	 */
	private String codeRefVl;
	
	/**
	 * 코드번호
	 */
	private String codeNo;

	/**
	 * 코드키
	 */
	private String codeKey;
	
	/**
	 * 콤보ID
	 */
	private String comboId;
	
	/**
	 * 콤보타입(A: 전체, S:선택, N:미사용)
	 */
	private String comboType;
	
	/**
	 * 코드타입
	 */
	private String codeType;
	
	/**
	 * 코드키 배열
	 */
	private String[] codeKeyArr;
	
	/**
	 * 콤보ID 배열
	 */
	private String[] comboIdArr;

	/**
	 * 콤보타입(A: 전체, S:선택, N:미사용) 배열
	 */
	private String[] comboTypeArr;
	
	/**
	 * 코드타입 배열
	 */
	private String[] codeTypeArr;
	
	/**
	 * 콤보데이터 Map
	 */
	private HashMap<String, Object> comboMap;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodeLabel() {
		return codeLabel;
	}

	public void setCodeLabel(String codeLabel) {
		this.codeLabel = codeLabel;
	}

	public String getCodeRefKey() {
		return codeRefKey;
	}

	public void setCodeRefKey(String codeRefKey) {
		this.codeRefKey = codeRefKey;
	}

	public String getCodeRefVl() {
		return codeRefVl;
	}

	public void setCodeRefVl(String codeRefVl) {
		this.codeRefVl = codeRefVl;
	}

	public String getCodeNo() {
		return codeNo;
	}

	public void setCodeNo(String codeNo) {
		this.codeNo = codeNo;
	}

	public String getCodeKey() {
		return codeKey;
	}

	public void setCodeKey(String codeKey) {
		this.codeKey = codeKey;
	}

	public String getComboId() {
		return comboId;
	}

	public void setComboId(String comboId) {
		this.comboId = comboId;
	}

	public String getComboType() {
		return comboType;
	}

	public void setComboType(String comboType) {
		this.comboType = comboType;
	}

	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	public String[] getCodeKeyArr() {
		return codeKeyArr;
	}

	public void setCodeKeyArr(String[] codeKeyArr) {
		this.codeKeyArr = codeKeyArr;
	}

	public String[] getComboIdArr() {
		return comboIdArr;
	}

	public void setComboIdArr(String[] comboIdArr) {
		this.comboIdArr = comboIdArr;
	}

	public String[] getComboTypeArr() {
		return comboTypeArr;
	}

	public void setComboTypeArr(String[] comboTypeArr) {
		this.comboTypeArr = comboTypeArr;
	}

	public String[] getCodeTypeArr() {
		return codeTypeArr;
	}

	public void setCodeTypeArr(String[] codeTypeArr) {
		this.codeTypeArr = codeTypeArr;
	}

	public HashMap<String, Object> getComboMap() {
		return comboMap;
	}

	public void setComboMap(HashMap<String, Object> comboMap) {
		this.comboMap = comboMap;
	}

	@Override
	public String toString() {
		return "CmComDVO [code=" + code + ", codeLabel=" + codeLabel + ", codeRefKey=" + codeRefKey + ", codeRefVl="
				+ codeRefVl + ", codeNo=" + codeNo + ", codeKey=" + codeKey + ", comboId=" + comboId + ", comboType="
				+ comboType + ", codeType=" + codeType + ", codeKeyArr=" + Arrays.toString(codeKeyArr) + ", comboIdArr="
				+ Arrays.toString(comboIdArr) + ", comboTypeArr=" + Arrays.toString(comboTypeArr) + ", codeTypeArr="
				+ Arrays.toString(codeTypeArr) + ", comboMap=" + comboMap + "]";
	}
	
}
