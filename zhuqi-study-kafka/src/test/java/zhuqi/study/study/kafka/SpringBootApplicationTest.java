package zhuqi.study.study.kafka;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.*;

/**
 * @author zhuqi at 2021/1/7
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootApplicationTest {

    @Autowired
    MyKafkaConsumer kafkaConsumer;

    @Autowired
    MyKafkaProducer kafkaProducer;

    /**
     * 测试:kafka的接收器
     */
    @Test
    public void testKafkaConsumer(){

    }

    /**
     * 测试:kafka Producer
     */
    @Test
    public void testKafkaProducerDemo(){
        kafkaProducer.sendlog("-1");
    }

    /**
     * 测试:kafka
     */
    @Test
    public void testKafkaProducer() throws IOException {

    }
}
