package com.registore.apartment.register;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ApartmentRegisterDao extends CrudRepository<ApartmentRegister, Long> {

	//@Query("select * from apartment_register ar where ar.apartment_name = ?1")
	List<ApartmentRegister> findByApartmentName(String apartmentName);
	
}