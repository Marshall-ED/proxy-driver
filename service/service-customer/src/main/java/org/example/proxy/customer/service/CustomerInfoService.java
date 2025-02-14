package org.example.proxy.customer.service;


import com.baomidou.mybatisplus.extension.service.IService;
import org.example.proxy.model.entity.customer.CustomerInfo;
import org.example.proxy.model.form.customer.UpdateWxPhoneForm;
import org.example.proxy.model.vo.customer.CustomerLoginVo;

public interface CustomerInfoService extends IService<CustomerInfo> {

    //微信小程序登录接口
    Long login(String code);

    //获取客户登录信息
    CustomerLoginVo getCustomerInfo(Long customerId);

    //更新客户微信手机号码
    Boolean updateWxPhoneNumber(UpdateWxPhoneForm updateWxPhoneForm);

    String getCustomerOpenId(Long customerId);
}
