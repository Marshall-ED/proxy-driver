package org.example.proxy.rules.service;


import org.example.proxy.model.form.rules.RewardRuleRequestForm;
import org.example.proxy.model.vo.rules.RewardRuleResponseVo;

public interface RewardRuleService {

    RewardRuleResponseVo calculateOrderRewardFee(RewardRuleRequestForm rewardRuleRequestForm);
}
