package org.example.proxy.coupon.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.proxy.model.entity.coupon.CouponInfo;
import org.example.proxy.model.form.coupon.UseCouponForm;
import org.example.proxy.model.vo.base.PageVo;
import org.example.proxy.model.vo.coupon.AvailableCouponVo;
import org.example.proxy.model.vo.coupon.NoReceiveCouponVo;
import org.example.proxy.model.vo.coupon.NoUseCouponVo;
import org.example.proxy.model.vo.coupon.UsedCouponVo;

import java.math.BigDecimal;
import java.util.List;

public interface CouponInfoService extends IService<CouponInfo> {

    PageVo<NoReceiveCouponVo> findNoReceivePage(Page<CouponInfo> pageParam, Long customerId);

    PageVo<NoUseCouponVo> findNoUsePage(Page<CouponInfo> pageParam, Long customerId);

    Boolean receive(Long customerId, Long couponId);

    List<AvailableCouponVo> findAvailableCoupon(Long customerId, BigDecimal orderAmount);

    BigDecimal useCoupon(UseCouponForm useCouponForm);

    PageVo<UsedCouponVo> findUsedPage(Page<CouponInfo> pageParam, Long customerId);
}
