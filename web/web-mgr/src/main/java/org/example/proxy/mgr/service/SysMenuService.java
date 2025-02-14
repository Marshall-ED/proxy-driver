package org.example.proxy.mgr.service;




import org.example.proxy.model.entity.system.SysMenu;
import org.example.proxy.model.vo.system.AssginMenuVo;

import java.util.List;

public interface SysMenuService {

    void save(SysMenu sysMenu);

    void update(SysMenu sysMenu);

    void remove(Long id);

    /**
     * 菜单树形数据
     * @return
     */
    List<SysMenu> findNodes();


    /**
     * 保存角色权限
     * @param  assginMenuVo
     */
    void doAssign(AssginMenuVo assginMenuVo);


    List<SysMenu> toAssign(Long roleId);
}
