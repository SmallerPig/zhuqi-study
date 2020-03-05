package com.chinamobile.iot.zhuqi.study.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.chinamobile.iot.zhuqi.study.dubbo.service.UserService;

import java.util.List;

/**
 * @author zhuqi
 * @date create at 2020-01-22 16:39
 */
@Service
public class UserServiceImpl implements UserService {


    @Override
    public List<Long> getUserAddressList(String userId) {
        return null;
    }
}
