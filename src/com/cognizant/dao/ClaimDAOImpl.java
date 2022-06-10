package com.cognizant.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cognizant.control.ClaimController;
import com.cognizant.entity.Claim;
import com.cognizant.helper.SessionCreator;

@Repository("ClaimDAOImpl")

public class ClaimDAOImpl implements ClaimDAO {
	@Autowired
	private SessionCreator sessionCreator;

	static Logger log = Logger.getLogger(ClaimController.class);

	@Override
	public List<Claim> getNewClaim() {

		Session session = sessionCreator.createSession();
		Query query = session.getNamedQuery("getNewClaims");
		query.setParameter("claimStatus", "Submitted");

		List<Claim> newClaimList = query.list();

		return newClaimList;
	}

	@Override
	public List<Claim> getProcessedClaim() {

		Session session = sessionCreator.createSession();
		Query query = session.getNamedQuery("getProcessedClaims");
		query.setParameter("claimStatus1", "Approved");
		query.setParameter("claimStatus2", "Denied");
		List<Claim> processedClaimList = query.list();

		/*
		 * for(Claim claim : processedClaimList){
		 * System.out.println(claim.getClaimStatus()); }
		 * 
		 */

		return processedClaimList;

	}

	@Override
	public List<Claim> getOneClaim(int claimId) {
		Session session = sessionCreator.createSession();
		Query query = session.getNamedQuery("getOneClaim");
		query.setInteger("claimId", claimId);
		List<Claim> oneClaim = query.list();
		return oneClaim;
	}

	@Override
	public boolean acceptClaimRequest(int claimId, String memberId) {
		Session session = sessionCreator.createSession();
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		Query query = session.getNamedQuery("updateStatusAsAccepted");
		query.setParameter("claimStatus", "Approved");
		query.setParameter("claimId", claimId);
		query.setParameter("memberId", memberId);

		int acceptStatus = query.executeUpdate();
		transaction.commit();
		if (acceptStatus > 0)
			return true;
		else
			return false;

	}

	@Override
	public boolean rejectClaimRequest(int claimId, String memberId) {
		Session session = sessionCreator.createSession();
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		Query query = session.getNamedQuery("updateStatusAsRejected");
		query.setParameter("claimStatus", "Denied");
		query.setParameter("claimId", claimId);
		query.setParameter("memberId", memberId);

		int rejectStatus = query.executeUpdate();
		transaction.commit();

		if (rejectStatus > 0)
			return true;
		else
			return false;

	}

	@Override

	public boolean insertClaim(Claim claim) {

		Session session = sessionCreator.createSession();

		Transaction tx = session.beginTransaction();
		tx.begin();
		session.persist(claim);
		tx.commit();

		return true;
	}

	@Override
	public List<Claim> getClaimListOfMember(String memberCId) {

		Session session = sessionCreator.createSession();
		Query query = session.getNamedQuery("getMemberClaims");
		query.setParameter("memberId", memberCId);
		List<Claim> memberClaimsList = query.list();
		log.info(memberClaimsList);
		log.info(memberCId);
		return memberClaimsList;
	}

}
