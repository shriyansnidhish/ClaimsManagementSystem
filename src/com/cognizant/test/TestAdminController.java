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

import com.cognizant.control.AdminController;
import com.cognizant.model.AdminModel;
import com.cognizant.service.AdminService;
import com.cognizant.validation.AdminRagistrationValidator;
import com.cognizant.validation.AdminValidator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:/config/applicationContext.xml" })
public class TestAdminController {

	private MockMvc mockMvc;

	@Autowired
	@Spy
	private AdminValidator adminValidator;

	@Autowired
	@Mock
	private AdminService adminService;

	@Autowired
	@Spy
	private AdminRagistrationValidator adminRagistrationValidator;

	@InjectMocks
	private AdminController adminController;

	@Mock
	private HttpSession session;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();
	}

	@Test // ADMIN CAN LOGIN WITH CORRECT ID AND PASSWORD
	public void test_loginPositive() {
		AdminModel adminModel = new AdminModel();

		adminModel.setAdminId("ADMINGE");
		adminModel.setPassword("123@Pass");
		Errors errors = new BeanPropertyBindingResult(adminModel, "adminModel");
		ModelAndView mv = adminController.doAdminLogin(adminModel, errors, session);
		String view = mv.getViewName();
		assertEquals("admin", view);
	}

}
