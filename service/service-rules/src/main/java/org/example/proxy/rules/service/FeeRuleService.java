package org.example.proxy.rules.service;


import org.example.proxy.model.form.rules.FeeRuleRequestForm;
import org.example.proxy.model.vo.rules.FeeRuleResponseVo;


public interface FeeRuleService {

    //计算订单费用
    FeeRuleResponseVo calculateOrderFee(FeeRuleRequestForm calculateOrderFeeForm);
}
