package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.MemberRegistrationRequestDAO;
import com.cognizant.entity.MemberRegistrationRequest;

@Service("MemberRegistrationRequestServiceImpl")
public class MemberRegistrationRequestServiceImpl implements MemberRegistrationRequestService {
	@Autowired
	private MemberRegistrationRequestDAO memberRegistrationRequestDAO;

	@Override
	public List<MemberRegistrationRequest> getAllNewRegistration() {

		return memberRegistrationRequestDAO.getAllNewRegistration();
	}

	@Override
	public boolean acceptRegistrtionRequest(String memberId) {

		return memberRegistrationRequestDAO.acceptRegistrtionRequest(memberId);
	}

	@Override
	public boolean rejectRegistrtionRequest(String memberId) {

		return memberRegistrationRequestDAO.rejectRegistrtionRequest(memberId);
	}

	@Override
	public List<MemberRegistrationRequest> getAllApprovedRegistration() {
		return memberRegistrationRequestDAO.getAllApprovedRegistration();
	}
}
