package com.happytail.general.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happytail.forum.model.TopiclistView;
import com.happytail.general.model.CodeMap;
import com.happytail.general.util.Page;
import com.happytail.general.util.PageInfo;

@Repository
public class CodeMaoDAOImpl implements CodeMapDAO {

	@Autowired
	private SessionFactory sessionfactory;

	public Session getSession() {
		Session session = sessionfactory.getCurrentSession();
		return session;
	}

	public CodeMaoDAOImpl() {
	}

	private final String selectValue = "FROM com.happytail.general.model.CodeMap WHERE module=:module and type=:type and key=:key";

	private final String selectValueList = "FROM com.happytail.general.model.CodeMap WHERE module=:module and type=:type";

	private final String selectMyFavorateValueList = "FROM com.happytail.general.model.CodeMap WHERE module=:module and type=:type and key in (:categoryIdlist)";

	@Override
	public CodeMap insert(CodeMap codeMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CodeMap update(CodeMap CodeMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CodeMap selectValue(String module, String type, String key) {
		Query<CodeMap> check = getSession().createQuery(selectValue, CodeMap.class);
		check.setParameter("module", module);
		check.setParameter("type", type);
		check.setParameter("key", key);

		List<CodeMap> list = check.list();

		if (list == null || list.size() == 0) {
			System.out.println("No result");
			return null;
		} else {
			return list.get(0);
		}
	}

	@Override
	public List<CodeMap> selectValueList(String module, String type) {
		Query<CodeMap> check = getSession().createQuery(selectValueList, CodeMap.class);
		check.setParameter("module", module);
		check.setParameter("type", type);

		List<CodeMap> list = check.list();

		if (list == null || list.size() == 0) {
			System.out.println("No result");
			return null;
		} else {
			return list;
		}
	}

	@Override
	public List<CodeMap> getMyFavorateCategorylist(List<Integer> categoryIdlist, String module, String type) {
		List<String> paramList = new ArrayList<String>();
		
		for(Integer categoryId : categoryIdlist) {
			paramList.add(String.valueOf(categoryId));
		}
		
//		categoryIdlist.forEach((e) -> {
//			paramList.add(String.valueOf(e));
//		});
		
		Query<CodeMap> query = getSession().createQuery(selectMyFavorateValueList, CodeMap.class);
		query.setParameter("categoryIdlist", paramList);
		query.setParameter("module", module);
		query.setParameter("type", type);


		return query.list();
	}

}
