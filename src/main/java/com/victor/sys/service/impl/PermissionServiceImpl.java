package com.victor.sys.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.victor.sys.entity.Permission;
import com.victor.sys.mapper.PermissionMapper;
import com.victor.sys.service.IPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * permission 权限表 服务实现类
 * </p>
 *
 * @author Victor
 * @since 2017-12-16
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

    @Resource
    private PermissionMapper permissionMapper;

    /**
     * 用户拥有的权限
     * @param uid
     * @return 权限集合
     */
    @Override
    public List<Permission> findUserPermission(Long uid) {
        return permissionMapper.findUserPermission(uid);
    }
}
