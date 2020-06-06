package com.happytail.member.model.dao;

import java.util.List;

import com.happytail.member.model.PetMembers;





public interface PetMembersDAO {
	
	public PetMembers insertPetMembers(PetMembers petMembers);
	
	public PetMembers selectPetMembers(Integer id);
	
	public List<PetMembers> selectAllPetMembers();
	
//	public PetMembers updatePetMembers(int memberId, String email, String password, String username, String gender, 
//			Date bday, int age, String address, String phone, String petType, Blob memberImage, String fileName, Timestamp registerTime);
	
	public boolean deletePetMembers(Integer id);

	PetMembers selectPetMembers(String password, String account);

	PetMembers updatePetMembers(PetMembers petMember);

	PetMembers checkLogin(String account, String password);

	public PetMembers selectPetMembers(String account);

	PetMembers checkStartCode(String code);

	public PetMembers checkTemporaryPassword(String temporaryPasswordAccount, String temporaryPassword);

	void insertTemporaryPassword(String temporaryPasswordAccount, String temporaryPassword);
	
	
}
