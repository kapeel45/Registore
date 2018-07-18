package com.registore.visitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/visitor/")
public class VisitorController {

	@Autowired
	VisitorService visitorService;
	
	@GetMapping("/verify/{mobile}")
	public boolean verifyVisitor(@PathVariable String mobile){

		System.out.println("Mobile Num"+mobile);
		
		if(visitorService.verifyVisitor(mobile)) 
			return true;
		else 
			return false;
		
	}
	
}
