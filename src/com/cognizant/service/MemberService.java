package com.cognizant.service;

import java.util.List;

import com.cognizant.entity.Member;
import com.cognizant.model.MemberModel;

public interface MemberService {
	public boolean doLogin(MemberModel memberModel);

	public boolean persistMember(MemberModel memberModel);

	public List<Member> getMemberById(String memberId);

	public String getId();
}
