package zhuqi.study.study.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author zhuqi at 2021/6/20
 */
@Component
public class MyKafkaConsumer {

    @KafkaListener(topics = {"example"})
    public  void consumer(ConsumerRecord consumerRecord){
        Optional kafkaMsg=  Optional.ofNullable(consumerRecord.value());
        if (kafkaMsg.isPresent()){
            Object msg=  kafkaMsg.get();
            System.err.println(msg);
        }
    }

}
