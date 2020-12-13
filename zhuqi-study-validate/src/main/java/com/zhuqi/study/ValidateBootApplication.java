package com.zhuqi.study;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhuqi
 * @date create at 2019-11-08 16:12
 */
@SpringBootApplication
@RestController
@Validated
public class ValidateBootApplication {


    public static void main(String[] args) {
        HashMap<String, String> paramMap = new HashMap<>(16);
        paramMap.put("code", "123");
        String prestr = "";
        for (Map.Entry<String, String> entry : paramMap.entrySet()) {
            prestr = prestr + entry + "&";
        }
        System.out.println(prestr);
    }


}
