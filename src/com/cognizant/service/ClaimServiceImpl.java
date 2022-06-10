package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.ClaimDAO;
import com.cognizant.entity.Claim;
import com.cognizant.model.ClaimModel;

@Service("ClaimServiceImpl")
public class ClaimServiceImpl implements ClaimService {

	@Autowired
	private ClaimDAO claimDAO;

	@Override
	public List<Claim> getNewClaim() {

		return claimDAO.getNewClaim();
	}

	@Override
	public List<Claim> getProcessedClaim() {
		return claimDAO.getProcessedClaim();

	}

	@Override
	public List<Claim> getOneClaim(int claimId) {
		return claimDAO.getOneClaim(claimId);

	}

	@Override
	public boolean acceptClaimRequest(int claimId, String memberId) {
		return claimDAO.acceptClaimRequest(claimId, memberId);
	}

	@Override
	public boolean rejectClaimRequest(int claimId, String memberId) {
		return claimDAO.rejectClaimRequest(claimId, memberId);
	}

	@Override
	public boolean persistClaim(ClaimModel claimModel) {
		Claim claim = new Claim();

		claim.setClaimId(claimModel.getClaimId());
		claim.setMemberId(claimModel.getMemberId());
		claim.setClaimServiceDate(claimModel.getClaimServiceDate());
		claim.setClaimSubmissionDate(claimModel.getClaimSubmissionDate());
		claim.setClaimProcessingDate(claimModel.getClaimProcessingDate());
		claim.setClaimStatus(claimModel.getClaimStatus());
		claim.setClaimAmount(claimModel.getClaimAmount());
		claim.setApprovedAmount(claimModel.getApprovedAmount());

		return claimDAO.insertClaim(claim);
	}

	@Override
	public List<Claim> getClaimListOfMember(String memberCId) {

		return claimDAO.getClaimListOfMember(memberCId);
	}

}
