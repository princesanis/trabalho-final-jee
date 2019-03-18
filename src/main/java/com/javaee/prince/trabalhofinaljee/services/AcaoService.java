package com.javaee.prince.trabalhofinaljee.services;

import java.util.List;

import com.javaee.prince.trabalhofinaljee.domain.Acao;
import com.javaee.prince.trabalhofinaljee.domain.Pessoa;

public interface AcaoService {
	
	Acao getById(Long id);

	List<Acao> getAllAcoesByIdPessoa(Long id);
	
	List<Acao> getAllAcoesByIdEmpresa(Long id);
	
	List<Pessoa> getAllPessoasByIdAcao(Long id);

    Acao createAcao(Acao acao);

    Acao save(Long id, Acao acao);

    Acao patch(Long id, Acao acao);
    
    Acao comprarAcao(Long id, Acao acao);
    
    Acao venderAcao(Long id, Acao acao);
}
