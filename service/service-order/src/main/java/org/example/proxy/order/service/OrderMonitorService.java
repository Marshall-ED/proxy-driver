package org.example.proxy.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.proxy.model.entity.order.OrderMonitor;
import org.example.proxy.model.entity.order.OrderMonitorRecord;

public interface OrderMonitorService extends IService<OrderMonitor> {

    Boolean saveOrderMonitorRecord(OrderMonitorRecord orderMonitorRecord);
}
