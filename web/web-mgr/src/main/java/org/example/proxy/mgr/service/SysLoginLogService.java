package org.example.proxy.mgr.service;


import org.example.proxy.model.entity.system.SysLoginLog;
import org.example.proxy.model.query.system.SysLoginLogQuery;
import org.example.proxy.model.vo.base.PageVo;

public interface SysLoginLogService {

    PageVo<SysLoginLog> findPage(Long page, Long limit, SysLoginLogQuery sysLoginLogQuery);

    /**
     * 记录登录信息
     *
     * @param sysLoginLog
     * @return
     */
    void recordLoginLog(SysLoginLog sysLoginLog);

    SysLoginLog getById(Long id);
}
