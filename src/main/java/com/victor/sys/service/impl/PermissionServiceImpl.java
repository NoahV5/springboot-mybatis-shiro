package com.victor.sys.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.victor.sys.entity.Menu;
import com.victor.sys.entity.Permission;
import com.victor.sys.mapper.PermissionMapper;
import com.victor.sys.service.IPermissionService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * permission 权限表 服务实现类
 * </p>
 *
 * @author Victor
 * @since 2017-12-16
 */
@SuppressWarnings("all")
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

    /**
     * 查询子菜单
     * @param uid 用户ID
     * @return
     */
    @Override
    public List<Permission> findSubMenu(Long uid, Long pid) {
        return permissionMapper.findSubMenu(uid,pid);
    }
    /**
     * 获取用户拥有权限的按钮
     * @param currentLoginId
     * @return
     */
    @Override
    public List<Menu> createMenu(Long currentLoginId) {
        // 创建菜单对象
        List<Menu> menus = new ArrayList<>();

        // 查询父菜单
        List<Permission> parentMenu = baseMapper.findParentMenu(currentLoginId);
        parentMenu.forEach(p -> {
            Menu menu = new Menu();
            BeanUtils.copyProperties(p, menu);
            menus.add(menu);
        });

        // 查询子菜单
        menus.forEach(m -> {
            List<Menu> temp = new ArrayList<>();
            List<Permission> children = baseMapper.findSubMenu(currentLoginId, m.getId());
            children.forEach(c -> {
                Menu menu = new Menu();
                BeanUtils.copyProperties(c, menu);
                temp.add(menu);
            });
            m.setChildren(temp);
        });
        return menus;
    }
}
