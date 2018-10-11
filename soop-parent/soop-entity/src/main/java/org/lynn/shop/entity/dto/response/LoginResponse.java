package org.lynn.soop.entity.dto.response;

/**
 * Created by gaoguoxiang on 2016/7/19
 */
public class LoginResponse {
    private Integer status;
    private String error;
    private String msg;
    private LoginRtnData data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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

    public LoginRtnData getData() {
        return data;
    }

    public void setData(LoginRtnData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "status=" + status +
                ", error='" + error + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
