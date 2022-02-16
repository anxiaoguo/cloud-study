package cn.axg.study.mq.rabbitmq.boot.topic;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerTopic {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(name = "topic-exchange",type = "topic"),
                    key = {"user.*","order.*"}
            )
    })
    public void receive1(String message){
        System.out.println("消费者1===========>" + message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(name = "topic-exchange",type = "topic"),
                    key = {"user.#"}
            )
    })
    public void receive2(String message){
        System.out.println("消费者2===========>" + message);
    }
}
