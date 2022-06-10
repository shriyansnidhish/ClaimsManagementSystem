package com.cognizant.service;

import java.util.List;

import com.cognizant.entity.MemberRegistrationRequest;

public interface MemberRegistrationRequestService {
	public List<MemberRegistrationRequest> getAllNewRegistration();

	public boolean acceptRegistrtionRequest(String memberId);

	public boolean rejectRegistrtionRequest(String memberId);

	public List<MemberRegistrationRequest> getAllApprovedRegistration();
}
