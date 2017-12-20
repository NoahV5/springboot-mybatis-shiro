package com.victor.sys.service;


import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.service.IService;
import com.victor.sys.entity.User;
import java.util.List;

/**
 * <p>
 * user 用户表 服务类
 * </p>
 *
 * @author Victor
 * @since 2017-12-16
 */
public interface IUserService extends IService<User> {

	/**
	 * <p>
	 * 查询 : 根据state状态查询用户列表，分页显示
	 * </p>
	 *
	 * @param page
	 *            翻页对象，可以作为 xml 参数直接使用，传递参数 Page 即自动分页
	 * @param state
	 *            状态
	 * @return
	 */
	Page<User> selectUserList(Page<User> page, Integer state);

}
