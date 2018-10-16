package com.registore.apartment.register;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	@GetMapping("/apartmentDetails/{apartmentName}")
	public @ResponseBody ResponseEntity<List<ApartmentRegister>> getApartmentDetails(@PathVariable String apartmentName) {
		
		logger.info("Apartmentname : "+apartmentName);
		List<ApartmentRegister> apartDetails = apartmentRegService.getApartmentDetails(apartmentName);
		return new ResponseEntity<List<ApartmentRegister>>(apartDetails,HttpStatus.OK);
	}
	
	
	@CrossOrigin
	@GetMapping(value="/aprtregister/{id}")
	public ApartmentRegister getTopic(@PathVariable String id){
		return apartmentRegService.getAptRegisterById(id);
	}
}