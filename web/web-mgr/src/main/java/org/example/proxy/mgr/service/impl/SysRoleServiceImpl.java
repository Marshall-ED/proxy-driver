package org.example.proxy.mgr.service.impl;


import org.example.proxy.mgr.service.SysRoleService;
import org.example.proxy.model.entity.system.SysRole;
import org.example.proxy.model.query.system.SysRoleQuery;
import org.example.proxy.model.vo.base.PageVo;
import org.example.proxy.model.vo.system.AssginRoleVo;
import org.example.proxy.system.client.SysRoleFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleFeignClient sysRoleFeignClient;

    @Override
    public SysRole getById(Long id) {
        return sysRoleFeignClient.getById(id).getData();
    }

    @Override
    public void save(SysRole sysRole) {
        sysRoleFeignClient.save(sysRole);
    }

    @Override
    public void update(SysRole sysRole) {
        sysRoleFeignClient.update(sysRole);
    }

    @Override
    public void remove(Long id) {
        sysRoleFeignClient.remove(id);
    }

    @Override
    public PageVo<SysRole> findPage(Long page, Long limit, SysRoleQuery roleQuery) {
        return sysRoleFeignClient.findPage(page,limit, roleQuery).getData();
    }

    @Override
    public void batchRemove(List<Long> idList) {
        sysRoleFeignClient.batchRemove(idList);
    }

    @Override
    public Map<String, Object> toAssign(Long userId) {
        return sysRoleFeignClient.toAssign(userId).getData();
    }

    @Override
    public void doAssign(AssginRoleVo assginRoleVo) {
        sysRoleFeignClient.doAssign(assginRoleVo);
    }

    @Override
    public List<SysRole> findAll() {
        return sysRoleFeignClient.findAll().getData();
    }
}
