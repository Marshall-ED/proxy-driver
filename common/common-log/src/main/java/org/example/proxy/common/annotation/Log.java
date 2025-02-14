package org.example.proxy.common.annotation;

import org.example.proxy.common.enums.BusinessType;
import org.example.proxy.common.enums.OperatorType;

import java.lang.annotation.*;

/**
 * @Author Marshall
 * @Date 2025/2/8 18:11
 * @Description: customized operation log recording annotation
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    /**
     * module
     *
     * @return
     */
    public String title() default "";

    /**
     * function
     * @return
     */
    public BusinessType businessType() default BusinessType.OTHER;

    public OperatorType operatorType()default OperatorType.MANAGE;

    public boolean isSaveRequestData() default true;

    public boolean isSaveResponseData() default true;


}
