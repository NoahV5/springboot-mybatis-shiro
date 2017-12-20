package com.victor.test;

import com.baomidou.mybatisplus.plugins.Page;
import com.victor.sys.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Aaron on 2017/12/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestDemo {

	@Autowired
	private IUserService userService;

	@Test
	public void testPage(){

		Page page = new Page();
		page.setCurrent(1);
		page.setSize(10);
		page.setTotal(10);
		page = userService.selectUserList(page, 1);
		System.out.println(page);
	}
}
