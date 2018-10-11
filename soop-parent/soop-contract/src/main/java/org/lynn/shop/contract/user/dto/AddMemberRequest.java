package org.lynn.soop.contract.user.dto;

import org.lynn.soop.contract.BaseRequest;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AddMemberRequest extends BaseRequest {
    @JsonProperty("login_name")
    private String loginName;
    private String password;
    @JsonProperty("mobile_no")
    private String mobileNo;
    private String email;

    public String getLoginName() {
        return loginName;
    }

    public String getPassword() {
        return password;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getEmail() {
        return email;
    }
}
