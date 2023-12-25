package cn.axg.study.mq.rabbitmq.boot.topic;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Component
public class ConsumerTopic {

//    @RabbitListener(bindings = {
//            @QueueBinding(
//                    value = @Queue,
//                    exchange = @Exchange(name = "topic-exchange",type = "topic"),
//                    key = {"user.*","order.*"}
//            )
//    })

    @RabbitHandler
    @Transactional(rollbackFor = Exception.class)
//    @RabbitListener(queues = "order.add")
    public void receive1(Message message, Channel channel){
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        System.out.println("消费者1===========>" + message);
        try {
            channel.basicAck(deliveryTag, Boolean.FALSE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    @RabbitListener(bindings = {
//            @QueueBinding(
//                    value = @Queue,
//                    exchange = @Exchange(name = "topic-exchange",type = "topic"),
//                    key = {"user.#"}
//            )
//    })
    public void receive2(String message){
        System.out.println("消费者2===========>" + message);
    }
}
