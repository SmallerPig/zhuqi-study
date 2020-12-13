package com.zhuqi.study.zhuqi.study.dubbo.service;

import java.util.List;

/**
 * @author zhuqi
 * @date create at 2020-01-22 16:39
 */
public interface UserService {


    List<Long> getUserAddressList(String userId);
}
