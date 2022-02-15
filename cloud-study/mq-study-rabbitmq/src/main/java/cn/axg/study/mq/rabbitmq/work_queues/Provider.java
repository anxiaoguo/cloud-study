package cn.axg.study.mq.rabbitmq.work_queues;

import cn.axg.study.mq.rabbitmq.common.RabbitMQUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * 生产者生产消息（Work_queues模式）
 */
public class Provider {

    @Test
    public void test() throws IOException {

        Connection connection = RabbitMQUtils.getConnection();
        Channel channel = connection.createChannel();
        //参数1：队列名称，如果队列不存在则自动创建一个新的
        //参数2：用来定义队列特性是否要持久化，true表示持久化队列 false表示不持久化队列
        //参数3：是否独占队列，true表示独占 false表示不独占
        //参数4：是否在消费完成后自动删除队列
        //参数5：表示额外附加参数
        channel.queueDeclare("hello-world", true, false, false, null);
        //想队列发送i条消息
        for (int i = 0; i < 20; i++) {
            channel.basicPublish("", "hello-world", MessageProperties.PERSISTENT_TEXT_PLAIN, (i + "=====>i love you").getBytes());
        }
        RabbitMQUtils.closeConnectionAndChanel(connection,channel);
    }
}
