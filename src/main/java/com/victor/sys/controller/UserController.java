package com.victor.sys.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.victor.common.controller.BaseController;
import com.victor.common.result.JsonResult;
import com.victor.common.utils.StringUtil;
import com.victor.sys.entity.Role;
import com.victor.sys.entity.User;
import com.victor.sys.service.IRoleService;
import com.victor.sys.service.IUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * user 用户表 前端控制器
 * </p>
 *
 * @author Victor
 * @since 2017-12-16
 */
@Controller
@RequestMapping("/admin/user")
public class UserController extends BaseController{

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;



    @RequiresPermissions("user:show")
    @RequestMapping("/list")
    public String list(Model model){
        EntityWrapper<Role> wrapper = new EntityWrapper<>();
        wrapper.or("sort", true);
        List<Role> allRole = roleService.selectList(wrapper);
        model.addAttribute("allRole", allRole);
        return "/admin/user/list";
    }

    /**
     * 用户列表展示
     * @param pageNumber
     * @param pageSize
     * @param searchText
     * @return
     */
    @RequestMapping("/getList")
    @ResponseBody
    public Map<String,Object> getList(int pageNumber, int pageSize, String searchText){

        Map<String,Object> result = new HashMap<String,Object>();
        Page<User> page = new Page<>(pageNumber, pageSize);
        EntityWrapper<User> wrapper = new EntityWrapper<>();
        if (StringUtil.isNotEmpty(searchText)) {
            wrapper.like("username", searchText);
        }
        Page<User> userPage = userService.selectPage(page, wrapper);
        result.put("total", userPage.getTotal());
        result.put("rows", userPage.getRecords());
        return result;
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("/addUser")
    public JsonResult addUser(User user){

        // 创建盐, 散列加密
        String salt = String.valueOf(System.currentTimeMillis());
        SimpleHash password = new SimpleHash("MD5", user.getPassword(), salt);
        user.setSalt(salt);
        user.setPassword(password.toString());
        try {
            userService.insert(user);
            return renderError("添加用户成功!");
        }catch (Exception e){
            e.printStackTrace();
            return renderError("添加用户失败");
        }
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateUser")
    public JsonResult updateUser(User user){

        try {
            userService.updateById(user);
            return renderError("修改用户成功!!");
        }catch (Exception e){
            e.printStackTrace();
            return renderError("修改用户失败!!");
        }

    }


}
