package com.javaee.prince.trabalhofinaljee.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.javaee.prince.trabalhofinaljee.domain.Acao;

@Repository
public interface AcaoRepository extends MongoRepository<Acao, String>{
	
	Set<Acao> findByName(String name);
	
	@Query("{'acao.id' : ?0, venda: ?1}")
	public Acao findByAcaoDisponivelVenda(String id, Boolean disponivel);	

}
