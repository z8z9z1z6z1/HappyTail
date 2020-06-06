package com.happytail.general.util;

import java.util.Map;

import org.springframework.util.StringUtils;

import com.happytail.general.util.PageInfo.Sort.Direction;

public class PageInfo {

	private Integer pageSize;
	// number of per page

	private Integer pageNum;
	// current page Number

	private Sort sort;
	
	public PageInfo(Integer pageSize, Integer pageNum) {
		this.pageSize = (pageSize != null) ? pageSize : Const.DEFAULT_PAGE_SIZE;
		this.pageNum = (pageNum != null) ? pageNum : Const.FIRST_PAGE_NUM;
		// check the value and use the default setting
	}

	public PageInfo(Integer pageSize, Integer pageNum, Sort sort) {
		this.pageSize = (pageSize != null) ? pageSize : Const.DEFAULT_PAGE_SIZE;
		this.pageNum = (pageNum != null) ? pageNum : Const.FIRST_PAGE_NUM;
		// check the value and use the default setting
		this.sort = sort;
	}

	public PageInfo(Map<String, Object> map) {
		String pageSize = String.valueOf(map.get(Const.PAGE_SIZE));
		String pageNum = String.valueOf(map.get(Const.PAGE_NUM));

		this.pageSize = (pageSize != null) ? Integer.valueOf(pageSize) : Const.DEFAULT_PAGE_SIZE;
		this.pageNum = (pageNum != null) ? Integer.valueOf(pageNum) : Const.FIRST_PAGE_NUM;
		// check the value and use the default setting

		if (hasSortInfo(map)) {
			String[] columnNames = String.valueOf(map.get(Const.ORDER_COLUMNS)).split(",");
			String direction = String.valueOf(map.get(Const.ORDER_DIRECTION));
			if (Direction.ASC.toString().equalsIgnoreCase(direction)) {
				this.sort = new Sort(Direction.ASC, columnNames);
			} else if (Direction.DESC.toString().equalsIgnoreCase(direction)) {
				this.sort = new Sort(Direction.DESC, columnNames);
			}
		}

	}

	private boolean hasSortInfo(Map<String,Object> map) {
		if(map.get(Const.ORDER_COLUMNS)!= null && map.get(Const.ORDER_DIRECTION)!= null){
			if(StringUtils.hasText(String.valueOf(map.get(Const.ORDER_COLUMNS))) &&
					StringUtils.hasText(String.valueOf(map.get(Const.ORDER_DIRECTION)))) {
				return true;
			}
		}
		return false;
	}

	// for calling
	public boolean hasSortInfo() {
		return this.sort != null;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Sort getSort() {
		return sort;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}

	//
	public static class Sort {

		// Sorting direction
		private Direction direction;

		// column Names
		private String[] columnNames;

		public Sort(Direction direction, String[] columnNames) {
			this.direction = direction;
			this.columnNames = columnNames;
		}

		public Direction getDirection() {

			return direction;

		}

		public String[] getColumeNames() {
			return columnNames;
		}

		public static enum Direction {
			ASC, DESC
		}
	}
}
