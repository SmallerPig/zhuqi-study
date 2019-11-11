package com.chinamobile.iot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chinamobile.iot.dao.UserMapper;
import com.chinamobile.iot.domain.UserEntity;
import com.chinamobile.iot.service.UserService;
import com.chinamobile.iot.wuxi.common.web.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.Instant;

/**
 * @author zhuqi
 * @Description
 * @Date create at 2019-07-24 8:41
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(UserEntity entity) {
        entity.setGmtCreate(Date.from(Instant.now()));
        save(entity);
        System.out.println(entity);
        doSomeThing(entity);

    }

    private void doSomeThing(UserEntity entity){

        System.out.println(entity);
        throw new DataException("一些错误");
    }

}
