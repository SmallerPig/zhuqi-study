package com.zhuqi.study.thread.local;

/**
 * @author zhuqi at 2021/10/11
 */
public class ThreadUserLocal {
    /**
     * 把构造函数私有，外面不能new，只能通过下面两个方法操作
     */
    private ThreadUserLocal(){
    }

    private static final ThreadLocal<UserInfo> LOCAL = new ThreadLocal<UserInfo>();

    public static void set(UserInfo user){
        LOCAL.set(user);;
    }

    public static UserInfo get(){
        return LOCAL.get();
    }


}
