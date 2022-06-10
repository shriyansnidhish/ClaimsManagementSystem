package com.cognizant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "cms_member_registration")
@NamedQueries({
		@NamedQuery(name = "getAllNewRegistration", query = "from MemberRegistrationRequest m where m.registrationStatus=:registrationStatus"),
		@NamedQuery(name = "registrationAccepted", query = "update  MemberRegistrationRequest m set m.registrationStatus=:registrationStatus where m.memberId=:memberId"),
		@NamedQuery(name = "registrationRejected", query = "update  MemberRegistrationRequest m set m.registrationStatus=:registrationStatus where m.memberId=:memberId"),
		@NamedQuery(name = "getAllApprovedRegistration", query = "from MemberRegistrationRequest m where m.registrationStatus=:registrationStatus") })
public class MemberRegistrationRequest {

	@Id
	@Column(name = "Member_Id")
	private String memberId;

	@Column(name = "Registration_Status")
	private String registrationStatus;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getRegistrationStatus() {
		return registrationStatus;
	}

	public void setRegistrationStatus(String registrationStatus) {
		this.registrationStatus = registrationStatus;
	}

}
