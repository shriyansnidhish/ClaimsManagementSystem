package com.cognizant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CMS_CLAIM")
@NamedQueries({ @NamedQuery(name = "getNewClaims", query = "from Claim o where o.claimStatus=:claimStatus"),
		@NamedQuery(name = "getProcessedClaims", query = "from Claim o where o.claimStatus=:claimStatus1 or o.claimStatus=:claimStatus2"),
		@NamedQuery(name = "getOneClaim", query = "from Claim o where o.claimId=:claimId"),
		@NamedQuery(name = "updateStatusAsAccepted", query = "update Claim o set o.claimStatus=:claimStatus where o.claimId=:claimId and o.memberId=:memberId"),
		@NamedQuery(name = "updateStatusAsRejected", query = "update Claim o set o.claimStatus=:claimStatus where o.claimId=:claimId and o.memberId=:memberId"),
		@NamedQuery(name = "getMemberClaims", query = "from Claim o where o.memberId=:memberId") })

public class Claim {

	@Id

	@Column(name = "Claim_Id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_NAME")
	@SequenceGenerator(name = "SEQUENCE_NAME", sequenceName = "SEQUENCE_NAME", allocationSize = 1, initialValue = 1)
	private int claimId;

	@Column(name = "Member_Id")
	private String memberId;

	@Column(name = "Claim_Service_Date")
	private String claimServiceDate;

	@Column(name = "Claim_Submission_Date")
	private String claimSubmissionDate;

	@Column(name = "Claim_Processing_Date")
	private String claimProcessingDate;

	@Column(name = "Claim_Status")
	private String claimStatus;

	@Column(name = "Claim_Amount")
	private int claimAmount;

	@Column(name = "Approved_Amount")
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
