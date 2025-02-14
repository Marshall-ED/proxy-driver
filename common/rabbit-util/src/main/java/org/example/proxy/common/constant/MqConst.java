package org.example.proxy.common.constant;

/**
 * @Author Marshall
 * @Date 2025/2/12 14:49
 * @Description:
 */
public class MqConst {

    public static final String EXCHANGE_ORDER = "proxydriver.order";
    public static final String ROUTING_PAY_SUCCESS = "proxydriver.pay.success";
    public static final String ROUTING_PROFITSHARING_SUCCESS = "proxydriver.profitsharing.success";
    public static final String QUEUE_PAY_SUCCESS = "proxydriver.pay.success";
    public static final String QUEUE_PROFITSHARING_SUCCESS = "proxydriver.profitsharing.success";


    //Cancel order delayed messages
    public static final String EXCHANGE_CANCEL_ORDER = "proxydriver.cancel.order";
    public static final String ROUTING_CANCEL_ORDER = "proxydriver.cancel.order";
    public static final String QUEUE_CANCEL_ORDER = "proxydriver.cancel.order";

    //profit sharing delayed messages
    public static final String EXCHANGE_PROFITSHARING = "proxydriver.profitsharing";
    public static final String ROUTING_PROFITSHARING = "proxydriver.profitsharing";
    public static final String QUEUE_PROFITSHARING  = "proxydriver.profitsharing";

}
