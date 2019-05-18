package com.geek.lyb.client;


import com.geek.lyb.client.service.UserInfoService;
import com.geek.lyb.demo.mongo.model.Address;
import com.geek.lyb.demo.mongo.model.UserInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoTests {

	@Autowired
	@Qualifier("userInfoService")
	private UserInfoService userInfoService;


	@Test
	public void testSaveUserInfo(){
		UserInfo info = UserInfo.builder()
				.address(Address.builder().addressName("风云阁20号").floor(20).build())
				.idCard("2222")
				.mobile("18800000003")
				.realName("王五")
				.sex("男")
				.createTime(new Date())
				.updateTime(new Date())
				.build();

		boolean flag = userInfoService.saveUserInfo(info);

		Assert.assertTrue(flag);
	}

	@Test
	public void testUpdateUserInfo(){
		UserInfo info = UserInfo.builder().id(1L).idCard("bbbb").updateTime(new Date()).build();

		boolean flag = userInfoService.saveUserInfo(info);

		Assert.assertTrue(flag);
	}
//
//
	@Test
	public void testDeleteById(){
		boolean flag = userInfoService.deleteUserInfoById(1L);
		Assert.assertTrue(flag);
	}

//
	@Test
	public void testList(){
		List<UserInfo> userInfos = userInfoService.findAll();

		Assert.assertNotNull(userInfos);

		userInfos.forEach(userInfo-> System.out.println(userInfo));
	}
//
	@Test
	public void testListByUserName(){
		List<UserInfo> userInfos = userInfoService.findAllByRealName("王");

		Assert.assertNotNull(userInfos);

		userInfos.forEach(userInfo-> System.out.println(userInfo));
	}

}
