package com.cognizant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "CMS_ADMIN")
@NamedQueries({ @NamedQuery(name = "findAdmin", query = "from Admin o where o.adminId=:id and o.password=:password") })
public class Admin {

	@Id
	@GenericGenerator(name = "ADMINIDSEQ", strategy = "com.cognizant.dao.AdminIDGenerator")
	@GeneratedValue(generator = "ADMINIDSEQ")
	@Column(name = "Admin_id")
	private String adminId;

	@Column(name = "Password")
	private String password;

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

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

}
