package com.cognizant.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cognizant.model.AdminModel;
import com.cognizant.service.AdminService;

@Component("AdminValidator")
public class AdminValidator implements Validator {

	@Autowired
	private AdminService adminService;

	public boolean supports(Class<?> arg0) {

		return arg0.equals(AdminModel.class);
	}

	public void validate(Object arg0, Errors arg1) {

		AdminModel adminModel = (AdminModel) arg0;
		boolean adminAuth = adminService.doLogin(adminModel);

		if (!adminAuth) {
			arg1.rejectValue("adminId", "com.cognizant.entity.Admin.adminId.invalid");
		}

	}

}
