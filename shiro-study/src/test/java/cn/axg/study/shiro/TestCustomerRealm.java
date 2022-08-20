package cn.axg.study.shiro;

import cn.axg.study.shiro.config.CustomerRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class TestCustomerRealm {


    @Test
    public void test() {
        //1.获取安全管理器
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        //2.给安全管理器设置realm
        securityManager.setRealm(new CustomerRealm());
        //3.SecurityUtils 设置安全管理器
        SecurityUtils.setSecurityManager(securityManager);
        //4.获取主体subject
        Subject subject = SecurityUtils.getSubject();
        //5.创建token
        UsernamePasswordToken token = new UsernamePasswordToken("jack", "123");
        //6.subject认证
        try {
            System.out.println("==========================");
            subject.login(token);
            System.out.println(subject.isAuthenticated());
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("用户名错误");
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            System.out.println("密码错误");
        }

    }

}
