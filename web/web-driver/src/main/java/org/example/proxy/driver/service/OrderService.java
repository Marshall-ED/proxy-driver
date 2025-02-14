package org.example.proxy.driver.service;


import org.example.proxy.model.form.map.CalculateDrivingLineForm;
import org.example.proxy.model.form.order.OrderFeeForm;
import org.example.proxy.model.form.order.StartDriveForm;
import org.example.proxy.model.form.order.UpdateOrderCartForm;
import org.example.proxy.model.vo.base.PageVo;
import org.example.proxy.model.vo.map.DrivingLineVo;
import org.example.proxy.model.vo.order.CurrentOrderInfoVo;
import org.example.proxy.model.vo.order.NewOrderDataVo;
import org.example.proxy.model.vo.order.OrderInfoVo;

import java.util.List;

public interface OrderService {

    Integer getOrderStatus(Long orderId);

    List<NewOrderDataVo> findNewOrderQueueData(Long driverId);

    Boolean robNewOrder(Long driverId, Long orderId);

    CurrentOrderInfoVo searchDriverCurrentOrder(Long driverId);

    OrderInfoVo getOrderInfo(Long orderId, Long driverId);

    DrivingLineVo calculateDrivingLine(CalculateDrivingLineForm calculateDrivingLineForm);

    Boolean driverArriveStartLocation(Long orderId, Long driverId);

    Boolean updateOrderCart(UpdateOrderCartForm updateOrderCartForm);

    Boolean startDrive(StartDriveForm startDriveForm);

    Boolean endDrive(OrderFeeForm orderFeeForm);

    PageVo findDriverOrderPage(Long driverId, Long page, Long limit);

    Boolean sendOrderBillInfo(Long orderId, Long driverId);
}
