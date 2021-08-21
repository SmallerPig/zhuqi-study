package com.zhuqi.study.rocketmq.cons;

import org.apache.rocketmq.spring.core.RocketMQListener;

/**
 * @author zhuqi at 2020/9/15
 */
public class MessageLisenter implements RocketMQListener<String> {
    @Override
    public void onMessage(String message) {

    }
}
