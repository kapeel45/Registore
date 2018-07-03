package com.registore.registration;

import org.springframework.data.repository.CrudRepository;
import java.lang.String;
import com.registore.registration.Registration;
import java.util.List;

public interface RegistrationDao extends CrudRepository<Registration, Long>{

	List<Registration> findByEmail(String email);
}
