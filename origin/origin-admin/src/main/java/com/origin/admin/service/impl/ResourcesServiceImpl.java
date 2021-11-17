package com.origin.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.origin.admin.entity.bo.ResourceBo;
import com.origin.admin.entity.po.Resources;
import com.origin.admin.mapper.ResourcesMapper;
import com.origin.admin.service.IResourcesService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 媒体资源 服务实现类
 * </p>
 *
 * @author MrTen
 * @since 2021-11-17
 */
@Service
public class ResourcesServiceImpl extends ServiceImpl<ResourcesMapper, Resources> implements IResourcesService {

    @Override
    public Boolean save(ResourceBo resource) {
        Resources resources = new Resources();
        BeanUtils.copyProperties(resource, resources);
        resources.setCreateTime(new Date());
        if(resources.getLocation()==null){
            resources.setLocation(0);
        }
        return save(resources);
    }

    @Override
    public Boolean del(Long id) {
        return removeById(id);
    }


}
