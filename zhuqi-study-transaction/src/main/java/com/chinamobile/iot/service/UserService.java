package com.chinamobile.iot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chinamobile.iot.domain.UserEntity;

/**
 * @author zhuqi
 * @Description
 * @Date create at 2019-07-24 8:41
 */
public interface UserService extends IService<UserEntity> {

    /** 添加
     * @param entity
     */
    void add(UserEntity entity);


}
