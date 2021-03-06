package com.qtec.studyboot.customer.security.realm;

import com.qtec.studyboot.customer.entity.Customer;
import com.qtec.studyboot.customer.service.CustomerService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by duhc on 2017/11/23.
 */
public class ShiroRealm extends AuthorizingRealm{

    @Autowired
    CustomerService customerService;

    /**
     * 登录验证 需要进行权限验证时才会调用---校验密码是否相同
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // TODO 获取用户名并根据用户名从数据源中获取用户校验信息
        String loginNm = (String) token.getPrincipal();
        Customer customer = customerService.getCustomerByName(loginNm);
        if (customer == null){
            throw  new AuthenticationException("该用户不存在");
        }
        //组装该用户数据
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(customer,customer.getPassword(),getName());
        return authenticationInfo;
    }

    /**
     * 授权 需要进行权限验证时才回调用
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo  info = new SimpleAuthorizationInfo();
        //获取登录对象--应该是组装用户数据的时候放进去的？？
        Customer customer = (Customer) principals.getPrimaryPrincipal();
        //TODO 获取登录对象的权限信息--从数据库或者缓存
        if (customer!=null && customer.getLevel() == 5){
            info.addRole("admin");
        }
        return info;
    }
}
