package com.registore.visitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registore.registration.RegistrationService;

@Service
public class VisitorService {

	@Autowired
	RegistrationService registrationService;
	
	public boolean verifyVisitor(String mobileNo) {
		
		if(registrationService.verifyRegistrationbyMobile(mobileNo))
			return false;
		else
			return false;
	}

	
	
}
