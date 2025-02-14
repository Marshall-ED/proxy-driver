package org.example.proxy.system.service;


import com.baomidou.mybatisplus.extension.service.IService;
import org.example.proxy.model.entity.system.SysDept;

import java.util.List;

public interface SysDeptService extends IService<SysDept> {

    List<SysDept> findNodes();

    List<SysDept> findUserNodes();

    void updateStatus(Long id, Integer status);
}
