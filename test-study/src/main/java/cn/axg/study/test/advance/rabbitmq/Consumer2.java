package cn.axg.study.test.advance.rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * 消费者 （用于模拟死信队列转发消息的）
 */
public class Consumer2 {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("z-exchange", "direct",true);
        //创建虚拟队列
        String queueName = channel.queueDeclare().getQueue();
        //队列绑定交换机
        //参数1：队列名称
        //参数2：交换机名称
        //参数3：RoutingKey的名称
        channel.queueBind(queueName, "z-exchange", "error");
        channel.queueBind(queueName, "z-exchange", "trace");
        //消费消息
        channel.basicConsume(queueName, true, new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者2====>" + new String(body));
            }
        });

    }
}
