package com.cognizant.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.entity.Claim;
import com.cognizant.exception.SessionExpired;
import com.cognizant.model.ClaimModel;
import com.cognizant.service.ClaimService;
import com.cognizant.validation.ClaimValidator;

@Controller
public class ClaimController {

	@Autowired
	@Qualifier("ClaimValidator")
	private ClaimValidator claimvalidator;

	@Autowired
	private ClaimService claimService;

	static Logger log = Logger.getLogger(ClaimController.class);

	@ModelAttribute("claimModel")
	public ClaimModel createClaimModelObject() {
		ClaimModel claimModel = new ClaimModel();
		return claimModel;
	}

	// returns claim detail of a specific member
	@RequestMapping(value = "viewonememberclaim.htm", method = RequestMethod.GET)
	public ModelAndView viewOneMemberClaim(@RequestParam("claimId") int claimId, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		HttpSession session = request.getSession(false);
		if (session.getAttribute("memberId") == null) {

			throw new SessionExpired("Session Expired");
		} else {

			log.info("Session Not null");
		}
		if (request.getSession(false) != null) {
			List<Claim> oneMemberClaim = claimService.getOneClaim(claimId);

			mv.addObject("oneMemberClaim", oneMemberClaim);

			mv.setViewName("viewonememberclaim");
		}

		else {
			mv.setViewName("message");
		}

		return mv;
	}

	// return all new claim
	@RequestMapping(value = "viewnewclaim.htm", method = RequestMethod.GET)
	public ModelAndView viewNewClaim(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		HttpSession session = request.getSession(false);
		if (session.getAttribute("adminId") == null) {

			throw new SessionExpired("Session Expired");
		} else {

			log.info("Session Not null");
		}
		if (request.getSession(false) != null) {
			List<Claim> newClaimList = claimService.getNewClaim();

			mv.addObject("newClaimList", newClaimList);

			mv.setViewName("viewnewclaim");
		}

		else {
			mv.setViewName("message");
		}
		return mv;
	}

	// return all processed claim
	@RequestMapping(value = "viewprocessedclaim.htm", method = RequestMethod.GET)
	public ModelAndView viewProcessedClaim(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		HttpSession session = request.getSession(false);
		if (session.getAttribute("adminId") == null) {

			throw new SessionExpired("Session Expired");
		} else {

			log.info("Session Not null");
		}
		if (request.getSession(false) != null) {
			List<Claim> processedClaimList = claimService.getProcessedClaim();

			mv.addObject("processedClaimList", processedClaimList);

			mv.setViewName("viewprocessedclaim");
		}

		else {
			mv.setViewName("message");
		}
		return mv;
	}

	// return claim by Id
	@RequestMapping(value = "viewoneclaim.htm", method = RequestMethod.GET)
	public ModelAndView viewOneClaim(@RequestParam("claimId") int claimId, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession(false);
		if (session.getAttribute("adminId") == null) {

			throw new SessionExpired("Session Expired");
		} else {

			log.info("Session Not null");
		}
		if (request.getSession(false) != null) {
			List<Claim> oneClaim = claimService.getOneClaim(claimId);

			mv.addObject("oneClaim", oneClaim);

			mv.setViewName("viewoneclaim");
		}

		else {
			mv.setViewName("message");
		}
		return mv;
	}

	// process claim request
	@RequestMapping(value = "changeRequestStatus.htm", method = RequestMethod.GET)
	public ModelAndView changeClaimStatus(@RequestParam("claimId") int claimId,
			@RequestParam("memberId") String memberId, @RequestParam("action") String action,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		HttpSession session = request.getSession(false);
		if (session.getAttribute("adminId") == null) {

			throw new SessionExpired("Session Expired");
		} else {

			log.info("Session Not null");
		}
		if (request.getSession(false) != null) {
			if (action.equals("Accept")) {
				boolean acceptClaim = claimService.acceptClaimRequest(claimId, memberId);
				if (acceptClaim)
					mv.setViewName("admin");

			} else {

				boolean rejectClaim = claimService.rejectClaimRequest(claimId, memberId);
				if (rejectClaim)
					mv.setViewName("admin");

			}
		}

		else {
			mv.setViewName("message");
		}
		return mv;
	}

	// Load raise claim form
	@RequestMapping(value = "raiseclaimform.htm", method = RequestMethod.GET)
	public String loadRaiseClaimForm(HttpServletRequest request, HttpSession session) {

		session = request.getSession(false);
		if (session.getAttribute("memberId") == null) {
			throw new SessionExpired("Session Expired");
		} else {

			log.info("Session Not null");
		}
		if (request.getSession(false) != null) {
			return "raiseclaimform";
		}

		return "message";
	}

	// claim registration process
	@RequestMapping(value = "claimregistrationprocess.htm", method = RequestMethod.POST)
	public ModelAndView addClaim(@ModelAttribute("claimModel") ClaimModel claimModel, Errors error, HttpSession session,
			HttpServletRequest request) {

		String memberSId = (String) session.getAttribute("memberId");

		ModelAndView mv = new ModelAndView();
		ValidationUtils.invokeValidator(claimvalidator, claimModel, error);

		request.getSession(false);
		if (session.getAttribute("memberId") == null) {

			throw new SessionExpired("Session Expired");
		} else {

			log.info("Session Not null");
		}
		if (request.getSession(false) != null) {

			if (error.hasErrors()) {
				mv.setViewName("raiseclaimform");
			}

			else {
				claimModel.setMemberId(memberSId);
				claimModel.setClaimStatus("Submitted");
				if (claimService.persistClaim(claimModel) == true) {
					mv.setViewName("claimregistrationsuccess");

				} else {
					mv.setViewName("raiseclaimform");
				}
			}
		}

		else {
			mv.setViewName("message");
		}

		return mv;

	}

	// return all claims of a particular member
	@RequestMapping(value = "viewAllClaimOfMember.htm", method = RequestMethod.GET)
	public ModelAndView viewAllClaimOfMember(HttpSession session, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		request.getSession(false);
		if (session.getAttribute("memberId") == null) {

			throw new SessionExpired("Session Expired");
		} else {

			log.info("Session Not null");
		}
		if (request.getSession(false) != null) {
			String memberCId = (String) session.getAttribute("memberId");
			List<Claim> memberClaimsList = claimService.getClaimListOfMember(memberCId);

			mv.addObject("memberClaimsList", memberClaimsList);

			mv.setViewName("memberclaimdetail");
		}

		else {
			mv.setViewName("message");
		}
		return mv;
	}

}
