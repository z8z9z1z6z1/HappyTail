package com.happytail.general.model.dao;

import java.util.List;

import com.happytail.general.model.Notice;
import com.happytail.general.util.Page;
import com.happytail.general.util.PageInfo;

public interface NoticeDAO {
	
	public Notice insert(Notice notice);
	
	public boolean delete(Integer id);
	
	public Notice update(Notice notice);
	
	public Notice updateAll(Notice notice);
	
	public Notice select(Integer id);
	
	public List<Notice> selectAll();

	public List<Notice> selectByUserIdList(Integer userId);
	
	public List<Notice> selectByModule(Integer userId, String module);
	
	public Page<Notice> getAllNoticelist(Integer userId, String module, PageInfo pageInfo);
	
	public Notice selectByUserId(Integer userId);

	}