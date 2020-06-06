package com.happytail.forum.model.dao;

import java.util.List;

import com.happytail.forum.model.Favorate;

public interface FavorateDAO{
	
	public Favorate insert(Favorate favorate);

	//修改的方式 - 全刪再重存
	public boolean delete(Integer userId);
		
	public Favorate selectByUserIdAndCategoryId(Integer userId, Integer categoryId);
	
	public List<Integer> selectCategoryIdList(Integer userId);
	
	public List<Favorate> selectFavorateCategoryList(Integer userId);	

}
