package com.registore.apartment.register;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ApartmentRegisterService {

	private static final Logger logger=LoggerFactory.getLogger(ApartmentRegisterService.class) ;
	
	@Autowired
	private ApartmentRegisterDao apartmentRegisterDao;
	
	public ApartmentRegister createApartmentRegistration(ApartmentRegisterDto apartmentRegisterDto) {
		
		ApartmentRegister apartmentRegister = new ApartmentRegister();
		
		try {
			if(apartmentRegisterDto != null)
			{
				//TODO Set dto into Apartment object
				apartmentRegister.setApartmentName(apartmentRegisterDto.getApartmentName());
				apartmentRegister.setLatitude(Double.parseDouble(apartmentRegisterDto.getLatitude()));
				apartmentRegister.setLongitude(Double.parseDouble(apartmentRegisterDto.getLongitude()));
				apartmentRegister.setLocation(apartmentRegisterDto.getLocation());
				apartmentRegister.setNoOfFlats(Integer.parseInt(apartmentRegisterDto.getNoOfFlats()));
				apartmentRegister.setNoOfFlatsOnEachFloor(Integer.parseInt(apartmentRegisterDto.getNoOfFlatsOnEachFloor()));
				apartmentRegister.setNoOfFloors(Integer.parseInt(apartmentRegisterDto.getNoOfFloors()));
				apartmentRegister.setNoOfWings(Long.parseLong(apartmentRegisterDto.getNoOfWings()));
				apartmentRegister.setWingsName(apartmentRegisterDto.getWingsName());
				
				logger.info("Apartment Register not null"+apartmentRegisterDto.getApartmentName());
				return apartmentRegisterDao.save(apartmentRegister);
				
			}
			else{
				logger.error("Apartment Register null");
			}
		} catch (Exception e) {
			logger.debug("Apartment Register Exception: "+apartmentRegisterDto.getApartmentName());
			logger.error("Exception Message"+e.toString());
		}
		
		return null;
	}
	
	
	public List<ApartmentRegister> getApartmentDetails(String apartmentName) {
		logger.info("in get Apartment detail service");
		return apartmentRegisterDao.findByApartmentName(apartmentName);
 	}

}