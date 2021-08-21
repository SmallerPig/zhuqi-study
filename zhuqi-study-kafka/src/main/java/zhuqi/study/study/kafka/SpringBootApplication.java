package zhuqi.study.study.kafka;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

/**
 * @author zhuqi at 2018/8/7
 */
@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringBootApplication.class, args);
    }


    @Autowired
    MyKafkaProducer kafkaProducer;

    @Autowired
    MyKafkaConsumer kafkaConsumer;
}
