package org.example.proxy.customer.service;


import org.example.proxy.model.form.customer.ExpectOrderForm;
import org.example.proxy.model.form.customer.SubmitOrderForm;
import org.example.proxy.model.form.map.CalculateDrivingLineForm;
import org.example.proxy.model.form.payment.CreateWxPaymentForm;
import org.example.proxy.model.vo.base.PageVo;
import org.example.proxy.model.vo.customer.ExpectOrderVo;
import org.example.proxy.model.vo.driver.DriverInfoVo;
import org.example.proxy.model.vo.map.DrivingLineVo;
import org.example.proxy.model.vo.map.OrderLocationVo;
import org.example.proxy.model.vo.map.OrderServiceLastLocationVo;
import org.example.proxy.model.vo.order.CurrentOrderInfoVo;
import org.example.proxy.model.vo.order.OrderInfoVo;
import org.example.proxy.model.vo.payment.WxPrepayVo;

public interface OrderService {

    //预估订单数据
    ExpectOrderVo expectOrder(ExpectOrderForm expectOrderForm);

    //乘客下单
    Long submitOrder(SubmitOrderForm submitOrderForm);

    //查询订单状态
    Integer getOrderStatus(Long orderId);

    //乘客查找当前订单
    CurrentOrderInfoVo searchCustomerCurrentOrder(Long customerId);

    OrderInfoVo getOrderInfo(Long orderId, Long customerId);

    DriverInfoVo getDriverInfo(Long orderId, Long customerId);

    OrderLocationVo getCacheOrderLocation(Long orderId);

    DrivingLineVo calculateDrivingLine(CalculateDrivingLineForm calculateDrivingLineForm);

    OrderServiceLastLocationVo getOrderServiceLastLocation(Long orderId);

    PageVo findCustomerOrderPage(Long customerId, Long page, Long limit);

    WxPrepayVo createWxPayment(CreateWxPaymentForm createWxPaymentForm);

    Boolean queryPayStatus(String orderNo);
}
