package com.registore.registration;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface RegistrationDao extends CrudRepository<Registration, Long>{

	Registration findByEmail(String email);
	
	Registration findByMobile(String mobile);
	
	@Query("select ar from registration ar where ar.email = ?1 and ar.mobile = ?2")
	Registration findByEmailAndMobile(String email, String mobile);
	
}
