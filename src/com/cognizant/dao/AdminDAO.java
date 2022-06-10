package com.cognizant.dao;

import com.cognizant.entity.Admin;
import com.cognizant.model.AdminModel;

public interface AdminDAO {

	public boolean doLogin(AdminModel adminModel);

	public boolean insertAdmin(Admin admin);

	public void generateAdminId();

	public String getId();
}
