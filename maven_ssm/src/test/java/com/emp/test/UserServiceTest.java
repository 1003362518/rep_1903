package com.emp.test;

import static org.junit.Assert.fail;

import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.emp.entity.User;
import com.emp.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration({"classpath:applicationContext.xml"})
public class UserServiceTest {
	//注入业务层对象

	@Resource
	private UserService userService;
	  
	@Test
	public void testGetByUserName() {
		User user=userService.getByUserName("zs");
		System.out.println(user);
	}

	@Test
	public void testGetRoles() {
		Set<String> roles=userService.getRoles("zs");
		System.out.println(roles);
	}

	@Test
	public void testGetPermissions() {
		Set<String> per=userService.getPermissions("ls");
		System.out.println(per);
	}

}
