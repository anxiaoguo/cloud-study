package cn.axg.study.mq.rabbitmq.publish_subscribe;

import cn.axg.study.mq.rabbitmq.common.RabbitMQUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * 生产者生产消息（Publish/Subscribe模型）
 */
public class Provider {

    @Test
    public void test() throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();
        //参数1：指定交换机名字，如果没有则自动创建一个
        //参数2：指定交换机类型，fanout表示广播类型
        channel.exchangeDeclare("exchange_logs", "fanout");
        //发送消息
        channel.basicPublish("exchange_logs", "", null, "i love you".getBytes("UTF-8"));
        //关闭资源
        RabbitMQUtils.closeConnectionAndChanel(connection,channel);

    }

}
