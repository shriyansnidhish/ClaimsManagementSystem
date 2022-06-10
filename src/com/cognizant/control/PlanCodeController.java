package com.cognizant.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.entity.PlanCode;
import com.cognizant.exception.SessionExpired;
import com.cognizant.model.PlanCodeModel;
import com.cognizant.service.PlanCodeService;

@Controller
public class PlanCodeController {
	@Autowired
	private PlanCodeService planCodeService;

	static Logger log = Logger.getLogger(PlanCodeController.class);

	// return member plan code detail
	@RequestMapping(value = "viewmemberplancode.htm", method = RequestMethod.GET)
	public ModelAndView viewPlanCode(@RequestParam("planCode") String planCode, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession(false);
		if (session.getAttribute("adminId") == null) {

			throw new SessionExpired("Session Expired");
		} else {

			log.info("Session Not null");
		}
		if (request.getSession(false) != null) {

			List<PlanCode> planById = planCodeService.getPlanDetailById(planCode);
			log.info(planById);
			mv.addObject("planById", planById);
			mv.setViewName("editplancode");
		}

		else {
			mv.setViewName("message");
		}
		return mv;
	}

	// Load Plan code form to edit
	@RequestMapping(value = "loadplancodeform.htm", method = RequestMethod.GET)
	public ModelAndView loadPlanCodeForm(@RequestParam("planCode") String planCode, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		HttpSession session = request.getSession(false);
		if (session.getAttribute("adminId") == null) {

			throw new SessionExpired("Session Expired");
		} else {

			log.info("Session Not null");
		}
		if (request.getSession(false) != null) {

			mv.addObject("planCode", planCode);
			mv.setViewName("editplancodeform");
		}

		else {
			mv.setViewName("message");
		}

		return mv;
	}

	// pocess of update the plan code
	@RequestMapping(value = "editplancode.htm", method = RequestMethod.POST)
	public ModelAndView editPlanCodeForm(@ModelAttribute("planCodeModel") PlanCodeModel planCodeModel,
			@RequestParam("planCode") String planCode, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession(false);
		if (session.getAttribute("adminId") == null) {

			throw new SessionExpired("Session Expired");
		} else {

			log.info("Session Not null");
		}
		if (request.getSession(false) != null) {
			planCodeModel.setPlanCode(planCode);
			if (planCodeService.updatePlanCode(planCodeModel) == true) {
				List<PlanCode> planById = planCodeService.getPlanDetailById(planCode);

				mv.addObject("planById", planById);
				mv.setViewName("editplancode");
				return mv;
			} else {
				mv.setViewName("editPlanCodeform");

			}
		}

		else {
			mv.setViewName("message");
		}

		return mv;
	}

	// create plan code model object
	@ModelAttribute("planCodeModel")
	public PlanCodeModel createPlanCodeModelObject() {
		PlanCodeModel planCodeModel = new PlanCodeModel();
		return planCodeModel;

	}
}
