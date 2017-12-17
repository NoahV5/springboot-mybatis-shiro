package com.victor.sys.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.victor.sys.entity.Permission;

import java.util.List;

/**
 * <p>
  * permission 权限表 Mapper 接口
 * </p>
 *
 * @author Victor
 * @since 2017-12-16
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    List<Permission> findUserPermission(Long uid);

}