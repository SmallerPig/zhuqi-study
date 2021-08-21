package zhuqistudyspring;

import zhuqistudyspring.UserService;
import zhuqistudyspring.annoation.OrgCheck;

/**
 * @author zhuqi at 2020/8/12
 */
public class UserServiceImpl implements UserService {
    @Override
    @OrgCheck
    public void login(String username, String passwod) {
        System.out.println("UserServiceImpl.login");
        System.out.println("username = " + username + ", passwod = " + passwod);

    }
}
