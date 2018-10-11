package org.lynn.soop.contract.user.dto;

import org.lynn.soop.contract.dto.BaseQueryRequest;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryCondition extends BaseQueryRequest {
    private Date registerDateFrom;
    private Date registerDateTo;
    private String accountStatus;
    private String onlineStatus;


    public Date getRegisterDateFrom() {
        return registerDateFrom;
    }

    public Date getRegisterDateTo() {
        return registerDateTo;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public String getOnlineStatus() {
        return onlineStatus;
    }

}
