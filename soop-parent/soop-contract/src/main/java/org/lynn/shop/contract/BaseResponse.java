package org.lynn.soop.contract;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.HashMap;
import java.util.Map;

public class BaseResponse<T> {
    public static final int CODE_OK = 200;
    public static final int CODE_CLIENT_ERROR = 400;
    public static final int CODE_SERVER_ERROR = 500;
    public static final int CODE_SERVER_REDIRECT = 302;
    public static final int CODE_CLIENT_NO_LOGIN = 403;
    
    public static final String OK = "1";
    public static final String FAILED = "0";

    private Map<String, String> token = new HashMap<String, String>();

    public Map<String, String> getToken() {
        return token;
    }

    public void put(String key, String value) {
        token.put(key, value);
    }

    private int code;
    private String message;

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static <T> BaseResponse<T> buildSuccessResponse(T data) {
        BaseResponse<T> toReturn = new BaseResponse<T>();
        toReturn.setData(data);
        toReturn.setCode(CODE_OK);
        toReturn.setMessage("SUCCESS");
        return toReturn;
    }

    public static <T> BaseResponse<T> buildResponse(T data, int code) {
        BaseResponse<T> toReturn = new BaseResponse<T>();
        toReturn.setData(data);
        toReturn.setCode(code);
        return toReturn;
    }

    public static <T> BaseResponse<T> buildResponse(int code, String message) {
        BaseResponse<T> toReturn = new BaseResponse<T>();
        toReturn.setCode(code);
        toReturn.setMessage(message);
        return toReturn;
    }

    /**
     * 服务端错误
     *
     * @param message 错误消息
     * @return
     */
    public static <T> BaseResponse<T> buildServerErrorResponse(String message) {
        BaseResponse<T> toReturn = new BaseResponse<T>();
        toReturn.setCode(CODE_SERVER_ERROR);
        toReturn.setMessage(message);
        return toReturn;
    }

    /**
     * 客户端错误，如，参数验证错误，密码不正确等
     *
     * @param message 错误消息
     * @return
     */
    public static <T> BaseResponse<T> buildClientErrorResponse(String message) {
        BaseResponse<T> toReturn = new BaseResponse<T>();
        toReturn.setCode(CODE_CLIENT_ERROR);
        toReturn.setMessage(message);
        return toReturn;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public boolean isSuccess() {
        return getCode() == CODE_OK;
    }
}
