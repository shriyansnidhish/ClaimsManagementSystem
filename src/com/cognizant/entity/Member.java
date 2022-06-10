package com.cognizant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "CMS_MEMBER")
@NamedQueries({ @NamedQuery(name = "findMember", query = "from Member m where m.memberId=:id and m.password=:pass"),
		@NamedQuery(name = "getMemberById", query = "from Member m where m.memberId=:id"),

})
public class Member {

	@Id
	@GenericGenerator(name = "MEMBERIDSEQ", strategy = "com.cognizant.dao.MemberIDGenerator")
	@GeneratedValue(generator = "MEMBERIDSEQ")
	@Column(name = "Member_Id")
	private String memberId;

	@Column(name = "First_Name")
	private String firstName;

	@Column(name = "Last_Name")
	private String lastName;

	@Column(name = "Age")
	private int age;

	@Column(name = "Gender")
	private String gender;

	@Column(name = "DOB")
	private String dob;

	@Column(name = "Contact_Number")
	private long contactNo;

	@Column(name = "Alt_Contact_Number")
	private long altContactNo;

	@Column(name = "Email_Id")
	private String emailId;

	@Column(name = "password")
	private String password;

	@Column(name = "Plan_code")
	private String planCode;

	@Column(name = "Coverage_Start_Date")
	private String coverageStartDate;

	@Column(name = "Coverage_End_date")
	private String coverageEndDate;

	@Column(name = "Address_Line_1")
	private String addressLine1;

	@Column(name = "Address_Line_2")
	private String addressLine2;

	@Column(name = "City")
	private String city;

	@Column(name = "State")
	private String state;

	@Column(name = "Zip_Code")
	private int zipCode;

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	public long getAltContactNo() {
		return altContactNo;
	}

	public void setAltContactNo(long altContactNo) {
		this.altContactNo = altContactNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPlanCode() {
		return planCode;
	}

	public void setPlanCode(String planCode) {
		this.planCode = planCode;
	}

	public String getCoverageStartDate() {
		return coverageStartDate;
	}

	public void setCoverageStartDate(String coverageStartDate) {
		this.coverageStartDate = coverageStartDate;
	}

	public String getCoverageEndDate() {
		return coverageEndDate;
	}

	public void setCoverageEndDate(String coverageEndDate) {
		this.coverageEndDate = coverageEndDate;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

}
