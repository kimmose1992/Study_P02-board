package com.gdgs.slyouth.cm.vo;

/**
 * @title	: [공통] 페이징 입력 VO 클래스	  
 * @author	: mosekim
 * @create	: 2021.05.22
 */
public class CmPagingInDVO {
	
	/**
	 * 페이지번호
	 */
	private int pageNo;

	/**
	 * 하단 페이지 블록 수
	 */
	private int pageSize;
	
	/**
	 * 페이지당 출력할 데이터 건수
	 */
	private int listSize;
	
	/**
	 * 전체 데이터 건수
	 */	
	private int totalDataCnt;
	
	/**
	 * 데이터 시작 번호
	 */
	private int startDataNo;
	
	/**
	 * 검색 유형
	 */	
	private String searchType;

	/**
	 * 검색 키워드
	 */	
	private String searchKeyword;
	
	public CmPagingInDVO() {
		this.pageNo = 1;
		this.pageSize = 5;
		this.listSize = 10;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getListSize() {
		return listSize;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}

	public int getTotalDataCnt() {
		return totalDataCnt;
	}

	public void setTotalDataCnt(int totalDataCnt) {
		this.totalDataCnt = totalDataCnt;
	}

	public int getStartDataNo() {
		startDataNo = (pageNo - 1) * listSize;
		return startDataNo;
	}

	public void setStartDataNo(int startDataNo) {
		this.startDataNo = startDataNo;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	
}
