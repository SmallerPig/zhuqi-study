package com.zhuqi.study;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import javafx.beans.Observable;

/**
 * @author zhuqi at 2018/7/10
 */
public class CommandHelloWorld extends HystrixCommand<String> {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(CommandHelloWorld.class);
    private final String name;

    public CommandHelloWorld(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }

    @Override
    protected String run() {
        // a real example would do work like a network call here
        System.out.println(name);
        return "Hello " + name + "!";
    }

    public static void main(String[] args) {
        String s = new CommandHelloWorld("World").execute();

    }

}

