package org.example.proxy.model.entity.system;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.example.proxy.model.entity.base.BaseEntity;

@Data
@Schema(description = "角色菜单")
@TableName("sys_role_menu")
public class SysRoleMenu extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	@Schema(description = "角色id")
	@TableField("role_id")
	private Long roleId;

	@Schema(description = "菜单id")
	@TableField("menu_id")
	private Long menuId;

}

