package com.victor.common.exception;

import javax.servlet.http.HttpServletRequest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * Created by Aaron on 2017/12/15.
 */
@ControllerAdvice
public class MyGolbalDefaultExceptionHander {

	/**
	 * 处理异常
	 * @param request
	 * @param e
	 */
	@Transactional
	public void defaultExceptionHander(HttpServletRequest request,Exception e){
		//TODO
		e.printStackTrace();
		System.out.println("处理异常类");
	}
}
