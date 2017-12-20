package com.victor.sys.controller;

import com.victor.common.controller.BaseController;
import com.victor.common.result.JsonResult;
import com.victor.config.datasource.TargetDataSource;
import com.victor.sys.entity.Menu;
import com.victor.sys.entity.User;
import com.victor.sys.service.IPermissionService;
import com.victor.sys.service.IUserService;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Aaron on 2017/12/18.
 */
@Controller
@RequestMapping("/admin")
public class IndexController extends BaseController{

	private Logger logger = LoggerFactory.getLogger(IndexController.class);

	@Resource
	private IPermissionService permissionService;

	@Resource
	private IUserService userService;


	/**
	 * 跳转到登录页面
	 * @return
	 */
	@RequestMapping("/login")
	public String login(){
		return "/admin/login";
	}

	/**
	 * 登录成功后跳转到主页面
	 * @return
	 */
	@RequestMapping("/index")
	public String index(Model model){
		// 获取当前用户菜单
		List<Menu> menus = permissionService.createMenu(getCurrentLoginId());
		model.addAttribute("menus",menus);
		return "/admin/index";
	}

	@TargetDataSource(name = "test1")
	@RequestMapping("/test")
	@Transactional
	public void test2(){
		User user = new User();
		user.setUsername("testdatasource");
		userService.insert(user);
		logger.info("success");
	}



	/**
	 * 用户登录
	 * @return
	 */
	@RequestMapping("/mylogin")
	public String login(String username, String password, Map<String, Object> map,Model model,boolean rememberMe){
		Subject subject = SecurityUtils.getSubject();//获取当前用户
		UsernamePasswordToken token = new UsernamePasswordToken(username,password,rememberMe);
		JsonResult result = new JsonResult();
		try {
			subject.login(token);
		} catch (UnknownAccountException e) {
			result = this.renderError("用户不存在");
			model.addAttribute(result);
			return "/admin/login";
			}catch (IncorrectCredentialsException e){
			result = this.renderError("您输入的密码有误,请重新输入..");
			model.addAttribute(result);
			return "/admin/login";
		}
		boolean authenticated = subject.isAuthenticated();
		if (authenticated) {
			return "redirect:/admin/index.html";
		}
		return "/admin/index";
	}
}
