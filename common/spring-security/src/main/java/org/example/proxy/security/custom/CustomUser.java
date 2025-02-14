package org.example.proxy.security.custom;


import org.example.proxy.model.entity.system.SysUser;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;

public class CustomUser extends User {


    private SysUser sysUser;

    public CustomUser(SysUser sysUser) {
        super(sysUser.getUsername(), sysUser.getPassword(), new ArrayList<>());
        this.sysUser = sysUser;
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }

}

