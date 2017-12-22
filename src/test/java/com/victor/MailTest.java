package com.victor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Aaron on 2017/12/20.
 * 发邮件Demo测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MailTest {

	@Autowired
	private JavaMailSender mailSender;

	/**
	 * 修改application.properties的用户，才能发送。
	 */
	@Test
	public void sendSimpleEmail(){
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("15989040320@139.com");//发送者.
		message.setTo("1375338333@qq.com");//接收者.
		message.setSubject("测试邮件（邮件主题）");//邮件主题.
		message.setText("这是邮件内容");//邮件内容.
		mailSender.send(message);//发送邮件
	}
}