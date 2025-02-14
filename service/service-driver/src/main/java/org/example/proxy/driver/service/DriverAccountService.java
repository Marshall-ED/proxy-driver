package org.example.proxy.driver.service;


import com.baomidou.mybatisplus.extension.service.IService;
import org.example.proxy.model.entity.driver.DriverAccount;
import org.example.proxy.model.form.driver.TransferForm;

public interface DriverAccountService extends IService<DriverAccount> {

    Boolean transfer(TransferForm transferForm);
}
