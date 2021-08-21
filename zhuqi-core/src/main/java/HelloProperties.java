
import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * @author zhuqi at 2018/11/21
 */
@ConfigurationProperties(prefix = "hello")
public class HelloProperties {
    //消息内容
    private String msg = "HengYu";
    //是否显示消息内容
    private boolean show = true;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }
}

