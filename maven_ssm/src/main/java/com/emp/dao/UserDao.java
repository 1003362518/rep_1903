package com.emp.dao;

import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.emp.entity.User;

public interface UserDao {
	
	/**
	 *  ͨ���û��������û�
	 *  @param username
	 *  @return User
	 */
	@Select("select id,username,password,role_id from s_user where username=#{username}")
	public User getByUserName(@Param("username") String username);
	
	/**
	 *  ͨ���û������Ҹ��û����еĽ�ɫ��������Set������
	 *  @param username
	 *  @return Set<String> ����ֵ������Shiro��ܶ����
	 */	
	@Select("select r.rolename  from s_user u inner join "
			+ " s_role r on u.role_id=r.id "
			+ "where u.username=#{username}")
	public Set<String> getRoles(@Param("username")String username);
	
	/**
	 *  ͨ���û������Ҹ��û����е�Ȩ�޲�������Set������
	 *  @param username
	 *  @return Set<String>
	 */	 
	@Select("select p.permission_name "
			+ "from s_user u inner join  s_role r on u.role_id=r.id "
			+ "inner join s_permission p on p.role_id=r.id  "
			+ "where u.username=#{username}")
	public Set<String> getPermissions(@Param("username")String username);

}
