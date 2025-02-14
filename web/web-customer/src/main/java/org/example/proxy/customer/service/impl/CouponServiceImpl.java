package org.example.proxy.customer.service.impl;


import lombok.extern.slf4j.Slf4j;
import org.example.proxy.coupon.client.CouponFeignClient;
import org.example.proxy.customer.service.CouponService;
import org.example.proxy.model.vo.base.PageVo;
import org.example.proxy.model.vo.coupon.AvailableCouponVo;
import org.example.proxy.model.vo.coupon.NoReceiveCouponVo;
import org.example.proxy.model.vo.coupon.NoUseCouponVo;
import org.example.proxy.model.vo.coupon.UsedCouponVo;
import org.example.proxy.model.vo.order.OrderBillVo;
import org.example.proxy.order.client.OrderInfoFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@SuppressWarnings({"unchecked", "rawtypes"})
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponFeignClient couponFeignClient;

    @Autowired
    private OrderInfoFeignClient orderInfoFeignClient;

    @Override
    public Boolean receive(Long customerId, Long couponId) {
        return couponFeignClient.receive(customerId, couponId).getData();
    }

    @Override
    public List<AvailableCouponVo> findAvailableCoupon(Long customerId, Long orderId) {
        OrderBillVo orderBillVo = orderInfoFeignClient.getOrderBillInfo(orderId).getData();
        return couponFeignClient.findAvailableCoupon(customerId,
                orderBillVo.getPayAmount()).getData();
    }

    @Override
    public PageVo<NoReceiveCouponVo> findNoReceivePage(Long customerId, Long page, Long limit) {
        return couponFeignClient.findNoReceivePage(customerId, page, limit).getData();
    }

    @Override
    public PageVo<NoUseCouponVo> findNoUsePage(Long customerId, Long page, Long limit) {
        return couponFeignClient.findNoUsePage(customerId, page, limit).getData();
    }

    @Override
    public PageVo<UsedCouponVo> findUsedPage(Long customerId, Long page, Long limit) {
        return couponFeignClient.findUsedPage(customerId, page, limit).getData();
    }
}
