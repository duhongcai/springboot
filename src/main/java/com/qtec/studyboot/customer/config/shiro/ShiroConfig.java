package com.qtec.studyboot.customer.config.shiro;

import com.qtec.studyboot.customer.security.realm.ShiroRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by duhc on 2017/11/23.
 */
@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager);
        //拦截器
        Map<String, String> filterCharinDefinitionMap = new LinkedHashMap<>();
        //首先配置不需要拦截的路径 执行逻辑是先匹配上面的，
        // 如果上面的匹配就按照当前，不再往下寻找
        filterCharinDefinitionMap.put("/js/**", "anon");
        filterCharinDefinitionMap.put("/css/**", "anon");
        filterCharinDefinitionMap.put("/captcha","anon");
        filterCharinDefinitionMap.put("/favicon.ico","anon");
        filterCharinDefinitionMap.put("/register","anon");
        //配置登出的处理方式
        filterCharinDefinitionMap.put("/logout", "logout");
        filterCharinDefinitionMap.put("/list","roles[admin]");
        //范围最大的要放在最下面
        filterCharinDefinitionMap.put("/**", "authc");

        //设置处理逻辑生效
        factoryBean.setLoginUrl("/login");
//        factoryBean.setSuccessUrl("/customer/person");
        factoryBean.setUnauthorizedUrl("/customer/403");
        factoryBean.setFilterChainDefinitionMap(filterCharinDefinitionMap);
        return factoryBean;
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm());
        return securityManager;
    }

    @Bean
    public ShiroRealm shiroRealm() {
        ShiroRealm shiroRealm = new ShiroRealm();
        return shiroRealm;
    }
}

