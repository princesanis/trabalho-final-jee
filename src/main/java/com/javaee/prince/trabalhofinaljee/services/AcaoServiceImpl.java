package com.javaee.prince.trabalhofinaljee.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.javaee.prince.trabalhofinaljee.domain.Acao;
import com.javaee.prince.trabalhofinaljee.domain.Pessoa;
import com.javaee.prince.trabalhofinaljee.exceptions.ResourceNotFoundException;

@Service
public class AcaoServiceImpl implements AcaoService {

	@Override
	public Acao getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Acao> getAllAcoesByIdPessoa(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Acao> getAllAcoesByIdEmpresa(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pessoa> getAllPessoasByIdAcao(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Acao createAcao(Acao acao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Acao save(Long id, Acao acao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Acao patch(Long id, Acao acao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Acao comprarAcao(Long id, Acao acao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Acao venderAcao(Long id, Acao acao) {
		// TODO Auto-generated method stub
		return null;
	}
}
