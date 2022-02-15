package cn.axg.study.mq.rabbitmq.publish_subscribe;

import cn.axg.study.mq.rabbitmq.common.RabbitMQUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * 消费者消费消息（Publish/Subscribe模型）
 */
public class Consumer2 {

    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();
        //通道绑定交换机
        channel.exchangeDeclare("exchange_logs", "fanout");
        //临时队列
        String queueName = channel.queueDeclare().getQueue();
        //交换机跟队列进行绑定
        channel.queueBind(queueName, "exchange_logs", "");
        //接收消息(具体的业务操作)
        channel.basicConsume(queueName, true, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者2====>" + new String(body));
            }
        });
    }

}
