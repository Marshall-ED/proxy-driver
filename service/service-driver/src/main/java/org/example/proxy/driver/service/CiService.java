package org.example.proxy.driver.service;


import org.example.proxy.model.vo.order.TextAuditingVo;

public interface CiService {

    //图片审核
    Boolean imageAuditing(String path);

    TextAuditingVo textAuditing(String content);
}
