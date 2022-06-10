package com.cognizant.dao;

import java.util.List;

import com.cognizant.entity.MemberRegistrationRequest;

public interface MemberRegistrationRequestDAO {
	public List<MemberRegistrationRequest> getAllNewRegistration();

	public boolean acceptRegistrtionRequest(String memberId);

	public boolean rejectRegistrtionRequest(String memberId);

	public List<MemberRegistrationRequest> getAllApprovedRegistration();
}
