package com.javaee.prince.trabalhofinaljee.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.javaee.prince.trabalhofinaljee.config.EmailConfig;
import com.javaee.prince.trabalhofinaljee.config.RabbitMQConfig;
import com.javaee.prince.trabalhofinaljee.domain.Acao;
import com.javaee.prince.trabalhofinaljee.domain.Empresa;
import com.javaee.prince.trabalhofinaljee.domain.Pessoa;
import com.javaee.prince.trabalhofinaljee.repositories.AcaoRepository;
import com.javaee.prince.trabalhofinaljee.repositories.EmpresaRepository;
import com.javaee.prince.trabalhofinaljee.repositories.PessoaRepository;

@Service
public class AcaoServiceImpl implements AcaoService {

	private final RabbitTemplate rabbitTemplate;
	
	private AcaoRepository acaoRepository;
	private EmpresaRepository empresaRepository;
	private PessoaRepository pessoaRepository;
	
	
	public AcaoServiceImpl(RabbitTemplate rabbitTemplate,
						   AcaoRepository acaoRepository,
						   EmpresaRepository empresaRepository,
						   PessoaRepository pessoaRepository) 
	{
		this.acaoRepository = acaoRepository;
		this.empresaRepository = empresaRepository;
		this.pessoaRepository = pessoaRepository;
		this.rabbitTemplate = rabbitTemplate;
	}
	
	@Override
	public Set<Acao> getAll() {
		
		Set<Acao> acoes = new HashSet<>();
		
		this.acaoRepository.findAll().iterator().forEachRemaining(acoes::add);
		
		return acoes;
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
			acao.setDataOperacao(new Date());
			acao.setDisponivel(true);
			
			return acaoRepository.save(acao);
		}
		else 
		{
			throw new IllegalArgumentException("Já existe uma ação com este nome cadastrada: " + acao.getName());
		}
	}

	@Override
	public void comprarAcao(Acao acao) {
		
		Optional<Empresa> empresa = empresaRepository.findById(acao.getIdEmpresa());
		
		Optional<Pessoa> pessoa = pessoaRepository.findById(acao.getIdPessoaProprietaria());
		
		if(!empresa.isPresent()) {
			throw new IllegalArgumentException("Empresa não encontrada!");
		}
		
		if(!pessoa.isPresent()) {
			throw new IllegalArgumentException("Pessoa não encontrada!");
		}
		
		System.out.println(pessoa.toString());
		System.out.println(empresa.toString());
		
		this.rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_MESSAGES_COMPRAS, acao);
	}

	@Override
	public void venderAcao(Acao acao) {
		
		this.rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_MESSAGES_VENDAS, acao);
	}
	
	@Override
	public void executarSolicitacaoDeCompraDeAcao(Acao acao)
	{
		Acao acaoDisponivel = acaoRepository.findByAcaoDisponivelVenda(acao.getId(), true);
		
		if (acaoDisponivel != null) 
		{
			String idVendedor = acaoDisponivel.getIdPessoaProprietaria();
			String idComprador = acao.getIdPessoaProprietaria();
			
			enviarEmailSolicitacaoEfetuada(idVendedor, idComprador, acaoDisponivel.getId());
			
			acaoDisponivel.setIdPessoaProprietaria(acao.getIdPessoaProprietaria());
			acaoDisponivel.setDisponivel(false);
			acaoDisponivel.setDataOperacao(new Date());
			
			acaoRepository.save(acaoDisponivel);
		} 
	}
	
	private void enviarEmailSolicitacaoEfetuada(String idVendedor, String idComprador, String idAcao)
	{
		Optional<Pessoa> vendedor = pessoaRepository.findById(idVendedor);
		Optional<Pessoa> comprador = pessoaRepository.findById(idComprador);
		
		String toEmailVendedor = "";
		String toEmailComprador = "";
		String subject = "Mercado de Ações - Java EE";
		
		
		if (vendedor.isPresent()) {
			toEmailVendedor = vendedor.get().getPessoaEmail();
		}
		
		if (comprador.isPresent()) {
			toEmailComprador = comprador.get().getPessoaEmail();
		}
			
		String body = "A ação de id " + idAcao + " foi vendida da pessoa " + toEmailVendedor + " para a pessoa " + toEmailComprador;			
		
		EmailConfig emailConfig = new EmailConfig();
		
		emailConfig.sendEmail(toEmailComprador, toEmailVendedor, subject, body);
	}

	@Override
	public void executarSolicitacaoDeVendaDeAcao(Acao acao) {
		
		if (acao != null) 
		{
			acao.setDisponivel(true);
			acao.setDataOperacao(new Date());
			
			acaoRepository.save(acao);
		} 		
	}
}
