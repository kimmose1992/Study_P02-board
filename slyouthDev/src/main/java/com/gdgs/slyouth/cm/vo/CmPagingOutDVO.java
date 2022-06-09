package com.gdgs.slyouth.cm.vo;

/**
 * @title	: [공통] 페이징 출력 VO 클래스	  
 * @author	: mosekim
 * @create	: 2021.04.22
 */
public class CmPagingOutDVO {
	
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
	 * 전체 페이지 건수
	 */	
	private int totalPageCnt;
	
	/**
	 * 페이지 시작 번호
	 */
	private int startPageNo;
	
	/**
	 * 페이지 종료 번호
	 */
	private int endPageNo;
	
	/**
	 * 데이터 시작 번호
	 */
	private int startDataNo;
	
	/**
	 * 데이터 종료 번호
	 */
	private int endDataNo;
		
	/**
	 * 이전페이지 존재 여부
	 */
	private boolean isPrevPage;

	/**
	 * 다음페이지 존재 여부
	 */
	private boolean isNextPage;
	
	public CmPagingOutDVO(CmPagingInDVO cmPagingInDVO) {
		// 페이지 번호
		if (cmPagingInDVO.getPageNo() < 1) {
			cmPagingInDVO.setPageNo(1);
		}
		
		// 페이지 목록 수
		if (cmPagingInDVO.getListSize() < 1 || cmPagingInDVO.getListSize() > 50) {
			cmPagingInDVO.setListSize(10);
		}
		
		// 페이지 블록 수
		if (cmPagingInDVO.getPageSize() < 1 || cmPagingInDVO.getPageSize() > 10) {
			cmPagingInDVO.setPageSize(10);
		}

		this.pageNo = cmPagingInDVO.getPageNo();
		this.listSize = cmPagingInDVO.getListSize();
		this.pageSize = cmPagingInDVO.getPageSize();
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
		
		if (totalDataCnt > 0) {
			this.pageCalculation();
		}
	}

	/**
	 * @title	: 페이징 정보 계산 함수	  
	 * @method	: pageCalculation()	 
	 * @comment	: 입력된 정보로 페이징 정보를 계산한다.
	 */
	private void pageCalculation() {
		// 전체 페이지 수 (현재 페이지 번호가 전체 페이지 수보다 크면 현재 페이지 번호에 전체 페이지 수를 저장)
		totalPageCnt = ((totalDataCnt - 1) / listSize) + 1;
		
		if (pageSize > totalPageCnt) {
			pageSize = totalPageCnt;
		}
		
		// 페이지 리스트의 첫 페이지 번호
		startPageNo = ((pageNo - 1) / pageSize) * pageSize + 1;

		// 페이지 리스트의 마지막 페이지 번호 (마지막 페이지가 전체 페이지 수보다 크면 마지막 페이지에 전체 페이지 수를 저장)
		endPageNo = startPageNo + pageSize - 1;
		
		if (endPageNo > totalPageCnt) {
			endPageNo = totalPageCnt;
		}
		
		// SQL 데이터 No
		startDataNo = (pageNo - 1) * listSize;
		endDataNo = pageNo * listSize;

		// 이전 페이지 존재 여부
		isPrevPage = startPageNo == 1 ? false : true;

		// 다음 페이지 존재 여부
		isNextPage = (endPageNo * listSize) >= totalDataCnt ? false : true;
	}

	public int getTotalPageCnt() {
		return totalPageCnt;
	}

	public void setTotalPageCnt(int totalPageCnt) {
		this.totalPageCnt = totalPageCnt;
	}

	public int getStartPageNo() {
		return startPageNo;
	}

	public void setStartPageNo(int startPageNo) {
		this.startPageNo = startPageNo;
	}

	public int getEndPageNo() {
		return endPageNo;
	}

	public void setEndPageNo(int endPageNo) {
		this.endPageNo = endPageNo;
	}

	public int getStartDataNo() {
		return startDataNo;
	}

	public void setStartDataNo(int startDataNo) {
		this.startDataNo = startDataNo;
	}

	public int getEndDataNo() {
		return endDataNo;
	}

	public void setEndDataNo(int endDataNo) {
		this.endDataNo = endDataNo;
	}

	public boolean isPrevPage() {
		return isPrevPage;
	}

	public void setPrevPage(boolean isPrevPage) {
		this.isPrevPage = isPrevPage;
	}

	public boolean isNextPage() {
		return isNextPage;
	}

	public void setNextPage(boolean isNextPage) {
		this.isNextPage = isNextPage;
	}
	
}
