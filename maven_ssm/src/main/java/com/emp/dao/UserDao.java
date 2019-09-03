package com.emp.dao;

import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.emp.entity.User;

public interface UserDao {
	
	/**
	 *  通过用户名查找用户
	 *  @param username
	 *  @return User
	 */
	@Select("select id,username,password,role_id from s_user where username=#{username}")
	public User getByUserName(@Param("username") String username);
	
	/**
	 *  通过用户名查找该用户所有的角色并保存在Set集合中
	 *  @param username
	 *  @return Set<String> 返回值类型是Shiro框架定义的
	 */	
	@Select("select r.rolename  from s_user u inner join "
			+ " s_role r on u.role_id=r.id "
			+ "where u.username=#{username}")
	public Set<String> getRoles(@Param("username")String username);
	
	/**
	 *  通过用户名查找该用户所有的权限并保存在Set集合中
	 *  @param username
	 *  @return Set<String>
	 */	 
	@Select("select p.permission_name "
			+ "from s_user u inner join  s_role r on u.role_id=r.id "
			+ "inner join s_permission p on p.role_id=r.id  "
			+ "where u.username=#{username}")
	public Set<String> getPermissions(@Param("username")String username);

}
