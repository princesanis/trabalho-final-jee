package com.javaee.prince.trabalhofinaljee.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.javaee.prince.trabalhofinaljee.domain.Acao;

@Repository
public interface AcaoRepository extends MongoRepository<Acao, String>{
	
	

}
