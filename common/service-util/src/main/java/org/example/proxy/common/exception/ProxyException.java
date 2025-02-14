package org.example.proxy.common.exception;

import lombok.Data;
import org.example.proxy.common.result.ResultCodeEnum;

/**
 * @Author Marshall
 * @Date 2025/2/12 16:34
 * @Description: Customized global exception class
 */
@Data
public class ProxyException extends RuntimeException {
    private Integer code;

    private String message;

    /**
     * Create an exception object through the status code and error message
     * @param code
     * @param message
     */
    public ProxyException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    /**
     * Accept an enumeration type object
     * @param resultCodeEnum
     */
    public ProxyException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
    }

    @Override
    public String toString() {
        return "ProxyException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}
