package com.emp.utils;

import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.emp.entity.User;
import com.emp.service.UserService;

/**
 * 认证(登录)
 * 授权的核心业务逻辑
 */
public class MyRealm extends AuthorizingRealm {
	 
	@Autowired
	private UserService userService;
 
	/**
	 * 授权方法
	 */
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		
		/**
		 * 注意principals.getPrimaryPrincipal()对应
		 * new SimpleAuthenticationInfo(user.getUserName(), user.getPassword(), getName())的第一个参数
		 */
	
		//获取当前身份
		String username = (String) principals.getPrimaryPrincipal();
		//授权验证对象,需要但前登录用户所有的角色和权限信息
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		
		//从数据库中查找该用户有何角色和权限
		Set<String> roles = userService.getRoles(username);
		Set<String> permissions = userService.getPermissions(username);
		
		//为当前用户赋予对应角色和权限
		info.setRoles(roles);
		info.setStringPermissions(permissions);
		//由info去判断用户是否有访问某个资源
		//或者做某种操作的权限
		return info;
	}
 
	/**
	 * 认证方法
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//获取用户名
		String username = (String) token.getPrincipal();
		
		//从数据库中查找用户信息
		User user = userService.getByUserName(username);
		if (user == null) {
			return null;			
		}
		AuthenticationInfo info = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
		return info;
	}

}
