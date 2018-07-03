package com.registore.registration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

	@Autowired
	private RegistrationService regService;

	@RequestMapping("/register")
	public List<Registration> getAllRegisteredUser(){
		return regService.getAllRegisteredUser(); 
	}
	
	@RequestMapping("/register/{id}")
	public Registration getTopic(@PathVariable String id){	
		return regService.getRegistration(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/register")
	public void addRegistration(@RequestBody Registration register){
		regService.createRegistration(register);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/register/{id}")
	public void updateRegistration(@RequestBody Registration register, @PathVariable String id){
		regService.updateRegistration(id, register);
	}
	
	@RequestMapping(value="/register/{id}",method=RequestMethod.DELETE)
	public void deleteRegistration(@PathVariable String id){
		regService.deleteRegistration(id);
	}
}
