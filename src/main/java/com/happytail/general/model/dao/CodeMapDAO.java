package com.happytail.general.model.dao;

import java.util.List;

import com.happytail.general.model.CodeMap;

public interface CodeMapDAO {
	
	public CodeMap insert(CodeMap codeMap);
	
	public boolean delete(Integer id);
	
	public CodeMap update(CodeMap CodeMap);
	
	public CodeMap selectValue(String module, String type, String key);

	public List<CodeMap> selectValueList(String module, String type);
	
	public List<CodeMap> getMyFavorateCategorylist(List<Integer> categoryIdlist,String module, String type);

}
