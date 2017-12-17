package com.victor.sys.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.victor.sys.entity.Role;
import com.victor.sys.mapper.RoleMapper;
import com.victor.sys.service.IRoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * role 角色表 服务实现类
 * </p>
 *
 * @author Victor
 * @since 2017-12-16
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
	
}
