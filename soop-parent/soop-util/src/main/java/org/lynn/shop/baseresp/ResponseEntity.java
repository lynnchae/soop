package org.lynn.soop.baseresp;

import java.io.Serializable;

/**
 * Copyright @ 2016QIANLONG.
 * All right reserved.
 * Class Name : org.lynn.soop.baseresp
 * Description :
 * Author : gaoguoxiang
 * Date : 2016/8/3
 */

public class ResponseEntity implements Serializable {
    private static final long serialVersionUID = -720807478055084231L;

    private String status;
    private String error;
    private String msg;
    private Object data;
    public ResponseEntity() {

    }

    public ResponseEntity(Object data) {
        this.data = data;
    }

    public ResponseEntity(Object data, String status) {
        this.data = data;
        this.status = status;
    }

    public ResponseEntity(Object data, String status, String msg) {
        this.data = data;
        this.status = status;
        this.msg = msg;
    }

    public ResponseEntity(Object data, String status, String msg,
                          String error) {
        this.data = data;
        this.status = status;
        this.msg = msg;
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
