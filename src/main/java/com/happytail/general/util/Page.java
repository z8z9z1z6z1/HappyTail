package com.happytail.general.util;

import java.util.List;

import com.happytail.forum.model.TopiclistView;

public class Page<T>{
	
	private Integer pageSize;
	//number of per page 
	
	private Integer currentPage;
	//current page
	
	private Integer totalPages;
	//total pages
	
	private Integer totalNum;
	//total number
	
	private List<T> records;
	//list of data
	
	public Page(List<T> records,Integer pageNum, Integer pageSize,long totalCount) {
		this.records = records;
		this.pageSize = pageSize;
		this.currentPage = pageNum;
		this.totalPages = (int) Math.ceil(((double) totalCount)/pageSize);
		this.totalNum = (int)totalCount;
	}
		
	public Page() {
		
	}

	public void setPageInfo(PageInfo pageInfo) {
		this.pageSize = pageInfo.getPageSize();
		this.currentPage = pageInfo.getPageNum();
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	public Integer getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

	public List<T> getRecords() {
		return records;
	}

	public void setRecords(List<T> records) {
		this.records = records;
	}
	
	public boolean getIsFirstPage() {
		return this.currentPage == 1;
	}
	
	public boolean getIsLastPage() {
		return this.currentPage == this.totalPages;
	}
	
	public boolean getIsHasNext() {
		return this.currentPage < this.totalPages;
	}
}