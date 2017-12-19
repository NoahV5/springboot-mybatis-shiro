package com.victor.sys.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.victor.sys.entity.Permission;

import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
  * permission 权限表 Mapper 接口
 * </p>
 *
 * @author Victor
 * @since 2017-12-16
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    /**
     * 查询用户拥有的权限集合
     * @param uid
     * @return
     */
    List<Permission> findUserPermission(Long uid);

    /**
     * 查询子菜单
     * @param uid 用户ID
     * @param pid 父ID
     * @return
     */
    List<Permission> findSubMenu(@Param("uid")Long uid, @Param("pid")Long pid);

}