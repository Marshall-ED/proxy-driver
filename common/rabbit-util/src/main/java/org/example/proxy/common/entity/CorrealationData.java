package org.example.proxy.common.entity;

/**
 * @Author Marshall
 * @Date 2025/2/12 14:52
 * @Description:
 */
public class CorrealationData {
    //message body
    private Object message;
    //exchange machine
    private String exchange;
    //routine key
    private String routingKey;
    //retry count
    private int retryCount = 0;
    //whether it is a delayed message
    private boolean isDelay = false;
    //delay duration( in seconds or milliseconds, depending on the context)
    private int delayTime = 10;
}
