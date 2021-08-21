package com.zhuqi.study.zhuqistudyshiro;

import org.apache.shiro.util.ThreadContext;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试Shiro的核心类 ThreadContext
 * @author zhuqi at 2020/8/13
 */
public class ThreadContextTest {


    /**
     * 测试: 基础增加ThreadContext的值
     */
    @Test
    public void test(){
        Map<Object, Object> backingMap = new HashMap<>();
        backingMap.put("a","1");
        backingMap.put("b",2);
        ThreadContext.setResources(backingMap);

        Assert.assertEquals("1", ThreadContext.get("a").toString());
    }
    /**
     * 测试: 删除ThreadContext的值
     */
    @Test
    public void test1(){
        Map<Object, Object> backingMap = new HashMap<>();
        backingMap.put("a","1");
        backingMap.put("b",2);
        ThreadContext.setResources(backingMap);

        Assert.assertEquals("1", ThreadContext.get("a").toString());

        // 删除之后返回删除之后的value
        Object a = ThreadContext.remove("a");
        System.out.println("a = " + a);
        Assert.assertNull(ThreadContext.get("a"));
    }

    /**
     * 测试:绑定Shiro配置,获取subject
     */
    @Test
    public void testSubject(){

    }


}
