package org.lynn.soop.entity.handwrite.originEntityBuilder;

import org.lynn.soop.entity.VerificationCode;
import org.lynn.soop.entity.handwrite.VerificationCodeExtend;

public class VerificationCodeOriginBuilder extends VerificationCode {

    public static VerificationCodeExtend buildOrigin(VerificationCode origin) {
        VerificationCodeExtend returnValue=new VerificationCodeExtend();
        returnValue.setId(origin.getId());
        returnValue.setDate_created(origin.getDate_created());
        returnValue.setCreated_by(origin.getCreated_by());
        returnValue.setDate_updated(origin.getDate_updated());
        returnValue.setUpdated_by(origin.getUpdated_by());
        returnValue.setType(origin.getType());
        returnValue.setKey_number(origin.getKey_number());
        returnValue.setCode(origin.getCode());
        returnValue.setExpired_at(origin.getExpired_at());
        returnValue.setBusiness_ref_no(origin.getBusiness_ref_no());
        return returnValue;
    }
}