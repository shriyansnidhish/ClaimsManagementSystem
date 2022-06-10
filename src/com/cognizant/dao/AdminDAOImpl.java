package com.cognizant.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cognizant.entity.Admin;
import com.cognizant.helper.SessionCreator;
import com.cognizant.model.AdminModel;

@Repository("AdminDAOImpl")

public class AdminDAOImpl implements AdminDAO {
	@Autowired
	private SessionCreator sessionCreator;

	public static String id;

	public boolean doLogin(AdminModel adminModel) {

		Session session = sessionCreator.createSession();
		Query query = session.getNamedQuery("findAdmin");
		query.setParameter("id", adminModel.getAdminId());
		query.setParameter("password", adminModel.getPassword());
		List<Admin> adminList = query.list();

		if (adminList.isEmpty())
			return false;
		else
			return true;
	}

	@Override
	public boolean insertAdmin(Admin admin) {
		Session session = sessionCreator.createSession();
		generateAdminId();
		Transaction tx = session.beginTransaction();
		tx.begin();
		session.persist(admin);
		tx.commit();
		id = admin.getAdminId();

		return true;
	}

	@Override
	public void generateAdminId() {

		Session session = sessionCreator.createSession();
		Query query = session.createSQLQuery("select Admin_ID.nextval FROM DUAL");
		Long key = ((BigDecimal) query.uniqueResult()).longValue();
		AdminStoreId.addId(key.intValue());
	}

	@Override
	public String getId() {

		return id;
	}
}
