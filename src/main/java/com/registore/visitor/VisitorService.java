package com.registore.visitor;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.registore.registration.RegistrationService;

import ch.qos.logback.core.net.SyslogOutputStream;


@Service
public class VisitorService {
	public static final Logger logger=LoggerFactory.getLogger(VisitorService.class);

	@Autowired

	private VisitorDao visitorDao;
	
	
    private RegistrationService registrationService;
	
	
	public boolean verifyVisitor(String mobileNo) {
		
		if(registrationService.verifyRegistrationbyMobile(mobileNo))
			return true;
		else
			return false;
	}

	
	
	
	public Visitor createVisitor(Visitor visitor)
	{
		
		//TODO change from visitordto to entity visitor
		Visitor visitors=new Visitor();
		try {
			if(visitors != null)
			{
				visitors.setApartmentName(visitor.getApartmentName());
				visitors.setArea(visitor.getArea());
				visitors.setCity(visitor.getCity());
				visitors.setDate(visitor.getDate());
				visitors.setFlatNo(visitor.getFlatNo());
				visitors.setFloor((visitor.getFloor()));
				visitors.setInTime(visitor.getInTime());
				visitors.setWing(visitor.getWing());
				visitors.setPincode(visitor.getPincode());
				visitors.setUserId(visitor.getUserId());
				visitors.setPurpose(visitor.getPurpose());
				visitors.setVehicleNumber(visitor.getVehicleNumber());
				visitors.setWhomToMeet(visitor.getWhomToMeet());

				logger.info("visitor information  not null"+visitor.getApartmentName());
				return visitorDao.save(visitor);
			}
			else{
			logger.error("Visitor information is null");
			}
		} catch (Exception e) {
			logger.debug("Visitor record  Exception: "+visitor.getApartmentName());
			logger.error("Exception Message"+e.toString());
		}
		return visitor;
	}




	public void updateVisitor(String id, Visitor visitor) {
		
			Visitor visit=visitorDao.findOne(Long.parseLong(id));
			
			visit.setOutTime(visitor.getOutTime());
			visitorDao.save(visit);
		}
		
	}
	

	

