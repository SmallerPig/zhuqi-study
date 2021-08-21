package zhuqi.study.spring;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author zhuqi at 2020/8/2
 */
public class BeanFactory {

    private static Properties env =  new Properties();

    static {
        // 获取IO输入流
        InputStream stream  =  BeanFactory.class.getResourceAsStream("/application.properties");

        try {
            //加载文件内容, 形成标准的key,value形式
            env.load(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public static Object getBean(String key){
        Object resutl = null;
        try {
            Class clazz = Class.forName(env.getProperty(key));
            resutl = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resutl;

    }
}
