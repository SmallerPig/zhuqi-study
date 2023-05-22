package com.zhuqi.study.nio;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * @author zhuqi at 2021/11/20
 */
public class NioDemo {

    /*
    1. nio Channel
    2. Buffer
    3. Selector
     */

    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(5);
        ByteBuffer byteBuffer = ByteBuffer.allocate(5);

        // put value in buffer
//        intBuffer.put(10);
//        intBuffer.put(12);
//        intBuffer.put(13);
//        intBuffer.put(14);
//        intBuffer.put(15);
        for (int i = 0; i < intBuffer.capacity(); i++) {
            intBuffer.put(i * 2);
        }

        // get value in buffer
        // read/write change
        intBuffer.flip();
        intBuffer.position(1);
        intBuffer.limit(3);
        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }

    }
}
