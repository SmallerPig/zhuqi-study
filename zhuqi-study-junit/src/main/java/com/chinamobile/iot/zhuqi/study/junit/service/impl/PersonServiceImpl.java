package com.chinamobile.iot.zhuqi.study.junit.service.impl;

import com.chinamobile.iot.zhuqi.study.junit.dao.PersonDAO;
import com.chinamobile.iot.zhuqi.study.junit.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhuqi
 * @date create at 2019-10-16 20:10
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDAO personDAO;


}
