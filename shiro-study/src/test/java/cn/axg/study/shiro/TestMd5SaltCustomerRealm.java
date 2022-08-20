package cn.axg.study.shiro;

import cn.axg.study.shiro.config.Md5SaltCustomerRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class TestMd5SaltCustomerRealm {

    @Test
    public void test() {
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        Md5SaltCustomerRealm realm = new Md5SaltCustomerRealm();
        //设置realm与凭证匹配器
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("md5");
        realm.setCredentialsMatcher(credentialsMatcher);

        securityManager.setRealm(realm);
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        //因为传入的密码没有数据库中经过MD5加密后的密码不匹配，所以就不能登陆
        UsernamePasswordToken token = new UsernamePasswordToken("jack", "123");
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("用户名错误");
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            System.out.println("密码错误");
        }


    }

}
