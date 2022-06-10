package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.PlanCodeDAO;
import com.cognizant.entity.PlanCode;
import com.cognizant.model.PlanCodeModel;

@Service("PlanCodeServiceImpl")
public class PlanCodeServiceImpl implements PlanCodeService {

	@Autowired
	private PlanCodeDAO planCodeDAO;

	@Override
	public List<PlanCode> getPlanDetailById(String planCode) {

		return planCodeDAO.getPlanDetailById(planCode);
	}

	@Override
	public boolean updatePlanCode(PlanCodeModel planCodeModel) {

		return planCodeDAO.updatePlanCode(planCodeModel);
	}

	@Override
	public List<PlanCode> getPlanCodeList() {

		return planCodeDAO.getPlanCodeList();
	}

}
