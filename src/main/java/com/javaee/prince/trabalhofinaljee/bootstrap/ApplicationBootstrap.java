package com.javaee.prince.trabalhofinaljee.bootstrap;

import java.math.BigDecimal;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.javaee.prince.trabalhofinaljee.domain.*;
import com.javaee.prince.trabalhofinaljee.repositories.*;

@Component
public class ApplicationBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	
	private AcaoRepository acaoRepository;
	private EmpresaRepository empresaRepository;
	private PessoaRepository pessoaRepository;
	
	public ApplicationBootstrap(AcaoRepository acaoRepository,
								EmpresaRepository empresaRepository,
								PessoaRepository pessoaRepository) 
	{
		this.acaoRepository = acaoRepository;
		this.empresaRepository = empresaRepository;
		this.pessoaRepository = pessoaRepository;
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) 
	{
		if (acaoRepository.count() == 0L) 
		{
			acaoRepository.deleteAll();
			loadAcoes();
		}
		
		if (empresaRepository.count() == 0L) 
		{
			empresaRepository.deleteAll();
			loadEmpresas();
		}
		
		if (pessoaRepository.count() == 0L) 
		{
			pessoaRepository.deleteAll();
			loadPessoas();
		}
	}
	
	private void loadAcoes() 
	{
		BigDecimal valorInicial = BigDecimal.ZERO;
		BigDecimal valorAtual = BigDecimal.valueOf(100.0);
		
        Acao acaoCemig = new Acao();
        acaoCemig.setNome("");
        acaoCemig.setValorInicial(valorInicial);
        acaoCemig.setValorAtual(valorAtual);
        acaoRepository.save(acaoCemig);
	}
	
	private void loadEmpresas() 
	{
        Empresa empresa01 = new Empresa();
        empresa01.setNome("Cemig");
        empresaRepository.save(empresa01);
	}
	
	private void loadPessoas() 
	{
        Pessoa pessoa01 = new Pessoa();
        pessoa01.setNome("");
        pessoa01.setEmail("");
        pessoaRepository.save(pessoa01);
	}
}
