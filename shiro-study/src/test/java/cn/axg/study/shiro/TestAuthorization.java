package cn.axg.study.shiro;

import cn.axg.study.shiro.config.Md5SaltHashCustomerRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

import java.util.Arrays;

/**
 * 测试授权
 */
public class TestAuthorization {

    //授权是在认证的基础上做的，所以一定要先认证通过才可以授权
    @Test
    public void test(){
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        Md5SaltHashCustomerRealm realm = new Md5SaltHashCustomerRealm();
        //设置realm与凭证匹配器
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("md5");
        credentialsMatcher.setHashIterations(2048);
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

        //授权
        if(subject.isAuthenticated()){
            //基于单角色的判断
            System.out.println(subject.hasRole("admin"));
            //基于多角色的判断
            boolean[] booleans = subject.hasRoles(Arrays.asList("admin", "user", "super"));
            for (int i = 0; i < booleans.length; i++) {
                System.out.println(booleans[i]);
            }
            //所有角色都具有才会返回true
            System.out.println(subject.hasAllRoles(Arrays.asList("admin", "user", "super")));

            //基于权限字符串的访问控制  资源标识符:操作:类型
            System.out.println(subject.isPermitted("user:*:*"));

        }

    }

}
