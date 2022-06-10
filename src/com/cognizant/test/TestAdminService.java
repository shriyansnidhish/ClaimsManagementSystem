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

import com.cognizant.dao.AdminDAO;
import com.cognizant.model.AdminModel;
import com.cognizant.service.AdminServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:/config/applicationContext.xml" })
public class TestAdminService {
	private MockMvc mockMvc;

	@Autowired
	@Spy
	private AdminDAO adminDAO;

	@InjectMocks
	private AdminServiceImpl adminServiceImpl;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(adminServiceImpl).build();
	}

	@Test // AFTER PERFORM VALIDATION ADMIN WILL PERSIST IN DB
	public void persistPositiveTest() {

		AdminModel adminModel = new AdminModel();
		adminModel.setFirstName("Satyansh");
		adminModel.setLastName("Shukla");

		adminModel.setAge(23);
		adminModel.setContactNo(1234567890);
		adminModel.setAltContactNo(1234567890);
		adminModel.setDob("10/11/1997");
		adminModel.setEmailId("iamsatyansh@gmail.com");
		adminModel.setGender("Male");
		adminModel.setPassword("123@Pass");

		boolean status = adminServiceImpl.persistAdmin(adminModel);
		assertEquals(true, status);
	}

	@Test // ID AND PASSWORD MATCH WITH ID AND PASSWORD OF DB
	public void loginPositiveTest() {

		AdminModel adminModel = new AdminModel();
		adminModel.setAdminId("ADMINGE");
		adminModel.setPassword("123@Pass");

		boolean status = adminServiceImpl.doLogin(adminModel);
		assertEquals(true, status);
	}

}
