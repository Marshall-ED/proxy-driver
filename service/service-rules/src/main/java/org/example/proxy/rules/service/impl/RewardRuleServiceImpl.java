package org.example.proxy.rules.service.impl;


import lombok.extern.slf4j.Slf4j;
import org.example.proxy.model.form.rules.RewardRuleRequest;
import org.example.proxy.model.form.rules.RewardRuleRequestForm;
import org.example.proxy.model.vo.rules.RewardRuleResponse;
import org.example.proxy.model.vo.rules.RewardRuleResponseVo;
import org.example.proxy.rules.service.RewardRuleService;
import org.example.proxy.rules.utils.DroolsHelper;
import org.kie.api.runtime.KieSession;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@SuppressWarnings({"unchecked", "rawtypes"})
public class RewardRuleServiceImpl implements RewardRuleService {

    private static final String RULES_CUSTOMER_RULES_DRL = "rules/RewardRule.drl";

    @Override
    public RewardRuleResponseVo calculateOrderRewardFee(RewardRuleRequestForm rewardRuleRequestForm) {
        //封装传入参数对象
        RewardRuleRequest rewardRuleRequest = new RewardRuleRequest();
        rewardRuleRequest.setOrderNum(rewardRuleRequestForm.getOrderNum());

        //创建规则引擎对象
        KieSession kieSession = DroolsHelper.loadForRule(RULES_CUSTOMER_RULES_DRL);

        //封装返回对象
        RewardRuleResponse rewardRuleResponse = new RewardRuleResponse();
        kieSession.setGlobal("rewardRuleResponse",rewardRuleResponse);

        //设置对象，触发规则
        kieSession.insert(rewardRuleRequest);
        kieSession.fireAllRules();

        //终止会话
        kieSession.dispose();

        //封装RewardRuleResponseVo
        RewardRuleResponseVo rewardRuleResponseVo = new RewardRuleResponseVo();
        rewardRuleResponseVo.setRewardAmount(rewardRuleResponse.getRewardAmount());
        return rewardRuleResponseVo;
    }
}
