package org.example.proxy.driver.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.proxy.model.entity.driver.DriverAccount;

import java.math.BigDecimal;

@Mapper
public interface DriverAccountMapper extends BaseMapper<DriverAccount> {

    //2 添加奖励到司机账户表
    void add(@Param("driverId") Long driverId, @Param("amount") BigDecimal amount);
}
