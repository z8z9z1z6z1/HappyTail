package com.happytail.admin.model.service;

import java.util.List;

import com.happytail.member.model.PetMembers;

public interface AdminMembersService {

	// 所有會員總數
	public Long countMembers();

	// 所有男性會員總數
	public Long countMale();

	// 所有女性會員總數
	public Long countFemale();
	
	//年齡分布
	public List<Long> age();

	// 更改會員狀態
	PetMembers changeMemberStatus(Integer id);

}
