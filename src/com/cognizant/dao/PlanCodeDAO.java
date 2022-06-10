package com.cognizant.dao;

import java.util.List;

import com.cognizant.entity.PlanCode;
import com.cognizant.model.PlanCodeModel;

public interface PlanCodeDAO {
	public List<PlanCode> getPlanDetailById(String planCode);

	public boolean updatePlanCode(PlanCodeModel planCodeModel);

	public List<PlanCode> getPlanCodeList();
}
