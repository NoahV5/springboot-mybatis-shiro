package com.victor.sys.service;


import com.baomidou.mybatisplus.service.IService;
import com.victor.sys.entity.Menu;
import com.victor.sys.entity.Permission;

import java.util.List;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 查询子菜单
     * @param uid 用户ID
     * @param pid 父ID
     * @return
     */
    List<Permission> findSubMenu(@Param("uid")Long uid, @Param("pid")Long pid);

    /**
     * 获取用户拥有权限的按钮
     * @param currentLoginId
     * @return
     */
    List<Menu> createMenu(Long currentLoginId);
}
