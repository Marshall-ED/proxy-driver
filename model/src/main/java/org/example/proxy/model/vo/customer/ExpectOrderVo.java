package org.example.proxy.model.vo.customer;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.example.proxy.model.vo.map.DrivingLineVo;
import org.example.proxy.model.vo.rules.FeeRuleResponseVo;

@Schema(description = "预估订单实体")
@Data
public class ExpectOrderVo {

	@Schema(description = "驾车路线")
	private DrivingLineVo drivingLineVo;

	@Schema(description = "订单费用")
	private FeeRuleResponseVo feeRuleResponseVo;

}