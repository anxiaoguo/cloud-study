package cn.axg.study.mq.rabbitmq.boot.work_queues;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerWork {

//    @RabbitListener(queuesToDeclare = @Queue(value = "work-queue"))
    public void receive1(String message){
        System.out.println("消费者1===========>" + message);
    }

//    @RabbitListener(queuesToDeclare = @Queue(value = "work-queue"))
    public void receive2(String message){
        System.out.println("消费者2===========>" + message);
    }
}
