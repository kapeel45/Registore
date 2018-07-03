package com.registore.otp;

import org.springframework.data.repository.CrudRepository;

interface OTPDao extends CrudRepository<OTPData, Long>{
	
	OTPData findByOtpCode(String otpcode);
}
