package com.victor.weixin.servlet;

import com.victor.weixin.utils.SignUtil;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Aaron on 2017/12/21.
 * Springboot注入微信接入的Servlet
 */
//不指定name的情况下,name默认值为类的全路径,即org.springboot.sample.servlet.WechatServlet
@WebServlet(urlPatterns = "wechat/myservlet",description = "Servlet说明")
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
		if (SignUtil.checkSignature("weixinTest", signature, timestamp, nonce)) {
			out.print(echostr);
			//System.out.println("这是："+echostr);
		}
		out.close();
		out = null;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}

