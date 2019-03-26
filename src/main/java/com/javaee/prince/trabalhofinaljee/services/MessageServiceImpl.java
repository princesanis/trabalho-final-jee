package com.javaee.prince.trabalhofinaljee.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.javaee.prince.trabalhofinaljee.config.RabbitMQConfig;
import com.javaee.prince.trabalhofinaljee.domain.Message;

@Service
public class MessageServiceImpl implements MessageService {

	private final RabbitTemplate rabbitTemplate;
	 
    public MessageServiceImpl(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    
/*    @Override
    public void sendMessage(Message message) {
        this.rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_MESSAGES, message);
}*/

	@Override
	public void sendMessageCompra(Message message) {
		
		this.rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_MESSAGES_COMPRAS, message);
		
	}

	@Override
	public void sendMessageVenda(Message message) {
		
		this.rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE_MESSAGES_VENDAS, message);
		
	}	
	
}
