package com.javaee.prince.trabalhofinaljee.services;

import com.javaee.prince.trabalhofinaljee.domain.Acao;

public interface AcaoService {
	
	Acao getAcaoById(String id);

    Acao createNewAcao(Acao acao);

    Acao patch(String id, Acao acao);
    
    Acao comprarAcao(String id, Acao acao);
    
    Acao venderAcao(String id, Acao acao);
}
