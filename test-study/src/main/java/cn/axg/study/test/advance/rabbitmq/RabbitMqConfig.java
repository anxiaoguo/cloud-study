package cn.axg.study.test.advance.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {


    /**
     * 订单延迟队列（死信队列）
     */
    @Bean
    public Queue orderTtlQueue() {
        return QueueBuilder
                .durable("dead-queue")//设置队列名字并且设置durable为false
                .withArgument("x-dead-letter-exchange", "z-exchange")//到期后转发的交换机
                .withArgument("x-dead-letter-routing-key", "error")//到期后转发的路由键
                .build();
    }

    /**
     * 死信队列所绑定的交换机
     */
    @Bean
    DirectExchange orderTtlDirect() {
        return (DirectExchange) ExchangeBuilder
                .directExchange("dead-exchange")
                .durable(true)
                .build();
    }

    /**
     * 死信队列绑定：队列-交换机-routingkey
     */
    @Bean
    Binding orderTtlBinding(DirectExchange orderTtlDirect, Queue orderTtlQueue){
        return BindingBuilder
                .bind(orderTtlQueue)
                .to(orderTtlDirect)
                .with("dead-routingkey");
    }

}
