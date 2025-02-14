package org.example.proxy.rules.controller;


import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.example.proxy.common.result.Result;
import org.example.proxy.model.form.rules.FeeRuleRequestForm;
import org.example.proxy.model.vo.rules.FeeRuleResponseVo;
import org.example.proxy.rules.service.FeeRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/rules/fee")
@SuppressWarnings({"unchecked", "rawtypes"})
public class FeeRuleController {

    @Autowired
    private FeeRuleService feeRuleService;

    @Operation(summary = "计算订单费用")
    @PostMapping("/calculateOrderFee")
    public Result<FeeRuleResponseVo> calculateOrderFee(@RequestBody FeeRuleRequestForm calculateOrderFeeForm) {
        FeeRuleResponseVo feeRuleResponseVo = feeRuleService.calculateOrderFee(calculateOrderFeeForm);
        return Result.ok(feeRuleResponseVo);
    }

}

