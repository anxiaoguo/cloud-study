package cn.axg.study.shiro.config;

import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 用来整合SpringBoot的Shiro配置
 */
@Configuration
public class ShiroConfig {

    //创建ShiroFilter
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //配置系统受限资源
        //配置系统公共资源
        //key表示资源的路径，value表示受限的类型
        Map<String,String> filterMap = new HashMap<>();
        filterMap.put("/user/login","anon");
        filterMap.put("/user/index","authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        shiroFilterFactoryBean.setLoginUrl("/user/login");
        return shiroFilterFactoryBean;
    }

    //创建安全管理器
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("getRealm") Realm realm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);
        return securityManager;
    }

    //创建自定义Realm,同时设置凭证匹配器
    @Bean
    public Realm getRealm(CredentialsMatcher sha1CredentialsMatcher){
        Md5SaltHashCustomerRealm md5SaltHashCustomerRealm = new Md5SaltHashCustomerRealm();
        md5SaltHashCustomerRealm.setCredentialsMatcher(sha1CredentialsMatcher);

        //开启缓存管理（ehcache缓存，存在应用服务器）
        md5SaltHashCustomerRealm.setCacheManager(new EhCacheManager());
        md5SaltHashCustomerRealm.setCachingEnabled(true);//全局缓存
        md5SaltHashCustomerRealm.setAuthenticationCachingEnabled(true);//开启认证缓存
        md5SaltHashCustomerRealm.setAuthenticationCacheName("authenticationCache");//给缓存取个名字
        md5SaltHashCustomerRealm.setAuthorizationCachingEnabled(true);//开启授权缓存
        md5SaltHashCustomerRealm.setAuthorizationCacheName("authorizationCache");

        return md5SaltHashCustomerRealm;
    }

    /**
     * 获取md5凭证匹配器
     * @return 凭证匹配器
     */

    @Bean
    public CredentialsMatcher md5CredentialsMatcher(){
        HashedCredentialsMatcher credentialsMatcher=new HashedCredentialsMatcher();
        //用的是MD5算法
        credentialsMatcher.setHashAlgorithmName(Md5Hash.ALGORITHM_NAME);
        //迭代次数
        credentialsMatcher.setHashIterations(2048);
        return credentialsMatcher;
    }


}
