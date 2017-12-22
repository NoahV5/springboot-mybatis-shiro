package com.victor.weixin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Aaron on 2017/12/22.
 */
@Controller
@RequestMapping("/weixin/mes")
public class MessageController {

	/**
	 * 处理微信服务器发来的消息
	 */
	@RequestMapping("/handle")
	public void handleWxMessage(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 调用核心业务类接收消息、处理消息
		String respMessage = CoreService.processRequest(request);

		// 响应消息
		PrintWriter out = response.getWriter();
		out.print(respMessage);
		out.close();
	}

}
