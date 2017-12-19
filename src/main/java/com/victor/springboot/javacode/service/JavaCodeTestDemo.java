package com.victor.springboot.javacode.service;

import com.victor.sys.service.IUserService;
import javax.annotation.Resource;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Aaron on 2017/12/19.
 */
@Controller
@RequestMapping("/admin2")
public class JavaCodeTestDemo {

	@Resource(name = "javaCode")
	private JavaCodeService javaCode;

	@Resource(name = "javaCode2")
	private JavaCodeService javaCode2;

	@Resource
	private IUserService userService;
	@Test
	public void testDemo(){
		System.out.println(userService);
		javaCode.display();
		javaCode2.display();
	}
}
