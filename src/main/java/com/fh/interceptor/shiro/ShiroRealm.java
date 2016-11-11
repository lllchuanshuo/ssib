package com.fh.interceptor.shiro;


import com.fh.entity.system.User;
import com.fh.service.system.user.UserService;
import com.fh.util.PageData;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;


public class ShiroRealm extends AuthorizingRealm {

	@Resource
	private UserService userService;

	/*
	 * 登录信息和用户验证信息验证(non-Javadoc)
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {

		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;

		PageData user  = userService.findByLoginName(token.getUsername());
		if(user == null){
			throw new UnknownAccountException();// 账号不存在
		}


		// 认证缓存信息
		return new SimpleAuthenticationInfo(user, user.getString("PASSWORD").toCharArray(), getName());
	     
	}
	
	/*
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用,负责在应用程序中决定用户的访问控制的方法(non-Javadoc)
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {


		return null;
	}

}
