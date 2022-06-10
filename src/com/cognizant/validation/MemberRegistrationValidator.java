package com.cognizant.validation;


import com.cognizant.model.MemberModel;
import com.cognizant.service.MemberService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component("MemberRegistrationValidator")
public class MemberRegistrationValidator implements Validator {

	@Autowired
	private MemberService memberService;
	private Pattern pattern;
	private Matcher matcher;
	
	static Logger log=Logger.getLogger(ClaimValidator.class);

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String DATE_PATTERN = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})";
	String ID_PATTERN = "[0-9]+";
	String ZIP_PATTERN = "[0-9]+";
	String STRING_PATTERN = "[a-zA-Z]+";
	String MOBILE_PATTERN = "[0-9]{10}";

	@Override
	public boolean supports(Class<?> arg0) {

		return arg0.equals(MemberModel.class);
	}

	@Override
	public void validate(Object target, Errors errors) {

		MemberModel user = (MemberModel) target;
		if ((user.getAge()) < 18 || (user.getAge() > 120)) {
			System.out.println("age btw 18 and 120");
			errors.rejectValue("age", "memberage.incorrect");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dob", "memberdaterequired.dob");
		if (!(user.getDob() != null && user.getDob().isEmpty())) {
			pattern = Pattern.compile(DATE_PATTERN);
			matcher = pattern.matcher(user.getDob());
			
			try{
			
			int length=user.getDob().length();
			int year=Integer.parseInt(user.getDob().substring(6,10));
			int date=Integer.parseInt(user.getDob().substring(0,2));
		    int month=Integer.parseInt(user.getDob().substring(3,5));
			
		    
		    
		     if(year<1960 || year>2018)
			  errors.rejectValue("dob", "memberyear.incorrect");
		    
			else if(month>12|| month<1)
					errors.rejectValue("dob", "membermonth.incorrect");
		    
			else if(date>31||date<1)
				errors.rejectValue("dob", "memberdate1.incorrect");
		    
			else if (!matcher.matches()) 
				errors.rejectValue("dob", "memberdate.incorrect");
		     
		 }catch(Exception e){
		     log.info("enter dd/mm/yyyy formate");
		  }
		}

		ValidationUtils.rejectIfEmpty(errors, "zipCode", "memberrequired.zipCode");
		String zip = String.valueOf(user.getZipCode());
		if (zip != null) {
			pattern = Pattern.compile(ZIP_PATTERN);

			matcher = pattern.matcher(zip.toString());
			if (!matcher.matches()) {

				errors.rejectValue("zipCode", "memberzipCode.incorrect");
			}
			if (zip.toString().length() > 6) {
				System.out.println("length>5");
				errors.rejectValue("zipCode", "memberzipCode.exceed");
			}
		}

		ValidationUtils.rejectIfEmpty(errors, "state", "memberrequired.state");
		ValidationUtils.rejectIfEmpty(errors, "city", "memberrequired.city");
		ValidationUtils.rejectIfEmpty(errors, "addressLine1", "memberrequired.addressLine1");

		ValidationUtils.rejectIfEmpty(errors, "coverageStartDate", "memberrequired.coverageStartDate");
		if (!(user.getCoverageStartDate() != null && user.getCoverageStartDate().isEmpty())) {
			pattern = Pattern.compile(DATE_PATTERN);
			matcher = pattern.matcher(user.getDob());
		try{	
			int length=user.getCoverageStartDate().length();
			int year=Integer.parseInt(user.getCoverageStartDate().substring(6,10));
			int date=Integer.parseInt(user.getCoverageStartDate().substring(0,2));
		    int month=Integer.parseInt(user.getCoverageStartDate().substring(3,5));
			
		    
		    
		     if(year<1960 || year>2018)
			  errors.rejectValue("coverageStartDate", "memberyear.incorrect");
		    
			else if(month>12|| month<1)
					errors.rejectValue("coverageStartDate", "membermonth.incorrect");
		    
			else if(date>31||date<1)
				errors.rejectValue("coverageStartDate", "memberdate1.incorrect");
		    
			else if (!matcher.matches()) 
				errors.rejectValue("coverageStartDate", "memberdate.incorrect");
		     
		 }catch(Exception e){
		     log.info("enter dd/mm/yyyy formate");
		  }
		}
		
		ValidationUtils.rejectIfEmpty(errors, "coverageEndDate", "memberrequired.coverageEndDate");
		
		if (!(user.getCoverageEndDate() != null && user.getCoverageEndDate().isEmpty())) {
			pattern = Pattern.compile(DATE_PATTERN);
			matcher = pattern.matcher(user.getDob());
			try{
			int length=user.getCoverageEndDate().length();
			int year=Integer.parseInt(user.getCoverageEndDate().substring(6,10));
			int date=Integer.parseInt(user.getCoverageEndDate().substring(0,2));
		    int month=Integer.parseInt(user.getCoverageEndDate().substring(3,5));
			
		    
		    
		     if(year<1960 || year>2018)
			  errors.rejectValue("coverageEndDate", "memberyear.incorrect");
		    
			else if(month>12|| month<1)
					errors.rejectValue("coverageEndDate", "membermonth.incorrect");
		    
			else if(date>31||date<1)
				errors.rejectValue("coverageEndDate", "memberdate1.incorrect");
		    
			else if (!matcher.matches()) 
				errors.rejectValue("coverageEndDate", "memberdate.incorrect");
		     
		 }catch(Exception e){
		     log.info("enter dd/mm/yyyy formate");
		  }
		     
		}
		
		
		ValidationUtils.rejectIfEmpty(errors, "planCode", "memberrequired.planCode");

		ValidationUtils.rejectIfEmpty(errors, "firstName", "required.firstName");

		if (!(user.getFirstName() != null && user.getFirstName().isEmpty())) {
			pattern = Pattern.compile(STRING_PATTERN);
			matcher = pattern.matcher(user.getFirstName());
			if (!matcher.matches()) {
				errors.rejectValue("firstName", "memberfirstname.containNonChar");
			}
		}

		ValidationUtils.rejectIfEmpty(errors, "lastName", "memberrequired.lastName");

		if (!(user.getLastName() != null && user.getLastName().isEmpty())) {
			pattern = Pattern.compile(STRING_PATTERN);
			matcher = pattern.matcher(user.getLastName());
			if (!matcher.matches()) {
				errors.rejectValue("lastName", "memberlastname.containNonChar");
			}
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailId", "memberrequired.emailId");
		if (!(user.getEmailId() != null && user.getEmailId().isEmpty())) {
			pattern = Pattern.compile(EMAIL_PATTERN);
			matcher = pattern.matcher(user.getEmailId());
			if (!matcher.matches()) {
				errors.rejectValue("emailId", "memberemailId.incorrect");
			}
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "memberrequired.password");

		if (!(user.getPassword() != null && user.getPassword().isEmpty())) {
			pattern = Pattern.compile(PASSWORD_PATTERN);
			matcher = pattern.matcher(user.getPassword());
			if (!matcher.matches()) {
				errors.rejectValue("password", "memberpassword.incorrect");
			}
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactNo", "memberrequired.contactNo");

		// phone number validation
		String c = Long.toString(user.getContactNo());
		if (!(c != null && c.isEmpty())) {
			pattern = Pattern.compile(MOBILE_PATTERN);
			matcher = pattern.matcher(c);
			if (!matcher.matches()) {
				errors.rejectValue("contactNo", "membercontactNo.incorrect");
			}
		}

		// alternate phone number validation

		String d = Long.toString(user.getAltContactNo());
		if (!(d != null && d.isEmpty())) {
			pattern = Pattern.compile(MOBILE_PATTERN);
			matcher = pattern.matcher(d);
			if (!matcher.matches()) {
				errors.rejectValue("altContactNo", "memberaltContactNo.incorrect");
			}
		}

	}
}
