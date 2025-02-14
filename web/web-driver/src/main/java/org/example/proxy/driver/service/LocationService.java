package org.example.proxy.driver.service;



import org.example.proxy.model.form.map.OrderServiceLocationForm;
import org.example.proxy.model.form.map.UpdateDriverLocationForm;
import org.example.proxy.model.form.map.UpdateOrderLocationForm;

import java.util.List;

public interface LocationService {

    //更新司机位置
    Boolean updateDriverLocation(UpdateDriverLocationForm updateDriverLocationForm);

    Boolean updateOrderLocationToCache(UpdateOrderLocationForm updateOrderLocationForm);

    Boolean saveOrderServiceLocation(List<OrderServiceLocationForm> orderLocationServiceFormList);
}
