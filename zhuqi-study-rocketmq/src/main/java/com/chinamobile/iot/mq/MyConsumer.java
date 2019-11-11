package com.chinamobile.iot.mq;

import com.maihaoche.starter.mq.annotation.MQConsumer;
import com.maihaoche.starter.mq.base.AbstractMQPushConsumer;

import java.util.Map;

/**
 * @author zhuqi
 * @date create at 2019-10-14 15:22
 */
@MQConsumer(topic = "demo", consumerGroup = "demo")
public class MyConsumer extends AbstractMQPushConsumer {


    @Override
    public boolean process(Object o, Map map) {
        return false;
    }
}
