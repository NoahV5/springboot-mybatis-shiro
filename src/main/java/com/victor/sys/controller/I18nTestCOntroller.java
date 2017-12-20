package com.victor.sys.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Aaron on 2017/12/20.
 */
@Controller
@RequestMapping("/i18n")
public class I18nTestCOntroller {

	private Logger logger  = LoggerFactory.getLogger(I18nTestCOntroller.class);

	@RequestMapping("/hello")
	public String hello(){
		logger.info("测试I18N");
		return  "/i18nDemo";
	}
}
