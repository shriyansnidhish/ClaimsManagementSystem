package com.cognizant.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.exception.SessionExpired;
import com.cognizant.model.AdminModel;
import com.cognizant.service.AdminService;
import com.cognizant.validation.AdminRagistrationValidator;

@Controller
public class AdminController {

	static Logger log = Logger.getLogger(AdminController.class);

	@Autowired
	@Qualifier("AdminValidator")
	private Validator adminvalidator;

	@Autowired
	private AdminService adminService;

	@Autowired
	private AdminRagistrationValidator adminRagistrationValidator;

	// Create Admin Model Object
	@ModelAttribute("adminModel")
	public AdminModel createAdminModelObject() {
		AdminModel adminModel = new AdminModel();
		return adminModel;

	}

	// Load Admin Login Form
	@RequestMapping(value = "adminlogin.htm", method = RequestMethod.GET)
	public String loadLoginForm() {
		log.info("Admin Login Form is Loading");
		return "adminlogin";
	}

	// Admin Login Process
	@RequestMapping(value = "doadminlogin.htm", method = RequestMethod.POST)
	public ModelAndView doAdminLogin(@ModelAttribute("adminModel") AdminModel adminModel, Errors errors,
			HttpSession session) {
		ValidationUtils.invokeValidator(adminvalidator, adminModel, errors);
		ModelAndView mv = new ModelAndView();

		if (errors.hasErrors()) {
			mv.setViewName("adminlogin");
		} else {
			String adminId = adminModel.getAdminId();
			session.setAttribute("adminId", adminId);
			mv.setViewName("admin");
			log.info("Admin Login Successful");
		}

		return mv;
	}

	// Load Admin Registration Form
	@RequestMapping(value = "adminregistration.htm", method = RequestMethod.GET)
	public String loadAdminRegistrationForm() {
		log.info("Admin Registration Form is Loading");
		return "adminregistration";
	}

	// Admin registration Process
	@RequestMapping(value = "registerProcessAdmin.htm", method = RequestMethod.POST)
	public ModelAndView addAdmin(@ModelAttribute("adminModel") AdminModel adminModel, Errors error) {

		ValidationUtils.invokeValidator(adminRagistrationValidator, adminModel, error);
		ModelAndView mv = new ModelAndView();
		if (error.hasErrors()) {
			mv.setViewName("adminregistration");
		}

		else {
			if (adminService.persistAdmin(adminModel) == true) {
				String adminId = adminService.getId();
				mv.addObject("adminId", adminId);
				mv.setViewName("adminforward");
				log.info("Admin registration successful");
			} else
				mv.setViewName("adminregistration");
		}
		return mv;
	}

	// After login process forward the admin to registration success page
	@RequestMapping(value = "adminforward.htm", method = RequestMethod.GET)
	public ModelAndView doRedirect(HttpServletRequest request, @RequestParam("adminId") String adminId) {
		ModelAndView mv = new ModelAndView();
		mv.addObject(adminId, adminId);
		mv.setViewName("registrationsuccess");
		return mv;
	}

	// Admin Logout Process
	@RequestMapping(value = "adminlogout.htm", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession(false);
		session.removeAttribute("adminId");
		session.invalidate();
		mv.setViewName("logoutpage");
		return mv;
	}

	// Admin dashboard
	@RequestMapping(value = "admindash.htm", method = RequestMethod.GET)
	public String loadAdminDash(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session.getAttribute("adminId") == null) {
			throw new SessionExpired("Session Expired");
		} else {
			log.info("Session Not null");
		}
		if (request.getSession(false) != null) {
			return "admin";
		}

		return "message";
	}

	@ExceptionHandler(value=SessionExpired.class)
	public ModelAndView sessionExpiredHanlder(){
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("message");
		return mv;
	}
	
}
