package com.cognizant.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cognizant.control.AdminController;
import com.cognizant.entity.Member;
import com.cognizant.entity.MemberRegistrationRequest;
import com.cognizant.helper.SessionCreator;
import com.cognizant.model.MemberModel;

@Repository("MemberDAOImpl")

public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SessionCreator sessionCreator;

	static Logger log = Logger.getLogger(AdminController.class);

	MemberRegistrationRequest memberRegistrationRequest = new MemberRegistrationRequest();

	public boolean doLogin(MemberModel memberModel) {

		Session session = sessionCreator.createSession();
		Query query = session.getNamedQuery("findMember");
		query.setParameter("id", memberModel.getMemberId());
		query.setParameter("pass", memberModel.getPassword());
		List<Member> memberList = query.list();

		if (memberList.isEmpty())
			return false;
		else
			return true;
	}

	public static String id;

	@Override
	public boolean insertMember(Member member) {
		generateMemberId();
		Session session = sessionCreator.createSession();
		Transaction tx = session.beginTransaction();
		tx.begin();

		session.persist(member);
        tx.commit();
		log.info("member persist");
		
		memberRegistrationRequest.setMemberId(member.getMemberId());
		memberRegistrationRequest.setRegistrationStatus("Submitted");
        
		Session session1 = sessionCreator.createSession();
		Transaction tx1 = session1.beginTransaction();
		tx1.begin();
		session.persist(memberRegistrationRequest);
		tx1.commit();
		log.info("member registration request persist");
		id = member.getMemberId();

		return true;
	}

	@Override
	public List<Member> getMemberById(String memberId) {

		Session session = sessionCreator.createSession();
		Query query = session.getNamedQuery("getMemberById");
		query.setParameter("id", memberId);
		List<Member> member = query.list();
		return member;
	}

	@Override
	public void generateMemberId() {

		Session session = sessionCreator.createSession();
		Query query = session.createSQLQuery("select Member_ID.nextval FROM DUAL");
		Long key = ((BigDecimal) query.uniqueResult()).longValue();

		MemberStoreId.addId(key.intValue());
	}

	@Override
	public String getId() {

		return id;
	}

}
