package com.registore.registration;

import java.util.List;

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

import com.registore.constants.Constant;
import com.registore.exception.ApiError;

@RestController
public class RegistrationController {

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
	public @ResponseBody ResponseEntity<Object> addRegistration(@RequestBody Registration register){
		
		try {
			regService.createRegistration(register);
		}catch(Exception e) {
			return new ResponseEntity<Object>(new ApiError(HttpStatus.BAD_REQUEST,e),HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object>(Constant.Success,HttpStatus.OK);
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
