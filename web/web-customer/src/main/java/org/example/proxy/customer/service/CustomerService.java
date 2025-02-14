package org.example.proxy.customer.service;


import org.example.proxy.model.form.customer.UpdateWxPhoneForm;
import org.example.proxy.model.vo.customer.CustomerLoginVo;


public interface CustomerService {

    //微信登录
    String login(String code);

    //获取用户信息
    CustomerLoginVo getCustomerLoginInfo(String token);

    //获取用户信息
    CustomerLoginVo getCustomerInfo(Long customerId);

    //更新用户微信手机号
    Boolean updateWxPhoneNumber(UpdateWxPhoneForm updateWxPhoneForm);
}
