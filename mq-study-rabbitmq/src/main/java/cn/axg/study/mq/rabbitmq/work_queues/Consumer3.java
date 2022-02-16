package cn.axg.study.mq.rabbitmq.work_queues;

import cn.axg.study.mq.rabbitmq.common.RabbitMQUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * 消费者（Work_queues模式）
 */
public class Consumer3 {

    public static void main(String[] args) throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();

        //设置管道消息一次走一个
        channel.basicQos(1);
        channel.queueDeclare("hello-world", true, false, false, null);

        //参数1：队列的名称
        //参数2：是否开启自动消息确认（只要开启，则队列的消息一下就全部分配给了消费者，此时队列就会变空）
        channel.basicConsume("hello-world",false,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("消费者3======>"+new String(body));
                //手动消息确认 参数1：确认队列中哪个具体消息 参数2：是否开启多个消息同时确认 false表示一次确认一个
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        });

    }

}
