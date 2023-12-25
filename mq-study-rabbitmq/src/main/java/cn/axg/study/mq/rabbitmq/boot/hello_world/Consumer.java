package cn.axg.study.mq.rabbitmq.boot.hello_world;

import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * 用SpringBoot的方式
 */
@Slf4j
@Component
//消费者的监听，可以指定一些列的属性
//默认是持久化、非独占、不是自动删除的队列@Queue(value = "hello-springboot",declare = "true",exclusive = "false",autoDelete = "false")
//@RabbitListener(queues = "hello-springboot")
public class Consumer {

//    @RabbitHandler
//    public void receive(String message){
//        //接收到消息后具体业务操作
//        System.out.println("消费者=======>" + message);
//    }

    @RabbitHandler
    @Transactional(rollbackFor = Exception.class)
    @RabbitListener(queues = "hello")
    public void processUserCouponSenderInfo(Message message, Channel channel) throws IOException {
//        log.info("监听到用户发券消息 message:{} ----> channel:{}", message, channel);
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
            // 消息转换 转换为接收的对象class
            System.out.println("------------------>"+ new String(message.getBody()));
            System.out.println("!!!!!!!!!!!!"+channel);
            System.out.println("==============>消息内容:" + message);
            // TODO 业务逻辑（通过业务处理逻辑判断消息是否手动确认接收）

            //假设在这里发生异常
            int i = 0;
//            int y = 9 / i;

            // 接收消息
            channel.basicAck(deliveryTag, Boolean.FALSE);
        } catch (Exception e) {
            e.printStackTrace();
            // 拒收消息 放回队列
            channel.basicNack(deliveryTag, Boolean.FALSE, Boolean.TRUE);
        }
    }

}
