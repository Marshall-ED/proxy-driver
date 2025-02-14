package org.example.proxy.mgr.service;


import org.example.proxy.model.entity.system.SysOperLog;
import org.example.proxy.model.query.system.SysOperLogQuery;
import org.example.proxy.model.vo.base.PageVo;

public interface SysOperLogService {

    PageVo<SysOperLog> findPage(Long page, Long limit, SysOperLogQuery sysOperLogQuery);

    /**
     * 保存系统日志记录
     */
    void saveSysLog(SysOperLog sysOperLog);

    SysOperLog getById(Long id);
}
