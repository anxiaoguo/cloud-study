package cn.axg.study.mq.rabbitmq.work_queues;

import cn.axg.study.mq.rabbitmq.common.RabbitMQUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * 消费者（Work_queues模式）
 */
public class Consumer2 {

    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare("hello-world", true, false, false, null);
        //参数1：队列的名称
        //参数2：是否开启自动消息确认（只要开启，则队列的消息一下就全部分配给了消费者，此时队列就会变空）
        channel.basicConsume("hello-world", true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者2======>" + new String(body));
            }
        });

    }

}
