package com.victor.sys.service.impl;


import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.victor.sys.entity.User;
import com.victor.sys.mapper.UserMapper;
import com.victor.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * user 用户表 服务实现类
 * </p>
 *
 * @author Victor
 * @since 2017-12-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public Page<User> selectUserList(Page<User> page, Integer status) {
		page.setRecords(userMapper.selectUserList(page, status));
		return page;
	}
}
