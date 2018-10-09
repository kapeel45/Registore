package com.registore.apartment.register;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register-apartment")
public class ApartmentRegisterController {

	
	private static final Logger logger=LoggerFactory.getLogger(ApartmentRegisterController.class) ;
	
	
	@Autowired
	private ApartmentRegisterService apartmentRegService;
	
	@CrossOrigin
	@PostMapping("/add")
	public @ResponseBody ResponseEntity<ApartmentRegister> addApartmentRegistration(@RequestBody ApartmentRegisterDto apartmentRegisterDto){
		ApartmentRegister apartmentRegister = null;
		logger.info("Registration controller called");
		
		try { 
			apartmentRegister = apartmentRegService.createApartmentRegistration(apartmentRegisterDto);
		}catch(Exception e) {
			logger.error("Exception Message: "+e.toString());
			//return new ResponseEntity<>(apartmentRegister,HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<ApartmentRegister>(apartmentRegister, HttpStatus.OK);
	}
	
	
	@CrossOrigin
	@PostMapping("/getdata")
	public @ResponseBody ApartmentRegister getByEmailMobile(@RequestBody ApartmentRegister reg) {
		System.out.println("here");
		System.out.println("Apartment name : "+reg.getApartmentName());
		ApartmentRegister re=apartmentRegService.getdata(reg.getApartmentName());
		return re;
	}
	
}