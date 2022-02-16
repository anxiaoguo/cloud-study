package cn.axg.study.mq.rabbitmq.routing;

import cn.axg.study.mq.rabbitmq.common.RabbitMQUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * 生产者 发布订阅（Routing模式）
 */
public class Provider {

    @Test
    public void test() throws IOException {
        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();
        //管道与交换机连接 参数1：交换机名称 参数2：direct表示路由模式
        channel.exchangeDeclare("EXCHANGE_NAME", "direct");
        //参数1：交换机的名称
        //参数2：RoutingKey的名称
        //参数3：额外指定参数
        //参数4：发送消息的具体内容
        channel.basicPublish("EXCHANGE_NAME", "info", null, "i love you 路由模式".getBytes("UTF-8"));
        //关闭资源
        RabbitMQUtils.closeConnectionAndChanel(connection,channel);
    }

}
