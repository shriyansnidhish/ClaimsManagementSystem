package com.cognizant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.AdminDAO;
import com.cognizant.entity.Admin;
import com.cognizant.model.AdminModel;

@Service("AdminServiceImpl")
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO adminDAO;

	public boolean doLogin(AdminModel adminModel) {

		return adminDAO.doLogin(adminModel);
	}

	@Override
	public boolean persistAdmin(AdminModel adminModel) {
		Admin admin = new Admin();

		admin.setPassword(adminModel.getPassword());
		admin.setFirstName(adminModel.getFirstName());
		admin.setLastName(adminModel.getLastName());
		admin.setAge(adminModel.getAge());
		admin.setGender(adminModel.getGender());
		admin.setDob(adminModel.getDob());
		admin.setContactNo(adminModel.getAltContactNo());
		admin.setAltContactNo(adminModel.getAltContactNo());
		admin.setEmailId(adminModel.getEmailId());

		return adminDAO.insertAdmin(admin);
	}

	@Override
	public String getId() {

		return adminDAO.getId();
	}

}
