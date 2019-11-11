package com.chinamobile.iot;

import cn.hutool.core.thread.ThreadFactoryBuilder;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.*;

/**
 * @author zhuqi
 * @date create at 2019-11-01 18:42
 */
public class BootApplication {


    public static void main(String[] args) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNamePrefix("demo-pool-zhuqi")
                .build();


        ExecutorService pool = new ThreadPoolExecutor(5, 200,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 50; i++) {
            final int ii = i;

            pool.execute(() -> {
                String url = "http://localhost:8080/ping/" + ii;
                OkHttpClient okHttpClient = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(url)
                        .build();
                Call call = okHttpClient.newCall(request);
                try {
                    Response response = call.execute();
                    System.out.println("ii:" + ii + "get:" + response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
