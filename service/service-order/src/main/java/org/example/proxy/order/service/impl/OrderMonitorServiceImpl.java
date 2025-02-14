package org.example.proxy.order.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.proxy.model.entity.order.OrderMonitor;
import org.example.proxy.model.entity.order.OrderMonitorRecord;
import org.example.proxy.order.mapper.OrderMonitorMapper;
import org.example.proxy.order.repository.OrderMonitorRecordRepository;
import org.example.proxy.order.service.OrderMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings({"unchecked", "rawtypes"})
public class OrderMonitorServiceImpl extends ServiceImpl<OrderMonitorMapper, OrderMonitor> implements OrderMonitorService {

    @Autowired
    private OrderMonitorRecordRepository orderMonitorRecordRepository;

    @Override
    public Boolean saveOrderMonitorRecord(OrderMonitorRecord orderMonitorRecord) {
        orderMonitorRecordRepository.save(orderMonitorRecord);
        return true;
    }
}
