package com.registore.apartment.register;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ApartmentRegisterDao extends CrudRepository<ApartmentRegister, Long> {

	@Query("select * from apartment_register ar where ar.apartment_name = ?1")
	ApartmentRegister findByApartmentName(String apartmentName);
	
}