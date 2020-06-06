package com.happytail.admin.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.stereotype.Repository;

import com.happytail.member.model.PetMembers;

@Repository
public class AdminMembersDaoImpl implements AdminMembersDao {

	@Autowired
	private SessionFactory factory;

	public Session getSession() {
		Session session = factory.getCurrentSession();
		return session;
	}

	// 計算所有會員數
	@Override
	public Long countMembers() {
		String hql = "select count(*) from PetMembers";
		Query query = getSession().createQuery(hql);
		return (Long) query.uniqueResult();
	}

	// 計算所有男性會員
	@Override
	public Long countMale() {
		Query query = getSession().createQuery("select count(*) from PetMembers p where p.gender=:gender");
		query.setParameter("gender", "M");
		return (Long) query.uniqueResult();
	}

	// 所有女性會員
	@Override
	public Long countFemale() {
		Query query = getSession().createQuery("select count(*) from PetMembers p where p.gender=:gender");
		query.setParameter("gender", "F");
		return (Long) query.uniqueResult();
	}

	// 會員年齡分布
	@Override
	public List<Long> age() {

		String sql1 = "with Age as( select bday, DATEDIFF(yy, bday, GETDATE() ) - CASE WHEN DATEADD(YY, DATEDIFF(YY, bday, GETDATE()), bday) > GETDATE() then 1 ELSE 0 end as age from PetMembers)";
		String sql2 = "SELECT COUNT(*) AS levelCount FROM Age GROUP BY CAST(age / 10 * 10 AS VARCHAR) + '~' +  CAST( age / 10 * 10 + 9 AS VARCHAR)";
		Query query = getSession().createSQLQuery(sql1 + sql2);
		List<Long> list = query.list();
		return list;

	}

	//更改會員狀態
	@Override
	public PetMembers changeMemberStatus(Integer id) {
		Query<PetMembers> query = getSession().createQuery("From PetMembers p where p.id=:id",PetMembers.class);
		query.setParameter("id", id);
		PetMembers member = (PetMembers) query.uniqueResult();
		
		if (member != null) {
			if (member.getStatus() == 1) {
				member.setStatus(2); //停權
				getSession().update(member);
			}
			else if (member.getStatus() == 2) {
				member.setStatus(1); //復原
				getSession().update(member);
			}
		}
		return member;
	}

}
