package org.example.proxy.system.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.proxy.model.entity.system.SysLoginLog;
import org.example.proxy.model.query.system.SysLoginLogQuery;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysLoginLogMapper extends BaseMapper<SysLoginLog> {

    IPage<SysLoginLog> selectPage(Page<SysLoginLog> page, @Param("query") SysLoginLogQuery sysLoginLogQuery);

}
