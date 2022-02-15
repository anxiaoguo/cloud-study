package cn.axg.study.mq.rabbitmq.routing;

import cn.axg.study.mq.rabbitmq.common.RabbitMQUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * 消费者 发布订阅（Routing模式）
 */
public class Consumer3 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("EXCHANGE_NAME", "direct");
        //创建虚拟队列
        String queueName = channel.queueDeclare().getQueue();
        //队列绑定交换机
        //参数1：队列名称
        //参数2：交换机名称
        //参数3：RoutingKey的名称
        channel.queueBind(queueName, "EXCHANGE_NAME", "info");
        channel.queueBind(queueName, "EXCHANGE_NAME", "debug");
        channel.queueBind(queueName, "EXCHANGE_NAME", "warning");
        //消费消息
        channel.basicConsume(queueName, true, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者3====>" + new String(body));
            }
        });

    }
}
