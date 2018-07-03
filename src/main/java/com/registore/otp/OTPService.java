package com.registore.otp;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registore.registration.Registration;
import com.registore.registration.RegistrationDao;

@Service
public class OTPService {
	
	@Autowired
	OTPDao otpDao;

	@Autowired
	RegistrationDao regDao;
	
	public void saveOTP() {
		
		OTPData otpData = new OTPData();
		
		//TODO pass registration object/id while saving
		Registration registration = regDao.findOne(1l);
		otpData.setOtpCode(generateOTP(6));
		otpData.setRegistrationOtpId(registration);
		otpDao.save(otpData);
	}

	private String generateOTP(int size) {
		StringBuilder generatedToken = new StringBuilder();
        try {
            SecureRandom number = SecureRandom.getInstance("SHA1PRNG");
            // Generate 20 integers 0..20
            for (int i = 0; i < size; i++) {
                generatedToken.append(number.nextInt(9));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return generatedToken.toString();
	}

	public boolean verifyOTP(String otpCode) {
		
		OTPData otpData = otpDao.findByOtpCode(otpCode);
		if(otpData != null) {
			return true;
		}
		
		return false;
	}
}
