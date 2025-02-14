package org.example.proxy.payment.service;


import jakarta.servlet.http.HttpServletRequest;
import org.example.proxy.model.form.payment.PaymentInfoForm;
import org.example.proxy.model.vo.payment.WxPrepayVo;

public interface WxPayService {

    WxPrepayVo createWxPayment(PaymentInfoForm paymentInfoForm);

    Boolean queryPayStatus(String orderNo);

    void wxnotify(HttpServletRequest request);

    //支付成功后续处理
    void handleOrder(String orderNo);
}
