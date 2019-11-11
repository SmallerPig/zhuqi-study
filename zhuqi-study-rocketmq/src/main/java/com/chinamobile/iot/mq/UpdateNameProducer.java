package com.chinamobile.iot.mq;

import com.maihaoche.starter.mq.annotation.EnableMQConfiguration;
import com.maihaoche.starter.mq.annotation.MQProducer;
import com.maihaoche.starter.mq.base.AbstractMQProducer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

/**
 * demo of the producer
 *
 * @author zhuqi
 */
@MQProducer
@ConditionalOnBean(
        annotation = EnableMQConfiguration.class
)
public class UpdateNameProducer extends AbstractMQProducer {

}
