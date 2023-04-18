package com.zhuqi.study.hutools;

import cn.hutool.core.lang.Console;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zhuqi at 2021/9/5
 */
@SpringBootTest
public class SocketTest {


    /**
     * 测试: hutools 的网络连接
     */
    @Test
    public void testSocket(){

    }


    /**
     * 测试:Http请求客户端
     */
    @Test
    public void testHttpClient(){
        //链式构建请求
        String result2 = HttpRequest.get("www.baidu.com")
                .header(Header.USER_AGENT, "Hutool http")//头信息，多个头信息多次调用此方法即可
                .timeout(20000)//超时，毫秒
                .execute().body();
        Console.log(result2);
    }
}
