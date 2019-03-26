package com.javaee.prince.trabalhofinaljee.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
import org.springframework.messaging.handler.annotation.support.MessageHandlerMethodFactory;

@Configuration
public class RabbitMQConfig implements RabbitListenerConfigurer {

	public static final String QUEUE_MESSAGES_COMPRAS = "compras-messages-queue";
    public static final String EXCHANGE_MESSAGES_COMPRAS = "compras-messages-exchange";
    public static final String QUEUE_DEAD_MESSAGES_COMPRAS = "compras-dead-messages-queue";
    
	public static final String QUEUE_MESSAGES_VENDAS = "vendas-messages-queue";
    public static final String EXCHANGE_MESSAGES_VENDAS = "vendas-messages-exchange";
    public static final String QUEUE_DEAD_MESSAGES_VENDAS = "vendas-dead-messages-queue";    
	
    @Bean
    Queue comprasMessagesQueue() {
    	return QueueBuilder.durable(QUEUE_MESSAGES_COMPRAS)
                .withArgument("x-dead-letter-exchange", "")
                .withArgument("x-dead-letter-routing-key", QUEUE_DEAD_MESSAGES_COMPRAS)
                .withArgument("x-message-ttl", 3000) //if message is not consumed in 15 seconds send to DLQ
                .build();
    }
    
    @Bean
    Queue vendasMessagesQueue() {
    	return QueueBuilder.durable(QUEUE_MESSAGES_VENDAS)
                .withArgument("x-dead-letter-exchange", "")
                .withArgument("x-dead-letter-routing-key", QUEUE_DEAD_MESSAGES_VENDAS)
                .withArgument("x-message-ttl", 3000) //if message is not consumed in 15 seconds send to DLQ
                .build();
    }
    
    @Bean
    Queue comprasDeadMessagesQueue() {
        return QueueBuilder.durable(QUEUE_DEAD_MESSAGES_COMPRAS).build();
    }
    
    @Bean
    Queue vendasDeadMessagesQueue() {
        return QueueBuilder.durable(QUEUE_DEAD_MESSAGES_VENDAS).build();
    }    
    
    @Bean
    Exchange comprasMessagesExchange() {
        return ExchangeBuilder.topicExchange(EXCHANGE_MESSAGES_COMPRAS).build();
    }
    
    @Bean
    Exchange vendasMessagesExchange() {
        return ExchangeBuilder.topicExchange(EXCHANGE_MESSAGES_VENDAS).build();
    }
    
    @Bean
    Binding comprasBinding(Queue comprasMessagesQueue, TopicExchange comprasMessagesExchange) {
        return BindingBuilder.bind(comprasMessagesQueue).to(comprasMessagesExchange).with(QUEUE_MESSAGES_COMPRAS);
    }
    
    @Bean
    Binding vendasBinding(Queue vendasMessagesQueue, TopicExchange vendasMessagesExchange) {
        return BindingBuilder.bind(vendasMessagesQueue).to(vendasMessagesExchange).with(QUEUE_MESSAGES_VENDAS);
    }    
    
    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }
 
    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    
    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar register) {
        register.setMessageHandlerMethodFactory(messageHandlerMethodFactory());
    }
 
    @Bean
    MessageHandlerMethodFactory messageHandlerMethodFactory() {
        DefaultMessageHandlerMethodFactory messageHandlerMethodFactory = new DefaultMessageHandlerMethodFactory();
        messageHandlerMethodFactory.setMessageConverter(consumerJackson2MessageConverter());
        return messageHandlerMethodFactory;
    }
 
    @Bean
    public MappingJackson2MessageConverter consumerJackson2MessageConverter() {
        return new MappingJackson2MessageConverter();
    }    
    
}
