package org.example.proxy.customer.service;



import org.example.proxy.model.vo.base.PageVo;
import org.example.proxy.model.vo.coupon.AvailableCouponVo;
import org.example.proxy.model.vo.coupon.NoReceiveCouponVo;
import org.example.proxy.model.vo.coupon.NoUseCouponVo;
import org.example.proxy.model.vo.coupon.UsedCouponVo;

import java.util.List;

public interface CouponService  {

    PageVo<NoReceiveCouponVo> findNoReceivePage(Long customerId, Long page, Long limit);

    PageVo<NoUseCouponVo> findNoUsePage(Long customerId, Long page, Long limit);

    Boolean receive(Long customerId, Long couponId);

    List<AvailableCouponVo> findAvailableCoupon(Long customerId, Long orderId);

    PageVo<UsedCouponVo> findUsedPage(Long customerId, Long page, Long limit);
}
