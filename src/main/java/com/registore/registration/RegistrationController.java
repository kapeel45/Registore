package com.registore.registration;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

	private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);
	
	@Autowired
	private RegistrationService regService;

	@GetMapping("/register")
	public List<Registration> getAllRegisteredUser(){
		return regService.getAllRegisteredUser(); 
	}
	
	@RequestMapping("/run")
	public String run(){
		return "Complete"; 
	}
	
	@GetMapping("/register/{id}")
	public Registration getTopic(@PathVariable String id){	
	
		return regService.getRegistration(id);
	}
	
	@PostMapping(value="/register")
	public @ResponseBody ResponseEntity<Registration> addRegistration(@RequestBody Registration register){
		Registration registration = null;
		logger.info("Registration controller called");
		try { 
			registration = regService.createRegistration(register);
		}catch(Exception e) {
			return new ResponseEntity<Registration>(registration,HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<Registration>(registration,HttpStatus.OK);
	}
	
	@PutMapping(value="/register/{id}")
	public void updateRegistration(@RequestBody Registration register, @PathVariable String id){
		regService.updateRegistration(id, register);
	}
	
	
	@DeleteMapping(value="/register/{id}")
	public void deleteRegistration(@PathVariable String id){
		regService.deleteRegistration(id);
	}
}
