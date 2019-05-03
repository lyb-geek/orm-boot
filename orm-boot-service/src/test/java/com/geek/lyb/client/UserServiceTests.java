package com.geek.lyb.client;


import com.geek.lyb.client.service.UserService;
import com.geek.lyb.demo.orm.mybatis.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTests {

	@Autowired
	private UserService userService;


	@Test
	public void testSaveUser(){
		User user = User.builder()
				.userName("陈文茵").createTime(new Date()).updateTime(new Date())
				.deptName("oa产品部").domain("geek.lyb.cn").email("chenwenyin@geek.lyb.cn")
				.mobile("18800000005").sex("女").build();

		boolean flag = userService.saveUser(user);

		Assert.assertTrue(flag);
	}

	@Test
	public void testUpdateUser(){
		User user = User.builder().id(5L)
				.userName("陈文茵").updateTime(new Date())
				.deptName("oa产品部").domain("geek.lyb.test.cn").email("chenwenyin1@geek.lyb.cn")
				.mobile("18800000006").sex("女").build();

		boolean flag = userService.saveUser(user);

		Assert.assertTrue(flag);
	}


	@Test
	public void testDeleteById(){
        boolean flag = userService.deleteUserById(6L);
        Assert.assertTrue(flag);
	}


	@Test
	public void testList(){
		List<User> users = userService.findAll();

		Assert.assertNotNull(users);

		users.forEach(user-> System.out.println(user));
	}

	@Test
	public void testListByUserName(){
		List<User> users = userService.findAllByUserName("王");

		Assert.assertNotNull(users);

		users.forEach(user-> System.out.println(user));
	}

}
