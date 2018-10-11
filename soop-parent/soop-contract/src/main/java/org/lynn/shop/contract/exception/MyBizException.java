package org.lynn.soop.contract.exception;


import org.lynn.soop.contract.BaseResponse;

/**
 * Created by chenwen on 4/30/16.
 */
public class MyBizException extends RuntimeException {

    protected BaseResponse resp;

    protected MyBizException(String message) {
        super(message);
    }


    public MyBizException(BaseResponse resp) {
        this(String.valueOf(resp));
        this.resp = resp;
    }

    public BaseResponse getResp() {
        return resp;
    }

}
