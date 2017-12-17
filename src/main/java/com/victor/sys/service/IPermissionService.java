package com.victor.sys.service;


import com.baomidou.mybatisplus.service.IService;
import com.victor.sys.entity.Permission;

import java.util.List;

/**
 * <p>
 * permission 权限表 服务类
 * </p>
 *
 * @author Victor
 * @since 2017-12-16
 */
public interface IPermissionService extends IService<Permission> {

    /**
     * 用户拥有的权限
     * @param uid
     * @return 权限集合
     */
    List<Permission> findUserPermission(Long uid);
	
}
