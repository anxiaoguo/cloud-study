package cn.axg.study.mq.rabbitmq.boot.publish_subscribe;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ComsumberPS {

//    @RabbitListener(bindings = {
//            @QueueBinding(
//                    value = @Queue,
//                    exchange = @Exchange(name = "ps-fanout", type = "fanout")
//            )}
//    )
    public void receive1(String message) {
        System.out.println("消费者1=======>"+ message);
    }

//    @RabbitListener(bindings = {
//            @QueueBinding(
//                    value = @Queue,
//                    exchange = @Exchange(name = "ps-fanout", type = "fanout")
//            )}
//    )
    public void receive2(String message) {
        System.out.println("消费者2=======>"+ message);
    }
}
