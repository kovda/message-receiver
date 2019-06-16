package ru.cft.msgreceiver.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Configuration
@EnableRabbit
public class RabbitConfig {

    public static final String AMQ_RABBITMQ_TRACE = "amq.rabbitmq.trace";

    private static final String POSTFIX_EXCHANGE = "_ex";

    @Value("${rabbit.queue.massages.channel}")
    private String messagesChannel;

    @Autowired
    protected RabbitTemplate rabbitTemplate;

    @Autowired
    private MessageConverter messageConverter;

    @Autowired
    protected SimpleRabbitListenerContainerFactory containerFactory;

    @PostConstruct
    protected void init() {
        rabbitTemplate.setMessageConverter(messageConverter);
        containerFactory.setMessageConverter(messageConverter);
        containerFactory.setMissingQueuesFatal(false);

        Queue queue = new Queue(messagesChannel);
        DirectExchange exchange = new DirectExchange(messagesChannel + POSTFIX_EXCHANGE);
        Binding binding = new Binding(queue.getName(), Binding.DestinationType.QUEUE, exchange.getName(), "", null);
        RabbitAdmin admin = rabbitAdmin();
        admin.declareQueue(queue);
        admin.declareExchange(exchange);
        admin.declareBinding(binding);


//        rabbitTemplate.convertAndSend(AMQ_RABBITMQ_TRACE, "", "");
    }

    @Bean
    RabbitAdmin rabbitAdmin() {
        return new RabbitAdmin(rabbitTemplate);
    }

}
