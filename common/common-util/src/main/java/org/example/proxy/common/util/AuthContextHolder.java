package org.example.proxy.common.util;

/**
 * @Author Marshall
 * @Date 2025/2/12 14:39
 * @Description:Current user information utility class
 */
public class AuthContextHolder {
    private static ThreadLocal<Long> userId = new ThreadLocal<Long>();

    public static void setUserId(Long _userId) {
        userId.set(_userId);
    }

    public static Long getUserId() {
        return userId.get();
    }

    public static void removeUserId() {
        userId.remove();
    }

}
