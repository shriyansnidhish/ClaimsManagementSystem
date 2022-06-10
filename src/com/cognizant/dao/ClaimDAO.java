package com.cognizant.dao;

import java.util.List;

import com.cognizant.entity.Claim;

public interface ClaimDAO {
	public boolean insertClaim(Claim claim);

	public List<Claim> getNewClaim();

	public List<Claim> getProcessedClaim();

	public List<Claim> getOneClaim(int claimId);

	public List<Claim> getClaimListOfMember(String memberCId);

	public boolean acceptClaimRequest(int claimId, String memberId);

	public boolean rejectClaimRequest(int claimId, String memberId);

}
