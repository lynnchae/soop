package org.lynn.soop.contract;

import org.lynn.soop.entity.AdminUser;

public class BaseRequest<T> {
    private int requestId;
    private String type;
    private String dto;
    private AdminUser operator;
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public AdminUser getOperator() {
        return operator;
    }

    public void setOperator(AdminUser operator) {
        this.operator = operator;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDto() {
        return dto;
    }

    public void setDto(String dto) {
        this.dto = dto;
    }

}
