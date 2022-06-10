package com.cognizant.model;

public class ClaimModel {

	private int claimId;

	private String memberId;

	private String claimServiceDate;

	private String claimSubmissionDate;

	private String claimProcessingDate;

	private String claimStatus;

	private int claimAmount;

	private int approvedAmount;

	public int getClaimId() {
		return claimId;
	}

	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getClaimServiceDate() {
		return claimServiceDate;
	}

	public void setClaimServiceDate(String claimServiceDate) {
		this.claimServiceDate = claimServiceDate;
	}

	public String getClaimSubmissionDate() {
		return claimSubmissionDate;
	}

	public void setClaimSubmissionDate(String claimSubmissionDate) {
		this.claimSubmissionDate = claimSubmissionDate;
	}

	public String getClaimProcessingDate() {
		return claimProcessingDate;
	}

	public void setClaimProcessingDate(String claimProcessingDate) {
		this.claimProcessingDate = claimProcessingDate;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public int getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(int claimAmount) {
		this.claimAmount = claimAmount;
	}

	public int getApprovedAmount() {
		return approvedAmount;
	}

	public void setApprovedAmount(int approvedAmount) {
		this.approvedAmount = approvedAmount;
	}

}
