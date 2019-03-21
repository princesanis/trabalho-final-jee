package com.javaee.prince.trabalhofinaljee.repositories;

import java.util.Set;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.javaee.prince.trabalhofinaljee.domain.Pessoa;

@Repository
public interface PessoaRepository extends MongoRepository<Pessoa, String>{
	
	Set<Pessoa> findByName(String name);

}
