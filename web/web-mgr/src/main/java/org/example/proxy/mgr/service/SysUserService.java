package org.example.proxy.mgr.service;


import org.example.proxy.model.entity.system.SysUser;
import org.example.proxy.model.query.system.SysUserQuery;
import org.example.proxy.model.vo.base.PageVo;

public interface SysUserService {

    SysUser getById(Long id);

    void save(SysUser sysUser);

    void update(SysUser sysUser);

    void remove(Long id);

    PageVo<SysUser> findPage(Long page, Long limit, SysUserQuery sysUserQuery);

    void updateStatus(Long id, Integer status);


}
