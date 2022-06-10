package com.cognizant.validation;

import com.cognizant.model.AdminModel;
import com.cognizant.service.AdminService;

import java.util.regex.Matcher;    
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;    
import org.springframework.validation.ValidationUtils;    
import org.springframework.validation.Validator;    
        
@Component("AdminRagistrationValidator")
public class AdminRagistrationValidator implements Validator {

	private Pattern pattern;
	private Matcher matcher;
	@Autowired
	private AdminService adminService;
	
	static Logger log=Logger.getLogger(ClaimValidator.class);

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
	private static final String DATE_PATTERN = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
	String ID_PATTERN = "[0-9]+";
	String STRING_PATTERN = "[a-zA-Z]+";
	String MOBILE_PATTERN = "[0-9]{10}";

	@Override
	public boolean supports(Class<?> arg0) {

		return arg0.equals(AdminModel.class);
	}

	@Override
	public void validate(Object target, Errors errors) {

		AdminModel user = (AdminModel) target;

		if ((user.getAge()) < 18 || (user.getAge() > 120)) {
			System.out.println("age btw 18 and 120");
			errors.rejectValue("age", "age.incorrect", "Age is less than 18 or greater than 120");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dob", "admindaterequired.dob");
		if (!(user.getDob() != null && user.getDob().isEmpty())) {
			pattern = Pattern.compile(DATE_PATTERN);
			matcher = pattern.matcher(user.getDob());
			
			try{
			
			int length=user.getDob().length();
			int year=Integer.parseInt(user.getDob().substring(6,10));
			int date=Integer.parseInt(user.getDob().substring(0,2));
		    int month=Integer.parseInt(user.getDob().substring(3,5));
			
		    
		    
		     if(year<1960 || year>2018)
			  errors.rejectValue("dob", "adminyear.incorrect");
		    
			else if(month>12|| month<1)
					errors.rejectValue("dob", "adminmonth.incorrect");
		    
			else if(date>31||date<1)
				errors.rejectValue("dob", "admindate1.incorrect");
		    
			else if (!matcher.matches()) 
				errors.rejectValue("dob", "admindate.incorrect");
		     
		 }catch(Exception e){
		     log.info("enter dd/mm/yyyy formate");
		  }
		     
		    }

		
		ValidationUtils.rejectIfEmpty(errors, "firstName", "required.firstName");
		if (!(user.getFirstName() != null && user.getFirstName().isEmpty())) {
			pattern = Pattern.compile(STRING_PATTERN);
			matcher = pattern.matcher(user.getFirstName());
			if (!matcher.matches()) {
				errors.rejectValue("firstName", "firstname.containNonChar");
			}
		}

		ValidationUtils.rejectIfEmpty(errors, "lastName", "required.lastName");
		if (!(user.getLastName() != null && user.getLastName().isEmpty())) {
			pattern = Pattern.compile(STRING_PATTERN);
			matcher = pattern.matcher(user.getLastName());
			if (!matcher.matches()) {
				errors.rejectValue("lastName", "lastname.containNonChar");
			}
		}

		if (!(user.getEmailId() != null && user.getEmailId().isEmpty())) {
			pattern = Pattern.compile(EMAIL_PATTERN);
			matcher = pattern.matcher(user.getEmailId());
			if (!matcher.matches()) {
				errors.rejectValue("emailId", "emailId.incorrect");
			}
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.password");

		if (!(user.getPassword() != null && user.getPassword().isEmpty())) {
			pattern = Pattern.compile(PASSWORD_PATTERN);
			matcher = pattern.matcher(user.getPassword());
			if (!matcher.matches()) {
				errors.rejectValue("password", "password.incorrect");
			}
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactNo", "required.contactNo");

		// phone number validation
		String c = Long.toString(user.getContactNo());
		if (!(c != null && c.isEmpty())) {
			pattern = Pattern.compile(MOBILE_PATTERN);
			matcher = pattern.matcher(c);
			if (!matcher.matches()) {
				errors.rejectValue("contactNo", "contactNo.incorrect", "Enter a correct phone number");
			}
		}

		// alternate phone number validation
		String d = Long.toString(user.getAltContactNo());
		if (!(d != null && d.isEmpty())) {
			pattern = Pattern.compile(MOBILE_PATTERN);
			matcher = pattern.matcher(d);
			if (!matcher.matches()) {
				errors.rejectValue("altContactNo", "altContactNo.incorrect");
			}
		}

	}
}


