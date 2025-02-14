package org.example.proxy.mgr.service;



import org.example.proxy.model.entity.system.SysPost;
import org.example.proxy.model.query.system.SysPostQuery;
import org.example.proxy.model.vo.base.PageVo;

import java.util.List;

public interface SysPostService {

    SysPost getById(Long id);

    void save(SysPost sysPost);

    void update(SysPost sysPost);

    void remove(Long id);

    PageVo<SysPost> findPage(Long page, Long limit, SysPostQuery sysPostQuery);

    void updateStatus(Long id, Integer status);

    List<SysPost> findAll();
}
