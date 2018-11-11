 package com.registore.visitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/qr/visitor/")
//TODO add column from registore apartment
public class VisitorController {

	private static final Logger logger=LoggerFactory.getLogger(VisitorController.class);
	
	@Autowired
	 private VisitorService visitorService;
	
	@GetMapping("/verify/{mobile}")
	public boolean verifyVisitor(@PathVariable String mobile){

		System.out.println("Mobile Num"+mobile);
		
		if(visitorService.verifyVisitor(mobile)) 
			return true;
		else 
			return false;
		
	}
	@CrossOrigin
	@PostMapping("/add")
	public @ResponseBody ResponseEntity<Visitor> addVisitor(@RequestBody Visitor visitors){
		Visitor addVisitor=null;
		
		logger.info("visitor record added; apartmentName"+visitors.getApartmentName());
		
		try {
			addVisitor = visitorService.createVisitor(visitors);
			
			
		} catch (Exception e) {
			
		}
		return new ResponseEntity<Visitor>(addVisitor, HttpStatus.OK);
	}
	
	
	@PutMapping(value="/update-visitor/{id}")
	public void updateVisitor(@RequestBody Visitor visitor,@PathVariable String id) {
		visitorService.updateVisitor(id, visitor);
	}
}
