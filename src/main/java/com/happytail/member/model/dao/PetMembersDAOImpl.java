package com.happytail.member.model.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.happytail.member.model.PetMembers;
import com.happytail.member.util.MailCodeUtil;



@Repository
public class PetMembersDAOImpl implements PetMembersDAO  {
	
	@Autowired
	private SessionFactory factory;
	
	
	public Session getSession() {
		Session session = factory.getCurrentSession();
		return session;
	}	
	
	@Override
	public PetMembers checkLogin(String account,String password) {
		
		PetMembers result = selectPetMembers(account, password);
	
			return result;	
	}	
	
	@Override
	public PetMembers insertPetMembers(PetMembers petMembers) {
		
		Query<PetMembers> query = getSession().createQuery("From PetMembers where account=:account", PetMembers.class);
		query.setParameter("account", petMembers.getAccount());
		PetMembers bean = (PetMembers) query.uniqueResult();
		if(bean == null) {
			System.out.println(petMembers.getStartCode());			
			if(petMembers.getStartCode() != null) {
				getSession().save(petMembers);
				return petMembers;		
			}
		}		
		return null;
	}
	
//	public saveStartCode(String StartCode ) {
//		
//	}
	
	@Override
	public PetMembers checkStartCode(String code) {	
		Query<PetMembers> query = getSession().createQuery("From PetMembers where startCode=:startCode", PetMembers.class);
		query.setParameter("startCode", code);
		PetMembers bean = (PetMembers) query.uniqueResult();
		if(bean != null) {
			bean.setStatus(1);
			getSession().save(bean);		
		}						
		return bean;	
	}
	@Override
	public void insertTemporaryPassword(String temporaryPasswordAccount, String temporaryPassword) {
		PetMembers petMembers = selectPetMembers(temporaryPasswordAccount);
		petMembers.setTemporaryPassword(temporaryPassword);
		getSession().update(petMembers);
		
	}
	
	
	@Override
	public PetMembers checkTemporaryPassword(String temporaryPasswordAccount ,String temporaryPassword) {	
		Query<PetMembers> query = getSession().createQuery("from PetMembers where account=?1 and temporaryPassword=?2", PetMembers.class);
		query.setParameter(1, temporaryPasswordAccount);
		query.setParameter(2, temporaryPassword);
		System.out.println(temporaryPassword);
		PetMembers result = null;
		try {
			result = (PetMembers) query.getSingleResult();
		}catch(NoResultException nre) {
			nre.printStackTrace();
			return result;
		}		
		return result;
	
	}
	
	@Override
	public PetMembers selectPetMembers(Integer id) {		
		
		return getSession().get(PetMembers.class , id);
	}
	
	@Override
	public PetMembers selectPetMembers(String account) {
		Query<PetMembers> query = getSession().createQuery("From PetMembers where account=:account", PetMembers.class);
		query.setParameter("account", account);
		PetMembers bean = (PetMembers) query.uniqueResult();
		if(bean == null) {
			return null;
		}
		return bean;
	}
	
	@Override
	public PetMembers selectPetMembers(String account, String password) {		
		
		Query<PetMembers> query = getSession().createQuery("from PetMembers where account=?1 and password=?2", PetMembers.class);
		query.setParameter(1, account);
		query.setParameter(2, password);
		System.out.println(account + "  " + password);
		PetMembers result = null;
		try {
			result = (PetMembers) query.getSingleResult();
		}catch(NoResultException nre) {
			nre.printStackTrace();
			return result;
		}		
		return result;
	}
	
	@Override
	public List<PetMembers> selectAllPetMembers() {
		
		Query<PetMembers> query = getSession().createQuery("from PetMembers", PetMembers.class);
		List<PetMembers> list = query.list();
		return list;		
	}
	
	@Override
	public PetMembers updatePetMembers(PetMembers petMember) {
		
		PetMembers pMember = getSession().get(PetMembers.class, petMember.getId());
		
		if(pMember != null) {
			pMember.setAccount(petMember.getAccount());
			pMember.setEmail(petMember.getEmail());
			pMember.setPassword(petMember.getPassword());
			pMember.setUsername(petMember.getUsername());
			pMember.setGender(petMember.getGender());
			pMember.setBday(petMember.getBday());
			pMember.setAge(petMember.getAge());
			pMember.setAddress(petMember.getAddress());
			pMember.setPhone(petMember.getPhone()); 
//			pMember.setPetType(petMember.getPetType());
			pMember.setMemberImage(petMember.getMemberImage());
			pMember.setFileName(petMember.getFileName());
			
			getSession().update(pMember);
		}		
		return petMember;
	}
	
	@Override
	public boolean deletePetMembers(Integer id) {
		PetMembers petMember = getSession().get(PetMembers.class,id);
		
		if(petMember!=null) {
			getSession().delete(petMember);
			return true;
		}		
		return false;
	}		
	
}
