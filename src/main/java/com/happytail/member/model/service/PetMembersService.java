package com.happytail.member.model.service;

import java.util.List;

import com.happytail.member.model.PetMembers;



public interface PetMembersService {
	
	public PetMembers insertPetMembers(PetMembers petMembers);
	
	public PetMembers selectPetMembers(Integer id);
	
	public List<PetMembers> selectAllPetMembers();
	
//	public PetMembers updatePetMembers(int memberId, String email, String password, String username, String gender, 
//			Date bday, int age, String address, String phone, String petType, Blob memberImage, String fileName, Timestamp registerTime);
	
	public boolean deletePetMembers(Integer id);

	PetMembers selectPetMembers(String password, String account);

	PetMembers updatePetMembers(PetMembers petMember);

	PetMembers checkLogin(String account, String password);

	PetMembers selectPetMembers(String account);

	boolean checkStartCode(String code);
	
	void sendTemporaryPassword(String temporaryPasswordAccount);

	PetMembers checkTemporaryPassword(String temporaryPasswordAccount, String temporaryPassword);
	
}
