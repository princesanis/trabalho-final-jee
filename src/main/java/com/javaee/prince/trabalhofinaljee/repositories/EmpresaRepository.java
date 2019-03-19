package com.javaee.prince.trabalhofinaljee.repositories;

import java.util.Set;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.javaee.prince.trabalhofinaljee.domain.Empresa;;

@Repository
public interface EmpresaRepository extends MongoRepository<Empresa, String> {

	Set<Empresa> findByName(String name);
	
}
