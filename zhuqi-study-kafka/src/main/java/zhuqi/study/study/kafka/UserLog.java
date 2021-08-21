package zhuqi.study.study.kafka;

/**
 * @author zhuqi at 2021/6/20
 */
public class UserLog {

    private  String username;
    private String userid;
    private String state;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
