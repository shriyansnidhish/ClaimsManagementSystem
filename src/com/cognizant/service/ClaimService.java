package com.cognizant.service;

import java.util.List;

import com.cognizant.entity.Claim;
import com.cognizant.model.ClaimModel;

public interface ClaimService {
	public boolean persistClaim(ClaimModel claimModel);

	public List<Claim> getNewClaim();

	public List<Claim> getProcessedClaim();

	public List<Claim> getOneClaim(int claimId);

	public List<Claim> getClaimListOfMember(String memberCId);

	public boolean acceptClaimRequest(int claimId, String memberId);

	public boolean rejectClaimRequest(int claimId, String memberId);
}
