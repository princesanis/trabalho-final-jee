package com.javaee.prince.trabalhofinaljee.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.javaee.prince.trabalhofinaljee.config.RabbitMQConfig;
import com.javaee.prince.trabalhofinaljee.domain.Message;

@Component
public class MessageListener {

	static final Logger logger = LoggerFactory.getLogger(MessageListener.class);

    @RabbitListener(queues = RabbitMQConfig.QUEUE_DEAD_MESSAGES_COMPRAS)
    //public void processMessage(Message message) {
    public void processMessageCompras(Message message) {    	
        logger.info("Mensagem recebida");
        logger.info("Subject:" + message.getSubject());
        logger.info("Body:" + message.getBody());
    }
    
    @RabbitListener(queues = RabbitMQConfig.QUEUE_DEAD_MESSAGES_VENDAS)
    public void processMessageVendas(Message message) {
        logger.info("Mensagem recebida");
        logger.info("Subject:" + message.getSubject());
        logger.info("Body:" + message.getBody());
    }    
}
