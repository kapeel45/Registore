package com.registore.registration;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.registore.constants.Constant;
import com.registore.exception.UserAlreadyExist;

@Service
public class RegistrationService {

	private static final Logger logger = LoggerFactory.getLogger(RegistrationService.class);
	
	@Autowired
	RegistrationDao regDao;
	
	public List<Registration> getAllRegisteredUser(){
		
		return (List<Registration>) regDao.findAll();
	}
	
	public Registration getRegistration(String id){
		return regDao.findOne(Long.parseLong(id));
	}

	public Registration createRegistration(Registration autoRegister) throws Exception {
		Registration registration;
		try {
			 registration = regDao.save(autoRegister);
			 
			 if(registration == null) {
				 logger.error(Constant.ENTITY_NOT_CREATED+autoRegister.getId());
			 }
			 
		}catch(Exception e) {
			logger.error("createRegistration Exception: "+e.toString());
			throw new UserAlreadyExist(e.toString());
		}
		
		return registration;
	}

	public void updateRegistration(String id, Registration reqRegister) {
		//regDao.save(autoRegister);
		Registration regObj = regDao.findOne(Long.parseLong(id));
		
		regObj.setArea(reqRegister.getArea());
		regObj.setEmail(reqRegister.getEmail());
		regObj.setFirstname(reqRegister.getFirstname());
		regObj.setLastname(reqRegister.getLastname());
		regObj.setMiddlename(reqRegister.getMiddlename());
		regObj.setMobile(reqRegister.getMobile());
		regObj.setGender(regObj.getGender());
		
		
		regDao.save(regObj);
	}

	public void deleteRegistration(String id) {
		regDao.delete(Long.parseLong(id));
	}

	public boolean verifyRegistrationbyMobile(String mobileNo) {
		
		Registration registration = regDao.findByMobile(mobileNo);
		
		if(registration != null)
			return true;
		else
			return false;
	}
	
}
