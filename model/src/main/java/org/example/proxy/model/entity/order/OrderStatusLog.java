package org.example.proxy.model.entity.order;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.example.proxy.model.entity.base.BaseEntity;

import java.util.Date;

@Data
@Schema(description = "OrderStatusLog")
@TableName("order_status_log")
public class OrderStatusLog extends BaseEntity {

	private static final long serialVersionUID = 1L;

    @Schema(description = "orderId")
	@TableField("order_id")
	private Long orderId;

    @Schema(description = "订单状态")
	@TableField("order_status")
	private Integer orderStatus;

    @Schema(description = "操作时间")
	@TableField("operate_time")
	private Date operateTime;

}