package org.example.proxy.common.constant;

/**
 * @Author Marshall
 * @Date 2025/2/12 16:33
 * @Description:
 */
public class SystemConstant {

    // Radius for searching nearby drivers (unit: kilometers)
    public static final double NEARBY_DRIVER_RADIUS = 5;

    // Delay time for canceling an order (unit: seconds)
    public static final int CANCEL_ORDER_DELAY_TIME = 15 * 60;

    // Default distance for accepting an order (unit: kilometers)
    public static final int ACCEPT_DISTANCE = 5;

    // Confirmation distance between driver's location and the start point of the designated driving service (unit: meters)
    public static final int DRIVER_START_LOCATION_DISTION = 1000;

    // Confirmation distance between driver's location and the end point of the designated driving service (unit: meters)
    public static final int DRIVER_END_LOCATION_DISTION = 2000;

    // Delay time for profit sharing (unit: seconds)
    public static final int PROFITSHARING_DELAY_TIME = 2 * 60;
}

