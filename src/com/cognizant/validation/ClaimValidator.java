package com.cognizant.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cognizant.control.AdminController;
import com.cognizant.model.ClaimModel;

import com.cognizant.service.ClaimService;

@Component("ClaimValidator")
public class ClaimValidator implements Validator {
	
	static Logger log=Logger.getLogger(ClaimValidator.class);

	@Autowired
	private ClaimService claimService;

	private Pattern pattern;
	private Matcher matcher;

	private static final String DATE_PATTERN = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
	String ID_PATTERN = "[0-9]+";
	String STRING_PATTERN = "[a-zA-Z]+";
	String MOBILE_PATTERN = "[0-9]";

	@Override
	public boolean supports(Class<?> arg0) {

		return arg0.equals(ClaimModel.class);
	}

	@Override
	public void validate(Object target, Errors errors) {

		ClaimModel claims = (ClaimModel) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "claimProcessingDate", "required.processingDate");
		if (!(claims.getClaimProcessingDate() != null && claims.getClaimProcessingDate().isEmpty())) {
			pattern = Pattern.compile(DATE_PATTERN);
			matcher = pattern.matcher(claims.getClaimProcessingDate());
		
			
		    try{
		    if (!matcher.matches() )
				errors.rejectValue("claimProcessingDate", "memberdate.incorrect");
		    
			
			int length=claims.getClaimProcessingDate().length();
			int year=Integer.parseInt(claims.getClaimProcessingDate().substring(6,10));
			int date=Integer.parseInt(claims.getClaimProcessingDate().substring(0,2));
		    int month=Integer.parseInt(claims.getClaimProcessingDate().substring(3,5));
		
		 if(year<1960 || year>2018)
			  errors.rejectValue("claimProcessingDate", "memberyear.incorrect");
		    
			else if(month>12|| month<1)
					errors.rejectValue("claimProcessingDate", "membermonth.incorrect");
		    
			else if(date>31||date<1)
				errors.rejectValue("claimProcessingDate", "memberdate1.incorrect");
		 
		 }catch(Exception e){
		     log.info("enter dd/mm/yyyy formate");
		  }
		    
		}
		

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "claimServiceDate", "required.serviceDate");
		if (!(claims.getClaimServiceDate() != null && claims.getClaimServiceDate().isEmpty())) {
			pattern = Pattern.compile(DATE_PATTERN);
			matcher = pattern.matcher(claims.getClaimServiceDate());
             
			
		   try{ 
		    if (!matcher.matches()) 
				errors.rejectValue("claimServiceDate", "memberdate.incorrect");
		    int length=claims.getClaimServiceDate().length();
			int year=Integer.parseInt(claims.getClaimServiceDate().substring(6,10));
			int date=Integer.parseInt(claims.getClaimServiceDate().substring(0,2));
		    int month=Integer.parseInt(claims.getClaimServiceDate().substring(3,5));
			
		    if(year<1960 || year>2018)
			  errors.rejectValue("claimServiceDate", "memberyear.incorrect");
		    
			else if(month>12|| month<1)
					errors.rejectValue("claimServiceDate", "membermonth.incorrect");
		    
			else if(date>31||date<1)
				errors.rejectValue("claimServiceDate", "memberdate1.incorrect");
		   }catch(Exception e){
			     log.info("enter dd/mm/yyyy formate");
			  }
			}
		

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "claimSubmissionDate", "required.submissionDate");
		if (!(claims.getClaimSubmissionDate() != null && claims.getClaimSubmissionDate().isEmpty())) {
			pattern = Pattern.compile(DATE_PATTERN);
			matcher = pattern.matcher(claims.getClaimSubmissionDate());
			
			try{
		    
		    if (!matcher.matches()) 
				errors.rejectValue("claimSubmissionDate", "memberdate.incorrect");
		    
		    int length=claims.getClaimSubmissionDate().length();
			int year=Integer.parseInt(claims.getClaimSubmissionDate().substring(6,10));
			int date=Integer.parseInt(claims.getClaimSubmissionDate().substring(0,2));
		    int month=Integer.parseInt(claims.getClaimSubmissionDate().substring(3,5));
			
		    
		     if(year<1960 || year>2018)
			  errors.rejectValue("claimSubmissionDate", "memberyear.incorrect");
		    
			else if(month>12|| month<1)
					errors.rejectValue("claimSubmissionDate", "membermonth.incorrect");
		    
			else if(date>31||date<1)
				errors.rejectValue("claimSubmissionDate", "memberdate1.incorrect");
		     
		 }catch(Exception e){
		     log.info("enter dd/mm/yyyy formate");
		  }
		    
			
		}
		

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "claimAmount", "required.claimAmount");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "approvedAmount", "required.approvedAmount");

		
	}

}
