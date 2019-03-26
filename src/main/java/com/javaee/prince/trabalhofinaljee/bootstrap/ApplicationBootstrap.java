package com.javaee.prince.trabalhofinaljee.bootstrap;

import java.text.DateFormat;
import java.util.Date;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.javaee.prince.trabalhofinaljee.domain.Acao;
import com.javaee.prince.trabalhofinaljee.domain.Empresa;
import com.javaee.prince.trabalhofinaljee.domain.Pessoa;

import com.javaee.prince.trabalhofinaljee.repositories.AcaoRepository;
import com.javaee.prince.trabalhofinaljee.repositories.EmpresaRepository;
import com.javaee.prince.trabalhofinaljee.repositories.PessoaRepository;

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
		Date dataAtual = new Date();
		String dataInicial = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(dataAtual);
		
        Acao acaoCemig = new Acao();
        acaoCemig.setName("CMIG4");
        acaoCemig.setValorInicial(14.43f);
        acaoCemig.setValorAtual(0);
        acaoCemig.setIdEmpresa(1);
        acaoCemig.setDataInicial(dataInicial);
        acaoCemig.setDataVendaAtual("");
        acaoRepository.save(acaoCemig);
        
        Acao acaoMagazineLuiza = new Acao();
        acaoMagazineLuiza.setName("MGLU3");
        acaoMagazineLuiza.setValorInicial(181.63f);
        acaoMagazineLuiza.setValorAtual(0);
        acaoMagazineLuiza.setIdEmpresa(2);
        acaoMagazineLuiza.setDataInicial(dataInicial);
        acaoMagazineLuiza.setDataVendaAtual("");
        acaoRepository.save(acaoMagazineLuiza);

        Acao acaoOracle = new Acao();
        acaoOracle.setName("ORCL34");
        acaoOracle.setValorInicial(204.73f);
        acaoOracle.setValorAtual(0);
        acaoOracle.setIdEmpresa(3);
        acaoOracle.setDataInicial(dataInicial);
        acaoOracle.setDataVendaAtual("");
        acaoRepository.save(acaoOracle);
	}
	
	private void loadEmpresas() 
	{
        Empresa empresa01 = new Empresa();
        empresa01.setName("Cemig");
        empresa01.setEmpresaId(1);
        empresaRepository.save(empresa01);
        
        Empresa empresa02 = new Empresa();
        empresa02.setName("Magazine Luiza");
        empresa01.setEmpresaId(2);
        empresaRepository.save(empresa02);
        
        Empresa empresa03 = new Empresa();
        empresa03.setName("Oracle");
        empresa03.setEmpresaId(3);
        empresaRepository.save(empresa03);
	}
	
	private void loadPessoas() 
	{
        Pessoa pessoa01 = new Pessoa();
        pessoa01.setName("João");
        pessoa01.setPessoaEmail("joao.silva@gmail.com");
        pessoa01.setPessoaCpf("83128339007");
        pessoaRepository.save(pessoa01);
        
        Pessoa pessoa02 = new Pessoa();
        pessoa02.setName("Luiz");
        pessoa02.setPessoaEmail("luiz.josue@gmail.com");
        pessoa02.setPessoaCpf("53182603060");
        pessoaRepository.save(pessoa02);
        
        Pessoa pessoa03 = new Pessoa();
        pessoa03.setName("Samuel");
        pessoa03.setPessoaEmail("samuel.junior@gmail.com");
        pessoa03.setPessoaCpf("24502762032");
        pessoaRepository.save(pessoa03);
	}
}
