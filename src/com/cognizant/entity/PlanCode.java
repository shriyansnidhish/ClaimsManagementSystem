package com.cognizant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity(name = "PlanCode")
@Table(name = "CMS_PLAN_CODE")
@NamedQueries({

		@NamedQuery(name = "getPlanById", query = "from PlanCode p where p.planCode=:planCode"),
		@NamedQuery(name = "updatePlanById", query = "update PlanCode p set p.planDescription=:planDescription ,p.coverage1=:coverage1 ,p.coverage2=:coverage2 ,p.coverage3=:coverage3 ,p.coverage4=:coverage4 ,p.coverage5=:coverage5 where p.planCode=:planCode")

})
public class PlanCode {

	@Id
	@Column(name = "Plan_Code")
	private String planCode;

	@Column(name = "Plan_Description")
	private String planDescription;

	@Column(name = "Coverage1")
	private String coverage1;

	@Column(name = "Coverage2")
	private String coverage2;

	@Column(name = "Coverage3")
	private String coverage3;

	@Column(name = "Coverage4")
	private String coverage4;

	@Column(name = "Coverage5")
	private String coverage5;

	public String getPlanCode() {
		return planCode;
	}

	public void setPlanCode(String planCode) {
		this.planCode = planCode;
	}

	public String getPlanDescription() {
		return planDescription;
	}

	public void setPlanDescription(String planDescription) {
		this.planDescription = planDescription;
	}

	public String getCoverage1() {
		return coverage1;
	}

	public void setCoverage1(String coverage1) {
		this.coverage1 = coverage1;
	}

	public String getCoverage2() {
		return coverage2;
	}

	public void setCoverage2(String coverage2) {
		this.coverage2 = coverage2;
	}

	public String getCoverage3() {
		return coverage3;
	}

	public void setCoverage3(String coverage3) {
		this.coverage3 = coverage3;
	}

	public String getCoverage4() {
		return coverage4;
	}

	public void setCoverage4(String coverage4) {
		this.coverage4 = coverage4;
	}

	public String getCoverage5() {
		return coverage5;
	}

	public void setCoverage5(String coverage5) {
		this.coverage5 = coverage5;
	}

}
