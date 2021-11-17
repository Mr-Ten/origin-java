package com.origin.admin.service;

import com.origin.admin.entity.bo.ResourceBo;
import com.origin.admin.entity.po.Resources;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 媒体资源 服务类
 * </p>
 *
 * @author MrTen
 * @since 2021-11-17
 */
public interface IResourcesService extends IService<Resources> {

    /**
     * 添加一条媒体记录
     * @param resource
     * @return
     */
    Boolean save(ResourceBo resource);

    /**
     * 根据id删除一条记录
     * @param id
     * @return
     */
    Boolean del(Long id);

}
