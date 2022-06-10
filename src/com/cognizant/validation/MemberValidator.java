package com.cognizant.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.cognizant.model.MemberModel;
import com.cognizant.service.MemberService;

@Component("MemberValidator")
public class MemberValidator implements Validator {
	@Autowired
	private MemberService memberService;

	public boolean supports(Class<?> arg0) {
		return arg0.equals(MemberModel.class);
	}

	public void validate(Object arg0, Errors arg1) {
		MemberModel memberModel = (MemberModel) arg0;
		boolean memberAuth = memberService.doLogin(memberModel);

		if (!memberAuth) {
			arg1.rejectValue("memberId", "com.cognizant.entity.Member.memberId.invalid");
		}

	}
}
