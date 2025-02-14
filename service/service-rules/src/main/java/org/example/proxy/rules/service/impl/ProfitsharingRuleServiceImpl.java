package org.example.proxy.rules.service.impl;


import lombok.extern.slf4j.Slf4j;
import org.example.proxy.model.form.rules.ProfitsharingRuleRequest;
import org.example.proxy.model.form.rules.ProfitsharingRuleRequestForm;
import org.example.proxy.model.vo.rules.ProfitsharingRuleResponse;
import org.example.proxy.model.vo.rules.ProfitsharingRuleResponseVo;
import org.example.proxy.rules.mapper.ProfitsharingRuleMapper;
import org.example.proxy.rules.service.ProfitsharingRuleService;
import org.example.proxy.rules.utils.DroolsHelper;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@SuppressWarnings({"unchecked", "rawtypes"})
public class ProfitsharingRuleServiceImpl implements ProfitsharingRuleService {

    @Autowired
    private ProfitsharingRuleMapper rewardRuleMapper;

    private static final String RULES_CUSTOMER_RULES_DRL = "rules/ProfitsharingRule.drl";

    @Override
    public ProfitsharingRuleResponseVo calculateOrderProfitsharingFee(ProfitsharingRuleRequestForm profitsharingRuleRequestForm) {
        //传入参数对象封装
        ProfitsharingRuleRequest profitsharingRuleRequest = new ProfitsharingRuleRequest();
        profitsharingRuleRequest.setOrderAmount(profitsharingRuleRequestForm.getOrderAmount());
        profitsharingRuleRequest.setOrderNum(profitsharingRuleRequestForm.getOrderNum());

        //创建kieSession
        KieSession kieSession = DroolsHelper.loadForRule(RULES_CUSTOMER_RULES_DRL);

        //封装返回对象
        ProfitsharingRuleResponse profitsharingRuleResponse = new ProfitsharingRuleResponse();
        kieSession.setGlobal("profitsharingRuleResponse",profitsharingRuleResponse);

        //触发规则，返回vo对象
        kieSession.insert(profitsharingRuleRequest);
        kieSession.fireAllRules();
        kieSession.dispose();

        ProfitsharingRuleResponseVo profitsharingRuleResponseVo = new ProfitsharingRuleResponseVo();
        BeanUtils.copyProperties(profitsharingRuleResponse,profitsharingRuleResponseVo);

        return profitsharingRuleResponseVo;
    }
}
