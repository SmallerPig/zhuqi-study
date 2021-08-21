package zhuqi.study.study.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author zhuqi at 2021/1/7
 */
@Component
public class MyKafkaProducer{

    private KafkaProducer<String, String> producer;



    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void sendlog(String userid){

        kafkaTemplate.send("userLog", userid);

    }
}
