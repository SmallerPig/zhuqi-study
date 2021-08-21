package zhuqi.study;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.*;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @author zhuqi at 2020/11/2
 */
public class FastJsonSerialConfig implements ObjectSerializer {


    public static void main(String[] args) {
        SerializeConfig serializeConfig = SerializeConfig.globalInstance;
        serializeConfig.put(Long.class, ToStringSerializer.instance);

        User user = new User();
        user.setAge("15");
        user.setName("zhuqi");
        user.setId(1322054844796112897L);
        System.out.println(JSON.toJSONString(user));
    }

    @Override
    public void write(JSONSerializer serializer, Object object, Object fieldName, Type fieldType, int features) throws IOException {
        SerializeWriter out = serializer.out;
        System.out.println("fieldName = " + fieldName);
        System.out.println("fieldType = " + fieldType);
        System.out.println("features = " + features);
    }

    static class User {
        private String name;

        private String age;

        private Long id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
    }


}
