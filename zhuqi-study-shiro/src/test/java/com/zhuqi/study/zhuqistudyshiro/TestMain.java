package com.zhuqi.study.zhuqistudyshiro;

import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * @author zhuqi at 2018/9/5
 */
public class TestMain {

    private static final Logger logger = LoggerFactory.getLogger(TestMain.class);

    public static void main(String[] vars) {
        Serializable sessionId = "12312312312";
        Subject subject = initBySessionId(sessionId);
        logger.info("subject:{}", subject);


    }

    static Subject initBySessionId(Serializable sessionId) {
        return new Subject.Builder().sessionId(sessionId).buildSubject();
    }

    static Subject initByPrincipals(Serializable identity) {
        String realmName = "myRealm";
        PrincipalCollection principals = new SimplePrincipalCollection(identity, realmName);
        Subject subject = new Subject.Builder().principals(principals).buildSubject();
        return subject;
    }


}
