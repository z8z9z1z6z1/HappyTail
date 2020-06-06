package com.happytail.member.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.happytail.member.model.PetMembers;
import com.happytail.member.model.dao.PetMembersDAO;
import com.happytail.member.util.MailCodeUtil;
import com.happytail.member.util.MailUtil;
import com.happytail.member.util.MailUtil_forgetPwd;

@Service
@Transactional
public class PetMembersServiceImpl implements PetMembersService{
	
	@Autowired
	private PetMembersDAO petMembersDAO;	

	
	
	@Override
	public PetMembers checkLogin(String account,String password) {
		
		PetMembers petMember = petMembersDAO.selectPetMembers(account, password);
		if(petMember != null) {			
			return petMember;	
		}			
		return null;	
	}
	
	
	@Override
	public PetMembers insertPetMembers(PetMembers petMembers) {	
		String code = MailCodeUtil.startCode();
		new Thread(new MailUtil(petMembers.getEmail(), code)).start();
		petMembers.setStartCode(code);
		petMembers.setStatus(0);
		PetMembers	petMember = petMembersDAO.insertPetMembers(petMembers);		
		return petMember;	
	}
	
//	public void sendStartCode(String account) {
//		String code = MailCodeUtil.startCode();		
//		new Thread(new MailUtil(account, code)).start();			
//	}
	
	@Override
	public boolean checkStartCode(String code) {		
		PetMembers pMember = petMembersDAO.checkStartCode(code);
		if( pMember != null ){			
			return true;
		}else {
			return false;
		}
	}	
	
	@Override
	public void sendTemporaryPassword(String temporaryPasswordAccount) {	
		String temporaryPassword = MailCodeUtil.forgetPwdCode();
		petMembersDAO.insertTemporaryPassword(temporaryPasswordAccount, temporaryPassword);
		new Thread(new MailUtil_forgetPwd(temporaryPasswordAccount,temporaryPassword)).start();		
		
	}	
	
	@Override
	public PetMembers checkTemporaryPassword(String temporaryPasswordAccount,String temporaryPassword) {		
		PetMembers pMember = petMembersDAO.checkTemporaryPassword(temporaryPasswordAccount ,temporaryPassword);		
		return pMember;
	}	
	
	

	@Override
	public PetMembers selectPetMembers(Integer id) {		
		PetMembers petMember = petMembersDAO.selectPetMembers(id);	
		return  petMember;
	}
	
	@Override
	public PetMembers selectPetMembers(String account) {		
		PetMembers petMember = petMembersDAO.selectPetMembers(account);	
		return  petMember;
	}
	
	@Override
	public PetMembers selectPetMembers(String password, String account) {		
		PetMembers petMember = petMembersDAO.selectPetMembers(password,account);		
		return  petMember;
	}

	@Override
	public List<PetMembers> selectAllPetMembers() {		
		List<PetMembers> list = petMembersDAO.selectAllPetMembers();		
		return list;
	}

	@Override
	public PetMembers updatePetMembers(PetMembers petMember) {		
		PetMembers pMember = petMembersDAO.updatePetMembers(petMember);		
		return pMember; 
	}

	@Override
	public boolean deletePetMembers(Integer id) {		
		boolean result = petMembersDAO.deletePetMembers(id);		
		return result;
	}	

}
