package com.zhuqi.study.zhuqi.study.junit.service.impl;

import com.zhuqi.study.zhuqi.study.junit.dao.PersonDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.env.MockEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * @author zhuqi
 * @date create at 2019-10-16 20:11
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class PersonServiceImplTest {

//    @TestConfiguration
//    static class personDAOConfiguration {
//
//        @Bean
//        public PersonDAO personDAO() {
//            return new PersonDAO() {
//
//                @Override
//                public String toString() {
//                    return super.toString();
//                }
//            };
//        }
//    }

    @MockBean
    private PersonDAO personDAO;


    @Test
    public void envTest() {
        MockEnvironment mockEnvironment = new MockEnvironment();
        mockEnvironment.setProperty("zhuqi.security.enabled", "false");


        assertEquals("false", mockEnvironment.getProperty("zhuqi.security.enabled"));

    }
}
