package com.zhuqi.study.zhuqistudymybatis.service;

import com.zhuqi.study.zhuqistudymybatis.dao.UserDAO;
import com.zhuqi.study.zhuqistudymybatis.entity.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zhuqi at 2020/8/17
 */
@Transactional
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void save(User user) {
        userDAO.insert(user);
    }
}
