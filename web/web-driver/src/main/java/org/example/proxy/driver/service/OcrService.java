package org.example.proxy.driver.service;


import org.example.proxy.model.vo.driver.DriverLicenseOcrVo;
import org.example.proxy.model.vo.driver.IdCardOcrVo;
import org.springframework.web.multipart.MultipartFile;

public interface OcrService {

    //身份证识别
    IdCardOcrVo idCardOcr(MultipartFile file);

    //驾驶证识别
    DriverLicenseOcrVo driverLicenseOcr(MultipartFile file);
}
