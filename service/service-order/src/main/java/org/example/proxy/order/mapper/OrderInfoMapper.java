package org.example.proxy.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.proxy.model.entity.order.OrderInfo;
import org.example.proxy.model.vo.order.OrderListVo;
import org.example.proxy.model.vo.order.OrderPayVo;

@Mapper
public interface OrderInfoMapper extends BaseMapper<OrderInfo> {

    ////获取乘客订单分页列表
    IPage<OrderListVo> selectCustomerOrderPage(Page<OrderInfo> pageParam, Long customerId);

    IPage<OrderListVo> selectDriverOrderPage(Page<OrderInfo> pageParam, Long driverId);

    OrderPayVo selectOrderPayVo(@Param("orderNo") String orderNo,
                                @Param("customerId") Long customerId);
}
