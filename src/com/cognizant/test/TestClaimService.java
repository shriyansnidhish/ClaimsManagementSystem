package com.cognizant.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cognizant.dao.ClaimDAO;
import com.cognizant.model.ClaimModel;
import com.cognizant.service.ClaimServiceImpl;

public class TestClaimService {

	private MockMvc mockMvc;

	@Autowired
	@Mock
	private ClaimDAO claimDAO;

	@InjectMocks
	private ClaimServiceImpl claimServiceImpl;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(claimServiceImpl).build();
	}

	@Test // TRY TO INSERT A CLAIM WITH INT MEMBER ID
	public void test_loginNegative() {
		ClaimModel claimModel = new ClaimModel();
		claimModel.setClaimId(5);
		claimModel.setMemberId("123");
		claimModel.setClaimServiceDate("12/12/2018");
		claimModel.setClaimSubmissionDate("12/12/2018");
		claimModel.setClaimProcessingDate("12/12/2018");
		claimModel.setClaimStatus("Submitted");
		claimModel.setClaimAmount(2000);
		claimModel.setApprovedAmount(1500);
		boolean status = claimServiceImpl.persistClaim(claimModel);
		assertEquals(false, status);

	}
}
