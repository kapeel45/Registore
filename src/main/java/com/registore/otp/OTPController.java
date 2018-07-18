package com.registore.otp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/otp")
public class OTPController {

	@Autowired
	OTPService otpService;
	
	@PostMapping(value = "/verify/")
	public @ResponseBody boolean verifyOTP(@RequestParam String otpCode) {
		
		if(otpService.verifyOTP(otpCode)) {
			return true;
		}
		
		return false;
	}
	
}
