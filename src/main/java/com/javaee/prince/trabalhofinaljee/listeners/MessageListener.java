package com.javaee.prince.trabalhofinaljee.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.javaee.prince.trabalhofinaljee.config.RabbitMQConfig;
import com.javaee.prince.trabalhofinaljee.domain.Acao;
import com.javaee.prince.trabalhofinaljee.domain.Message;
import com.javaee.prince.trabalhofinaljee.services.AcaoService;

@Component
public class MessageListener {

	static final Logger logger = LoggerFactory.getLogger(MessageListener.class);
	
	private AcaoService acaoService;
	
	public MessageListener(AcaoService acaoService)
	{
		this.acaoService = acaoService;
	}
	
    @RabbitListener(queues = RabbitMQConfig.QUEUE_MESSAGES_COMPRAS)
    //public void processMessageCompras(Message message)
    public void processMessageCompras(Acao acao)
    {    	
    	acaoService.executarSolicitacaoDeCompraDeAcao(acao);
    	
        logger.info("Mensagem de compra recebida");
        logger.info(acao.getIdEmpresa().toString());
        logger.info(acao.getIdPessoaProprietaria().toString());
        logger.info(acao.getValorAtual().toString());
    }
    
    @RabbitListener(queues = RabbitMQConfig.QUEUE_MESSAGES_VENDAS)
    public void processMessageVendas(Acao acao) 
    {
		acaoService.executarSolicitacaoDeVendaDeAcao(acao);
		
		logger.info("Mensagem de venda recebida");	
        logger.info(acao.getIdEmpresa().toString());
        logger.info(acao.getIdPessoaProprietaria().toString());
        logger.info(acao.getValorAtual().toString());  	
    }    
}
