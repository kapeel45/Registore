package com.registore.document;

import org.springframework.data.repository.CrudRepository;

interface DocumentDao  extends CrudRepository<Document, Long>{
	
}
