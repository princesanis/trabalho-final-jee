package com.javaee.prince.trabalhofinaljee.services;

import java.util.Set;

import com.javaee.prince.trabalhofinaljee.domain.Acao;

public interface AcaoService {
	
	Set<Acao> getAll();
	
	Acao getAcaoById(String id);

    Acao createNewAcao(Acao acao);
    
    void comprarAcao(Acao acao);
    
    void venderAcao(Acao acao);
    
    void executarSolicitacaoDeCompraDeAcao(Acao acao);
    
    void executarSolicitacaoDeVendaDeAcao(Acao acao);
}
