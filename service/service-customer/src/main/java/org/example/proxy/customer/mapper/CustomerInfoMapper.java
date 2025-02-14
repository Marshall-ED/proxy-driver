package org.example.proxy.customer.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.proxy.model.entity.customer.CustomerInfo;

@Mapper
public interface CustomerInfoMapper extends BaseMapper<CustomerInfo> {

}
