package org.example.proxy.rules.service;


import org.example.proxy.model.form.rules.ProfitsharingRuleRequestForm;
import org.example.proxy.model.vo.rules.ProfitsharingRuleResponseVo;

public interface ProfitsharingRuleService {

    ProfitsharingRuleResponseVo calculateOrderProfitsharingFee(ProfitsharingRuleRequestForm profitsharingRuleRequestForm);
}
