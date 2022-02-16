package cn.axg.study.mq.rabbitmq.boot.hello_world;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 用SpringBoot的方式
 */
@Component
//消费者的监听，可以指定一些列的属性
//默认是持久化、非独占、不是自动删除的队列@Queue(value = "hello-springboot",declare = "true",exclusive = "false",autoDelete = "false")
@RabbitListener(queuesToDeclare = @Queue(value = "hello-springboot"))
public class Consumer {

    @RabbitHandler
    public void receive(String message){
        //接收到消息后具体业务操作
        System.out.println("消费者=======>" + message);
    }

}
