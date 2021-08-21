package com.zhuqi.study.zhuqistudyshiro;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ThreadContext;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuqi at 2020/8/13
 */
public class ShiroTest {
    /**
     * 测试:shiro
     */
    @Test
    public void test(){

        Map<Object, Object> backingMap = new HashMap<>();
        backingMap.put("a",1);
        backingMap.put("b",2);
        ThreadContext.setResources(backingMap);
        System.out.println("ThreadContext.get(a) = " + ThreadContext.get("a"));

    }


    /**
     * 测试:直接增加ThreadContext value
     */
    @Test
    public void test2(){
        Subject subject = ThreadContext.getSubject();
        System.out.println("subject = " + subject);
    }

}


