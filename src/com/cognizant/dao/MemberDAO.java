package com.cognizant.dao;

import java.util.List;

import com.cognizant.entity.Member;
import com.cognizant.model.MemberModel;

public interface MemberDAO {
	public boolean doLogin(MemberModel memberModel);

	public boolean insertMember(Member member);

	public List<Member> getMemberById(String memberId);

	public void generateMemberId();

	public String getId();
}
