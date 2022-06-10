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
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.entity.Member;
import com.cognizant.entity.MemberRegistrationRequest;
import com.cognizant.entity.PlanCode;
import com.cognizant.exception.SessionExpired;
import com.cognizant.model.MemberModel;
import com.cognizant.service.MemberRegistrationRequestService;
import com.cognizant.service.MemberService;
import com.cognizant.service.PlanCodeService;
import com.cognizant.validation.MemberRegistrationValidator;

@Controller
public class MemberController {

	@Autowired
	private MemberRegistrationValidator memberRagistrationValidator;

	@Autowired
	private MemberRegistrationRequestService memberRegistrationRequestService;

	@Autowired
	private PlanCodeService planCodeService;

	@Autowired
	@Qualifier("MemberValidator")
	private Validator membervalidator;

	@Autowired
	private MemberService memberService;

	static Logger log = Logger.getLogger(MemberController.class);

	// Create Member Model Object
	@ModelAttribute("memberModel")
	public MemberModel createMemberModelObject() {
		MemberModel memberModel = new MemberModel();
		return memberModel;
	}

	// Load Member Login Form
	@RequestMapping(value = "memberlogin.htm", method = RequestMethod.GET)
	public String memberLoginForm() {
		log.info("Member Login Form is Loading");
		return "memberlogin";
	}

	// Member Login Process
	@RequestMapping(value = "domemberlogin.htm", method = RequestMethod.POST)
	public ModelAndView doMemberLogin(@ModelAttribute("memberModel") MemberModel memberModel, Errors errors,
			HttpSession session) {
		List<MemberRegistrationRequest> ApprovedMemberList = memberRegistrationRequestService
				.getAllApprovedRegistration();

		String registrationStatus = "Submitted";
		String memberId = memberModel.getMemberId();

		// ADD MEMBER ID IN HTTP SESSION
		session.setAttribute("memberId", memberId);

		for (MemberRegistrationRequest temp : ApprovedMemberList) {
			if (temp.getMemberId().equals(memberId)) {
				registrationStatus = temp.getRegistrationStatus();
				break;

			}
		}
		log.info(registrationStatus);
		ValidationUtils.invokeValidator(membervalidator, memberModel, errors);
		ModelAndView mv = new ModelAndView();
		if (errors.hasErrors()) {
			mv.setViewName("memberlogin");
		} else {
			if (registrationStatus.equals("Approved")) {
				mv.addObject("memberStatusId", memberId);
				mv.setViewName("member");
				log.info("Member Login Successful");
			} else {
				mv.setViewName("memberlogin");
			}
		}
		return mv;
	}

	// Load Member Reagistration Form
	@RequestMapping(value = "memberregistration.htm", method = RequestMethod.GET)
	public ModelAndView loadMemberRegistrationForm() {
		ModelAndView mv = new ModelAndView();

		List<PlanCode> planCodeList = planCodeService.getPlanCodeList();

		mv.addObject("planCodeList", planCodeList);

		mv.setViewName("memberregistration");
		log.info("Member Registration Form is Loading");
		return mv;
	}

	// Member Registration Process
	@RequestMapping(value = "registerProcessMember.htm", method = RequestMethod.POST)
	public ModelAndView AddMember(@ModelAttribute("memberModel") MemberModel memberModel, Errors error) {

		ModelAndView mv = new ModelAndView();
		ValidationUtils.invokeValidator(memberRagistrationValidator, memberModel, error);

		if (error.hasErrors()) {
			mv.setViewName("memberregistration");
		} else {
			if (memberService.persistMember(memberModel) == true) {

				String memberId = memberService.getId();
				mv.addObject("memberId", memberId);
				mv.setViewName("memberforward");
				log.info("Member Registration Successful");
			} else
				mv.setViewName("memberregistration");
		}
		return mv;

	}

