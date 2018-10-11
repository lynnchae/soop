package org.lynn.soop.entity.dto.response;

/**
 * Created by gaoguoxiang on 2016/7/20
 */
public class VerifyTokenRtnData {
    private Integer validity;
    private Integer uid;

    public Integer getValidity() {
        return validity;
    }

    public void setValidity(Integer validity) {
        this.validity = validity;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "VerifyTokenRtnData{" +
                "validity=" + validity +
                ", uid=" + uid +
                '}';
    }
}
