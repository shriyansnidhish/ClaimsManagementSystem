package com.cognizant.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cognizant.dao.MemberDAO;
import com.cognizant.model.MemberModel;
import com.cognizant.service.MemberServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:/config/applicationContext.xml" })
public class TestMemberService {

	private MockMvc mockMvc;

	@Autowired
	@Spy
	private MemberDAO memberDAO;

	@InjectMocks
	private MemberServiceImpl memberServiceImpl;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(memberServiceImpl).build();
	}

	@Test
	public void persistPositiveTest() {

		MemberModel memberModel = new MemberModel();

		memberModel.setFirstName("Rahul");
		memberModel.setLastName("Kumar");
		memberModel.setAge(21);
		memberModel.setGender("male");
		memberModel.setDob("19/12/1996");
		memberModel.setContactNo(1010101100);
		memberModel.setAltContactNo(1847634733);
		memberModel.setEmailId("ragah@hi.com");
		memberModel.setPassword("Rahu@234");
		memberModel.setPlanCode("p2");
		memberModel.setCoverageStartDate("12/09/2016");
		memberModel.setCoverageEndDate("31/09/2016");

		memberModel.setAddressLine1("pune");
		memberModel.setAddressLine2("haridwar");
		memberModel.setCity("chennai");
		memberModel.setState("MP");
		memberModel.setZipCode(34);

		boolean status = memberServiceImpl.persistMember(memberModel);
		assertEquals(true, status);
	}

	@Test
	public void loginPositiveTest() {
		MemberModel memberModel = new MemberModel();
		memberModel.setMemberId("MEMBERGI");
		memberModel.setPassword("123@Pass");

		boolean status = memberServiceImpl.doLogin(memberModel);
		assertEquals(true, status);
	}
}
