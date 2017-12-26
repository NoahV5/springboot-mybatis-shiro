package com.victor.weixin.servlet;

import com.victor.common.utils.weixin.SignUtil;
import com.victor.weixin.service.WxCoreService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Aaron on 2017/12/21.
 * Springboot注入微信接入的Servlet
 */
//不指定name的情况下,name默认值为类的全路径,即org.springboot.sample.servlet.WechatServlet
@WebServlet(urlPatterns = "/coreServlet",description = "Servlet说明")
public class WechatServlet extends HttpServlet{

	private static final long serialVersionUID = -8685285401859800066L;

	/**
	 * 确认请求来自微信服务器
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 微信加密签名
		String signature = request.getParameter("signature");
		System.out.println("微信加密签名signature：-----------------------"+signature);
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		System.out.println("时间戳timestamp：-----------------------"+timestamp);
		// 随机数
		String nonce = request.getParameter("nonce");
		System.out.println("随机数nonce：-----------------------"+nonce);
		// 随机字符串
		String echostr = request.getParameter("echostr");
		System.out.println("随机字符串echostr：-----------------------"+echostr);
		//System.out.println("token-----------------------:"+token);

		PrintWriter out = response.getWriter();
		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
		if (SignUtil.checkSignature("weixinCourse", signature, timestamp, nonce)) {
			out.print(echostr);
			//System.out.println("这是："+echostr);
		}
		out.close();
		out = null;
	}

	/**
	 *  处理微信服务器发来的消息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 调用核心业务类接收消息、处理消息
		String respMessage = WxCoreService.processRequest(request);

		// 响应消息
		PrintWriter out = response.getWriter();
		out.print(respMessage);
		out.close();

	}
}

