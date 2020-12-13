package com.zhuqi.study;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

/**
 * @author zhuqi
 * @date create at 2020-10-20 20:44
 */
@RunWith(SpringRunner.class)
public class BootApplicationTest {

    private final static String TEST_TOPIC_NAME = "zhuqi_test_topic";

    @Test
    public void testMq() throws MQClientException, InterruptedException {
        DefaultMQProducer producer = new DefaultMQProducer("zhuqi_test");
        producer.setNamesrvAddr("172.16.1.223:9876");
        producer.setInstanceName("zhuqi_instance_name");
        producer.start();


        /**
         * 下面这段代码表明一个Producer对象可以发送多个topic，多个tag的消息。
         * 注意：send方法是同步调用，只要不抛异常就标识成功。但是发送成功也可会有多种状态，<br>
         * 例如消息写入Master成功，但是Slave不成功，这种情况消息属于成功，但是对于个别应用如果对消息可靠性要求极高，<br>
         * 需要对这种情况做处理。另外，消息可能会存在发送失败的情况，失败重试由应用来处理。
         */
        for (int i = 0; i < 10; i++) {
            try {
                {
                    Message msg = new Message(TEST_TOPIC_NAME,// topic
                            "TagA",// tag
                            "OrderID001",// key
                            ("Hello MetaQA").getBytes());// body
                    SendResult sendResult = producer.send(msg);
                    System.out.println(sendResult);
                }

                {
                    Message msg = new Message(TEST_TOPIC_NAME,// topic
                            "TagB",// tag
                            "OrderID0034",// key
                            ("Hello MetaQB").getBytes());// body
                    SendResult sendResult = producer.send(msg);
                    System.out.println(sendResult);
                }

                {
                    Message msg = new Message(TEST_TOPIC_NAME,// topic
                            "TagC",// tag
                            "OrderID061",// key
                            ("Hello MetaQC").getBytes());// body
                    SendResult sendResult = producer.send(msg);
                    System.out.println(sendResult);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            TimeUnit.MILLISECONDS.sleep(1000);
        }


    }
}
