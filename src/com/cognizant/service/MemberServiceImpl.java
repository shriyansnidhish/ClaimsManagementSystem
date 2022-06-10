package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.MemberDAO;
import com.cognizant.entity.Member;
import com.cognizant.model.MemberModel;

@Service("MemberServiceImpl")
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;

	public boolean doLogin(MemberModel memberModel) {

		return memberDAO.doLogin(memberModel);
	}

	@Override
	public boolean persistMember(MemberModel memberModel) {
		Member member = new Member();

		member.setFirstName(memberModel.getFirstName());
		member.setLastName(memberModel.getLastName());
		member.setAge(memberModel.getAge());
		member.setGender(memberModel.getGender());
		member.setDob(memberModel.getDob());
		member.setContactNo(memberModel.getContactNo());
		member.setAltContactNo(memberModel.getAltContactNo());
		member.setEmailId(memberModel.getEmailId());
		member.setPassword(memberModel.getPassword());
		member.setPlanCode(memberModel.getPlanCode());
		member.setCoverageStartDate(memberModel.getCoverageStartDate());
		member.setCoverageEndDate(memberModel.getCoverageEndDate());

		member.setAddressLine1(memberModel.getAddressLine1());
		member.setAddressLine2(memberModel.getAddressLine2());
		member.setCity(memberModel.getCity());
		member.setState(memberModel.getState());
		member.setZipCode(memberModel.getZipCode());

		return memberDAO.insertMember(member);
	}

	@Override
	public List<Member> getMemberById(String memberId) {
		return memberDAO.getMemberById(memberId);

	}

	@Override
	public String getId() {

		return memberDAO.getId();
	}

}
