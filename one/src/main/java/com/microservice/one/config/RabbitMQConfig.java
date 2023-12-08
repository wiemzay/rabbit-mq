package com.microservice.one.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Value("${rabbitmq.queue}")
    private String queue;
    @Value("${rabbitmq.exchange}")
    private String exchange;
    @Value("${rabbitmq.routingKey}")
    private String routingKey;

    /**
     * Configures a task queue.
     *
     * @return The configured task queue.
     */
    @Bean
    public Queue taskQueue() {
        return new Queue(queue);
    }

    /**
     * Configures a topic exchange.
     *
     * @return The configured topic exchange.
     */
    @Bean
    TopicExchange exchange() {
        return new TopicExchange(exchange);
    }

    /**
     * Configures a binding between the task queue and the topic exchange.
     *
     * @param queue    The task queue.
     * @param exchange The topic exchange.
     * @return The configured binding.
     */
    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange)
                .with(routingKey);
    }

    /**
     * Configures a message converter for JSON serialization.
     *
     * @return The configured message converter.
     */
    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    /**
     * Configures an AMQP template with the provided connection factory and message converter.
     *
     * @param connectionFactory The RabbitMQ connection factory.
     * @return The configured AMQP template.
     */
    @Bean
    public AmqpTemplate template (ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }

}
