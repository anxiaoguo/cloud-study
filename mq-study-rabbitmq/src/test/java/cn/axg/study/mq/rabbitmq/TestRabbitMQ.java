package cn.axg.study.mq.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitMQApplication.class)
public class TestRabbitMQ {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    //topic 动态路由模式
    @Test
    public void provider5(){
        rabbitTemplate.convertAndSend("topic-exchange","order.add","消息内容是：topic动态路由");
    }

    //routing 路由模式
    @Test
    public void provider4(){
        rabbitTemplate.convertAndSend("routing-exchange","error","路由模式");
    }

    // publish_subscribe 广播模式
    @Test
    public void provider3(){
        rabbitTemplate.convertAndSend("ps-fanout","","消息内容为：发布订阅模式");
    }

    //work queue
    @Test
    public void provider2(){
        for (int i = 0; i < 20; i++) {
            rabbitTemplate.convertAndSend("work-queue",i + "====>i love work");
        }
    }

    //hello world
    @Test
    public void provider1(){
        //向名字为hello-springboot的队列发送消息
        rabbitTemplate.convertAndSend("hello","i love you");
    }

}
