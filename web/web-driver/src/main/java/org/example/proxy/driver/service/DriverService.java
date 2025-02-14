package org.example.proxy.driver.service;


import org.example.proxy.model.form.driver.DriverFaceModelForm;
import org.example.proxy.model.form.driver.UpdateDriverAuthInfoForm;
import org.example.proxy.model.vo.driver.DriverAuthInfoVo;

public interface DriverService {

    String login(String code);

    //司机认证信息
    DriverAuthInfoVo getDriverAuthInfo(Long driverId);

    //更新司机认证信息
    Boolean updateDriverAuthInfo(UpdateDriverAuthInfoForm updateDriverAuthInfoForm);

    //创建司机人脸模型
    Boolean creatDriverFaceModel(DriverFaceModelForm driverFaceModelForm);

    //判断司机人脸识别
    Boolean isFaceRecognition(Long driverId);

    //人脸识别
    Boolean verifyDriverFace(DriverFaceModelForm driverFaceModelForm);

    //开始接单服务
    Boolean startService(Long driverId);

    //停止接单服务
    Boolean stopService(Long driverId);
}