	// After login process forward the member to registration success page
	@RequestMapping(value = "memberforward.htm", method = RequestMethod.GET)
	public ModelAndView doRedirect(HttpServletRequest request, @RequestParam("memberId") String memberId) {

		ModelAndView mv = new ModelAndView();

		mv.addObject("memberId",memberId);
		mv.setViewName("memberregisuccess");

		return mv;
	}

	// Load form to enter member id
	@RequestMapping(value = "viewmemberbyid.htm", method = RequestMethod.GET)
	public String loadMemberByIdForm(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		if (session.getAttribute("adminId") == null) {
			throw new SessionExpired("Session Expired");
		} else {

			log.info("Session Not null");
		}
		if (request.getSession(false) != null) {
			return "viewmemberbyid";
		}

		return "message";

	}

	// return member plan detail of given member id
	@RequestMapping(value = "memberbyid.htm", method = RequestMethod.GET)
	public ModelAndView veiwMemebrById(@RequestParam("memberId") String memberId, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		HttpSession session = request.getSession(false);
		if (session.getAttribute("adminId") == null) {

			throw new SessionExpired("Session Expired");
		} else {

			log.info("Session Not null");
		}
		if (request.getSession(false) != null) {

			List<Member> memberById = memberService.getMemberById(memberId);

			mv.addObject("memberById", memberById);

			mv.setViewName("viewmemberplandetails");
		}

		else {
			mv.setViewName("message");
		}
		return mv;
	}

	// // return member detail of given member id
	@RequestMapping(value = "memberdetailbyid.htm", method = RequestMethod.GET)
	public ModelAndView veiwMemebrDetailById(@RequestParam("memberId") String memberId, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();

		HttpSession session = request.getSession(false);
		if (session.getAttribute("adminId") == null) {

			throw new SessionExpired("Session Expired");
		} else {

			log.info("Session Not null");
		}
		if (request.getSession(false) != null) {
			List<Member> memberById = memberService.getMemberById(memberId);

			mv.addObject("memberById", memberById);

			mv.setViewName("viewmemberdetail");
		}

		else {
			mv.setViewName("message");
		}

		return mv;
	}

	// process registration request
	@RequestMapping(value = "changeRegistrationStatus.htm", method = RequestMethod.GET)
	public ModelAndView changeRegistrationStatus(@RequestParam("memberId") String memberId,
			@RequestParam("action") String action) {
		ModelAndView mv = new ModelAndView();

		if (action.equals("Accept")) {
			boolean acceptRegisration = memberRegistrationRequestService.acceptRegistrtionRequest(memberId);
			if (acceptRegisration)
				mv.setViewName("admin");
			log.info("RegistrationStatus is changed as Accepted");
			return mv;
		} else {

			boolean rejectRegisration = memberRegistrationRequestService.rejectRegistrtionRequest(memberId);
			if (rejectRegisration)
				mv.setViewName("admin");
			log.info("RegistrationStatus is changed as Denied");
			return mv;
		}
	}

	// return new members
	@RequestMapping(value = "viewnewmember.htm", method = RequestMethod.GET)
	public ModelAndView viewNewMember(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession(false);
		if (session.getAttribute("adminId") == null) {

			throw new SessionExpired("Session Expired");
		} else {

			log.info("Session Not null");
		}
		if (request.getSession(false) != null) {
			List<MemberRegistrationRequest> newMemberList = memberRegistrationRequestService.getAllNewRegistration();
			mv.addObject("newMemberList", newMemberList);

			mv.setViewName("viewnewmember");
		}

		else {
			mv.setViewName("message");
		}

		return mv;
	}

	// member dash board
	@RequestMapping(value = "memberdash.htm", method = RequestMethod.GET)
	public String loadMemberDash(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("memberId") == null) {
			throw new SessionExpired("Session Expired");
		} else {

			log.info("Session Not null");
		}
		if (request.getSession(false) != null) {
			return "member";
		}

		return "message";
	}

	// member logout process
	@RequestMapping(value = "memberlogout.htm", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession(false);
		session.removeAttribute("memberId");
		session.invalidate();
		mv.setViewName("logoutpage");
		return mv;
	}

}
