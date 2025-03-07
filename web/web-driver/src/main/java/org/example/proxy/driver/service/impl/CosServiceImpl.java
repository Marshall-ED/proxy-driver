package org.example.proxy.driver.service.impl;


import lombok.extern.slf4j.Slf4j;
import org.example.proxy.common.result.Result;
import org.example.proxy.driver.service.CosService;
import org.example.proxy.model.vo.driver.CosUploadVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
@SuppressWarnings({"unchecked", "rawtypes"})
public class CosServiceImpl implements CosService {

    @Autowired
    private CosFeignClient cosFeignClient;

    //文件上传接口
    @Override
    public CosUploadVo uploadFile(MultipartFile file, String path) {
        //远程调用
        Result<CosUploadVo> cosUploadVoResult = cosFeignClient.upload(file,path);
        CosUploadVo cosUploadVo = cosUploadVoResult.getData();
        return cosUploadVo;
    }
}
