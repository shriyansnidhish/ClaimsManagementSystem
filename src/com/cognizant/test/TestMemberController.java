package com.cognizant.test;

import static org.junit.Assert.assertEquals;

import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.control.MemberController;
import com.cognizant.model.MemberModel;
import com.cognizant.service.MemberRegistrationRequestService;
import com.cognizant.validation.MemberValidator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:/config/applicationContext.xml" })
public class TestMemberController {

	private MockMvc mockMvc;

	@Autowired
	@Mock
	private MemberRegistrationRequestService mr;

	@Mock
	private HttpSession session;

	@Autowired
	@Spy
	private MemberValidator memberValidator;

	@InjectMocks
	private MemberController memberController;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(memberController).build();
	}

	@Test // MEMBER IS REGISTERED BUT NOT ALLOW TO LOGIN
	public void test_loginNegative() {
		MemberModel memberModel = new MemberModel();
		memberModel.setMemberId("MEMBERGI");
		memberModel.setPassword("123@Pass");

		Errors errors = new BeanPropertyBindingResult(memberModel, "memberModel");
		ModelAndView mv = memberController.doMemberLogin(memberModel, errors, session);

		String actualView = mv.getViewName();
		assertEquals("memberlogin", actualView);
	}

}
