package com.javaee.prince.trabalhofinaljee.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.javaee.prince.trabalhofinaljee.domain.Acao;
import com.javaee.prince.trabalhofinaljee.repositories.AcaoRepository;

@Service
public class AcaoServiceImpl implements AcaoService {

	private AcaoRepository acaoRepository;
	
	public AcaoServiceImpl(AcaoRepository acaoRepository) 
	{
		this.acaoRepository = acaoRepository;
	}	
	
	@Override
	public Acao getAcaoById(String id) {

		Optional<Acao> acaoOptional = acaoRepository.findById(id);

        if (!acaoOptional.isPresent()) 
        {
            throw new IllegalArgumentException("Ação não encontrada pelo valor do ID: " + id.toString() );
        }
        
        return acaoOptional.get();
	}

	@Override
	public Acao createNewAcao(Acao acao) {

		if(acaoRepository.findByName(acao.getName()).isEmpty()) 
		{				
			return acaoRepository.save(acao);
		}
		else 
		{
			throw new IllegalArgumentException("Já existe uma ação com este nome cadastrada: " + acao.getName());
		}
	}

	@Override
	public Acao patch(String id, Acao acao) {
		
		return null;
	}

	@Override
	public Acao comprarAcao(String id, Acao acao) {
		
		// Enviar solicitação de compra de ação para a fila (Criar um método)
		
		return null;
	}

	@Override
	public Acao venderAcao(String id, Acao acao) {
		
		return null;
	}
	
	
	
}
