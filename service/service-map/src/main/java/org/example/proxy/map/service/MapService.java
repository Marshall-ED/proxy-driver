package org.example.proxy.map.service;


import org.example.proxy.model.form.map.CalculateDrivingLineForm;
import org.example.proxy.model.vo.map.DrivingLineVo;

public interface MapService {

    //计算驾驶线路
    DrivingLineVo calculateDrivingLine(CalculateDrivingLineForm calculateDrivingLineForm);
}
