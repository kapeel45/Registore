package com.registore.registration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

	@Autowired
	RegistrationDao regDao;
	
	public List<Registration> getAllUserRegistered(){
		
		return (List<Registration>) regDao.findAll();
	}
	
	public Registration getRegistration(String id){
		return regDao.findOne(Long.parseLong(id));
	}

	public void createRegistration(Registration autoRegister) {
		regDao.save(autoRegister);
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
