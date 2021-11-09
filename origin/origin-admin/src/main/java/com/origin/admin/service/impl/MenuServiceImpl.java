package com.origin.admin.service.impl;

import com.origin.admin.entity.po.Menu;
import com.origin.admin.mapper.MenuMapper;
import com.origin.admin.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单权限表 服务实现类
 * </p>
 *
 * @author MrTen
 * @since 2021-11-09
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

}
