package com.registore.apartment;

import org.springframework.data.repository.CrudRepository;

interface ApartmentDao extends CrudRepository<ApartmentRegistration, Long>{
	
}
