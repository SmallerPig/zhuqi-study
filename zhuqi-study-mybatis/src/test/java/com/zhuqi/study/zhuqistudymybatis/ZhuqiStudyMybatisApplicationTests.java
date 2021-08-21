package com.zhuqi.study.zhuqistudymybatis;

import com.zhuqi.study.zhuqistudymybatis.dao.UserDAO;
import com.zhuqi.study.zhuqistudymybatis.entity.User;
import com.zhuqi.study.zhuqistudymybatis.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;

public class ZhuqiStudyMybatisApplicationTests {

    @Test
    public void contextLoads() {
    }

    /**
     * 测试原始的mybatis使用方式
     *
     */
    @Test
    public void test() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDAO userDAO = (UserDAO) sqlSession.getMapper(UserDAO.class);
        User user = new User();
        user.setUsername("zhuqi1");
        user.setPassword("123456");
        System.out.println();

        userDAO.insert(user);

        sqlSession.commit();
    }


    /**
     * 测试:spring 和Mybatis的整合
     */
    @Test
    public void testSpringTest(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        UserService userService = (UserService) ctx.getBean("userService");

        User user = new User();
        user.setUsername("xiaojj");
        user.setPassword("123123");
        userService.save(user);
    }
}
