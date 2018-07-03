package com.registore.registration;

import org.springframework.data.repository.CrudRepository;

interface RegistrationDao extends CrudRepository<Registration, Long>{

	Registration findByEmail(String email);
	
	Registration findByMobile(String mobile);
	
}
