package org.example.proxy.common.constant;

/**
 * @Author Marshall
 * @Date 2025/2/12 16:31
 * @Description:
 */
public class RedisConstant {
    // User login
    public static final String USER_LOGIN_KEY_PREFIX = "user:login:";
    public static final String USER_LOGIN_REFRESH_KEY_PREFIX = "user:login:refresh:";
    public static final int USER_LOGIN_KEY_TIMEOUT = 60 * 60 * 24 * 100; // 100 days
    public static final int USER_LOGIN_REFRESH_KEY_TIMEOUT = 60 * 60 * 24 * 365; // 365 days

    // Driver GEO location
    public static final String DRIVER_GEO_LOCATION = "driver:geo:location";
    // Driver order temporary container
    public static final String DRIVER_ORDER_TEMP_LIST = "driver:order:temp:list:";
    public static final long DRIVER_ORDER_TEMP_LIST_EXPIRES_TIME = 1; // 1 hour

    // Driver order deduplication container
    public static final String DRIVER_ORDER_REPEAT_LIST = "driver:order:repeat:list:";
    public static final long DRIVER_ORDER_REPEAT_LIST_EXPIRES_TIME = 16; // 16 hours

    // Update order location
    public static final String UPDATE_ORDER_LOCATION = "update:order:location:";
    public static final long UPDATE_ORDER_LOCATION_EXPIRES_TIME = 15; // 15 minutes

    // Order acceptance mark
    public static final String ORDER_ACCEPT_MARK = "order:accept:mark:";
    public static final long ORDER_ACCEPT_MARK_EXPIRES_TIME = 15; // 15 minutes

    // New order lock
    public static final String ROB_NEW_ORDER_LOCK = "rob:new:order:lock";
    // Wait time to acquire the lock
    public static final long ROB_NEW_ORDER_LOCK_WAIT_TIME = 1; // 1 second
    // Lock lease time
    public static final long ROB_NEW_ORDER_LOCK_LEASE_TIME = 1; // 1 second

    // Coupon information
    public static final String COUPON_INFO = "coupon:info:";

    // Coupon distributed lock
    public static final String COUPON_LOCK = "coupon:lock:";
    // Wait time to acquire the lock
    public static final long COUPON_LOCK_WAIT_TIME = 1; // 1 second
    // Lock lease time
    public static final long COUPON_LOCK_LEASE_TIME = 1; // 1 second
}
