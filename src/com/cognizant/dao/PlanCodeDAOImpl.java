package com.cognizant.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cognizant.entity.PlanCode;
import com.cognizant.helper.SessionCreator;
import com.cognizant.model.PlanCodeModel;

@Repository("PlanCodeDAOImpl")
public class PlanCodeDAOImpl implements PlanCodeDAO {

	@Autowired
	private SessionCreator sessionCreator;

	@Override
	public List<PlanCode> getPlanDetailById(String planCode) {

		Session session = sessionCreator.createSession();
		Query query = session.getNamedQuery("getPlanById");

		query.setParameter("planCode", planCode);
		List<PlanCode> onePlan = query.list();
		return onePlan;

	}

	@Override
	public boolean updatePlanCode(PlanCodeModel planCodeModel) {

		Session session = sessionCreator.createSession();
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		Query query = session.getNamedQuery("updatePlanById");
		query.setParameter("planCode", planCodeModel.getPlanCode());
		query.setParameter("planDescription", planCodeModel.getPlanDescription());
		query.setParameter("coverage1", planCodeModel.getCoverage1());
		query.setParameter("coverage2", planCodeModel.getCoverage2());
		query.setParameter("coverage3", planCodeModel.getCoverage3());
		query.setParameter("coverage4", planCodeModel.getCoverage4());
		query.setParameter("coverage5", planCodeModel.getCoverage5());
		int updateSuccess = query.executeUpdate();
		transaction.commit();
		if (updateSuccess > 0)
			return true;
		else
			return false;
	}

	@Override
	public List<PlanCode> getPlanCodeList() {
		Session session = sessionCreator.createSession();
		String sql = "select PLAN_CODE from CMS_PLAN_CODE";
		SQLQuery query = session.createSQLQuery(sql);

		List<PlanCode> planCodeList = query.list();
		System.out.println(planCodeList);
		return planCodeList;
	}

}
