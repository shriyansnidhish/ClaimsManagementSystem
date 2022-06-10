package com.cognizant.service;

import com.cognizant.model.AdminModel;

public interface AdminService {

	public boolean doLogin(AdminModel adminModel);

	public boolean persistAdmin(AdminModel adminModel);

	public String getId();

}
