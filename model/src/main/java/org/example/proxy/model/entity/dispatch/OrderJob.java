package org.example.proxy.model.entity.dispatch;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.example.proxy.model.entity.base.BaseEntity;

@Data
@Schema(description = "订单任务关联表")
@TableName("order_job")
public class OrderJob extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Schema(description = "订单id")
	@TableField("order_id")
	private Long orderId;

	@Schema(description = "任务id")
	@TableField("job_id")
	private Long jobId;

	@Schema(description = "参数")
	@TableField("parameter")
	private String parameter;

}