package com.dream.dream.businesscenter.service.util;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.dream.dream.businesscenter.service.BusinessCenterService;
import com.dream.dream.businesscenter.service.module.user.model.User;
import com.dream.dream.businesscenter.service.module.user.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = BusinessCenterService.class)
@WebAppConfiguration
public class Test {

	@Autowired
	private UserService userService;
	
	@org.junit.Test 
    public void testApp() {
        List<User> list = userService.getUser();
        System.out.println("the result is......");
    }
}
