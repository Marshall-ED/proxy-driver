package org.example.proxy.dispatch.service;



import org.example.proxy.model.vo.dispatch.NewOrderTaskVo;
import org.example.proxy.model.vo.order.NewOrderDataVo;

import java.util.List;

public interface NewOrderService {

    ////创建并启动任务调度方法
    Long addAndStartTask(NewOrderTaskVo newOrderTaskVo);

    //执行任务：搜索附近代驾司机
    void executeTask(long jobId);

    List<NewOrderDataVo> findNewOrderQueueData(Long driverId);

    Boolean clearNewOrderQueueData(Long driverId);
}
