package com.registore.apartment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registore.apartment.register.ApartmentRegister;
import com.registore.constants.Constant;

@Service
public class ApartmentService {

	private static final Logger logger = LoggerFactory.getLogger(ApartmentService.class);
	
	@Autowired
	ApartmentDao apartmentDao;
	
	public ApartmentRegistration createApartmentRegistration(ApartmentRegistration apartReg) {
		
		ApartmentRegistration apartmentRegistration = apartmentDao.save(apartReg);
		
		if(apartmentRegistration == null) {
			logger.error(Constant.ENTITY_NOT_CREATED+apartReg.getRegistrationId());	
		}
		
		return apartmentRegistration;
	
	}


	
}
