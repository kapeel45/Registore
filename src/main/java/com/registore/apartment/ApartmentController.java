package com.registore.apartment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.registore.constants.Constant;

@RestController
@RequestMapping("/qr/apartment")
public class ApartmentController {

	private static final Logger logger = LoggerFactory.getLogger(ApartmentController.class);
	
	@Autowired
	ApartmentService apartmentService;
	
	@PostMapping(value="/register")
	public @ResponseBody ResponseEntity<ApartmentRegistration> createApartmentRegistration(@RequestBody ApartmentRegistration apartReg)
	{
		ApartmentRegistration apartRegistration = null;
		
		try {	
			apartRegistration = apartmentService.createApartmentRegistration(apartReg);
		}
		catch(Exception e)	{
			logger.error(Constant.GENERAL_EXCEPTION+e.toString());
		}
		
		return new ResponseEntity<ApartmentRegistration>(apartRegistration,HttpStatus.OK);
		
	}
	
}
