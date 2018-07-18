package com.registore.document;

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
@RequestMapping("/document/")
public class DocumentController {

	private static final Logger logger = LoggerFactory.getLogger(DocumentController.class);
	
	@Autowired
	DocumentService documentService;
	
	@PostMapping("/add")
	public @ResponseBody ResponseEntity<String> addDocument(@RequestBody DocumentDto documentDto){
		
		try {
			//TODO registration id will be provided from client end
			boolean result = documentService.addDocument(documentDto);
			if(result) {
				return new ResponseEntity<String>(Constant.SUCCESS,HttpStatus.OK);
			}else{
				return new ResponseEntity<String>(Constant.FAILED, HttpStatus.BAD_REQUEST);
			}
		}catch(Exception e) {
			logger.error(Constant.GENERAL_EXCEPTION+e.toString());
		}
		
		return new ResponseEntity<String>(Constant.FAILED, HttpStatus.BAD_REQUEST);
	}
	
}
