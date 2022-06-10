package com.cognizant.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cognizant.entity.MemberRegistrationRequest;
import com.cognizant.helper.SessionCreator;

@Repository("MemberRegistrationRequestDAOImpl.java")

public class MemberRegistrationRequestDAOImpl implements MemberRegistrationRequestDAO {
	@Autowired
	private SessionCreator sessionCreator;

	public List<MemberRegistrationRequest> getAllNewRegistration() {

		Session session = sessionCreator.createSession();
		Query query = session.getNamedQuery("getAllNewRegistration");
		query.setParameter("registrationStatus", "Submitted");

		List<MemberRegistrationRequest> newRegistrationList = query.list();

		return newRegistrationList;
	}

	@Override
	public boolean acceptRegistrtionRequest(String memberId) {
		Session session = sessionCreator.createSession();
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		Query query = session.getNamedQuery("registrationAccepted");
		query.setParameter("registrationStatus", "Approved");

		query.setParameter("memberId", memberId);

		int acceptStatus = query.executeUpdate();
		transaction.commit();
		if (acceptStatus > 0)
			return true;
		else
			return false;

	}

	@Override
	public boolean rejectRegistrtionRequest(String memberId) {
		Session session = sessionCreator.createSession();
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		Query query = session.getNamedQuery("registrationRejected");
		query.setParameter("registrationStatus", "Denied");

		query.setParameter("memberId", memberId);

		int rejectStatus = query.executeUpdate();
		transaction.commit();

		if (rejectStatus > 0)
			return true;
		else
			return false;

	}

	@Override
	public List<MemberRegistrationRequest> getAllApprovedRegistration() {
		Session session = sessionCreator.createSession();
		Query query = session.getNamedQuery("getAllApprovedRegistration");
		query.setParameter("registrationStatus", "Approved");

		List<MemberRegistrationRequest> ApprovedRegistrationList = query.list();

		return ApprovedRegistrationList;
	}

}
