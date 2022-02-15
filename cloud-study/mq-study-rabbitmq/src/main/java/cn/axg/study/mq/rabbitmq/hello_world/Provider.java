package cn.axg.study.mq.rabbitmq.hello_world;

import cn.axg.study.mq.rabbitmq.common.RabbitMQUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * 生成者发送消息（Hello World 模型）
 */
public class Provider {

    @Test
    public void providerMessageTest() throws IOException {

        //创建连接，用于连接rabbitmq服务器
        Connection connection = RabbitMQUtils.getConnection();
        //已经连接服务器了。就差管道和传输数据了
        Channel channel = connection.createChannel();
        //参数1：队列名称，如果队列不存在则自动创建一个新的
        //参数2：用来定义队列特性是否要持久化，true表示持久化队列 false表示不持久化队列
        //参数3：是否独占队列，true表示独占 false表示不独占
        //参数4：是否在消费完成后自动删除队列
        //参数5：表示额外附加参数
        channel.queueDeclare("hello-world", true, false, false, null);
        //参数1：交换机名称
        //参数2：队列名称
        //参数3：传递消息的额外设置 MessageProperties.PERSISTENT_TEXT_PLAIN 表示持久化消息
        //参数4：实际消息内容，注意这里要转换成getBytes
        channel.basicPublish("", "hello-world", MessageProperties.PERSISTENT_TEXT_PLAIN, "i love you".getBytes());
        //最后关闭资源
        RabbitMQUtils.closeConnectionAndChanel(connection,channel);
    }
}
