package com.registore.document;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registore.constants.Constant;
import com.registore.registration.Registration;
import com.registore.registration.RegistrationDao;

@Service
public class DocumentService {

	private static final Logger logger = LoggerFactory.getLogger(DocumentService.class);
	
	@Autowired
	DocumentDao documentDao;
	
	@Autowired
	RegistrationDao registrationDao;
	
	public boolean addDocument(DocumentDto documentDto) {
		logger.info("adding documents");
		try {
			logger.debug("fetching registration id: "+documentDto.getRegistrationId());
			Registration registration =  registrationDao.findOne(Long.parseLong(documentDto.getRegistrationId()));
			
			if(registration != null) {
				logger.info("fetched registration successfully saving documents");
				Document doc = documentDao.save(new Document(documentDto.getIdentityNumber(), documentDto.getIdentityDetail(), registration));
				logger.debug("document saved successfully document id: "+doc.getId());
				return true;
			}else {
				logger.error("Registration details not found for: "+documentDto.getRegistrationId());
			}
		}catch(Exception e) {
			logger.error(Constant.GENERAL_EXCEPTION+e.toString());
		}
		
		return false;
	}
}
