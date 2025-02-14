package org.example.proxy.common.result;

import lombok.Getter;

/**
 * @Author Marshall
 * @Date 2025/2/12 14:26
 * @Description:Unified response result status information class
 */
@Getter
public enum ResultCodeEnum {
    SUCCESS(200,"Success"),
    FAIL(201, "Failure"),
    SERVICE_ERROR(2012, "Service Exception"),
    DATA_ERROR(204, "Data Exception"),
    ILLEGAL_REQUEST(205, "Illegal Exception"),
    REPEAT_SUBMIT(206, "Duplicate Submission"),
    FEIGN_FAIL(207, "Remote Call Failure"),
    UPDATE_ERROR(204, "Data Update Failure"),

    ARGUMENT_VALID_ERROR(210, "Parameter Validation Exception"),
    SIGN_ERROR(300, "Signature Error"),
    SIGN_OVERDUE(301, "Signature Expired"),
    VALIDATECODE_ERROR(218 , "Verification Code Error"),

    LOGIN_AUTH(208, "Not Logger In"),
    PERMISSION(209, "No permission"),
    ACCOUNT_ERROR(214, "Incorrect Account"),
    PASSWORD_ERROR(215, "Incorrect Password"),
    PHONE_CODE_ERROR(215, "Incorrect Phone Verification Code"),
    LOGIN_MOBLE_ERROR( 216, "Incorrect Account"),
    ACCOUNT_STOP( 216, "Account Suspended"),
    NODE_ERROR( 217, "Cannot Delete Node With Sub-nodes"),

    COB_NEW_ORDER_FAIL( 217, "Order Grab Failure"),
    MAP_FAIL( 217, "Map Service Call Failure"),
    PROFITSHARING_FAIL( 217, "Profit sharing Call Failure"),
    NO_START_SERVICE( 217, "Ride-hailing Service Not Started, Cannot Update Location"),
    DRIVER_START_LOCATION_DISTION_ERROR( 217, "Must be within 1 km of the Ride-hailing Start Point to Confirm"),
    DRIVER_END_LOCATION_DISTION_ERROR( 217, "Must be within 2 km of the Ride-hailing Start Point to Confirm"),
    IMAGE_AUDITION_FAIL( 217, "Image Audit Not Passed"),
    AUTH_ERROR( 217, "Must be Authenticated to Start Ride-hailing Service"),
    FACE_ERROR( 250, "Face Recognition Not Performed on the Same Day"),

    COUPON_EXPIRE( 250, "Coupon Expired"),
    COUPON_LESS( 250, "Insufficient Coupon Stock"),
    COUPON_USER_LIMIT( 250, "Exceeded Coupon Collection Limit"),
    ;

    private Integer code;

    private String message;

    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
